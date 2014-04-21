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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import choco.Choco;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoComplianceTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.translators.ChocoTranslator;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.utils.Utils;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Context;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

/*
 * Importante para esta operacion: primero debe hacerse el add de la plantilla,
 * y luego de la oferta (la plantilla ocupara el lugar 0, y la oferta el 1)
 */
public class ChocoComplianceOp extends ChocoOperation implements
		ComplianceOperation {

	private boolean compliant;

	public ChocoComplianceOp() {
		compliant = false;
	}

	@Override
	public boolean isCompliant() {
		return compliant;
	}
	
	public boolean checkConsistency(AbstractDocument d, ChocoAnalyzer an){
		ConsistencyOperation op = new ChocoConsistencyOp();
		op.addDocument(d);
		an.analyze(op);
		boolean result = op.isConsistent(); 
		return result;
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
									//XXX Plantilla
									// la traduccion a choco en compliance de la plantilla
									// (primer documento) debe hacerse con el
									// ChocoTranslator basico
									ChocoTranslator trans1 = new ChocoTranslator(entry.getValue());
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
									
									//XXX Oferta
									ChocoComplianceTranslator trans2 = new ChocoComplianceTranslator(
											entry.getKey(), tempVars,trans1.getServicePropsMap());
									trans2.translate();
									Collection<AgreementElement> newVarsFromOffer = trans2
											.getNewVars();
									// todas las variables mismo dominio en oferta y
									// plantilla
									if (!trans2.hasDifferentDomains()
											&& newVarsFromOffer.isEmpty()) {

										// XXX no considerar los sdt's de forma distinta
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
										// XXX offer compliant template
										b = Utils.isCompliantConstraint(offer, template);
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

	public boolean validScopes(AgreementOffer o, Template t) {
		// XXX recorre la oferta para ver si todos los scopes
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

	public Map<AbstractDocument,AbstractDocument> matchViews(Map<ServiceScope,AbstractDocument> offerViews,
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