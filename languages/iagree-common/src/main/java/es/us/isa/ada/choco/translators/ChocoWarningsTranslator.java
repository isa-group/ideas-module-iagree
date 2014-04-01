/**
 * 	This file is part of ADA.
 *
 *     ADA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ADA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ada.choco.translators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import choco.Choco;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.model.variables.real.RealVariable;
import es.us.isa.ada.choco.antlr.ChocoParser;
import es.us.isa.ada.choco.utils.ChocoComplexGT;
import es.us.isa.ada.choco.utils.ParsingResult;
import es.us.isa.ada.choco.utils.UnknownVariableException;
import es.us.isa.ada.choco.utils.Utils;
import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.document.AgreementElement;
import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.AgreementOffer;
import es.us.isa.ada.wsag10.CreationConstraints;
import es.us.isa.ada.wsag10.GeneralConstraint;
import es.us.isa.ada.wsag10.GuaranteeTerm;
import es.us.isa.ada.wsag10.Item;
import es.us.isa.ada.wsag10.OfferItem;
import es.us.isa.ada.wsag10.Restriction;
import es.us.isa.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ada.wsag10.ServiceProperties;
import es.us.isa.ada.wsag10.ServiceReference;
import es.us.isa.ada.wsag10.StringSLO;
import es.us.isa.ada.wsag10.Template;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.ada.wsag10.TermCompositor;
import es.us.isa.ada.wsag10.domain.Domain;
import es.us.isa.ada.wsag10.domain.EnumeratedDomain;
import es.us.isa.ada.wsag10.domain.IntegerDomain;
import es.us.isa.ada.wsag10.domain.IntegerRange;
import es.us.isa.ada.wsag10.domain.RealDomain;
import es.us.isa.ada.wsag10.domain.RealRange;

public class ChocoWarningsTranslator {

	private ChocoParser p;
	protected AbstractDocument doc;
	protected Map<String, Variable> chocoVars;
	protected Map<AgreementElement,Constraint> termsConstraints;
	protected Map<AgreementElement,Constraint> ccConstraints;
	//XXX aqui guardaremos las variables duplicadas
	//si este conjunto contiene algo, es que hay errores
	//devolvemos ademas como explanations
	protected Collection<AgreementElement> duplicatedVars;
	protected Map<GuaranteeTerm,ChocoComplexGT> complexGTs;
	protected Map<GuaranteeTerm,Float> wrongUtilityVals;
	//SDTs duplicados en los valores de utilidad de un GT
	protected Collection<GuaranteeTerm> duplicatedSDTsGTs;
	private Collection<AgreementElement> unknownVars;
	protected Map<String,es.us.isa.ada.wsag10.Variable> servicePropsMap;
	private boolean isTemplate;
	
	private Collection<Constraint> domainExtraConstraints;


	

	public ChocoWarningsTranslator(AbstractDocument d) {
		reset();
		doc = d;
	}
	
	protected void reset(){
		p = new ChocoParser();
		chocoVars = new HashMap<String, Variable>();
		termsConstraints = new HashMap<AgreementElement, Constraint>();
		servicePropsMap = new HashMap<String,es.us.isa.ada.wsag10.Variable>();
		duplicatedVars = new LinkedList<AgreementElement>();
		complexGTs = new HashMap<GuaranteeTerm,ChocoComplexGT>();
		wrongUtilityVals = new HashMap<GuaranteeTerm, Float>();
		duplicatedSDTsGTs = new HashSet<GuaranteeTerm>();
		unknownVars = new HashSet<AgreementElement>();
		isTemplate = false;
		ccConstraints = new HashMap<AgreementElement, Constraint>();
		domainExtraConstraints = new LinkedList<Constraint>();
	}

	public void translate() {
		AbstractAgreementDocument entryAgreement = (AbstractAgreementDocument) doc;
		// recorrer el documento e ir traduciendo
		// primero las variables
		// luego los terminos
		// y las creation constraints
		Iterator<Term> it = entryAgreement.getTerms().getComprisedTerms()
				.iterator();

		//mapeo de variables
		this.mapProperties(it);

		//importante, le metemos las variables al parser
		p.setVariables(chocoVars);
		
		//mapeo de terminos
		this.mapTerms(entryAgreement.getTerms().getComprisedTerms());
		
		if (entryAgreement instanceof Template) {
			isTemplate = true;
			Template template = (Template) entryAgreement;
			CreationConstraints cc = template.getCc();

			// XXX items de las creations constraints
			Set<Item> items = cc.getItems();
			Iterator<Item> itemsIterator = items.iterator();
			while (itemsIterator.hasNext()) {
				Item item = itemsIterator.next();
				addItemVar(item);
			}
			
			//restricciones de las creation constraints
			Set<GeneralConstraint> cons = cc.getConstraints();
			Iterator<GeneralConstraint> consIterator = cons.iterator();
			while (consIterator.hasNext()) {
				GeneralConstraint genCon = consIterator.next();
				String stringConstraint = genCon.getConstraint();
				ParsingResult ps = p.parseConstraint(stringConstraint);
				Constraint c = ps.getConstraint();
				
				if (!ps.getUnknownVars().isEmpty()){
					//si cntiene vble no definidas, no metemos la restriccion
					//pueden estar en la plantilla
					if (isTemplate){
						unknownVars.add(genCon);
					}
				}
				else{
					ccConstraints.put(genCon, c);
				}
			}

		}

	}

	protected void mapProperties(Iterator<Term> it) {
		// Variables and domains MAPPING:
		while (it.hasNext()) { // catching vars and metrics, and initializing
			// locations
			Term term = (Term) it.next();
			ServiceProperties sp = new ServiceProperties();

			if (term instanceof ServiceProperties) {
				sp = (ServiceProperties) term;
				Set<es.us.isa.ada.wsag10.Variable> variables = sp
						.getVariableSet();
				Iterator<es.us.isa.ada.wsag10.Variable> it3 = variables
						.iterator();
				
				while (it3.hasNext()) {
					es.us.isa.ada.wsag10.Variable v = (es.us.isa.ada.wsag10.Variable) it3.next();
					addVar(v);
				}

			}
		}

	}

//	protected void addVar(es.us.isa.ada.wsag10.Variable var) {
//		Variable v = null;
//		String name = var.getUniqueName();
//		if (!chocoVars.containsKey(name)){
//			Metric m = var.getMetric();
//			String dataType = m.getDataType();
//			String oMax = m.getMax(), oMin = m.getMin();
//			if (dataType.equalsIgnoreCase(Metric.INTEGER_TYPE)) {
//				int max = Integer.parseInt(oMax), min = Integer.parseInt(oMin);
//				v = makeIntegerVar(var.getUniqueName(), min, max);
//			} else if (dataType.equalsIgnoreCase(Metric.REAL_TYPE)) {
//				double max = Double.parseDouble(oMax), min = Double.parseDouble(oMin);
//				v = makeRealVar(var.getUniqueName(), min, max);
//			} else if (dataType.equalsIgnoreCase(Metric.STRING_TYPE)) {
//				// TODO variables enumeradas
//			}
//			else{
//				throw new IllegalArgumentException("Tipo de la variable "+name+" no soportado");
//			}
//			chocoVars.put(var.getUniqueName(), v);
//			servicePropsMap.put(var.getUniqueName(), var);
//		}
//		else{
//			duplicatedVars.add(var);
//		}
//		
//	}
	
	protected void addVar(es.us.isa.ada.wsag10.Variable var) {
		Variable v = null;
		String name = var.getUniqueName();
		if (!chocoVars.containsKey(name)) {
			Domain d = var.getDomain();
			if (d instanceof IntegerDomain){
				IntegerDomain dom = (IntegerDomain) d;
				Collection<IntegerRange> ranges = dom.getRanges();
				int absoluteMin = Integer.MAX_VALUE, absoluteMax = Integer.MIN_VALUE;
				for (IntegerRange range:ranges){
					if (range.getMin() < absoluteMin){
						absoluteMin = range.getMin();
					}
					if (range.getMax() > absoluteMax){
						absoluteMax = range.getMax();
					}
				}
				IntegerVariable chocoVar = Choco.makeIntVar(name, absoluteMin, absoluteMax);
				
				//si tiene mas de un rango, metemos las restricciones adicionales
				if (ranges.size() > 1){
					Collection<Constraint> consCol = new LinkedList<Constraint>();
					for (IntegerRange range:ranges){
						Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()),Choco.leq(chocoVar, range.getMax()));
						consCol.add(aux);
					}
					Constraint[] consArray = consCol.toArray(new Constraint[0]);
					Constraint domainConstraint = Choco.and(consArray);
					//estas restricciones deberemos tenerlas luego en cuenta
					//en las operaciones
					domainExtraConstraints.add(domainConstraint);
				}
				v = chocoVar;
				
			}
			else if (d instanceof RealDomain){
				RealDomain dom = (RealDomain) d;
				Collection<RealRange> ranges = dom.getRanges();
				double absoluteMin = Double.POSITIVE_INFINITY, absoluteMax = Double.NEGATIVE_INFINITY;
				for (RealRange range:ranges){
					if (range.getMin() < absoluteMin){
						absoluteMin = range.getMin();
					}
					if (range.getMax() > absoluteMax){
						absoluteMax = range.getMax();
					}
				}
				RealVariable chocoVar = Choco.makeRealVar(name, absoluteMin, absoluteMax);
				
				//si tiene mas de un rango, metemos las restricciones adicionales
				if (ranges.size() > 1){
					Collection<Constraint> consCol = new LinkedList<Constraint>();
					for (RealRange range:ranges){
						Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()),Choco.leq(chocoVar, range.getMax()));
						consCol.add(aux);
					}
					Constraint[] consArray = consCol.toArray(new Constraint[0]);
					Constraint domainConstraint = Choco.and(consArray);
					//estas restricciones deberemos tenerlas luego en cuenta
					//en las operaciones
					domainExtraConstraints.add(domainConstraint);
				}
				v = chocoVar;
			}
			else if (d instanceof EnumeratedDomain){
				EnumeratedDomain dom = (EnumeratedDomain) d;
				Collection<Integer> col = dom.getIntegerValues();
				int[] values = new int[col.size()];
				int i = 0;
				for (Integer elem:col){
					values[i] = elem;
					i++;
				}
				IntegerVariable intVar = Choco.makeIntVar(name, values);
				v = intVar;
			}

			chocoVars.put(var.getUniqueName(), v);
			servicePropsMap.put(var.getUniqueName(), var);
		} else {
			duplicatedVars.add(var);
		}

	}

	protected void addItemVar(Item i) {
		//limpiamos el location
		String location = i.getLocation();
		location = location.trim();
		location = location.replace("\\", "");
		String vName = location.replace("/", "");
		
		Restriction r = (Restriction) i.getIconst();
		String sMin = r.getMinInclusive(), sMax = r.getMaxInclusive();
		if (!chocoVars.containsKey(vName)) {
			unknownVars.add(i);
		} else {
			Variable v = chocoVars.get(vName);

			if (v instanceof IntegerVariable) {
				int min = Integer.parseInt(sMin), max = Integer.parseInt(sMax);
				IntegerVariable intVar = (IntegerVariable) v;
				Constraint c = Choco.and(Choco.leq(intVar, max),
						Choco.geq(intVar, min));
				ccConstraints.put(i,c);
			}

			else if (v instanceof RealVariable) {
				double min = Double.parseDouble(sMin), max = Double
						.parseDouble(sMax);
				RealVariable realVar = (RealVariable) v;
				Constraint c = Choco.and(Choco.leq(realVar, max),
						Choco.geq(realVar, min));
				ccConstraints.put(i,c);
			}
			else {
				// TODO implementar cuando se permitan vbles con strings
			}
		}
	}
	

	protected void mapTerms(List<Term> list) {
		//mapeamos primero los SDT's porque
		//pueden contener variables que luego usen
		//los GT's
		for (Term t:list){
			if (t instanceof ServiceDescriptionTerm){
				termToConstraint(t);
			}
		}
		
		Iterator<Term> it = list.iterator();
		while (it.hasNext()) { 
			Term term = it.next();		
			if (!(term instanceof ServiceDescriptionTerm)){
				termToConstraint(term);
			}	
		}

	}

	/*
	 * Para mapear terminos de forma recursiva con los TermCompositor
	 */
	protected void termToConstraint(Term term) {
		//asumimos que nos pasan documentos planos
		Constraint res = null;

		if (term instanceof ServiceDescriptionTerm) {
			ServiceDescriptionTerm sdt = (ServiceDescriptionTerm) term;
			Map<String,Restriction> features = sdt.getSPServiceFeatures();
			Iterator<Entry<String,Restriction>> itSdt = features.entrySet().iterator();
			List<Constraint> listaSDT = new ArrayList<Constraint>();
			int i = 0;
			
			if(doc instanceof AgreementOffer){
				while (itSdt.hasNext()){
					Entry<String,Restriction> e = itSdt.next();
					String varName = e.getKey();
					Restriction value = e.getValue();
					//Si no tiene valor no creamos constraint
					if(!value.getFixedValue().equals("")){
						try{
							Constraint c = Utils.restriction2Choco(varName, value, chocoVars);
							listaSDT.add(c);
							i++;
						}
						catch (UnknownVariableException exp){
							if (isTemplate){
								unknownVars.add(sdt);
							}
						}
					}
//					if (chocoVars.containsKey(varName)){
//						//ya existe la vble, solo creamos otra restriccion
//						Variable v = chocoVars.get(varName);
//						Constraint c;
//						if (v instanceof IntegerVariable){
//							IntegerVariable intVar = (IntegerVariable) v;
//							int intValue = Integer.parseInt(value);
//							c = Choco.eq(intVar, intValue);
//						}
//						else if (v instanceof RealVariable){
//							RealVariable realVar = (RealVariable) v;
//							double realValue = Double.parseDouble(value);
//							c = Choco.eq(realVar, realValue);
//						}
//						else{
//							//TODO valor enumerado, ver como hacerlo en el futuro
//							c = null;
//						}
//						listaSDT.add(c);
//						i++;
//					}
//					else{
//						unknownVars.add(sdt);
//					}
				}
			}
			
			
			Map<es.us.isa.ada.wsag10.Variable,Restriction> moreFeatures = sdt.getServiceFeatures();
			Iterator<Entry<es.us.isa.ada.wsag10.Variable,Restriction>> secondIt = moreFeatures.entrySet().iterator();
			while (secondIt.hasNext()){
				Entry<es.us.isa.ada.wsag10.Variable,Restriction> entry = secondIt.next();
				es.us.isa.ada.wsag10.Variable agreementVar = entry.getKey();
				addVar(agreementVar);
				p.setVariables(chocoVars);
				Variable v = chocoVars.get(agreementVar.getUniqueName());
				
				if(doc instanceof AgreementOffer){
					Restriction value = entry.getValue();
					//Si no tiene valor no creamos constraint
					if(!value.getFixedValue().equals("")){
						Constraint c;
						try {
							c = Utils.restriction2Choco(agreementVar.getName(), value, chocoVars);
							listaSDT.add(c);
						} catch (UnknownVariableException e) {
							//no puede darse esta excepcion
							//la vble se ha a�adido en addVar
						}
					}
//					if (!value.isEmpty()){
//						Constraint c;
//						if (v instanceof IntegerVariable){
//							IntegerVariable intVar = (IntegerVariable) v;
//							int intValue = Integer.parseInt(value);
//							c = Choco.eq(intVar, intValue);
//						}
//						else if (v instanceof RealVariable){
//							RealVariable realVar = (RealVariable) v;
//							double realValue = Double.parseDouble(value);
//							c = Choco.eq(realVar, realValue);
//						}
//						else{
//							//TODO valor enumerado, ver como hacerlo en el futuro
//							c = null;
//						}
//						listaSDT.add(c);
//					}
				}
			}
			
			// S�lo a�adimos las restricciones de los OfferItems si el documento
			// es una oferta. En las plantillas, los valores que aparecen en los
			// OfferItems se consideran valores 'por defecto' o 'de ejemplo' por
			// lo que no deben ser tenidos en cuenta a la hora de analizar.
			if(doc instanceof AgreementOffer){
				for(OfferItem oi:sdt.getOfferItems()){
					Restriction rest = oi.getRestriction();
					if(!rest.getFixedValue().equals("")){
						try{
							Constraint c = Utils.restriction2Choco(oi.getName(), rest, chocoVars);
							termsConstraints.put(oi, c);
						}catch(UnknownVariableException e){
							
						}
					}
				}
			}
			
			Constraint[] arraySDT = listaSDT.toArray(new Constraint[0]);
			res = Choco.and(arraySDT);
			// termsConstraints.put(sdt, res);
		} 
		else if (term instanceof GuaranteeTerm) {
			GuaranteeTerm gt = (GuaranteeTerm) term;
			if (!gt.hasQualifyCondition()) {
				StringSLO slo = new StringSLO();
				if (slo.getClass().isInstance(gt.getSlo())) {
					slo = (StringSLO) gt.getSlo();
					String stringConstraint = slo.getSlo();
					ParsingResult ps = p.parseConstraint(stringConstraint);
					res = ps.getConstraint();
					if (!ps.getUnknownVars().isEmpty()){
						res = Choco.TRUE;
						if (isTemplate){
							unknownVars.add(gt);
						}
					}
					termsConstraints.put(gt, res);
				}

			} else {
				// si hay qualifcondition
				StringSLO slo = new StringSLO();
				if (slo.getClass().isInstance(gt.getSlo())) {
					slo = (StringSLO) gt.getSlo();
					String stringConstraint = slo.getSlo();
					ParsingResult ps1 = p.parseConstraint(stringConstraint);
					Constraint c1 = ps1.getConstraint();
					String qualifyCond = gt.getQualifyingCondition();
					ParsingResult ps2 = p.parseConstraint(qualifyCond);
					Constraint c2 = ps2.getConstraint();
					ChocoComplexGT complexGT = new ChocoComplexGT(c2, c1, gt);
					complexGTs.put(gt, complexGT);
					res = Choco.implies(c2, c1);
					if (!ps1.getUnknownVars().isEmpty() || !ps2.getUnknownVars().isEmpty()){
						if (isTemplate){
							unknownVars.add(gt);
						}
						res = Choco.TRUE;
					}
					else{
						res = Choco.implies(c2, c1);
					}
				}
			}
			
			//pillar aqui el valor de utilidad

		}
		else if (term instanceof ServiceReference) {
			// TODO hasta que el estandar no se clarifique, nada
		}
		else if (term instanceof TermCompositor) {
			//suponemos documentos planos, no puede haber TermCompositors
		}
	}
	
	protected boolean isInteger(String s){
		try{
			Integer.parseInt(s);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	
	protected boolean isReal(String s){
		try{
			Double.parseDouble(s);
			return true;
		}
		catch (NumberFormatException e){
			return false;
		}
	}
	
	protected IntegerVariable makeIntegerVar(String s, int min, int max){
		return Choco.makeIntVar(s, min, max);
	}
	
	protected RealVariable makeRealVar(String s, double min, double max){
		return Choco.makeRealVar(s, min, max);
	}

	public AbstractDocument getDoc() {
		return doc;
	}

	public Map<String, Variable> getChocoVars() {
		return chocoVars;
	}

	public Map<AgreementElement, Constraint> getChocoConstraints() {
		return termsConstraints;
	}
	
	public Map<String, es.us.isa.ada.wsag10.Variable> getServicePropsMap() {
		return servicePropsMap;
	}

	public Collection<AgreementElement> getDuplicatedVars(){
		return duplicatedVars;
	}
	
	public Map<GuaranteeTerm,ChocoComplexGT> getComplexGTs(){
		return complexGTs;
	}

	public Collection<GuaranteeTerm> getDuplicatedSDTsGTs(){
		return duplicatedSDTsGTs;
	}
	
	public Map<GuaranteeTerm,Float> getBadUtilitySums(){
		return wrongUtilityVals;
	}
	
	public Collection<AgreementElement> getUnknownVars(){
		return unknownVars;
	}
	
	public Map<AgreementElement,Constraint> getCreationContraints(){
		return ccConstraints;
	}
	
	public Collection<Constraint> getAdditionalConstraints(){
		return domainExtraConstraints;
	}
}
