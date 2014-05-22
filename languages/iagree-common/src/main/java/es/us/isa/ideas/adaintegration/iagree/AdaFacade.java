package es.us.isa.ideas.adaintegration.iagree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceImpl;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceV2;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

public class AdaFacade {

	// instanciado de ADA
	private ADAServiceV2 service;

	public AdaFacade() {
		System.out.println("## 1");
		this.service = new ADAServiceImpl();
	}

	// Devuelve true si es consistente y false en caso contrario
	public Boolean consistency(String doc) {
		byte[] bdoc = doc.getBytes();
		boolean res = false;
		if (service.checkDocumentConsistency(bdoc)) {
			if (service.getDeadTerms(bdoc).size() == 0) {
				if (service.getLudicrousTerms(bdoc).size() == 0) {
					res = true;
				}
			}
		}
		return res;
	}

	// Devuelve el numero del alternativas del documento
	public Integer getNumberOfAlternatives(String doc) {
		return service.getNumberOfAlternatives(doc.getBytes());
	}

	// Devuelve una lista de las inconsistencias
	public Map<AgreementElement, Collection<AgreementElement>> inconsistenciesMap(
			String doc) {
		return service.explainInconsistencies(doc.getBytes());
	}

	// Compara si la plantilla y la oferta no contienen términos disconformes
	public Boolean isCompliant(String template, String offer) {
		return service.isCompliant(template.getBytes(), offer.getBytes());
	}
	
	// Compara si la plantilla y la oferta son igual de restrictivas
	public Boolean isLessRestrictiveOffer(String template, String offer) {
		return service.isLessRestrictiveOffer(template.getBytes(), offer.getBytes());
	}
	
	// Compara si la plantilla y la oferta son igual de restrictivas
	public Boolean isMoreRestrictiveTemplateTermsThanCC(String template) {
		return service.isMoreRestrictiveTemplateTermsThanCC(template.getBytes());
	}
		
		

	// Explicacion de la inconsistencia
	public String inconsitencyExplaining(String wsag) {

		Object[] result = new Object[3];
		// 1. isConsistent
		// 2. hasWarnings
		// 3. inconsistencias si las hay, warnings si no hay inconsistencias
		List<String> warningsNames = new ArrayList<String>();
		List<String> errorsNames = new ArrayList<String>();
		Integer conflictsShowedInConsole = 1;
		Integer deadTermsShowedInConsole = 1;
		Integer ludicrousTermsShowedInConsole = 1;

		String returnMsg = "<pre>";

		Collection<Collection<String>> explaining = new LinkedList<Collection<String>>();
		try {
			boolean isConsistent;
			boolean hasWarnings = false;

			// Checking Inconsistent Terms
			isConsistent = service.checkDocumentConsistency(wsag.getBytes());

			if (isConsistent) {
				returnMsg += "The document doesn't contain Inconsistent Terms.";

				// Checking Dead Terms
				Collection<Term> deadTerms = service.getDeadTerms(wsag
						.getBytes());

				if (deadTerms.size() > 0) {
					returnMsg += "The document contains the following Dead Terms: \n";

					// Explaining Dead Terms
					Map<Term, Collection<AgreementElement>> deadTermsExplanation = service
							.explainDeadTerms(wsag.getBytes(), deadTerms);
					for (Map.Entry<Term, Collection<AgreementElement>> e : deadTermsExplanation
							.entrySet()) {

						Collection<String> set = new LinkedList<String>();
						Collection<AgreementElement> termValues = e.getValue();
						String warn = e.getKey().getName();

						returnMsg += "\t- Dead term " + deadTermsShowedInConsole
								+ ": " + warn + ". ";

						deadTermsShowedInConsole++;

						if (!warningsNames.contains(warn)) {
							// metemos el warning
							set.add(warn);
							warningsNames.add(warn);
						}

						for (AgreementElement cause : termValues) {
							// causas del warning
							returnMsg += "Cause: " + cause.getName();
							if (!warningsNames.contains(cause)) {
								// y metemos sus causas
								set.add(cause.getName());
								warningsNames.add(cause.getName());
							}
						}
						
						returnMsg += "\n";
						
						if (!set.isEmpty()) {
							explaining.add(set);
						}
					}
				} else {
					returnMsg += "The document doesn't contain Dead Terms.\n";
				}

				// Checking Ludicrous Terms
				Collection<Term> ludicrousTerms = service
						.getLudicrousTerms(wsag.getBytes());

				if (ludicrousTerms.size() > 0) {
					returnMsg += "The document contains the following Conditionally Inconsistent Terms: \n";

					// Explaining Ludicrous Terms
					Map<Term, Collection<AgreementElement>> ludicrousTermsExplanation = service
							.explainLudicrousTerms(wsag.getBytes(),
									ludicrousTerms);
					for (Map.Entry<Term, Collection<AgreementElement>> e : ludicrousTermsExplanation
							.entrySet()) {
						Collection<String> set = new LinkedList<String>();
						Collection<AgreementElement> termValues = e.getValue();

						String warn = e.getKey().getName();

						returnMsg += "\t- Conditionally Inconsistent Term "
								+ ludicrousTermsShowedInConsole + ": " + warn
								+ ". ";

						ludicrousTermsShowedInConsole++;
						if (!warningsNames.contains(warn)) {
							// metemos el warning
							set.add(warn);
							warningsNames.add(warn);
						}

						for (AgreementElement cause : termValues) {
							returnMsg += "Cause: " + cause.getName();
							// causas del warning
							if (!warningsNames.contains(cause)) {
								// y metemos sus causas
								set.add(cause.getName());
								warningsNames.add(cause.getName());
							}
						}
						
						returnMsg += "\n";

						if (!set.isEmpty()) {
							explaining.add(set);
						}
					}

				} else {
					returnMsg += "The document doesn't contain Conditionally Inconsistent Terms.\n";
				}
				hasWarnings = !(deadTerms.size() == 0 && ludicrousTerms.size() == 0);

			} else {
				returnMsg += "The document contains the following Inconsistent Terms: \n";

				// Explaining inconsistent terms
				Map<AgreementElement, Collection<AgreementElement>> errorsExplanation = service
						.explainInconsistencies(wsag.getBytes());
				for (Map.Entry<AgreementElement, Collection<AgreementElement>> e : errorsExplanation
						.entrySet()) {

					Collection<String> set = new LinkedList<String>();

					String keyName = e.getKey().getName();
					returnMsg += "\t- Conflict " + conflictsShowedInConsole + ": "
							+ keyName + ". ";
					conflictsShowedInConsole++;
					if (!errorsNames.contains(keyName)) {
						set.add(keyName);
						errorsNames.add(keyName);
					}

					Collection<AgreementElement> termValues = e.getValue();
					for (AgreementElement ae : termValues) {
						returnMsg += "Cause: " + ae.getName();
						if (!errorsNames.contains(ae.getName())) {
							set.add(ae.getName());
							errorsNames.add(ae.getName());
						}
					}
					
					returnMsg += "\n";

					if (!set.isEmpty()) {
						explaining.add(set);
					}
				}
			}
			result[0] = isConsistent;
			result[1] = hasWarnings;
			result[2] = explaining;
		} catch (BadSyntaxException e) {
			returnMsg += "There was an error: It may be due to a syntax error, please check the document syntax.";
			result = null;
		}
		
		returnMsg += "</pre>";

		return returnMsg;
	}

	// Explicacion del no cumplimiento
	public String nonComplianceExplaining(String template, String offer) {
		Object[] result = new Object[5];
		List<String> templateErrorsNames = new ArrayList<String>();
		List<String> offerErrorsNames = new ArrayList<String>();
		String returnMsg = "<pre>";

		Collection<Collection<String>> tempErrors = new LinkedList<Collection<String>>();
		Collection<Collection<String>> offerErrors = new LinkedList<Collection<String>>();
		try {
			boolean isTempConsistent;
			boolean isOfferConsistent;
			boolean isCompliant = false;
			boolean isLessRestrictiveOffer = false;
			boolean isMoreRestrictiveTemplateTerms = false;

			// Checking Template Inconsistent Terms

			isTempConsistent = service.checkDocumentConsistency(template
					.getBytes());
			if (isTempConsistent) {
				returnMsg += "The template is valid.\n";
			} else {
				returnMsg += "The template is NOT valid because it contains semantic errors.";
			}

			isOfferConsistent = service.checkDocumentConsistency(offer
					.getBytes());
			if (isOfferConsistent) {
				returnMsg += "The offer is valid.\n";
			} else {
				returnMsg += "The offer is NOT valid because contains semantic errors.\n";
			}

			if (isTempConsistent && isOfferConsistent) {

				isCompliant = service.isCompliant(template.getBytes(),
						offer.getBytes());
				isLessRestrictiveOffer = service.isLessRestrictiveOffer(
						template.getBytes(), offer.getBytes());
				isMoreRestrictiveTemplateTerms = service
						.isMoreRestrictiveTemplateTermsThanCC(template
								.getBytes());

				if (!isCompliant) {
					returnMsg += "\nConflicts between agreement offer terms and the template: \n";

					// Explaining Non-Compliance conflicts
					Map<AgreementError, Explanation> errorsArrayMapEntry = service
							.explainNonCompliance(template.getBytes(),
									offer.getBytes());
					
					for (Map.Entry<AgreementError, Explanation> e : errorsArrayMapEntry
							.entrySet()) {
						
						Collection<AgreementElement> agreementErrorElements = e
								.getKey().getElements();
						
						Collection<AgreementElement> explanationElements = e
								.getValue().getElements();
						
						Collection<String> offerElems = new LinkedList<String>();						
						
						for (AgreementElement agErrorElem : agreementErrorElements) {
							
							System.out.println("Error: " + agErrorElem.getName());
							
							String offerElemName = agErrorElem.getName();						
							

							returnMsg += "\t- " + offerElemName
									+ " in Offer is not compliant ";

							if (!offerErrorsNames.contains(offerElemName)) {
								offerElems.add(offerElemName);
								offerErrorsNames.add(offerElemName);
							}
						}
						offerErrors.add(offerElems);

						Collection<String> tempElems = new LinkedList<String>();
						for (AgreementElement explanationElem : explanationElements) {
							
							System.out.println("Explanation: " + explanationElem.getName());
							
							String templateElemName = explanationElem.getName();

							returnMsg += "with " + templateElemName + " in Template";

							if (!templateErrorsNames.contains(templateElemName)) {
								tempElems.add(templateElemName);
								templateErrorsNames.add(templateElemName);
							}
						}
						tempErrors.add(tempElems);
						
						returnMsg += "\n";
					}
					
				} else {
					returnMsg += "The agreement offer terms are compliant with the template terms and creation constraints.\n";
				}

				if ((isCompliant) && (!isLessRestrictiveOffer)) {

					returnMsg += "Offer terms that are More Restrictive than the template terms: \n";

					// Explaining Non-Compliance for More Restrictive offer
					// conflicts
					Map<AgreementError, Explanation> errorsArrayMapEntry = service
							.explainMoreRestrictiveOffer(template.getBytes(),
									offer.getBytes());
					for (Map.Entry<AgreementError, Explanation> e : errorsArrayMapEntry
							.entrySet()) {
						Collection<AgreementElement> agreementErrorElements = e
								.getKey().getElements();
						Collection<String> offerElems = new LinkedList<String>();
						for (AgreementElement agErrorElem : agreementErrorElements) {
							String offerElemName = agErrorElem.getName();

							returnMsg += "\t- Offer term: " + offerElemName + " ";

							if (!offerErrorsNames.contains(offerElemName)) {
								offerElems.add(offerElemName);
								offerErrorsNames.add(offerElemName);
							}
						}
						offerErrors.add(offerElems);

						Collection<AgreementElement> explanationElements = e
								.getValue().getElements();
						Collection<String> tempElems = new LinkedList<String>();
						for (AgreementElement explanationElem : explanationElements) {
							String templateElemName = explanationElem.getName();

							returnMsg += "Template element: "
									+ templateElemName;

							if (!templateErrorsNames.contains(templateElemName)) {
								tempElems.add(templateElemName);
								templateErrorsNames.add(templateElemName);
							}
						}
						
						returnMsg += "\n";
						
						tempErrors.add(tempElems);
					}
				} else {
					if (!isCompliant) {
						returnMsg += "As the documents are not compliant, the explaining for more restrictive offer is not performed.\n";
					} else
						returnMsg += "The agreement offer is Less Restrictive, or equal, than the template.\n";
				}
				if (!isMoreRestrictiveTemplateTerms) {
					returnMsg += "Template terms are less restrictive than the template creation constraints: \n";

					// Explaining Non-Compliance for Less Restrictive template
					// terms conflicts
					Map<AgreementError, Explanation> errorsArrayMapEntry = service
							.explainLessRestrictiveTemplateTerms(template
									.getBytes());
					for (Map.Entry<AgreementError, Explanation> e : errorsArrayMapEntry
							.entrySet()) {
						Collection<AgreementElement> guaranteeTermErrorElements = e
								.getKey().getElements(); // agreementErrorElements
						Collection<String> gtElems = new LinkedList<String>(); // agErrorElem
						for (AgreementElement gtErrorElem : guaranteeTermErrorElements) {
							String gtElemName = gtErrorElem.getName();

							returnMsg += "\t- Conflicting Template Term: "
									+ gtElemName + ". ";

							if (!offerErrorsNames.contains(gtElemName)) {
								gtElems.add(gtElemName);
								offerErrorsNames.add(gtElemName);
							}

						}
						offerErrors.add(gtElems);

						Collection<AgreementElement> explanationElements = e
								.getValue().getElements();
						Collection<String> ccElems = new LinkedList<String>();
						for (AgreementElement ccElem : explanationElements) {
							String ccElemName = ccElem.getName();

							returnMsg += "Cause: "
									+ ccElemName + "\n";

							if (!templateErrorsNames.contains(ccElemName)) {
								ccElems.add(ccElemName);
								templateErrorsNames.add(ccElemName);
							}
						}
						tempErrors.add(ccElems);
					}

				} else {
					returnMsg += "The template terms are more restrictive, or equal, than the template creation constraints.\n";
				}

			}

			result[0] = isTempConsistent;
			result[1] = isOfferConsistent;
			result[2] = isCompliant;
			result[3] = tempErrors;
			result[4] = offerErrors;
		} catch (BadSyntaxException e) {
			returnMsg += "There was an error: It may be due to a syntax error, please check the document syntax.";
		}
		
		returnMsg += "</pre>";
		
		return returnMsg;
	}

	public ADAServiceV2 getService() {
		return service;
	}

	public void setService(ADAServiceV2 service) {
		this.service = service;
	}

}
