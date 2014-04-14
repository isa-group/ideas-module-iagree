package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.timeAware;

import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.constraints.ConstraintType;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.solver.Solver;
import choco.kernel.solver.variables.integer.IntDomainVar;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoReifiedTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.ADAException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainNoConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Context;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.CreationConstraints;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Item;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.OfferItem;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareGeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareGuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareItem;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.DisjointTemporalInterval;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.InverseTemporalPair;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.InverseTemporalSequence;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.TemporalInterval;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.TemporalSequence;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.utils.TemporalAwareUtils;

public class ChocoTimeAwareExplainNoConsistencyOp extends ChocoOperation implements ExplainNoConsistencyOperation{
	
	private DisjointTemporalInterval covering;
	
	private Map<AgreementElement, Collection<AgreementElement>> res;
	
	public ChocoTimeAwareExplainNoConsistencyOp(){
		super();
		covering = new DisjointTemporalInterval();
	}

	/*
	 * Por cada alternative, reificamos e intentamos maximizar. Nos vamos
	 * quedando con el conjunto menor (y su documento plano)
	 * 
	 * Una vez tengamos el menor, por cada elemento dentro del conjunto de
	 * conflicto, imponemos este y reificamos el resto para obtener el mapping
	 * AgreementElement -> Collection<AgreementElement>
	 * 
	 * (non-Javadoc)
	 * 
	 * @see
	 * es.us.isa.ada.choco.ChocoOperation#execute(es.us.isa.ada.choco.ChocoAnalyzer
	 * )
	 */

	@Override
	public void execute(ChocoAnalyzer an) {
		res = new HashMap<AgreementElement, Collection<AgreementElement>>();
		AbstractDocument d = this.docs.get(0);

		// explanations previas sobre variables duplicadas, SDT's duplicados
		// en las referencias desde GT's para valores de utilidad, y
		// sumas incorrectas de los valores de utilidad
		ChocoTranslator basicTrans = new ChocoTranslator(d);
		basicTrans.translate();
		Collection<AgreementElement> duplicatedVars = basicTrans.getDuplicatedVars();
		Collection<Term> gtsErrors = basicTrans.getDuplicatedSDTsGTs();
		Map<GuaranteeTerm, Float> badUtils = basicTrans.getBadUtilitySums();
		Collection<AgreementElement> unknownVars = basicTrans.getUnknownVars();

		if (!duplicatedVars.isEmpty()) {
			for (AgreementElement elem : duplicatedVars) {
				res.put(elem, new LinkedList<AgreementElement>());
			}
		}
		if (!gtsErrors.isEmpty()) {
			for (AgreementElement elem : gtsErrors) {
				res.put(elem, new LinkedList<AgreementElement>());
			}
		}
		if (!badUtils.isEmpty()) {
			for (AgreementElement elem : badUtils.keySet()) {
				res.put(elem, new LinkedList<AgreementElement>());
			}
		}
		if (!unknownVars.isEmpty()) {
			for (AgreementElement elem : unknownVars) {
				res.put(elem, new LinkedList<AgreementElement>());
			}
		}

		// aqui almacenamos el conjunto minimo de explanations
		Collection<IntegerVariable> minSet = new LinkedList<IntegerVariable>();
		Collection<Constraint> minSetConstraints = null;
		Map<IntegerVariable, AgreementElement> minSetVars = null;
		int minSetSize = Integer.MAX_VALUE;
		ChocoReifiedTranslator minSetTranslator = null;

		Collection<AbstractDocument> altDocs = super.getAlternatives(d, an, true);

		// -----------------------
		// ------ ERRORES --------
		// -----------------------

		// por cada alternative, tomamos el minimo conjunto de elementos
		// de explaining, y de todos los alternatives, nos kedamos con el menor
		Iterator<AbstractDocument> it = altDocs.iterator();
		// boolean hayErrores = true;
		while (it.hasNext()) {
			AbstractAgreementDocument alternative = (AbstractAgreementDocument) it.next();

			Collection<AbstractDocument> views = super.getViews(alternative, an).values();
			Iterator<AbstractDocument> itViews = views.iterator();

			while (itViews.hasNext()) {
				AbstractAgreementDocument viewDoc = (AbstractAgreementDocument) itViews.next();
				
				TemporalSequence equivalentTemporalSequence = TemporalAwareUtils.getEquivalentTemporalSequence(viewDoc);
				InverseTemporalSequence its = equivalentTemporalSequence.getInverseTemporalSequence();
				
				// The temporal interval to be covered is the global validity period
				// We need an auxiliary variable in order to remove temporal intervals for it. 
				// In order to do it properly, a clone should be used (!)
				DisjointTemporalInterval gvp = new DisjointTemporalInterval();
				covering.add(its.getValidityPeriod());
				gvp.add(its.getValidityPeriod());
				
				for(InverseTemporalPair itp: its.getPairs()){
					// This is the point for non-temporal checking consistency to be asked (!)
					LinkedHashSet<Object> terms = itp.getData();
					// Si en los t-rminos del conjunto no aparece alguno de los t-rminos
					// que est-n definidos en todo el periodo global, es que hay overcovering
					// Lo comprobamos dentro de createNewDocument
					
					// A new document with terms in the same period is created to be analysed
					AbstractDocument newDoc = createNewDocument(viewDoc, terms);
					
					ChocoReifiedTranslator trans = new ChocoReifiedTranslator(newDoc);
					trans.translate();
					Collection<Constraint> constraints = trans.getChocoConstraints().values();
					Map<IntegerVariable, AgreementElement> reifiedVars = trans.getReifiedVariables();

					if (!reifiedVars.isEmpty()) {
						IntegerVariable[] varsToMax = reifiedVars.keySet().toArray(new IntegerVariable[0]);
						IntegerVariable suma = Choco.makeIntVar("Maximizacion", 0, varsToMax.length);
						// esta linea esta bien
						IntegerExpressionVariable sumatorio = Choco.sum(varsToMax);
						Constraint sumReifieds = Choco.eq(suma, sumatorio);

						CPModel problem = new CPModel();
						Iterator<Constraint> itConstraints = constraints.iterator();
						while (itConstraints.hasNext()) {
							Constraint c = itConstraints.next();
							problem.addConstraint(c);
						}
						problem.addConstraint(sumReifieds);

						CPSolver solver = new CPSolver();
						solver.read(problem);
						solver.maximize(solver.getVar(suma), false);

						// si ha encontrado errores
						if ((solver.getVar(suma)).getVal() < varsToMax.length) {

							Set<IntegerVariable> expElements = new HashSet<IntegerVariable>();

							Iterator<Entry<IntegerVariable, AgreementElement>> itVars = reifiedVars.entrySet().iterator();
							while (itVars.hasNext()) {
								Entry<IntegerVariable, AgreementElement> e = itVars.next();
								IntDomainVar solVar = solver.getVar(e.getKey());
								if (solVar.getVal() == 0) {
									expElements.add(e.getKey());
								}
							}

							if (expElements.size() < minSetSize) {
								minSetSize = expElements.size();
								minSet = expElements;
								minSetConstraints = constraints;
								minSetVars = reifiedVars;
								minSetTranslator = trans;
								/*
								 * detalle de implementacion: choco almacena en las
								 * variables todas las constraints en las que dicha
								 * variable aparece. por ello, vamos a eliminar esas
								 * restricciones, salvo la del reificado de la
								 * variable con el if only if (si y solo si)
								 */
								Set<Entry<IntegerVariable, AgreementElement>> entries = reifiedVars.entrySet();
								for (Entry<IntegerVariable, AgreementElement> entry : entries) {
									IntegerVariable var = entry.getKey();
									Constraint[] varConstraints = var.getConstraints();
									for (Constraint c : varConstraints) {
										if (!c.getConstraintType().equals(ConstraintType.IFONLYIF)) {
                                            // This was var.removeConstraint(c); but the method doesn't exist
											var._removeConstraint(c);
										}
									}
								}
							}
						}else{
							// no ha encontrado errores en este periodo
							// Temporal overcovering is checked
							DisjointTemporalInterval dti = new DisjointTemporalInterval(itp.getValidityPeriods());
							if (!dti.except(gvp).isEmpty()){
								throw new PeriodDefinitionWarningException("Overcovering detected! The following terms are overcovering the global period: "+terms);
							}
							// AND The covered temporal interval is removed 		
							covering.remove(itp.getValidityPeriods());
						}
					}
				}
			}
		}
		// In the end, if there aren-t errors and the covering is empty, the covering is not complete (!)
		// If some error exists, it has no sense to check for Undercovering
		if (minSetVars == null){
			if (!covering.isEmpty()){
				throw new PeriodDefinitionWarningException("Undercovering detected! Global period isn-t covered by all validity periods");
			}
		}
		
//		System.out.println("Ya hemos encontrado los errores");
		// ----------------------
		// ---- EXPLAINING ------
		// ------ (CAUSAS) ------
		// ----------------------

		// por cada error encontrado en el conjunto minimo
		if (minSetSize > 0) {
			for (IntegerVariable var : minSet) {
				Set<Entry<IntegerVariable, AgreementElement>> entries = minSetVars.entrySet();
				AgreementElement error = minSetVars.get(var);
				Collection<AgreementElement> causes = new LinkedList<AgreementElement>();
				CPModel problem = new CPModel();
				// recordar que ya tenemos el conjunto minimo de fallos
				// ya solo queda encontrar aquellos elementos que los originan

				// comprobamos con esto si el termino falla
				// por si mismo
				Model auxModel = new CPModel();
				Constraint[] varConstraints = var.getConstraints();
				auxModel.addConstraints(varConstraints);
				// aqui tengo que cargarme el resto de restricciones
				// que son erroneas
				auxModel.addConstraint(Choco.eq(var, 1));
				Solver auxSolver = new CPSolver();
				auxSolver.read(auxModel);

				if (auxSolver.solve()) {
					// Y LAS RESTRICCIONES DE ABAJO, POR QUE NO SE REIFICAN?
					// porque esas no fallan seguro
					// al encontar las inconsistencias, buscamos todas las
					// soluciones,
					// y en ese conjunto estan todas las restricciones
					// problematicas
					Iterator<Constraint> itConstraints = minSetConstraints.iterator();

					while (itConstraints.hasNext()) {
						Constraint c = itConstraints.next();
						problem.addConstraint(c);
					}

					// necesito eliminar
					// las constraints de los otros errores
					Map<IntegerVariable, AgreementElement> auxMap1 = minSetTranslator.getReifiedVariables();
					Map<String, Constraint> auxMap2 = minSetTranslator.getChocoConstraints();
					for (IntegerVariable varAux : minSet) {
						if (varAux != var) {
							AgreementElement elemAux = auxMap1.get(varAux);
							//Distinguimos entre OfferItem y el resto de AgElements.
							//Sino, el nombre del OfferItem se puede considerar
							//erroneamente como un Item de CreationConstraint y
							//eliminar la constraint equivocada
							if(elemAux instanceof OfferItem){
								Constraint cAux = auxMap2.get(elemAux.toString());
								problem.removeConstraint(cAux);
							}else{
								Constraint cAux = auxMap2.get(elemAux.getName());
								problem.removeConstraint(cAux);
							}
						}
					}

					// y meto variables reificadas
					// el error lo impongo como fijo a 1
					Collection<IntegerVariable> reifiedVars = new LinkedList<IntegerVariable>();
					for (Entry<IntegerVariable, AgreementElement> entry : entries) {
						if (entry.getKey() == var) {
							Constraint c1 = Choco.eq(entry.getKey(), 1);
							problem.addConstraint(c1);
						} else {
							reifiedVars.add(entry.getKey());
						}
					}
					IntegerVariable[] varsToMax = reifiedVars.toArray(new IntegerVariable[0]);
					IntegerVariable suma = Choco.makeIntVar("Maximizacion", 0, varsToMax.length);
					if (varsToMax.length > 0) {
						IntegerExpressionVariable sumatorio = Choco.sum(varsToMax);
						Constraint sumReifieds = Choco.eq(suma, sumatorio);
						problem.addConstraint(sumReifieds);

						Solver solver = new CPSolver();
						solver.read(problem);
						solver.maximize(solver.getVar(suma), false);

						// en el solver ya tenemos impuesta la restriccion
						// del error, y reificadas las posibles causas
						// ahora maximizamos las posibles causas
						// para encontrar las verdaderas

						for (Entry<IntegerVariable, AgreementElement> entry : entries) {
							IntDomainVar solVar = solver.getVar(entry.getKey());
							if (solVar.getVal() == 0) {
								AgreementElement cause = entry.getValue();
								//Si es un OfferItem queremos que aparezca 
								//como por ejemplo "SDT1-Size"
								if(cause instanceof OfferItem){
									cause.setName(((OfferItem)cause).toString());
								}
								appendPeriodNameToAgreementElement(cause);
								causes.add(cause);
							}
						}

					}

				} else {
					// la causa es la propia restriccion consigo misma
					appendPeriodNameToAgreementElement(error);
					causes.add(error);
					// TODO hay que tener cuidao en este caso, pk puede afectar
					// a otros
					// elementos, cuando el problema de este elemento es consigo
					// mismo
				}
				//Si el error es un OfferItem queremos que aparezca
				//como por ejemplo "SDT1-Size"
				if(error instanceof OfferItem){
					error.setName(((OfferItem)error).toString());
				}
				appendPeriodNameToAgreementElement(error);
				// TODO en el futuro estar-a bien generar un periodo en 4people que
				// indique los instantes temporales en los que los t-rminos son inconsistentes
				// en vez de decir el nombre de los periodos de cada t-rmino. Por ejemplo,
				// que en la explicaci-n se dijera que el conflicto est- en los lunes y martes
				// del periodo WORK.
				res.put(error, causes);

			}
		}
//		System.out.println("Ya hemos encontrando las explanations a los errores");
	}

	@Override
	public Map<AgreementElement, Collection<AgreementElement>> explainErrors() {
		return res;
	}
	
	private AbstractAgreementDocument createNewDocument(AbstractAgreementDocument doc, LinkedHashSet<Object> terms){
		AbstractAgreementDocument newDoc;
		
		//Los t-rminos que nos llegan pueden ser GT, SDT, Items y Constraints
		TermCompositor compositor = new TermCompositor();
		compositor.setType(TermCompositor.ALL);
		compositor.setName("terms");
		CreationConstraints cc = new CreationConstraints();
		Boolean isThereSomeGlobalPeriodInTerms = false;
		if(doc.getHasSomeGlobalTerm()){
			// tenemos que ver si hay alg-n global term en el conjunto de t-rminos. Si no hay ninguno
			// estamos ante un overcovering
		}
		for(Object t: terms){
			if(t instanceof Item){
				cc.addItem((Item) t);
				if(((TimeAwareItem) t).getValidityPeriod() == null){
					// este t-rmino es v-lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}else if(t instanceof GeneralConstraint){
				cc.addConstraint((GeneralConstraint) t);
				if(((TimeAwareGeneralConstraint) t).getValidityPeriod() == null){
					// este t-rmino es v-lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}else if(t instanceof Term){
//				if(t instanceof ServiceDescriptionTerm){
//					hasSDT = true;
//				}
				compositor.addComprisedTerm((Term) t);
				if(t instanceof TimeAwareServiceDescriptionTerm && ((TimeAwareServiceDescriptionTerm) t).getValidityPeriod() == null){
					// este t-rmino es v-lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}else if(t instanceof TimeAwareGuaranteeTerm && ((TimeAwareGuaranteeTerm) t).getValidityPeriod() == null){
					// este t-rmino es v-lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}
		}
		// Si en el documento hay t-rminos v-lidos para todo el global period,
		// pero en Terms no hay ninguno entonces estamos ante un overcovering
		if(doc.getHasSomeGlobalTerm() != isThereSomeGlobalPeriodInTerms){
			throw new PeriodDefinitionWarningException("Overcovering detected! The following terms are overcovering the global period: "+terms);
		}
		//Si es una plantilla tenemos que meter tambi-n las CreationConstraints
		if(doc instanceof Template){
			Template t = new Template();
			t.setCc(cc);
			newDoc = t;
		}else if(doc instanceof AgreementOffer){
			newDoc = new AgreementOffer();
		}else{
			throw new ADAException("The document isn-t a template neither an offer");
		}
		newDoc.setId(doc.getId());
		newDoc.setName(doc.getName());
		newDoc.setContext((Context) doc.getContext());
		// Tambi-n tenemos que a-adir las ServiceProperties del documento
		// original, sino fallar-a el translator a Choco por no conocer las
		// variables que se usan en el documento
		for(Term t: doc.getAllTerms()){
			if(t instanceof ServiceProperties){
				compositor.addComprisedTerm(t);
			}
		}
		newDoc.setTerms(compositor);
		return newDoc;
	}
	
	private void appendPeriodNameToAgreementElement(AgreementElement ae){
		TimeAwareTerm taTerm = (TimeAwareTerm) ae;
		String name = taTerm.getValidityPeriod().getName();
		ae.setName(ae.getName()+" on "+name);
	}

}
