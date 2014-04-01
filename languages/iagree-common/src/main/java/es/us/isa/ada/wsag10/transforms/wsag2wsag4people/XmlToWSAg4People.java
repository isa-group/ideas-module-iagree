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

package es.us.isa.ada.wsag10.transforms.wsag2wsag4people;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author cmuller
 */
public class XmlToWSAg4People {

	private Document agreement;
	private Document metricXML;

	/**
	 * @uml.property name="agDoc"
	 * @uml.associationEnd
	 */

	/**
	 * 
	 * @param agFileName
	 *            WS-Agreement* document name
	 */
	/*
	 * public WSAgTranslator(String agFileName){ openXML(agFileName); }
	 */

	/**
	 * The WS-Agreement document is opened and stored in "agreement" attribute
	 * If any error occurs, such attribute has the value null to simplify the
	 * use.
	 * 
	 * @param agFileName
	 *            WS-Agreement* document name
	 */
//	public void openAgreementXML(String agFileName) {
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//
//		DocumentBuilder builder;
//		try {
//			builder = factory.newDocumentBuilder();
//			agreement = builder.parse(agFileName);
//		} catch (Exception e) {
//			System.err.println("Error while opening the agreement file");
//		}
//		// return agreement;
//
//	}

	String wSAg4People = "";

	public String convertXMLToWSAg4People(Document docXML) {

		wSAg4People = "";
		// Document docXML ;
		// DocumentBuilderFactory factory =
		// DocumentBuilderFactory.newInstance();
		//
		// DocumentBuilder builder;
		// try {
		// builder = factory.newDocumentBuilder();
		// docXML = builder.parse(file);
		// } catch (Exception e) {
		// System.err.println("Error while opening the agreement file");
		// return "";
		// }

		// checking if file contains data
		NodeList rootNode = docXML.getChildNodes();
		if (rootNode.getLength() == 0) {
			return null;
		}

		Node root = rootNode.item(0);
		
		boolean nameFinished = false;
		
		if (root.getNodeName().equalsIgnoreCase("wsag:Template")) {
			wSAg4People += "Template ";
			NamedNodeMap m = root.getAttributes();
			String TemplateId = root.getAttributes().getNamedItem(
					"wsag:TemplateId").getNodeValue();
			wSAg4People += TemplateId;
			//System.out.println(TemplateId + "TEMPLATEID");
			NodeList childNodes = root.getChildNodes();
			String aux4name = "";
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node nextNode = childNodes.item(i);
				
				if (nameFinished){
					//elementos de profundidad 1
					String comment = extractCommentNodeln(nextNode);
					wSAg4People += comment;
				}
				else{
					aux4name += extractCommentNodeln(nextNode);
				}
				if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
					if (nextNode.getNodeName().equalsIgnoreCase("wsag:Name")) {
						wSAg4People += " - " + nextNode.getTextContent().trim()
								+ ":\n";
						nameFinished = true;
						wSAg4People += aux4name;
					} else if (nextNode.getNodeName().equalsIgnoreCase(
							"wsag:Context")) {
						if (nextNode.hasChildNodes()) {
							NodeList childNodesContext = nextNode
									.getChildNodes();
							int numElementos = 1;
							for (int j = 0; j < childNodesContext.getLength(); j++) {
								String comment = extractCommentNodeln(childNodesContext.item(j));
								wSAg4People += comment;
								if (childNodesContext.item(j).getNodeName()
										.equalsIgnoreCase(
												"wsag:AgreementInitiator")) {
									wSAg4People += "  "
											+ numElementos
											+ "  Initiator: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:AgreementResponder")) {
									wSAg4People += "  "
											+ numElementos
											+ "  Responder: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:ServiceProvider")) {
									wSAg4People += "  "
											+ numElementos
											+ "  ServiceProvider: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:ExpirationTime")) {
									wSAg4People += "  "
											+ numElementos
											+ "  ExpirationTime: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								}
								if (childNodesContext.item(j).getNodeName()
										.equalsIgnoreCase("wsag:TemplateId")) {
									wSAg4People += "  "
											+ numElementos
											+ "  TemplateID: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:TemplateName")) {
									wSAg4People += "  "
											+ numElementos
											+ "  TemplateName: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								}

							}

							wSAg4People = wSAg4People.subSequence(0,
									wSAg4People.length() - 2)
									+ ";\n"; // Sustituyo la ultima , por ;
						}

					} else if (nextNode.getNodeName().equalsIgnoreCase(
							"wsag:Terms")) {

						if (nextNode.hasChildNodes()) {
							NodeList childNodesTerms = nextNode.getChildNodes();
							wSAg4People += "\nTerms - "
									+ nextNode.getAttributes().getNamedItem(
											"wsag:Name").getTextContent()
									+ ": \n\n";
							for (int j = 0; j < childNodesTerms.getLength(); j++) {
								//TODO meter aqui para comentarios
								if (childNodesTerms.item(j).getNodeName()
										.equalsIgnoreCase("wsag:All")
										&& childNodesTerms.item(j)
												.hasChildNodes()) {
									NodeList childNodesAll = childNodesTerms
											.item(j).getChildNodes();

									analizaTerminos(childNodesAll, 0, "1", true);

								}
							}
						}
					} else if (nextNode.getNodeName().equalsIgnoreCase(
							"wsag:CreationConstraints")) {
						wSAg4People += "\nCreation Constraints:\n ";
						int numItems = 1;
						int numConstraints = 1;
						String items = "";
						String constraints = "";
						for (int j = 0; j < nextNode.getChildNodes()
								.getLength(); j++) {
							
							Node creationConstraint = nextNode.getChildNodes()
									.item(j);
							String commentCC = extractCommentNodeln(creationConstraint);
							if (!commentCC.isEmpty()){
								wSAg4People += commentCC;
							}
							else if (creationConstraint.getNodeName().equals(
									"wsag:Item")) {
								items += "     "
										+ numItems
										+ "  "
										+ creationConstraint.getAttributes()
												.getNamedItem("wsag:Name")
												.getTextContent().trim()
										+ ": Value Of ";
								numItems++;
								String commentItem = "";
								
								for (int k = 0; k < creationConstraint
										.getChildNodes().getLength(); k++) {
									Node childCC = creationConstraint
											.getChildNodes().item(k);
									
									String aux = extractCommentNode(childCC);
									if (!aux.isEmpty()){
										commentItem += aux;
									}
									else if (childCC.getNodeName().equals(
											("wsag:Location"))) {
										items += childCC.getTextContent()
												.trim()
												+ " is ";
									} else if (childCC.getNodeName().equals(
											("wsag:ItemConstraint"))) {
										for (int d = 0; d < childCC
												.getChildNodes().getLength(); d++) {
											
											aux = extractCommentNode(childCC.getChildNodes().item(d));
											if (!aux.isEmpty()){
												commentItem += aux;
											}
											
											if (childCC.getChildNodes().item(d)
													.getNodeName()
													.equalsIgnoreCase(
															"xs:restriction")) {
												items += childCC
														.getChildNodes()
														.item(d)
														.getAttributes()
														.getNamedItem("base")
														.getTextContent()
														+ " ";
												for (int v = 0; v < childCC
														.getChildNodes()
														.item(d)
														.getChildNodes()
														.getLength(); v++) {
													
													String comment = extractCommentNode(childCC
															.getChildNodes()
															.item(d)
															.getChildNodes()
															.item(v));
													commentItem += comment;
//													items += comment;
													
													if (childCC
															.getChildNodes()
															.item(d)
															.getChildNodes()
															.item(v)
															.getNodeName()
															.equalsIgnoreCase(
																	"xs:minInclusive")) {
														items += "["
																+ childCC
																		.getChildNodes()
																		.item(d)
																		.getChildNodes()
																		.item(v)
																		.getAttributes()
																		.getNamedItem(
																				"value")
																		.getTextContent()
																+ ",";
													} else if (childCC
															.getChildNodes()
															.item(d)
															.getChildNodes()
															.item(v)
															.getNodeName()
															.equalsIgnoreCase(
																	"xs:minExclusive")) {
														items += "("
																+ childCC
																		.getChildNodes()
																		.item(d)
																		.getChildNodes()
																		.item(v)
																		.getAttributes()
																		.getNamedItem(
																				"value")
																		.getTextContent()
																+ ",";

													} else if (childCC
															.getChildNodes()
															.item(d)
															.getChildNodes()
															.item(v)
															.getNodeName()
															.equalsIgnoreCase(
																	"xs:maxInclusive")) {
														items += childCC
																.getChildNodes()
																.item(d)
																.getChildNodes()
																.item(v)
																.getAttributes()
																.getNamedItem(
																		"value")
																.getTextContent()
																+ "],";
													} else if (childCC
															.getChildNodes()
															.item(d)
															.getChildNodes()
															.item(v)
															.getNodeName()
															.equalsIgnoreCase(
																	"xs:maxExclusive")) {
														items += childCC
																.getChildNodes()
																.item(d)
																.getChildNodes()
																.item(v)
																.getAttributes()
																.getNamedItem(
																		"value")
																.getTextContent()
																+ "),";

													}
												}
												
											}

										}
										
									}
								}
								items += " "+commentItem+"\n";

							} else if (creationConstraint.getNodeName().equals(
									"wsag:Constraint")) {
//								String commentCons = "";
								String aux = "";
								for (int k = 0; k < creationConstraint
										.getChildNodes().getLength(); k++) {
									aux += extractCommentNode(creationConstraint.getChildNodes()
											.item(k));
//									if (!aux.isEmpty()){
//										commentCons += aux;
//									}
									if (creationConstraint.getChildNodes()
											.item(k).getNodeName()
											.equalsIgnoreCase("Name")) {
										constraints += "     "
												+ numConstraints
												+ "  "
												+ creationConstraint
														.getChildNodes()
														.item(k)
														.getTextContent()
														.trim() + ":"+aux+"\n";
										numConstraints++;
										aux = "";
									} else if (creationConstraint
											.getChildNodes().item(k)
											.getNodeName().equalsIgnoreCase(
													"Content")) {
										constraints += "        "
												+ creationConstraint
														.getChildNodes()
														.item(k)
														.getTextContent()
														.trim() + ";"+aux+"\n";
										aux = "";

									}

								}
								constraints += " "+aux+"\n";

							}
						}

						wSAg4People += "  Items:\n" + items
								+ "\n   Constraints:\n" + constraints;

					}

				}
				

			}
		} else if (root.getNodeName().equalsIgnoreCase("wsag:AgreementOffer")) {
			//TODO modificar aqui para el peque�o error que aun da
			wSAg4People += "AgreementOffer ";
			NamedNodeMap m = root.getAttributes();
			String TemplateId = root.getAttributes().getNamedItem(
					"wsag:AgreementId").getNodeValue();
			wSAg4People += TemplateId;
			NodeList childNodes = root.getChildNodes();
			String aux4name = "";
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node nextNode = childNodes.item(i);
				
				if (nameFinished){
					//elementos de profundidad 1
					String comment = extractCommentNodeln(nextNode);
					wSAg4People += comment;
				}
				else{
					aux4name += extractCommentNodeln(nextNode);
				}
				
				if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
					if (nextNode.getNodeName().equalsIgnoreCase("wsag:Name")) {
						wSAg4People += " - " + nextNode.getTextContent().trim()
								+ ":\n";
						nameFinished = true;
						wSAg4People += aux4name;
					} else if (nextNode.getNodeName().equalsIgnoreCase(
							"wsag:Context")) {
						if (nextNode.hasChildNodes()) {
							NodeList childNodesContext = nextNode
									.getChildNodes();
							int numElementos = 1;
							for (int j = 0; j < childNodesContext.getLength(); j++) {
								String comment = extractCommentNodeln(childNodesContext.item(j));
								wSAg4People += comment;
								if (childNodesContext.item(j).getNodeName()
										.equalsIgnoreCase(
												"wsag:AgreementInitiator")) {
									wSAg4People += "  "
											+ numElementos
											+ "  Initiator: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:ServiceProvider")) {
									wSAg4People += "  "
											+ numElementos
											+ "  ServiceProvider: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:TemplateId")) {
									wSAg4People += "  "
											+ numElementos
											+ "  TemplateId: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								} else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
												"wsag:TemplateName")) {
									wSAg4People += "  "
											+ numElementos
											+ "  TemplateName: "
											+ childNodesContext.item(j)
													.getTextContent().trim()
											+ ",\n";
									numElementos++;
								}
								else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
										"wsag:AgreementResponder")){
									wSAg4People += "  "
										+ numElementos
										+ "  Responder: "
										+ childNodesContext.item(j)
												.getTextContent().trim()
										+ ",\n";
								numElementos++;
								}
								else if (childNodesContext.item(j)
										.getNodeName().equalsIgnoreCase(
										"wsag:ExpirationTime")){
									wSAg4People += "  "
										+ numElementos
										+ "  ExpirationTime: "
										+ childNodesContext.item(j)
												.getTextContent().trim()
										+ ",\n";
								numElementos++;
								}
							}
							wSAg4People = wSAg4People.subSequence(0,
									wSAg4People.length() - 2)
									+ ";\n"; // Sustituyo la ultima , por ;
						}

					} else if (nextNode.getNodeName().equalsIgnoreCase(
							"wsag:Terms")) {
						if (nextNode.hasChildNodes()) {
							NodeList childNodesTerms = nextNode.getChildNodes();
							wSAg4People += "\nTerms - "
								+ nextNode.getAttributes().getNamedItem(
										"wsag:Name").getTextContent()
								+ ": \n\n";
//							WSAg4People += "\n";
							for (int j = 0; j < childNodesTerms.getLength(); j++) {
								if (childNodesTerms.item(j).getNodeName()
										.equalsIgnoreCase("wsag:All")
										&& childNodesTerms.item(j)
												.hasChildNodes()) {
									NodeList childNodesAll = childNodesTerms
											.item(j).getChildNodes();

									analizaTerminos(childNodesAll, 0, "1", true);

								}
							}
						}
					}
				}
			}
		}
		// Limpiamos los \ por /:

		//System.out.println("\n" + WSAg4People);

		return wSAg4People;

	}

	public void analizaTerminos(NodeList nodos, int numEspacios,
			String numElement, boolean inicial) {
		String tipoActual = "";
		Node nodoInicial;
		nodoInicial = nodos.item(0);
		int numeroItem = 0;

		while (nodoInicial.getNodeType() != Node.ELEMENT_NODE) {
			String comment = extractCommentNodeln(nodoInicial);
			wSAg4People += comment;
			nodoInicial = nodoInicial.getNextSibling();
		}

		tipoActual = nodoInicial.getNodeName();
		if (inicial) {// primero se mira el All inicial que difiere de los dem�s
			int i = 0;
			while (i < nodos.getLength()) {
				int calculaNumIguales = 0;
				int calculaNumIgualesSinText = 0;
				// Calculamos cuantos elementos hay iguales
				for (int j = i; j < nodos.getLength(); j++) {
					if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
						if (nodos.item(j).getNodeName().equals(tipoActual)) {
							calculaNumIguales++;
							calculaNumIgualesSinText++;
						} else {
							j = nodos.getLength();
						}
					} else {
						calculaNumIguales++;
					}
				}

				if (tipoActual.equalsIgnoreCase("wsag:ServiceDescriptionTerm")) {
					numeroItem++;
					if (calculaNumIgualesSinText > 1) {
						wSAg4People += numeroItem
								+ " Service Description Terms:\n";
						int numero = 0;
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								numero++;
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios + 1, "#" + numeroItem + "."
												+ numero + "", " ");

							}
						}
					} else {
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios, "", numeroItem
												+ " Service Description Term");

							}
						}
					}
					wSAg4People += "\n";
				}

				if (tipoActual.equalsIgnoreCase("wsag:ServiceReference")) {
					numeroItem++;
					if (calculaNumIgualesSinText > 1) {
						wSAg4People += numeroItem + " Service References:\n";
						int numero = 0;
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								numero++;
								paintServiceReferences(nodos.item(j),
										numEspacios + 1, "#" + numeroItem + "."
												+ numero + "", " ");

							}
						}
					} else {
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								paintServiceReferences(nodos.item(j),
										numEspacios, "", numeroItem
												+ " Service Reference");

							}
						}
					}
					wSAg4People += "\n";
				}

				if (tipoActual.equalsIgnoreCase("wsag:ServiceProperties")) {
					numeroItem++;
					if (calculaNumIgualesSinText > 1) {
						wSAg4People += "Service Properties:\n";
						int numero = 0;
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								numero++;
								paintServiceProperties(nodos.item(j),
										numEspacios + 1, "#" + numeroItem + "."
												+ numero + "", " ");

							}
						}
					} else {
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								paintServiceProperties(nodos.item(j),
										numEspacios, "", numeroItem
												+ " Service Properties");

							}
						}
					}
					wSAg4People += "\n";
				}

				if (tipoActual.equalsIgnoreCase("wsag:GuaranteeTerm")) {
					numeroItem++;
					if (calculaNumIgualesSinText > 1) {
						wSAg4People += numeroItem + " Guarantees:\n";
						int numero = 0;
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								numero++;
								paintGuarantee(nodos.item(j), numEspacios + 1,
										"#" + numeroItem + "." + numero + "",
										" ");

							}
						}
					} else {
						for (int j = i; j < i + calculaNumIguales; j++) {
							if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
								paintGuarantee(nodos.item(j), numEspacios, "",
										numeroItem + " Guarantee");

							}
						}
					}
				}

				if (tipoActual.equalsIgnoreCase("wsag:All")) {
					numeroItem++;
					for (int j = i; j < i + calculaNumIguales; j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							wSAg4People += numeroItem + " All:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numeroItem + "", false);
						}
					}

				}
				if (tipoActual.equalsIgnoreCase("wsag:OneOrMore")) {
					numeroItem++;
					for (int j = i; j < i + calculaNumIguales; j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							wSAg4People += numeroItem
									+ " One Or More between:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numeroItem + "", false);
						}
					}
				}
				if (tipoActual.equalsIgnoreCase("wsag:ExactlyOne")) {
					numeroItem++;
					for (int j = i; j < i + calculaNumIguales; j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							wSAg4People += numeroItem
									+ " Exactly One between:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numeroItem + "", false);
						}
					}
				}

				// Buscamos el siguiente elemento a emparejar
				i = i + calculaNumIguales;
				while (i < nodos.getLength()
						&& nodos.item(i).getNodeType() != Node.ELEMENT_NODE) {
					i++;
				}
				if (i < nodos.getLength()) {
					tipoActual = nodos.item(i).getNodeName();

				}

				// //System.out.println(calculaNumIguales+"!!!");

			}
		} else {// Ahora vemos cualquier elemento, si llegamos aqui es por el
				// anidamiento de algun elemento ALL, ExactlyOne o
				// OneMoreBetween
			boolean iguales = true;
			// Mirarmos si todos los elementos son o no son iguales
			for (int j = 0; j < nodos.getLength(); j++) {
				if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
					if (!nodos.item(j).getNodeName().equals(tipoActual)) {
						iguales = false;
					}
				}
			}
			if (tipoActual.equalsIgnoreCase("wsag:All")
					|| tipoActual.equalsIgnoreCase("wsag:ExactlyOne")
					|| tipoActual.equalsIgnoreCase("wsag:OneOrMore")) {
				iguales = false;
			}

			if (iguales) { // son todos Iguales as� que se agrupan
				if (tipoActual.equalsIgnoreCase("wsag:ServiceDescriptionTerm")) {
					String espacios = espaciado(numEspacios * 5);
					wSAg4People += espacios + numElement
							+ ".1 Service Description Terms:\n";
					int numero = 0;
					for (int j = 0; j < nodos.getLength(); j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							numero++;
							if (numElement.equalsIgnoreCase(""))
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios + 1, "#" + "" + numero, " ");
							else
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios + 1, "#" + numElement + "."
												+ numero, " ");

						}
					}
					wSAg4People += "\n";

				}

				if (tipoActual.equalsIgnoreCase("wsag:ServiceReference")) {
					String espacios = espaciado(numEspacios * 5);
					wSAg4People += espacios + numElement
							+ ".1 Service References:\n";
					int numero = 0;
					for (int j = 0; j < nodos.getLength(); j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							numero++;
							if (numElement.equalsIgnoreCase(""))
								paintServiceReferences(nodos.item(j),
										numEspacios + 1, "#" + "" + numero, " ");
							else
								paintServiceReferences(nodos.item(j),
										numEspacios + 1, "#" + numElement + "."
												+ numero, " ");
						}
					}
					wSAg4People += "\n";
				}

				if (tipoActual.equalsIgnoreCase("wsag:ServiceProperties")) {
					String espacios = espaciado(numEspacios * 5);
					wSAg4People += espacios + numElement
							+ ".1 Service Properties:\n";
					int numero = 0;
					for (int j = 0; j < nodos.getLength(); j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							numero++;
							if (numElement.equalsIgnoreCase(""))
								paintServiceProperties(nodos.item(j),
										numEspacios + 1, "#" + "" + numero, " ");
							else
								paintServiceProperties(nodos.item(j),
										numEspacios + 1, "#" + numElement + "."
												+ numero, " ");

						}
					}
					wSAg4People += "\n";

				}

				if (tipoActual.equalsIgnoreCase("wsag:GuaranteeTerm")) {
					String espacios = espaciado(numEspacios * 5);
					wSAg4People += espacios + numElement + ".1 Guarantees:\n";
					int numero = 0;
					for (int j = 0; j < nodos.getLength(); j++) {
						if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
							numero++;

							if (numElement.equalsIgnoreCase(""))
								paintGuarantee(nodos.item(j), numEspacios + 1,
										"#" + numero, " ");
							else {
								paintGuarantee(nodos.item(j), numEspacios + 1,
										"#" + numElement + ".1." + numero, " ");

							}

						}
					}
					wSAg4People += "\n";

				}

			} else { // los elementos no se agrupan as� que ya directamente nos
						// dedicamos a irlos pintando o bien son all, exactly
						// one o one more between
				int numero = 0;
				for (int j = 0; j < nodos.getLength(); j++) {

					if (nodos.item(j).getNodeType() == Node.ELEMENT_NODE) {
						numero++;
						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:ServiceDescriptionTerm")) {
							if (numElement.equals("")) {
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios, "" + numero,
										" Service Description Term");
							} else
								paintServiceDescriptionTermn(nodos.item(j),
										numEspacios, numElement + "." + numero,
										" Service Description Term");

						}

						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:ServiceReference")) {
							if (numElement.equals("")) {
								paintServiceReferences(nodos.item(j),
										numEspacios, "" + numero,
										" Service Reference");
							} else
								paintServiceReferences(nodos.item(j),
										numEspacios, numElement + "." + numero,
										" Service Reference");

						}

						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:ServiceProperties")) {
							if (numElement.equals("")) {
								paintServiceProperties(nodos.item(j),
										numEspacios, "" + numero,
										" Service Properties");
							} else
								paintServiceProperties(nodos.item(j),
										numEspacios, numElement + "." + numero,
										" Service Properties");
						}

						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:GuaranteeTerm")) {
							if (numElement.equals("")) {
								paintGuarantee(nodos.item(j), numEspacios, ""
										+ numero, " Guarantee");
							} else
								paintGuarantee(nodos.item(j), numEspacios,
										numElement + "." + numero, " Guarantee");
						}
						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:All")) {
							wSAg4People += espaciado(numEspacios * 5)
									+ numElement + "." + numero + " All:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numElement + "." + numero, false);

						}
						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:ExactlyOne")) {
							wSAg4People += espaciado(numEspacios * 5)
									+ numElement + "." + numero
									+ " Exactly One between:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numElement + "." + numero, false);

						}
						if (nodos.item(j).getNodeName().equalsIgnoreCase(
								"wsag:OneOrMore")) {
							wSAg4People += espaciado(numEspacios * 5)
									+ numElement + "." + numero
									+ " One Or More between:\n";
							NodeList childNodesAll = nodos.item(j)
									.getChildNodes();
							analizaTerminos(childNodesAll, numEspacios + 1,
									numElement + "." + numero, false);

						}
					}
				}
			}

		}
	}

	public void paintServiceDescriptionTermn(Node nodo, int numEspacios,
			String numElement, String cabecera) {
		String espacios = espaciado(numEspacios * 5);
		wSAg4People += espacios
				+ numElement
				+ cabecera
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:Name")
						.getTextContent()
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:ServiceName")
						.getTextContent() + ":\n";
		NodeList childNodesSDT = nodo.getChildNodes();

//		WSAg4People += espacios + "    ";
		for (int i = 0; i < childNodesSDT.getLength(); i++) {
			Node childNodeSDT = childNodesSDT.item(i);
			espacios = espaciado(numEspacios + 5);

			String commentSDT = extractCommentNodeln(childNodeSDT);
			if (!commentSDT.isEmpty()){
				wSAg4People += espacios + commentSDT;
			}
			
			if (childNodeSDT.getNodeType() == Node.ELEMENT_NODE) {

				String nombreElemento = childNodeSDT.getNodeName();

				if (nombreElemento.equals("OfferItem")) {
					Node metricNode = childNodeSDT.getAttributes().getNamedItem("wsag:Metric");
					if (metricNode != null){
						//hay metric
						NodeList childsSDT = childNodeSDT.getChildNodes();
						int sdtLenght = childsSDT.getLength();
						String textSDT = "";
						for (int index = 0; index < sdtLenght; index++){
							Node auxNode = childsSDT.item(index);
							if (auxNode.getNodeType() == Node.TEXT_NODE){
								textSDT = auxNode.getNodeValue();
							}
						}
						
						if (textSDT != null && !textSDT.isEmpty()){
							//vble declarada en SDT con valor
							wSAg4People += espacios + childNodeSDT.getAttributes().getNamedItem(
							"name").getTextContent()
							+ " = "
							+ childNodeSDT.getTextContent().trim()
							+ " - measured by "+ metricNode.getNodeValue() +",\n";
						}
						else{
							//vble declarada en SDT pero sin valor asociado
							wSAg4People += espacios + childNodeSDT.getAttributes().getNamedItem(
							"name").getTextContent()
							+ " - measured by "+ metricNode.getNodeValue() +",\n";
						}
					}
					else{
						//no hay metric
						wSAg4People += espacios + childNodeSDT.getAttributes().getNamedItem(
						"name").getTextContent()
						+ " = "
						+ childNodeSDT.getTextContent().trim()
						+ ",\n";
					}
					
					
					
					
					

				} else {

					wSAg4People += childNodeSDT.getNodeName() + " = "
							+ childNodeSDT.getTextContent().trim() + ", ";

				}

			}
			

			// if(childNodeSDT.getNodeName().equalsIgnoreCase("var1")){
			// WSAg4People+=espacios+"    var1 = "+childNodeSDT.getTextContent().trim()+" , var2 = ";
			// }else if(childNodeSDT.getNodeName().equalsIgnoreCase("var2")){
			// WSAg4People+=childNodeSDT.getTextContent().trim()+"\n";
			// }

		}
		wSAg4People = wSAg4People.subSequence(0, wSAg4People.length() - 2)
				+ ";\n";

	}

	public void paintServiceReferences(Node nodo, int numEspacios,
			String numElement, String cabecera) {

		String espacios = espaciado(numEspacios * 5);

		wSAg4People += espacios
				+ numElement
				+ cabecera
				+ "  - "
				+ nodo.getAttributes().getNamedItem("wsag:Name")
						.getTextContent()
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:ServiceName")
						.getTextContent() + ":\n";
		NodeList childNodesSDT = nodo.getChildNodes();

		espacios = espaciado(numEspacios + 5);
		wSAg4People += espacios + nodo.getTextContent().trim() + ";\n";

	}

	public void paintServiceProperties(Node nodo, int numEspacios,
			String numElement, String cabecera) {
		String espacios = espaciado(numEspacios * 5);
		wSAg4People += espacios
				+ numElement
				+ cabecera
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:Name").getNodeValue()
						.trim()
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:ServiceName")
						.getNodeValue().trim() + ":\n";
		NodeList childNodesSDT = nodo.getChildNodes();
		espacios = espaciado(numEspacios * 5 + 5);
		for (int i = 0; i < childNodesSDT.getLength(); i++) {
			Node childNodeSDT = childNodesSDT.item(i);
			int numero = 1;
			
			String commentSP1 = extractCommentNodeln(childNodeSDT);
			if (!commentSP1.isEmpty()){
				wSAg4People += espacios + commentSP1;
			}
			
			if (childNodeSDT.getNodeName().equalsIgnoreCase("wsag:VariableSet")) {
				for (int j = 0; j < childNodeSDT.getChildNodes().getLength(); j++) {
					
					String commentSP2 = extractCommentNodeln(childNodeSDT.getChildNodes()
							.item(j));
					if (!commentSP2.isEmpty()){
						wSAg4People += espacios + commentSP2;
					}
					
					if (childNodeSDT.getChildNodes().item(j).getNodeName()
							.equalsIgnoreCase("wsag:Variable")) {

						for (int k = 0; k < childNodeSDT.getChildNodes()
								.item(j).getChildNodes().getLength(); k++) {
							
							String commentSP3 = extractCommentNodeln(childNodeSDT.getChildNodes().item(j)
									.getChildNodes().item(k));
							if (!commentSP3.isEmpty()){
								wSAg4People += espacios + commentSP3;
							}
							
							if (childNodeSDT.getChildNodes().item(j)
									.getChildNodes().item(k).getNodeName()
									.equalsIgnoreCase("wsag:Location")) {

								if (numElement.equalsIgnoreCase("")) {
									wSAg4People += espacios
											+ numero
											+ " "
											+ childNodeSDT.getChildNodes()
													.item(j).getAttributes()
													.getNamedItem("wsag:Name")
													.getNodeValue().trim()
											+ " - measured by "
											+ childNodeSDT
													.getChildNodes()
													.item(j)
													.getAttributes()
													.getNamedItem("wsag:Metric")
													.getNodeValue().trim()
											+ " - related to "
											+ childNodeSDT.getChildNodes()
													.item(j).getChildNodes()
													.item(k).getTextContent()
													.trim() + ",\n";
									NodeList locationChildren = childNodeSDT.getChildNodes().item(j).getChildNodes().item(k).getChildNodes();
									for (int l = 0; l < locationChildren.getLength(); l++){
										Node locationNode = locationChildren.item(l);
										String locationComment = extractCommentNodeln(locationNode);
										wSAg4People+=locationComment;
									}
									
									numero++;
								} else {

									wSAg4People += espacios
											+ numElement
											+ "."
											+ numero
											+ " "
											+ childNodeSDT.getChildNodes()
													.item(j).getAttributes()
													.getNamedItem("wsag:Name")
													.getNodeValue()
											+ " - measured by "
											+ childNodeSDT
													.getChildNodes()
													.item(j)
													.getAttributes()
													.getNamedItem("wsag:Metric")
													.getNodeValue()
											+ " - related to "
											+ childNodeSDT.getChildNodes()
													.item(j).getChildNodes()
													.item(k).getTextContent()
													.trim() + ",\n";
									NodeList locationChildren = childNodeSDT.getChildNodes().item(j).getChildNodes().item(k).getChildNodes();
									for (int l = 0; l < locationChildren.getLength(); l++){
										Node locationNode = locationChildren.item(l);
										String locationComment = extractCommentNodeln(locationNode);
										wSAg4People+=locationComment;
									}
									numero++;
								}
							}

						}

					}

				}
			}

		}
		wSAg4People = wSAg4People.subSequence(0, wSAg4People.length() - 2)
				+ ";\n";
		wSAg4People += "\n";
	}

	public void paintGuarantee(Node nodo, int numEspacios, String numElement,
			String cabecera) {
		//FIXME tocar por aqui para los scopes
		//XXX MALDITO SEAS JAVI
		String espacios = espaciado(numEspacios * 5);
		wSAg4People += espacios
				+ numElement
				+ cabecera
				+ " - "
				+ nodo.getAttributes().getNamedItem("wsag:Name")
						.getTextContent()
				+ " (by "
				+ nodo.getAttributes().getNamedItem("wsag:Obligated")
						.getTextContent() + "):\n";
		NodeList childNodesSDT = nodo.getChildNodes();
		espacios = espaciado(numEspacios * 5 + 5);
		String scopes = espacios + "Scopes:";
		String noscopes = "";

		for (int j = 0; j < childNodesSDT.getLength(); j++) {
			Node childNodeSDT = childNodesSDT.item(j);
			espacios = espaciado(numEspacios * 5 + 5);
			
			String commentGT = extractCommentNodeln(childNodeSDT);
			if (!commentGT.isEmpty()){
				wSAg4People += espacios + commentGT;
			}
			
			if (childNodeSDT.getNodeName()
					.equalsIgnoreCase("wsag:ServiceScope")) {
				scopes += childNodeSDT.getAttributes().getNamedItem(
						"wsag:ServiceName").getNodeValue()
						+ " - " + childNodeSDT.getTextContent().trim() + ", ";
			} else if (childNodeSDT.getNodeName().equalsIgnoreCase(
					"wsag:QualifyingCondition")) {
				noscopes += espacios + "Qualifying Condition: "
						+ childNodeSDT.getTextContent().trim() + "; \n";
			} else if (childNodeSDT.getNodeName().equalsIgnoreCase(
					"wsag:ServiceLevelObjective")) {
				String commentGT2 = "";
				for (int k = 0; k < childNodeSDT.getChildNodes().getLength(); k++) {
					Node childSLO = childNodeSDT.getChildNodes().item(k);
					commentGT2 += extractCommentNode(childSLO);
					
//					if (!commentGT2.isEmpty()){
//						wSAg4People += espacios + commentGT2;
//					}
					
					if (childSLO.getNodeType() == Node.ELEMENT_NODE) {

						if (childSLO.getNodeName().equals("wsag:KPITarget")) {
							for (int z = 0; z < childSLO.getChildNodes()
									.getLength(); z++) {
								Node childKPI = childSLO.getChildNodes()
										.item(z);
								if (childKPI.getNodeName().equals(
										"wsag:KPIName")) {
									noscopes += espacios + "KPI: "
											+ childKPI.getTextContent().trim()
											+ ",";
								} else if (childKPI.getNodeName().equals(
										"wsag:Target")) {
									noscopes += childKPI.getTextContent()
											+ "\n";
								}
							}
						} else if (childSLO.getNodeName().equals(
								"wsag:CustomServiceLevel")) {
							noscopes += espacios + "SLO: "
									+ childSLO.getTextContent().trim() + ";"+commentGT2+"\n";
							commentGT2 = "";
						}
					}
				}
			} else if (childNodeSDT.getNodeName().equalsIgnoreCase(
					"wsag:BusinessValueList")) {

				noscopes += espacios + "Business Value:\n";
				espacios = espaciado(numEspacios * 5 + 10);
				for (int k = 0; k < childNodeSDT.getChildNodes().getLength(); k++) {
					Node bussines = childNodeSDT.getChildNodes().item(k);
					if (bussines.getNodeName().equalsIgnoreCase(
							"wsag:Importance")) {
						noscopes += espacios
								+ "Relative importance between guarantees:"
								+ childNodeSDT.getChildNodes().item(k)
										.getTextContent().trim() + ";";

					} else if (bussines.getNodeName().equalsIgnoreCase(
							"wsag:Penalty")) {
						String penalty1 = "";
						String penalty2 = "";
						String valueUnit = "";
						String valueExpr = "";
						for (int z = 0; z < bussines.getChildNodes()
								.getLength(); z++) {
							if (bussines.getChildNodes().item(z).getNodeName()
									.equalsIgnoreCase("wsag:AssesmentInterval")) {

								for (int m = 0; m < bussines.getChildNodes()
										.item(z).getChildNodes().getLength(); m++) {
									if (bussines.getChildNodes().item(z)
											.getChildNodes().item(m)
											.getNodeName().equalsIgnoreCase(
													"wsag:TimeInterval")) {
										penalty1 = espacios
												+ " "
												+ bussines.getChildNodes()
														.item(z)
														.getChildNodes()
														.item(m)
														.getTextContent()
														.trim();
									} else if (bussines.getChildNodes().item(z)
											.getChildNodes().item(m)
											.getNodeName().equalsIgnoreCase(
													"wsag:Count")) {
										penalty2 = espacios
												+ " "
												+ bussines.getChildNodes()
														.item(z)
														.getChildNodes()
														.item(m)
														.getTextContent()
														.trim() + " invocation";
									}
								}

							} else if (bussines.getChildNodes().item(z)
									.getNodeName().equalsIgnoreCase(
											"wsag:ValueUnit")) {
								valueUnit = bussines.getChildNodes().item(z)
										.getTextContent().trim();

							} else if (bussines.getChildNodes().item(z)
									.getNodeName().equalsIgnoreCase(
											"wsag:ValueExpr")) {
								valueExpr = bussines.getChildNodes().item(z)
										.getTextContent().trim();
							}

						}
						if (penalty1.equals("")) {
							noscopes += "\n" + espacios + "Penalty: "
									+ valueExpr + ", " + valueUnit
									+ ". Assessed in " + penalty2.trim() + ";";
						} else if (penalty2.equals("")) {
							noscopes += "\n" + espacios + "Penalty: "
									+ valueExpr + ", " + valueUnit
									+ ". Assessed in " + penalty1.trim() + ";";
						}

					} else if (bussines.getNodeName().equalsIgnoreCase(
							"wsag:Reward")) {
						String penalty1 = "";
						String penalty2 = "";
						String valueUnit = "";
						String valueExpr = "";
						for (int z = 0; z < bussines.getChildNodes()
								.getLength(); z++) {
							if (bussines.getChildNodes().item(z).getNodeName()
									.equalsIgnoreCase("wsag:AssesmentInterval")) {
								for (int m = 0; m < bussines.getChildNodes()
										.item(z).getChildNodes().getLength(); m++) {
									if (bussines.getChildNodes().item(z)
											.getChildNodes().item(m)
											.getNodeName().equalsIgnoreCase(
													"wsag:TimeInterval")) {
										penalty1 = " "
												+ bussines.getChildNodes()
														.item(z)
														.getChildNodes()
														.item(m)
														.getTextContent()
														.trim() + "";
									} else if (bussines.getChildNodes().item(z)
											.getChildNodes().item(m)
											.getNodeName().equalsIgnoreCase(
													"wsag:Count")) {
										penalty2 = " "
												+ bussines.getChildNodes()
														.item(z)
														.getChildNodes()
														.item(m)
														.getTextContent()
														.trim() + " invocation";
									}
								}

							} else if (bussines.getChildNodes().item(z)
									.getNodeName().equalsIgnoreCase(
											"wsag:ValueUnit")) {
								valueUnit = bussines.getChildNodes().item(z)
										.getTextContent().trim();

							} else if (bussines.getChildNodes().item(z)
									.getNodeName().equalsIgnoreCase(
											"wsag:ValueExpr")) {
								valueExpr = bussines.getChildNodes().item(z)
										.getTextContent().trim();
							}

						}

						if (penalty1.equals("")) {
							noscopes += "\n" + espacios + "Reward: "
									+ valueExpr + ", " + valueUnit
									+ ". Assessed in " + penalty2.trim() + ";";
						} else if (penalty2.equals("")) {
							noscopes += "\n" + espacios + "Reward: "
									+ valueExpr + ", " + valueUnit
									+ ". Assessed in " + penalty1.trim() + ";";
						}

					} else if (bussines.getNodeName().equalsIgnoreCase(
							"wsag:Preference")) {
						espacios = espaciado(numEspacios * 5 + 5);
						noscopes += "\n" + espacios + "Utility if selected:\n";
						espacios = espaciado(numEspacios * 5 + 10);
						String frase = "";
						for (int z = 0; z < bussines.getChildNodes()
								.getLength(); z++) {

							if (bussines.getChildNodes().item(z).getNodeName()
									.equalsIgnoreCase(
											"wsag:ServiceTermReference")) {
								frase += bussines.getChildNodes().item(z)
										.getTextContent().trim();

							} else if (bussines.getChildNodes().item(z)
									.getNodeName().equalsIgnoreCase(
											"wsag:Utility")) {
								noscopes += espacios
										+ frase
										+ "=>"
										+ bussines.getChildNodes().item(z)
												.getTextContent().trim()
										+ ",\n";
								frase = "";
							}

						}
						noscopes = noscopes.subSequence(0,
								noscopes.length() - 2)
								+ ";\n";

					} else if (bussines.getNodeName().equalsIgnoreCase(
							"wsag:CustomBusinessValue")) {
						espacios = espaciado(numEspacios * 5 + 5);
						noscopes += espacios + "Custom Business Value:\n";
						espacios = espaciado(numEspacios * 5 + 10);
						noscopes += espacios + bussines.getTextContent().trim()
								+ ";\n";
					}

				}
			}
		}

		if (scopes.endsWith("Scopes:")) {
			scopes = "";
		} else {
			scopes = scopes.subSequence(0, scopes.length() - 2) + ";\n";
		}
		wSAg4People += scopes + noscopes + "\n";

	}

	public String espaciado(int num) {
		String resultado = "";
		for (int x = 0; x < num; x++) {
			resultado += " ";
		}
		return resultado;
	}

	public String tabulado(String inicial, int num) {
		for (int x = 0; x < num; x++) {
			inicial += "\t";
		}

		return inicial;
	}

	private String searchType(String cad) {

		String res = "";
		int i = 0;
		while (cad.charAt(i) != ':') {

			i++;
		}

		return res;
	}

//	private String extraeTipo(String palabra) {
//
//		String tipo = "";
//		int inicio = 1;
//		int fin = 2;
//		int i = 1;
//
//		while (palabra.charAt(i) != ' ') {
//
//			i++;
//		}
//
//		return tipo;
//	}
	
	//XXX para extraer comentarios
	private String extractCommentNode(Node n){
		String s = "";
		if (n.getNodeType() == Node.COMMENT_NODE){
			String comment = n.getTextContent();
			comment = comment.replace("\n", "\n//");
			//si hay saltos de linea en el comentario,
			//ponemos tb la doble barra en la linea siguiente
			//para que siga siendo un comentario
			s = "//"+comment;
		}
		return s; 
	}
	
	private String extractCommentNodeln(Node n){
		String s = "";
		if (n.getNodeType() == Node.COMMENT_NODE){
			String comment = n.getTextContent();
			comment = comment.replace("\n", "\n//");
			//si hay saltos de linea en el comentario,
			//ponemos tb la doble barra en la linea siguiente
			//para que siga siendo un comentario
			s = "//"+comment+"\n";
		}
		return s;
	}

}
