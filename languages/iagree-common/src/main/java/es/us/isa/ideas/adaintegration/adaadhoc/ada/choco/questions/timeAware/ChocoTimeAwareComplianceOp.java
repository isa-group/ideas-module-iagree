package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.timeAware;

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
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoAlternativeDocumentsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoConsistencyOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoComplianceTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.Utils;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.ADAException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Context;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.CreationConstraints;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Item;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.DisjointTemporalInterval;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.InverseParallelIteratingPair;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.InverseParallelIteratingResult;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.ParallelIteratingResult;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.TemporalInterval;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.TemporalSequence;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.utils.TemporalAwareUtils;

public class ChocoTimeAwareComplianceOp extends ChocoOperation implements ComplianceOperation{

	private Boolean compliant;
	
	public ChocoTimeAwareComplianceOp(){
		super();
		compliant = false;
	}
	
	@Override
	public boolean isCompliant() {
		return compliant;
	}
	
	@Override
	public void execute(ChocoAnalyzer an) {
		/*
		 * Nuevas comprobaciones, por la aparicion de las vistas:
		 * 
		 * 1) Comprobar que todas las operaciones de los scopes
		 *    de la oferta estan tambien en la plantilla
		 *    
		 * 2) Recorrer todas las vistas de oferta y plantilla,
		 *    y emparejar las vistas correspondientes
		 */
		compliant = false;
		// compliant es una operacion definida sobre dos documentos, si no hay 2
		// la respuesta es false

		if (docs.size() == 2) {
			Template t;
			AgreementOffer o;
			AbstractDocument doc1 = docs.get(0), doc2 = docs.get(1);
			if (doc1 instanceof Template && doc2 instanceof AgreementOffer) {
				// nos aseguramos que el primer documento sea una plantilla
				// y el segundo una oferta
				t = (Template) doc1;
				o = (AgreementOffer) doc2;
				
				if (checkConsistency(t,an) && checkConsistency(o,an)){
					Context context = o.getContext();
					String tName = t.getName().trim(), tId = t.getId().trim();
					String refName = context.getTemplateName().trim(), refId = context
							.getTemplateId().trim();

					if (tName.equalsIgnoreCase(refName)
							&& tId.equalsIgnoreCase(refId)
							&& validScopes(o,t)) {
						//nos aseguramos que se referencie a la plantilla desde la oferta
						//y ademas nos aseguramos de que los scopes
						//definidos en la oferta esten en la plantilla
						ChocoAlternativeDocumentsOp adop = new ChocoAlternativeDocumentsOp();
						adop.addDocument(doc1);
						an.analyze(adop);
						Collection<AbstractDocument> alts1 = adop
								.getAlternativeDocuments();
						adop = new ChocoAlternativeDocumentsOp();
						adop.addDocument(doc2);
						an.analyze(adop);
						Collection<AbstractDocument> alts2 = adop
								.getAlternativeDocuments();

						Iterator<AbstractDocument> it1 = alts1.iterator();
						Iterator<AbstractDocument> it2;
						boolean b = false;

						while (it1.hasNext() && !b) {
							// por cada alternative document de la plantilla
							AbstractDocument d1 = it1.next();
							
							it2 = alts2.iterator();

							while (it2.hasNext() && !b) {
								// por cada alternative document de la oferta
								AbstractDocument d2 = it2.next();
								//tenemos en cuenta ya las vistas
								//por cada vista de la oferta,
								//la correspondiente de la plantilla
								Map<ServiceScope,AbstractDocument> offerviews = super.getViews(d2,an);
								Map<ServiceScope,AbstractDocument> templateviews = super.getViews(d1,an);
								Map<AbstractDocument,AbstractDocument> viewsMatched = matchViews(offerviews, templateviews);
								Set<Entry<AbstractDocument,AbstractDocument>> entries = viewsMatched.entrySet();
								
								for (Entry<AbstractDocument, AbstractDocument> entry:entries){
									Template temp = (Template) entry.getValue();
									AgreementOffer off = (AgreementOffer) entry.getKey();
									
									TemporalSequence etsTemp = TemporalAwareUtils.getEquivalentTemporalSequence(temp);
									TemporalSequence etsOff = TemporalAwareUtils.getEquivalentTemporalSequence(off);
									
									ParallelIteratingResult pir = etsTemp.iterate(etsOff);
									InverseParallelIteratingResult ipir = pir.getInverseParallelIteratingResult();
									
									DisjointTemporalInterval covering = new DisjointTemporalInterval();
									// Only the relevant intervals in N are taken into account, not the global validity period (!)
									for(InverseParallelIteratingPair ipip: ipir.getPairs()){
										if(!ipip.getDataN().isEmpty()){
											for(TemporalInterval ti: ipip.getValidityPeriods()){
												covering.add(ti);
											}
										}
									}
									
									// Initially, the covering includes the full "global" validity period (sum of local validity periods)
									for (InverseParallelIteratingPair ipip: ipir.getPairs()){
										// It is assumed to be compliant (!)	
										if (!ipip.getDataM().isEmpty()){ // and (RESOLUTION.CHECK-SATISFIABILITY(ipip.getDataM(), ipip.getDataN()
											LinkedHashSet<Object> templateTerms = ipip.getDataN();
											LinkedHashSet<Object> offerTerms = ipip.getDataM();
											
											// New documents with terms in the same period are created to be analysed
											AbstractAgreementDocument parcialTemplate = createNewDocument(t, templateTerms);
											AbstractAgreementDocument parcialOffer = createNewDocument(o, offerTerms);
											
											// Plantilla
											// la traduccion a choco en compliance de la plantilla
											// (primer documento) debe hacerse con el
											// ChocoTranslator basico
											ChocoTranslator trans1 = new ChocoTranslator(parcialTemplate);
											trans1.translate();
											// necesito todas las constraints de la plantilla
											Map<AgreementElement, Constraint> tempCons = trans1
													.getChocoConstraints();
											Map<String, Variable> tempVars = trans1.getChocoVars();
											// para evitar el nullPointerException
											Collection<Constraint> auxToArray = new LinkedList<Constraint>(
													tempCons.values());
											auxToArray.add(Choco.TRUE);
											// tempCons.put("_TrueAuxConstraint", Choco.TRUE);
											Constraint[] templateAux = auxToArray
													.toArray(new Constraint[0]);
											Constraint template = Choco.and(templateAux);
											
											// Oferta
											ChocoComplianceTranslator trans2 = new ChocoComplianceTranslator(
													parcialOffer, tempVars,trans1.getServicePropsMap());
											trans2.translate();
											Collection<AgreementElement> newVarsFromOffer = trans2
													.getNewVars();
											// todas las variables mismo dominio en oferta y
											// plantilla
											if (!trans2.hasDifferentDomains()
													&& newVarsFromOffer.isEmpty()) {

												// no considerar los sdt's de forma distinta
												Collection<Constraint> sdtConstraints = trans2
														.getSdtConstraints();
												Collection<Constraint> ccConstraints = trans2
														.getCcConstraints();
												Collection<Constraint> gtConstraints = trans2
														.getGtConstraints();

												int arraySize = ccConstraints.size() + gtConstraints.size() + sdtConstraints.size();
												Constraint[] basicConstraintsarray; 
												if (arraySize == 0){
													//para que al final tengamos algun tipo de restricion si no hay nada
													basicConstraintsarray = new Constraint[1];
													basicConstraintsarray[0] = Choco.TRUE;
												}
												else{
													basicConstraintsarray = new Constraint[arraySize];
													Iterator<Constraint> it = ccConstraints
															.iterator();
													int i = 0;
													while (it.hasNext()) {
														Constraint c = it.next();
														basicConstraintsarray[i] = c;
														i++;
													}
													it = gtConstraints.iterator();
													while (it.hasNext()) {
														Constraint c = it.next();
														basicConstraintsarray[i] = c;
														i++;
													}
													it = sdtConstraints.iterator();
													while (it.hasNext()) {
														Constraint c = it.next();
														basicConstraintsarray[i] = c;
														i++;
													};
												}
												
												Constraint offer = Choco.and(basicConstraintsarray);
												// offer compliant template
												b = Utils.isCompliantConstraint(offer, template);
											}
											
											if(b){ // Are compliant
												// The covered temporal interval is removed
												covering.remove(ipip.getValidityPeriods());
											}
										}
										//System.out.print("At this stage, global VP is ");
										//for(TemporalInterval ti1: covering.getTiList())
										//	System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
										//		+ ti1.getEndingTimePoint().getTick() + ")");
										//System.out.println();
									}
									
									// In the end, if empty, the covering is complete
									if (covering.isEmpty()){
										compliant = true;
									}
								}
							}
						}
						compliant = b;
					}
				}
			}
		}
	}
	
//	@Override
//	public void execute(ChocoAnalyzer an){
//		if(docs.isEmpty()){
//			throw new ADAException("There are no documents to analyse");
//		}else if(docs.size() != 2){
//			throw new ADAException("Compliance operation needs two documents");
//		}else{
//			AbstractDocument doc1 = docs.get(0), doc2 = docs.get(1);
//			if(doc1 instanceof Template && doc2 instanceof AgreementOffer){
//				Template t = (Template) doc1;
//				AgreementOffer o = (AgreementOffer) doc2;
//				
//				//Suponemos que ambos documentos son consistentes ya que la consistencia
//				//se comprobará después dentro de la operación Compliance sin temporalidad
//				TemporalSequence etsTemp = TemporalAwareUtils.getEquivalentTemporalSequence(t);
//				TemporalSequence etsOff = TemporalAwareUtils.getEquivalentTemporalSequence(o);
//				
//				ParallelIteratingResult pir = etsTemp.iterate(etsOff);
//				InverseParallelIteratingResult ipir = pir.getInverseParallelIteratingResult();
//				
//				DisjointTemporalInterval covering = new DisjointTemporalInterval();
//				// Only the relevant intervals in N are taken into account, not the global validity period (!)
//				for(InverseParallelIteratingPair ipip: ipir.getPairs()){
//					if(!ipip.getDataN().isEmpty()){
//						for(TemporalInterval ti: ipip.getValidityPeriods()){
//							covering.add(ti);
//						}
//					}
//				}
//				
//				// Initially, the covering includes the full "global" validity period (sum of local validity periods)
//				for (InverseParallelIteratingPair ipip: ipir.getPairs()){
//					// It is assumed to be compliant (!)	
//					if (!ipip.getDataM().isEmpty()){ // and (RESOLUTION.CHECK-SATISFIABILITY(ipip.getDataM(), ipip.getDataN()
//						LinkedHashSet<Object> templateTerms = ipip.getDataN();
//						LinkedHashSet<Object> offerTerms = ipip.getDataM();
//						
//						// New documents with terms in the same period are created to be analysed
//						AbstractAgreementDocument parcialTemplate = createNewDocument(t, templateTerms);
//						AbstractAgreementDocument parcialOffer = createNewDocument(o, offerTerms);
//						
//						if(checkCompliance(parcialTemplate, parcialOffer, an)){
//							// The covered temporal interval is removed
//							covering.remove(ipip.getValidityPeriods());
//						}
//					}
//					//System.out.print("At this stage, global VP is ");
//					//for(TemporalInterval ti1: covering.getTiList())
//					//	System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
//					//		+ ti1.getEndingTimePoint().getTick() + ")");
//					//System.out.println();
//				}
//				
//				// In the end, if empty, the covering is complete
//				if (covering.isEmpty()){
//					compliant = true;
//				}
//			}else{
//				throw new ADAException("First document must be a template and second document must be an offer");
//			}
//		}
//	}
	
//	private boolean checkCompliance(AbstractDocument temp, AbstractDocument off, ChocoAnalyzer an){
//		ComplianceOperation op = new ChocoComplianceOp();
//		op.addDocument(temp);
//		op.addDocument(off);
//		an.analyze(op);
//		boolean result = op.isCompliant(); 
//		return result;
//	}
	
	private AbstractAgreementDocument createNewDocument(AbstractAgreementDocument doc, LinkedHashSet<Object> terms){
AbstractAgreementDocument newDoc;
		
		//Los términos que nos llegan pueden ser GT, SDT, Items y Constraints
		TermCompositor compositor = new TermCompositor();
		compositor.setType(TermCompositor.ALL);
		compositor.setName("terms");
		CreationConstraints cc = new CreationConstraints();
		for(Object t: terms){
			if(t instanceof Item){
				cc.addItem((Item) t);
			}else if(t instanceof GeneralConstraint){
				cc.addConstraint((GeneralConstraint) t);
			}else if(t instanceof Term){
				compositor.addComprisedTerm((Term) t);
			}
		}
		//Si es una plantilla tenemos que meter también las CreationConstraints
		if(doc instanceof Template){
			Template t = new Template();
			t.setCc(cc);
			newDoc = t;
		}else if(doc instanceof AgreementOffer){
			newDoc = new AgreementOffer();
		}else{
			throw new ADAException("The document isn´t a template neither an offer");
		}
		newDoc.setId(doc.getId());
		newDoc.setName(doc.getName());
		newDoc.setContext((Context) doc.getContext());
		// También tenemos que añadir las ServiceProperties del documento
		// original, sino fallaría el translator a Choco por no conocer las
		// variables que se usan en el documento
		for(Term t: doc.getAllTerms()){
			if(t instanceof ServiceProperties){
				compositor.addComprisedTerm(t);
			}
		}
		newDoc.setTerms(compositor);
		
		return newDoc;
	}
	
	private boolean checkConsistency(AbstractDocument d, ChocoAnalyzer an){
		ConsistencyOperation op = new ChocoConsistencyOp();
		op.addDocument(d);
		an.analyze(op);
		boolean result = op.isConsistent(); 
		return result;
	}
	
	private boolean validScopes(AgreementOffer o, Template t) {
		// recorre la oferta para ver si todos los scopes
		// tienen su correspondencia en la plantilla
		Collection<Term> offerTerms = o.getAllTerms();
		Collection<ServiceScope> offerScopes = new HashSet<ServiceScope>();
		for (Term term:offerTerms){
			if (term instanceof GuaranteeTerm){
				GuaranteeTerm gt = (GuaranteeTerm) term;
				Set<ServiceScope> aux = gt.getScopes();
				for (ServiceScope ss:aux){
					offerScopes.add(ss);
				}
			}
		}
		
		Collection<Term> tempTerms = o.getAllTerms();
		Collection<ServiceScope> tempScopes = new HashSet<ServiceScope>();
		for (Term term:tempTerms){
			if (term instanceof GuaranteeTerm){
				GuaranteeTerm gt = (GuaranteeTerm) term;
				Set<ServiceScope> aux = gt.getScopes();
				for (ServiceScope ss:aux){
					tempScopes.add(ss);
				}
			}
		}
		
		return tempScopes.containsAll(offerScopes);
	}

	private Map<AbstractDocument,AbstractDocument> matchViews(Map<ServiceScope,AbstractDocument> offerViews,
						Map<ServiceScope,AbstractDocument> templateViews){
		
		Map<AbstractDocument,AbstractDocument> res = new HashMap<AbstractDocument, AbstractDocument>();
		Set<Entry<ServiceScope, AbstractDocument>> set1 = offerViews.entrySet();
		for (Entry<ServiceScope, AbstractDocument> e1:set1){
			AbstractDocument aux = templateViews.get(e1.getKey());
			if (aux != null){
				res.put(e1.getValue(), aux);
			}
			else{
				//scope declarado en la oferta que no existe en la plantilla!!
				//error!!!!
				//de todos modos, esto ya se habria detectado mediante
				//una comprobacion previa
			}
		}
		return res;
		
	}
}
