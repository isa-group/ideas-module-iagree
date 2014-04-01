package es.us.isa.ada.choco.questions.timeAware;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.Model;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.solver.ContradictionException;
import es.us.isa.ada.choco.ChocoAnalyzer;
import es.us.isa.ada.choco.ChocoOperation;
import es.us.isa.ada.choco.translators.ChocoTranslator;
import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.document.AgreementElement;
import es.us.isa.ada.exceptions.ADAException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ada.operations.ConsistencyOperation;
import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.AgreementOffer;
import es.us.isa.ada.wsag10.Context;
import es.us.isa.ada.wsag10.CreationConstraints;
import es.us.isa.ada.wsag10.GeneralConstraint;
import es.us.isa.ada.wsag10.GuaranteeTerm;
import es.us.isa.ada.wsag10.Item;
import es.us.isa.ada.wsag10.ServiceProperties;
import es.us.isa.ada.wsag10.Template;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.ada.wsag10.TermCompositor;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareGeneralConstraint;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareGuaranteeTerm;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareItem;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareServiceDescriptionTerm;
import es.us.isa.temporalAlgorithms.ConsistencyResult;
import es.us.isa.temporalAlgorithms.DisjointTemporalInterval;
import es.us.isa.temporalAlgorithms.InverseTemporalPair;
import es.us.isa.temporalAlgorithms.InverseTemporalSequence;
import es.us.isa.temporalAlgorithms.TemporalSequence;
import es.us.isa.temporalAlgorithms.utils.TemporalAwareUtils;

public class ChocoTimeAwareConsistencyOp extends ChocoOperation implements ConsistencyOperation{
	
	private DisjointTemporalInterval covering;
	
	private ConsistencyResult consistencyResult;
	
	public ChocoTimeAwareConsistencyOp(){
		super();
		consistencyResult = ConsistencyResult.INCONSISTENT;
		covering = new DisjointTemporalInterval();
	}
	
	@Override
	public boolean isConsistent() {
		Boolean result = false;
		if(consistencyResult == ConsistencyResult.CONSISTENT){
			result = true;
		}
		return result;
	}
	
	@Override
	public void execute(ChocoAnalyzer an) {
		consistencyResult = ConsistencyResult.CONSISTENT;
		if (!docs.isEmpty()) {
			AbstractAgreementDocument d = (AbstractAgreementDocument) this.docs.get(0);

			ChocoTranslator trans = new ChocoTranslator(d);
			trans.translate();
			Collection<AgreementElement> duplicatedVars = trans
					.getDuplicatedVars();
			Collection<Term> gtsErrors = trans.getDuplicatedSDTsGTs();
			Map<GuaranteeTerm, Float> badUtils = trans.getBadUtilitySums();
			Collection<AgreementElement> unknownVars = trans.getUnknownVars();
			// comprobaciones previas
			// si hay variables duplicadas, sdts repetidos en valores de
			// utilidad,
			// sumas incorrectas en dichos valores de utilidad de los GT's,
			// o variables no declaradas,
			// el documento no es consistente
			if (!duplicatedVars.isEmpty() || !gtsErrors.isEmpty()
					|| !badUtils.isEmpty() || !unknownVars.isEmpty()) {
				consistencyResult = ConsistencyResult.INCONSISTENT;
			}
			else{
				//con que uno de los documentos planos sea consistente basta
				Collection<AbstractDocument> alternativeDocs = super.getAlternatives(d, an,true);
				Iterator<AbstractDocument> it = alternativeDocs.iterator();

				while (it.hasNext() && consistencyResult == ConsistencyResult.CONSISTENT) {
					AbstractAgreementDocument aux = (AbstractAgreementDocument) it.next();
					Collection<AbstractDocument> views = super.getViews(aux, an).values();
					Iterator<AbstractDocument> itViews = views.iterator();
					
					while (itViews.hasNext() && consistencyResult == ConsistencyResult.CONSISTENT){
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
							// Si en los t�rminos del conjunto no aparece alguno de los t�rminos
							// que est�n definidos en todo el periodo global, es que hay overcovering
							// Lo comprobamos dentro de createNewDocument
							
							// A new document with terms in the same period is created to be analysed
							AbstractDocument newDoc = createNewDocument(viewDoc, terms);
							
							//Calling solver
							Model problem = new CPModel();
							trans = new ChocoTranslator(newDoc);
							trans.translate();

							addToChoco(problem, trans);
							CPSolver solver = new CPSolver();
							solver.read(problem);
							try {
								solver.propagate();
								if(solver.solve()){
									consistencyResult = ConsistencyResult.CONSISTENT;
								}else{
									consistencyResult = ConsistencyResult.INCONSISTENT;
								}
							} catch (ContradictionException e) {
								consistencyResult = ConsistencyResult.INCONSISTENT;
							}
							
							if(consistencyResult == ConsistencyResult.CONSISTENT){
								// Temporal overcovering is checked
								DisjointTemporalInterval dti = new DisjointTemporalInterval(itp.getValidityPeriods());
								if (!dti.except(gvp).isEmpty()){
									consistencyResult = ConsistencyResult.TEMPORAL_OVERCOVERING;
									throw new PeriodDefinitionWarningException("Overcovering detected! The following terms are overcovering the global period: "+terms);
								}
								// AND The covered temporal interval is removed 		
								covering.remove(itp.getValidityPeriods());
							}else{
								consistencyResult = ConsistencyResult.INCONSISTENT;
								break;
							}
							
							TemporalAwareUtils.printGlobalValidityPeriod(covering);
						}
					}
				}
				// In the end, if empty, the covering is not complete (!)
				if (consistencyResult != ConsistencyResult.INCONSISTENT && consistencyResult != ConsistencyResult.TEMPORAL_OVERCOVERING){
					if (!covering.isEmpty()){
						consistencyResult = ConsistencyResult.TEMPORAL_UNDERCOVERING_WARNING;
						throw new PeriodDefinitionWarningException("Undercovering detected! Global period isn�t covered by all validity periods");
					}
				}
			}
			
		} else {
			consistencyResult = ConsistencyResult.INCONSISTENT;
		}

	}
	
//	@Override
//	public void execute(ChocoAnalyzer an){
//		if(docs.isEmpty()){
//			throw new ADAException("There are no documents to analyse");
//		}else{
//			consistent = true;
//			AbstractAgreementDocument doc = (AbstractAgreementDocument) this.docs.get(0);
//			
//			TemporalSequence equivalentTemporalSequence = TemporalAwareUtils.getEquivalentTemporalSequence(doc);
//			InverseTemporalSequence its = equivalentTemporalSequence.getInverseTemporalSequence();
//			
//			// The temporal interval to be covered is the global validity period
//			DisjointTemporalInterval covering = new DisjointTemporalInterval();
//			covering.add(its.getValidityPeriod());
//			
//			for(InverseTemporalPair itp: its.getPairs()){
//				// This is the point for non-temporal checking consistency to be asked (!)
//				LinkedHashSet<Object> terms = itp.getData();
//				// A new document with terms in the same period is created to be analysed
//				AbstractDocument newDoc = createNewDocument(doc, terms);
//				
//				// creamos el nuevo documento con los t�rminos que coinciden
//				//en un mismo intervalo, pero que los t�rminos no incluyan el intervalo
//				//para analizarlo con la operaci�n de consistencia sin temporalidad
//				
//				Boolean intervalConsistent = checkConsistency(newDoc, an);
//				if(intervalConsistent){
//					covering.remove(itp.getValidityPeriods());
//				}else{
//					consistent = false;
//				}
//				
//				printGlobalValidityPeriod(covering);
//			}
//			// In the end, if empty, the covering is not complete (!)
//			if (!covering.isEmpty()){
////				cr = ConsistencyResult.TEMPORAL_WARNING;
//				hasWarnings = true;
//			}
//		}
//	}
	
//	private boolean checkConsistency(AbstractDocument d, ChocoAnalyzer an){
//		ConsistencyOperation op = new ChocoConsistencyOp();
//		op.addDocument(d);
//		an.analyze(op);
//		boolean result = op.isConsistent(); 
//		return result;
//	}
	
	private AbstractAgreementDocument createNewDocument(AbstractAgreementDocument doc, LinkedHashSet<Object> terms){
		AbstractAgreementDocument newDoc;
		
		//Los t�rminos que nos llegan pueden ser GT, SDT, Items y Constraints
		TermCompositor compositor = new TermCompositor();
		compositor.setType(TermCompositor.ALL);
		compositor.setName("terms");
		CreationConstraints cc = new CreationConstraints();
		Boolean isThereSomeGlobalPeriodInTerms = false;
		if(doc.getHasSomeGlobalTerm()){
			// tenemos que ver si hay alg�n global term en el conjunto de t�rminos. Si no hay ninguno
			// estamos ante un overcovering
		}
		for(Object t: terms){
			if(t instanceof Item){
				cc.addItem((Item) t);
				if(((TimeAwareItem) t).getValidityPeriod() == null){
					// este t�rmino es v�lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}else if(t instanceof GeneralConstraint){
				cc.addConstraint((GeneralConstraint) t);
				if(((TimeAwareGeneralConstraint) t).getValidityPeriod() == null){
					// este t�rmino es v�lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}else if(t instanceof Term){
//				if(t instanceof ServiceDescriptionTerm){
//					hasSDT = true;
//				}
				compositor.addComprisedTerm((Term) t);
				if(t instanceof TimeAwareServiceDescriptionTerm && ((TimeAwareServiceDescriptionTerm) t).getValidityPeriod() == null){
					// este t�rmino es v�lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}else if(t instanceof TimeAwareGuaranteeTerm && ((TimeAwareGuaranteeTerm) t).getValidityPeriod() == null){
					// este t�rmino es v�lido en todo el global period
					isThereSomeGlobalPeriodInTerms = true;
				}
			}
		}
		// Si en el documento hay t�rminos v�lidos para todo el global period,
		// pero en Terms no hay ninguno entonces estamos ante un overcovering
		if(doc.getHasSomeGlobalTerm() != isThereSomeGlobalPeriodInTerms){
			throw new PeriodDefinitionWarningException("Overcovering detected! The following terms are overcovering the global period: "+terms);
		}
		//Si es una plantilla tenemos que meter tambi�n las CreationConstraints
		if(doc instanceof Template){
			Template t = new Template();
			t.setCc(cc);
			newDoc = t;
		}else if(doc instanceof AgreementOffer){
			newDoc = new AgreementOffer();
		}else{
			throw new ADAException("The document isn�t a template neither an offer");
		}
		newDoc.setId(doc.getId());
		newDoc.setName(doc.getName());
		newDoc.setContext((Context) doc.getContext());
		// Tambi�n tenemos que a�adir las ServiceProperties del documento
		// original, sino fallar�a el translator a Choco por no conocer las
		// variables que se usan en el documento
		for(Term t: doc.getAllTerms()){
			if(t instanceof ServiceProperties){
				compositor.addComprisedTerm(t);
			}
		}
		newDoc.setTerms(compositor);
		
//		// si el documento no tiene SDT quiere decir que hay overcovering
//		if(!hasSDT){
//			
//		}
		return newDoc;
	}
	
	private void addToChoco(Model chocoProblem, ChocoTranslator translator) {
		translator.translate();
		Collection<Constraint> constraints = translator.getChocoConstraints().values();
		Iterator<Constraint> itCons = constraints.iterator();
		while (itCons.hasNext()) {
			Constraint c = itCons.next();
			chocoProblem.addConstraint(c);
		}
	}
}
