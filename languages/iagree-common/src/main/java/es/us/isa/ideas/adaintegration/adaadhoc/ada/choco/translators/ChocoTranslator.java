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
import java.util.Set;
import java.util.Map.Entry;

import choco.Choco;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.model.variables.real.RealVariable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.antlr.ChocoParser;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.ChocoComplexGT;
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
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Preference;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Restriction;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceReference;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringSLO;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.Domain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.EnumeratedDomain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.IntegerDomain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.IntegerRange;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.RealDomain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.RealRange;

public class ChocoTranslator implements IChocoTranslator {

	private ChocoParser p;
	protected AbstractDocument doc;
	protected Map<String, Variable> chocoVars;
	protected Map<AgreementElement, Constraint> chocoConstraints;
	// XXX aqui guardaremos las variables duplicadas
	// si este conjunto contiene algo, es que hay errores
	// devolvemos ademas como explanations
	protected Collection<AgreementElement> duplicatedVars;
	protected Map<GuaranteeTerm, ChocoComplexGT> complexGTs;
	protected Map<GuaranteeTerm, Float> wrongUtilityVals;
	// SDTs duplicados en los valores de utilidad de un GT
	protected Collection<Term> duplicatedSDTsGTs;
	private Collection<AgreementElement> unknownVars;
	protected Map<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> servicePropsMap;
	private boolean isTemplate;

	private Collection<Constraint> domainExtraConstraints;

	public ChocoTranslator(AbstractDocument d) {
		reset();
		doc = d;
	}

	public ChocoTranslator(AbstractDocument d, Map<String, Variable> vars) {
		reset();
		doc = d;
		// asi evitamos trabajar contra el mismo map que nos pasan, y
		// no corremos el riesgo de modificarlo
		chocoVars = new HashMap<String, Variable>(vars);
	}

	protected void reset() {
		p = new ChocoParser();
		isTemplate = false;
		chocoVars = new HashMap<String, Variable>();
		chocoConstraints = new HashMap<AgreementElement, Constraint>();
		servicePropsMap = new HashMap<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable>();
		duplicatedVars = new LinkedList<AgreementElement>();
		complexGTs = new HashMap<GuaranteeTerm, ChocoComplexGT>();
		wrongUtilityVals = new HashMap<GuaranteeTerm, Float>();
		duplicatedSDTsGTs = new HashSet<Term>();
		unknownVars = new HashSet<AgreementElement>();
	}

	public void translate() {
		AbstractAgreementDocument entryAgreement = (AbstractAgreementDocument) doc;
		// recorrer el documento e ir traduciendo
		// primero las variables
		// luego los terminos
		// y las creation constraints
		Iterator<Term> it = entryAgreement.getTerms().getComprisedTerms().iterator();
		// Iterator<Term> it2 =
		// entryAgreement.getTerms().getComprisedTerms().iterator();

		// mapeo de variables
		this.mapProperties(it);
		p.setVariables(chocoVars);
		// mapeo de terminos
		this.mapTerms(entryAgreement.getTerms().getComprisedTerms());

		if (entryAgreement instanceof Template) {
			isTemplate = true;
			Template template = (Template) entryAgreement;
			CreationConstraints cc = template.getCc();

			// XXX items de las creations constraints
			Set<Item> items = cc.getItems();
			Iterator<Item> itemsIterator = items.iterator();
			// HashMap<String, Metric> varsDoms = new HashMap<String, Metric>();
			while (itemsIterator.hasNext()) {
				Item item = itemsIterator.next();
				addItemVar(item);
			}
			// importante, le metemos las variables al parser
			// restricciones de las creation constraints
			Set<GeneralConstraint> cons = cc.getConstraints();
			Iterator<GeneralConstraint> consIterator = cons.iterator();
			while (consIterator.hasNext()) {
				GeneralConstraint genCon = consIterator.next();
				String stringConstraint = genCon.getConstraint();
				ParsingResult ps = p.parseConstraint(stringConstraint);
				if (!ps.getUnknownVars().isEmpty()) {
					// si cntiene vble no definidas, no metemos la restriccion
					// pueden estar en la plantilla
					if (isTemplate) {
						unknownVars.add(genCon);
					}
					//
				} else {
					Constraint c = ps.getConstraint();
					chocoConstraints.put(genCon, c);
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
				Set<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> variables = sp.getVariableSet();
				Iterator<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> it3 = variables.iterator();

				while (it3.hasNext()) {
					es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable v = (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable) it3.next();
					addVar(v);
				}

			}
		}

	}

	// protected void addVar(es.us.isa.ada.wsag10.Variable var) {
	// Variable v = null;
	// String name = var.getUniqueName();
	// if (!chocoVars.containsKey(name)){
	// Metric m = var.getMetric();
	// String dataType = m.getDataType();
	// String oMax = m.getMax(), oMin = m.getMin();
	// if (dataType.equalsIgnoreCase(Metric.INTEGER_TYPE)) {
	// int max = Integer.parseInt(oMax), min = Integer.parseInt(oMin);
	// v = makeIntegerVar(var.getUniqueName(), min, max);
	// } else if (dataType.equalsIgnoreCase(Metric.REAL_TYPE)) {
	// double max = Double.parseDouble(oMax), min = Double.parseDouble(oMin);
	// v = makeRealVar(var.getUniqueName(), min, max);
	// } else if (dataType.equalsIgnoreCase(Metric.STRING_TYPE)) {
	// // TODO variables enumeradas
	// }
	// else{
	// throw new
	// IllegalArgumentException("Tipo de la variable "+name+" no soportado");
	// }
	// chocoVars.put(var.getUniqueName(), v);
	// servicePropsMap.put(var.getUniqueName(), var);
	// }
	// else{
	// duplicatedVars.add(var);
	// }
	//
	// }

	protected void addVar(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable var) {
		Variable v = null;
		String name = var.getUniqueName();
		if (!chocoVars.containsKey(name)) {
			Domain d = var.getDomain();
			if (d instanceof IntegerDomain) {
				IntegerDomain dom = (IntegerDomain) d;
				Collection<IntegerRange> ranges = dom.getRanges();
				int absoluteMin = Integer.MAX_VALUE, absoluteMax = Integer.MIN_VALUE;
				for (IntegerRange range : ranges) {
					if (range.getMin() < absoluteMin) {
						absoluteMin = range.getMin();
					}
					if (range.getMax() > absoluteMax) {
						absoluteMax = range.getMax();
					}
				}
				IntegerVariable chocoVar = Choco.makeIntVar(name, absoluteMin, absoluteMax);

				// si tiene mas de un rango, metemos las restricciones
				// adicionales
				if (ranges.size() > 1) {
					Collection<Constraint> consCol = new LinkedList<Constraint>();
					for (IntegerRange range : ranges) {
						Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()), Choco.leq(chocoVar, range.getMax()));
						consCol.add(aux);
					}
					Constraint[] consArray = consCol.toArray(new Constraint[0]);
					Constraint domainConstraint = Choco.and(consArray);
					// estas restricciones deberemos tenerlas luego en cuenta
					// en las operaciones
					domainExtraConstraints.add(domainConstraint);
				}
				v = chocoVar;

			} else if (d instanceof RealDomain) {
				RealDomain dom = (RealDomain) d;
				Collection<RealRange> ranges = dom.getRanges();
				double absoluteMin = Double.POSITIVE_INFINITY, absoluteMax = Double.NEGATIVE_INFINITY;
				for (RealRange range : ranges) {
					if (range.getMin() < absoluteMin) {
						absoluteMin = range.getMin();
					}
					if (range.getMax() > absoluteMax) {
						absoluteMax = range.getMax();
					}
				}
				RealVariable chocoVar = Choco.makeRealVar(name, absoluteMin, absoluteMax);

				// si tiene mas de un rango, metemos las restricciones
				// adicionales
				if (ranges.size() > 1) {
					Collection<Constraint> consCol = new LinkedList<Constraint>();
					for (RealRange range : ranges) {
						Constraint aux = Choco.and(Choco.geq(chocoVar, range.getMin()), Choco.leq(chocoVar, range.getMax()));
						consCol.add(aux);
					}
					Constraint[] consArray = consCol.toArray(new Constraint[0]);
					Constraint domainConstraint = Choco.and(consArray);
					// estas restricciones deberemos tenerlas luego en cuenta
					// en las operaciones
					domainExtraConstraints.add(domainConstraint);
				}
				v = chocoVar;
			} else if (d instanceof EnumeratedDomain) {
				EnumeratedDomain dom = (EnumeratedDomain) d;
				Collection<Integer> col = dom.getIntegerValues();
				int[] values = new int[col.size()];
				int i = 0;
				for (Integer elem : col) {
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
		
		//creamos la restriccion
		Restriction r = (Restriction) i.getIconst();
		String sMin = r.getMinInclusive(), sMax = r.getMaxInclusive();
		if (!chocoVars.containsKey(vName)) {
			unknownVars.add(i);
		} else {
			Variable v = chocoVars.get(vName);

			if (v instanceof IntegerVariable) {
				int min = Integer.parseInt(sMin), max = Integer.parseInt(sMax);
				IntegerVariable intVar = (IntegerVariable) v;
				Constraint c = Choco.and(Choco.leq(intVar, max), Choco.geq(intVar, min));
				chocoConstraints.put(i, c);
			}

			else if (v instanceof RealVariable) {
				double min = Double.parseDouble(sMin), max = Double.parseDouble(sMax);
				RealVariable realVar = (RealVariable) v;
				Constraint c = Choco.and(Choco.leq(realVar, max), Choco.geq(realVar, min));
				chocoConstraints.put(i, c);
			} else {
				// TODO implementar cuando se permitan vbles con strings
			}
		}
	}

	protected void mapTerms(List<Term> list) {
		// mapeamos primero los SDT's porque
		// pueden contener variables que luego usen
		// los GT's
		for (Term t : list) {
			if (t instanceof ServiceDescriptionTerm) {
				termToConstraint(t);
				// Constraint c = termToConstraint(t);
				// if (c != null){
				// chocoConstraints.put(t, c);
				// }
			}
		}

		Iterator<Term> it = list.iterator();
		while (it.hasNext()) {
			Term term = it.next();
			if (!(term instanceof ServiceDescriptionTerm)) {
				termToConstraint(term);
				// Constraint c = termToConstraint(term);
				// if (c != null){
				// chocoConstraints.put(term, c);
				// }
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

			Map<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction> moreFeatures = sdt.getServiceFeatures();
			Iterator<Entry<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction>> secondIt = moreFeatures.entrySet().iterator();
			while (secondIt.hasNext()) {
				Entry<es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable, Restriction> entry = secondIt.next();
				es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable agreementVar = entry.getKey();
				addVar(agreementVar);
				p.setVariables(chocoVars);
			}

			// S-lo a-adimos las restricciones de los OfferItems si el documento
			// es una oferta. En las plantillas, los valores que aparecen en los
			// OfferItems se consideran valores 'por defecto' o 'de ejemplo' por
			// lo que no deben ser tenidos en cuenta a la hora de analizar.
			if(doc instanceof AgreementOffer){
				Iterator<OfferItem> itSdt = sdt.getOfferItems().iterator();
				while (itSdt.hasNext()) {
					OfferItem oi = itSdt.next();
					Restriction value = oi.getRestriction();
					// Si no tiene valor no se crea la constraint
					if (!value.getFixedValue().equals("")) {
						Constraint c;
						try {
							c = Utils.restriction2Choco(oi.getName(), value, chocoVars);
							chocoConstraints.put(oi, c);
						} catch (UnknownVariableException e) {
							// no puede darse esta excepcion
							// la vble se ha a-adido en addVar
						}
					}
				}
			}

			// Constraint[] arraySDT = listaSDT.toArray(new Constraint[0]);
			// res = Choco.and(arraySDT);
		} else if (term instanceof GuaranteeTerm) {
			GuaranteeTerm gt = (GuaranteeTerm) term;
			if (!gt.hasQualifyCondition()) {
				StringSLO slo = new StringSLO();
				if (slo.getClass().isInstance(gt.getSlo())) {
					slo = (StringSLO) gt.getSlo();
					String stringConstraint = slo.getSlo();
					ParsingResult ps = p.parseConstraint(stringConstraint);
					res = ps.getConstraint();

					if (!ps.getUnknownVars().isEmpty()) {
						res = Choco.TRUE;
						if (isTemplate) {
							unknownVars.add(gt);
						}
					}
					chocoConstraints.put(gt, res);
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
					chocoConstraints.put(gt, c2);

					if (!ps1.getUnknownVars().isEmpty() || !ps2.getUnknownVars().isEmpty()) {
						if (isTemplate) {
							unknownVars.add(gt);
						}
						res = Choco.TRUE;
					} else {
						ChocoComplexGT complexGT = new ChocoComplexGT(c2, c1, gt);
						complexGTs.put(gt, complexGT);
						res = Choco.implies(c2, c1);
						chocoConstraints.put(gt, res);
					}
				}
			}

			// pillar aqui el valor de utilidad
			Collection<Preference> utilVals = gt.getBvl().getPreferences();
			Iterator<Preference> it = utilVals.iterator();
			Set<ServiceDescriptionTerm> sdts = new HashSet<ServiceDescriptionTerm>();
			float sum = 0;
			while (it.hasNext()) {
				Preference p = it.next();
				sum = sum + p.getUtility();
				ServiceDescriptionTerm aux = p.getServiceTermReference();
				if (sdts.contains(aux)) {
					// error
					duplicatedSDTsGTs.add(gt);
				} else {
					sdts.add(aux);
				}
			}
			if (sum > 1) {
				wrongUtilityVals.put(gt, sum);
			}

		} else if (term instanceof ServiceReference) {
			// TODO hasta que el estandar no se clarifique, nada
		}
		// else if (term instanceof TermCompositor) {
		// TermCompositor compositor = (TermCompositor) term;
		//
		// List<Term> termList = compositor.getComprisedTerms();
		// Iterator<Term> it = termList.iterator();
		// Constraint[] array = new Constraint[termList.size()];
		// int i = 0;
		//
		// while (it.hasNext()) {
		// Term t = it.next();
		// Constraint aux = termToConstraint(t);
		// array[i] = aux;
		// i++;
		// }
		//
		// String type = compositor.getType();
		//
		// if (type.equals(TermCompositor.ALL)) {
		// res = Choco.and(array);
		// } else if (type.equals(TermCompositor.EXACTLY_ONE)) {
		// // FIXME revisar si esto esta bien, se supone que choco
		// // introduce las restricciones asociadas a una variable
		// // sin necesidad de meter estas de forma explicita
		// // y viceversa
		// IntegerVariable[] auxVars = new IntegerVariable[array.length];
		// Constraint[] auxCons = new Constraint[array.length];
		// String nameAux = compositor.getTermName() + "-Xor_Variable";
		// for (i = 0; i < array.length; i++) {
		// // creamos n variables, que tendran valor 1 si
		// // su restriccion asociada se cumple
		// auxVars[i] = Choco.makeBooleanVar(nameAux + 1);
		// auxCons[i] = Choco.ifOnlyIf(array[i], Choco.eq(auxVars[i],
		// 1));
		// }
		// // finalmente, imponemos que la suma total de los valores
		// // de esas variables sea 1, por lo que solo se cumple
		// // una unica restriccion
		// res = Choco.eq(Choco.sum(auxVars), 1);
		// } else if (type.equals(TermCompositor.ONE_OR_MORE)) {
		// res = Choco.or(array);
		// }
		//
		// }
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

	public Map<String, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable> getServicePropsMap() {
		return servicePropsMap;
	}

	public Collection<AgreementElement> getDuplicatedVars() {
		return duplicatedVars;
	}

	public Map<GuaranteeTerm, ChocoComplexGT> getComplexGTs() {
		return complexGTs;
	}

	public Collection<Term> getDuplicatedSDTsGTs() {
		return duplicatedSDTsGTs;
	}

	public Map<GuaranteeTerm, Float> getBadUtilitySums() {
		return wrongUtilityVals;
	}

	public Collection<AgreementElement> getUnknownVars() {
		return unknownVars;
	}

	public Collection<Constraint> getDomainAdditionalConstraints() {
		return domainExtraConstraints;
	}
}
