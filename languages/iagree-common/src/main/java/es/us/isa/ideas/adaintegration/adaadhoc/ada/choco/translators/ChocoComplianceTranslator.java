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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators;

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
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.antlr.ChocoParser;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.ParsingResult;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.UnknownVariableException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.Utils;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.CreationConstraints;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Item;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.OfferItem;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Restriction;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceReference;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringSLO;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

/**
 * Utilizar esta clase para mapear unicamente ofertas que pretendamos que sean
 * compliant con plantillas, pasando previamente el conjunto de las variables de
 * la plantilla
 * 
 * @author jesus
 * 
 */
public class ChocoComplianceTranslator implements IChocoTranslator{

	private ChocoParser p;
	protected AbstractDocument doc;
	protected Map<String, Variable> chocoVars;
	protected Map<String,es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> templateVars;
	protected Map<AgreementElement, Constraint> chocoConstraints;
	protected Map<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> servicePropsMap;
	protected Map<String, Item> itemsMap;
	protected Collection<Constraint> sdtConstraints;
	protected Collection<Constraint> gtConstraints;
	protected Collection<Constraint> ccConstraints;
	protected ServiceProperties props;
	protected boolean differentDomains;
	protected Collection<AgreementElement> newVars;

	public ChocoComplianceTranslator(AbstractDocument d) {
		reset();
		doc = d;
	}

	public ChocoComplianceTranslator(AbstractDocument d,
			Map<String, Variable> vars,
			Map<String,es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> templateVars) {
		reset();
		doc = d;
		// asi evitamos trabajar contra el mismo map que nos pasan, y
		// no corremos el riesgo de modificarlo
		chocoVars = new HashMap<String, Variable>(vars);
		this.templateVars = templateVars;
	}

	protected void reset() {
		differentDomains = false;
		p = new ChocoParser();
		chocoVars = new HashMap<String, Variable>();
		chocoConstraints = new HashMap<AgreementElement, Constraint>();
		servicePropsMap = new HashMap<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable>();
		sdtConstraints = new LinkedList<Constraint>();
		gtConstraints = new LinkedList<Constraint>();
		ccConstraints = new LinkedList<Constraint>();
		itemsMap = new HashMap<String, Item>();
		newVars = new HashSet<AgreementElement>();
	}

	public void translate() {
		AbstractAgreementDocument entryAgreement = (AbstractAgreementDocument) doc;
		// recorrer el documento e ir traduciendo
		// primero las variables
		// luego los terminos
		// y las creation constraints
		Iterator<Term> it = entryAgreement.getTerms().getComprisedTerms()
				.iterator();

		// mapeo de variables
		this.mapProperties(it);
		
		p.setVariables(chocoVars);
		// mapeo de terminos
		this.mapTerms(entryAgreement.getTerms().getComprisedTerms());

		if (entryAgreement instanceof Template) {
			Template template = (Template) entryAgreement;
			CreationConstraints cc = template.getCc();

			// XXX items de las creations constraints
			Set<Item> items = cc.getItems();
			Iterator<Item> itemsIterator = items.iterator();
			while (itemsIterator.hasNext()) {
				Item item = itemsIterator.next();
				addItemVar(item);

			}
			
			// restricciones de las creation constraints
			Set<GeneralConstraint> cons = cc.getConstraints();
			Iterator<GeneralConstraint> consIterator = cons.iterator();
			while (consIterator.hasNext()) {
				GeneralConstraint genCon = consIterator.next();
				String stringConstraint = genCon.getConstraint();
				ParsingResult ps = p.parseConstraint(stringConstraint);
				Constraint c = ps.getConstraint();
				chocoConstraints.put(genCon, c);
				ccConstraints.add(c);
			}

		}

		

	}

	protected void mapProperties(Iterator<Term> it) {
		// Variables and domains MAPPING:
		while (it.hasNext()) { // catching vars and metrics, and initializing
			// locations
			Term term = (Term) it.next();
			ServiceProperties sp;
			if (term instanceof ServiceProperties) {
				sp = (ServiceProperties) term;
				props = sp;
				Set<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> variables = sp
						.getVariableSet();
				// HashMap<String, Metric> varsDoms = new HashMap<String,
				// Metric>();
				Iterator<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> it3 = variables
						.iterator();

				while (it3.hasNext()) {
					es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable v = (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable) it3
							.next();
					checkTemplateVar(v);
				}

			}
		}

	}

	protected void checkTemplateVar(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable var) {
		String name = var.getUniqueName();
		if (!chocoVars.containsKey(name)) {
			// XXX no se admiten variables que no sean de la plantilla
			newVars.add(var);
		}
		else{
			//tengo que comparar los dominios, por lo que necesito
			//los objetos es.us.isa.ada.wsag10.Variable de la plantilla
			es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable auxVar = templateVars.get(name);
			if (auxVar == null || !var.equals(auxVar)){
				differentDomains = true;
			}
		}
	}
	
	/*
	 * Esta implementacion para compliance comprueba si las variables de la
	 * oferta existen ya previamente en la plantilla
	 */
//	protected void addVar(es.us.isa.ada.wsag10.Variable var) {
//		Variable v = null;
//		String name = var.getUniqueName();
//		Metric m = var.getMetric();
//		String dataType = m.getDataType();
//		String oMax = m.getMax(), oMin = m.getMin();
//		if (!chocoVars.containsKey(name)) {
//			// XXX no se admiten variables que no sean de la plantilla
//			newVars.add(var);
//		}
//		else {
//			// TODO preguntar a carlos si los dominios de las vars
//			// deben ser iguales o no
//			v = chocoVars.get(name);
//			if (dataType.equalsIgnoreCase(Metric.INTEGER_TYPE)) {
//				int max = Integer.parseInt(oMax), min = Integer.parseInt(oMin);
//				if (v instanceof IntegerVariable) {
//					IntegerVariable intVar = (IntegerVariable) v;
//					int intMax = intVar.getUppB(), intMin = intVar.getLowB();
//					if ((intMax != max) || (intMin != min)) {
//						differentDomains = true;
//					}
//				} else {
//					differentDomains = true;
//				}
//			} else if (dataType.equalsIgnoreCase(Metric.REAL_TYPE)) {
//				double max = Double.parseDouble(oMax), min = Double
//						.parseDouble(oMin);
//				if (v instanceof RealVariable) {
//					RealVariable realVar = (RealVariable) v;
//					double realMax = realVar.getUppB(), realMin = realVar
//							.getLowB();
//					if ((realMax != max) || (realMin != min)) {
//						differentDomains = true;
//					}
//				} else {
//					differentDomains = true;
//				}
//			} else if (dataType.equalsIgnoreCase(Metric.STRING_TYPE)) {
//				// TODO implementar cuando se permitan dominios de strings
//			}
//		}
//
//	}

	/*
	 * Los items son una forma de imponer a las variables restricciones del tipo
	 * Var > L1 && Var < L2
	 */
	protected void addItemVar(Item i) {
		//limpiamos el location
		String location = i.getLocation();
		location = location.trim();
		location = location.replace("\\", "");
		String vName = location.replace("/", "");
		
		Restriction r = (Restriction) i.getIconst();
		String sMin = r.getMinInclusive(), sMax = r.getMaxInclusive();
		if (!chocoVars.containsKey(vName)) {
			// XXX no se admiten nuevas variables, aunque siendo una oferta
			// no se llegara nunca a este metodo...
			newVars.add(i);
		} else {
			// TODO preguntar a carlos sobre los dominios
			Variable v = chocoVars.get(vName);

			if (v instanceof IntegerVariable) {
				int min = Integer.parseInt(sMin), max = Integer.parseInt(sMax);
				IntegerVariable intVar = (IntegerVariable) v;
				Constraint c = Choco.and(Choco.leq(intVar, max),
						Choco.geq(intVar, min));
				ccConstraints.add(c);

			}

			else if (v instanceof RealVariable) {
				double min = Double.parseDouble(sMin), max = Double
						.parseDouble(sMax);
				RealVariable realVar = (RealVariable) v;
				Constraint c = Choco.and(Choco.leq(realVar, max),
						Choco.geq(realVar, min));
				ccConstraints.add(c);
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
	protected Constraint termToConstraint(Term term) {
		Constraint res = null;

		if (term instanceof ServiceDescriptionTerm) {
			ServiceDescriptionTerm sdt = (ServiceDescriptionTerm) term;
			
			Map<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable,Restriction> moreFeatures = sdt.getServiceFeatures();
			Iterator<Entry<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction>> secondIt = moreFeatures
					.entrySet().iterator();
			while (secondIt.hasNext()) {
				Entry<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction> entry = secondIt
						.next();
				es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable agreementVar = entry.getKey();
				checkTemplateVar(agreementVar);
				p.setVariables(chocoVars);
						
			}
			
			if (doc instanceof AgreementOffer) {
				Iterator<OfferItem> itSdt = sdt.getOfferItems().iterator();
				while (itSdt.hasNext()) {
					OfferItem oi = itSdt.next();
					Restriction value = oi.getRestriction();
					//Si no tiene valor no se crea la constraint
					if (!value.getFixedValue().equals("")) {
						Constraint c;
						try {
							c = Utils.restriction2Choco(oi.getName(), value, chocoVars);
							chocoConstraints.put(oi, c);
							this.sdtConstraints.add(c);
						} catch (UnknownVariableException e) {
							//no puede darse esta excepcion
							//la vble se ha a-adido en addVar
						}
					}
				}
			}
			
		} else if (term instanceof GuaranteeTerm) {
			GuaranteeTerm gt = (GuaranteeTerm) term;
			if (!gt.hasQualifyCondition()) {
				StringSLO slo = new StringSLO();
				if (slo.getClass().isInstance(gt.getSlo())) {
					slo = (StringSLO) gt.getSlo();
					String stringConstraint = slo.getSlo();
					ParsingResult ps = p.parseConstraint(stringConstraint);
					res = ps.getConstraint();
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
					res = Choco.implies(c2, c1);
				}
			}
			chocoConstraints.put(gt, res);
			gtConstraints.add(res);
			// pillar aqui el valor de utilidad

		} else if (term instanceof ServiceReference) {
			// hasta que el estandar no se clarifique, nada
		}
		return res;
	}

	protected boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected boolean isReal(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected IntegerVariable makeIntegerVar(String s, int min, int max) {
		return Choco.makeIntVar(s, min, max);
	}

	protected RealVariable makeRealVar(String s, double min, double max) {
		return Choco.makeRealVar(s, min, max);
	}

	public AbstractDocument getDoc() {
		return doc;
	}

	public Map<String, Variable> getChocoVars() {
		return chocoVars;
	}

	public Map<AgreementElement, Constraint> getChocoConstraints() {
		return chocoConstraints;
	}
	
	/*
	public Map<AgreementElement, Constraint> getChocoConstraintsWithoutSDT() {
		Set<Entry<AgreementElement, Constraint>> offerConstraintsEntries = chocoConstraints.entrySet();
		for (Iterator iterator = offerConstraintsEntries.iterator(); iterator.hasNext();) {
			Entry<AgreementElement, Constraint> entry = (Entry<AgreementElement, Constraint>) iterator.next();
			AgreementElement agreementElement = entry.getKey();
			if (agreementElement instanceof OfferItem) {			
				//System.out.println(agreementElement.getName()+" es un offer item");
				chocoConstraints.remove(agreementElement);
			}
		}
		return chocoConstraints;
	}
	*/

	public Map<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> getServicePropsMap() {
		return servicePropsMap;
	}

	public Collection<Constraint> getSdtConstraints() {
		return sdtConstraints;
	}

	public Collection<Constraint> getGtConstraints() {
		return gtConstraints;
	}

	public Collection<Constraint> getCcConstraints() {
		return ccConstraints;
	}

	public boolean hasDifferentDomains() {
		return differentDomains;
	}

	public ServiceProperties getServiceProperties() {
		return props;
	}

	public Collection<AgreementElement> getNewVars() {
		return newVars;
	}

}
