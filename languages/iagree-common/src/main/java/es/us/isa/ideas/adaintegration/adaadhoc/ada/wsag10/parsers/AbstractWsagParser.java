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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.io.IDocumentParser;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Agreement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AgreementOffer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.BusinessValueList;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Context;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Count;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.CreationConstraints;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Item;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Location;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Penalty;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Preference;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Restriction;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Reward;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceProperties;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceScope;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringDuration;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringSLO;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.StringValueExpr;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Template;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.Domain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareContext;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareGeneralConstraint;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareGuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareItem;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.RealTemporalInterval;

/**
 * Template pattern. A default implementation with some abstract methods. If any
 * parser needs to change more things, it should overwrite specific methods like
 * parseSP or parseSDT
 * 
 * @author Jesus
 * 
 */
public abstract class AbstractWsagParser implements IDocumentParser {

	protected Document agreement;

	protected AbstractAgreementDocument agDoc;
	protected TermCompositor docTerms;
	protected Map<String, Variable> vars;
	
	protected SDTParser selectedSDTParser;
	
	protected TimeAwareParser selectedTimeAwareParser;
	
	private static final String TA_NAMESPACE = "twsag4people:";

	public AbstractWsagParser() {
		selectedTimeAwareParser = initTimeAwareParser();
		selectedTimeAwareParser.setTimeAwareNamespace(TA_NAMESPACE);
		selectedSDTParser = initSDTParser();
	}

	protected void openAgreementXML(String agFileName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		File f = new File(agFileName);
		if (f.exists()) {
			try {
				InputStream is = new FileInputStream(f);
				InputSource source = new InputSource(is);
				builder = factory.newDocumentBuilder();
				agreement = builder.parse(source);
			} catch (Exception e) {
				System.err.println("Error while opening the agreement file");
			}
		}
	}

	public AbstractAgreementDocument parseFile(String agFileName, String... options) {
		docTerms = new TermCompositor();
		docTerms.setType(TermCompositor.ALL);
		vars = new HashMap<String, Variable>();
		selectedSDTParser.setVars(vars);
		selectedTimeAwareParser.resetDefinedPeriods();
		openAgreementXML(agFileName);

		if (agreement == null)
			return null;

		// checking if file contains data
		NodeList rootNode = agreement.getChildNodes();
		if (rootNode.getLength() == 0) {
			return null;
		}

		Node root = rootNode.item(0);

		// checking of the root xml node
		// we check if the document is an offer, an agreement (no difference
		// with offer) or a template
		if (root.getNodeName().equalsIgnoreCase("wsag:AgreementOffer") || root.getNodeName().equalsIgnoreCase("wsag:Agreement")) {

			if (root.getNodeName().equalsIgnoreCase("wsag:AgreementOffer")) {
				agDoc = new AgreementOffer();
			} else {
				agDoc = new Agreement();
			}
			NamedNodeMap atts = root.getAttributes();

			// obtenemos el agreementid
			Node agidNode = atts.getNamedItem("wsag:AgreementId");
			if (agidNode != null) {
				agDoc.setId(agidNode.getNodeValue());
			}

			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node nextNode = childNodes.item(i);
				if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
					if (nextNode.getNodeName().equalsIgnoreCase("wsag:Name")) {
						agDoc.setName(nextNode.getTextContent().trim());
					} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:Context")) {
						Context context = parseOfferContext(nextNode);
					} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:Terms")) {
						NodeList termsChildNodes = nextNode.getChildNodes();
						Node rootTermNode = termsChildNodes.item(1);
						if (!rootTermNode.getNodeName().equalsIgnoreCase("wsag:All")) {
							// error, debe ser un all
						} else {

							TermCompositor termsAllRoot = new TermCompositor();
							termsAllRoot.setType(TermCompositor.ALL);

							LinkedList<Term> l = new LinkedList<Term>();
							this.createTerms(rootTermNode.getChildNodes(), l);

							docTerms.setComprisedTerms(l);
							agDoc.setTerms(docTerms);
						}

					}
				}
			}
		} else if (root.getNodeName().equalsIgnoreCase("wsag:Template")) {
			Template agDoc = new Template();
			NamedNodeMap atts = root.getAttributes();
			Node tempIdNode = atts.getNamedItem("wsag:TemplateId");
			if (tempIdNode != null) {
				agDoc.setId(tempIdNode.getNodeValue());
			}

			NodeList childNodes = root.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				Node nextNode = childNodes.item(i);
				if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
					if (nextNode.getNodeName().equalsIgnoreCase("wsag:Name")) {
						agDoc.setName(nextNode.getTextContent().trim());
					} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:Context")) {
						Context context = parseContext(agDoc, nextNode);
					} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:Terms")) {
						NodeList termsChildNodes = nextNode.getChildNodes();
						Node rootTermNode = termsChildNodes.item(1);
						if (!rootTermNode.getNodeName().equalsIgnoreCase("wsag:All")) {
						} else {

							TermCompositor termsAllRoot = new TermCompositor();
							termsAllRoot.setType(TermCompositor.ALL);

							this.createTerms(rootTermNode.getChildNodes(), new ArrayList<Term>());

							LinkedList<Term> l = new LinkedList<Term>();
							this.createTerms(rootTermNode.getChildNodes(), l);

							docTerms.setComprisedTerms(l);
							agDoc.setTerms(docTerms);
						}

					} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:CreationConstraints")) {
						CreationConstraints cc = new CreationConstraints();
						NodeList ccChildNodes = nextNode.getChildNodes();
						for (int k = 0; k < ccChildNodes.getLength(); k++) {
							Node nextNodeCC = ccChildNodes.item(k);
							if (nextNodeCC.getNodeType() == Node.ELEMENT_NODE) {
								if (nextNodeCC.getNodeName().equalsIgnoreCase("wsag:Item")) {

									Item item = parseItem(nextNodeCC);
									if (item.isAnalysable()) {
										cc.addItem(item);
									}

								} else if (nextNodeCC.getNodeName().equalsIgnoreCase("wsag:Constraint")) {

									GeneralConstraint gc = parseConstraint(nextNodeCC);
									cc.addConstraint(gc);
								}
							}
						}
						agDoc.setCc(cc);
					}
				}
			}
			// Las CreationConstraint son obligatorias para una plantilla,
			// si no se han parseado lanzamos excepci-n
			if(agDoc.getCc() == null){
				throw new BadSyntaxException("CreationConstraint not found. Please add a CreationConstraint element to your document");
			}
		}
		return agDoc;
	}

	protected GeneralConstraint parseConstraint(Node nextNodeCC) {
		TimeAwareGeneralConstraint gc = new TimeAwareGeneralConstraint();
		NodeList constraintChildNodes = nextNodeCC.getChildNodes();
		for (int q = 0; q < constraintChildNodes.getLength(); q++) {
			Node nextNodeConstraint = constraintChildNodes.item(q);
			if (nextNodeConstraint.getNodeType() == Node.ELEMENT_NODE) {
				if (nextNodeConstraint.getNodeName().equalsIgnoreCase("Name")) {
					gc.setCcName(nextNodeConstraint.getTextContent().trim());
				} else if (nextNodeConstraint.getNodeName().equalsIgnoreCase("Content")) {
					gc.setConstraint(nextNodeConstraint.getTextContent().trim());
				}else if(nextNodeConstraint.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"ValidityPeriod")){
					// si tiene ValidityPeriod lo parseamos
					RealTemporalInterval rti = selectedTimeAwareParser.parseValidityPeriod(nextNodeConstraint);
					gc.setValidityPeriod(rti);
				}
			}
		}
		if(agDoc.getHasTemporality() && gc.getValidityPeriod() == null){
			TimeAwareContext tac = (TimeAwareContext) agDoc.getContext();
			gc.setValidityPeriod(tac.getGlobalPeriod());
		}
		return gc;
	}

	protected Item parseItem(Node nextNodeCC) {
		TimeAwareItem item = new TimeAwareItem();
		item.setCcName(nextNodeCC.getAttributes().getNamedItem("wsag:Name").getTextContent().trim());
		NodeList itemChildNodes = nextNodeCC.getChildNodes();
		for (int m = 0; m < itemChildNodes.getLength(); m++) {
			Node nextNodeItem = itemChildNodes.item(m);
			if (nextNodeItem.getNodeType() == Node.ELEMENT_NODE) {
				if (nextNodeItem.getNodeName().equalsIgnoreCase("wsag:Location")) {
					item.setLocation(nextNodeItem.getTextContent().trim());
				} else if (nextNodeItem.getNodeName().equalsIgnoreCase("wsag:ItemConstraint")) {

					NodeList itemRestrictionChildNodes = nextNodeItem.getChildNodes();

					for (int p = 0; p < itemRestrictionChildNodes.getLength(); p++) {
						Node nextNodeItemRestriction = itemRestrictionChildNodes.item(p);

						if (nextNodeItemRestriction.getNodeType() == Node.ELEMENT_NODE) {
							if (nextNodeItemRestriction.getNodeName().equalsIgnoreCase("xs:restriction")) {
								// de momento asumo
								// que la
								// restriction es
								// Simple y su tipo
								// base es
								// "xs:integer" para
								// permitir el 0
								Restriction r = new Restriction();
								String dataType = nextNodeItemRestriction.getAttributes().getNamedItem("base").getTextContent().trim();
								r.setBaseType(dataType);
								NodeList restrictionChildNodes = nextNodeItemRestriction.getChildNodes();
								for (int n = 0; n < restrictionChildNodes.getLength(); n++) {
									Node nextNodeRestriction = restrictionChildNodes.item(n);
									if (nextNodeRestriction.getNodeType() == Node.ELEMENT_NODE) {
										if (nextNodeRestriction.getNodeName().equalsIgnoreCase("xs:minInclusive")) {
											r.setMinInclusive(nextNodeRestriction.getAttributes().getNamedItem("value").getTextContent().trim());
										} else if (nextNodeRestriction.getNodeName().equalsIgnoreCase("xs:minExclusive")) {
											r.setMinExclusive(nextNodeRestriction.getAttributes().getNamedItem("value").getTextContent().trim());
										} else if (nextNodeRestriction.getNodeName().equalsIgnoreCase("xs:maxInclusive")) {
											r.setMaxInclusive(nextNodeRestriction.getAttributes().getNamedItem("value").getTextContent().trim());
										} else if (nextNodeRestriction.getNodeName().equalsIgnoreCase("xs:maxExclusive")) {
											r.setMaxExclusive(nextNodeRestriction.getAttributes().getNamedItem("value").getTextContent().trim());
										}
									}
								}
								item.setIconst(r);

							}
						}
					}

				}else if(nextNodeItem.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"ValidityPeriod")){
					// si tiene validityPeriod lo parseamos
					RealTemporalInterval rti = selectedTimeAwareParser.parseValidityPeriod(nextNodeItem);
					item.setValidityPeriod(rti);
				}

			}
		}
		// Si el documento tiene temporalidad pero este item no tiene definido periodo
		// de validez, le asignamos el global period
		if(agDoc.getHasTemporality() && item.getValidityPeriod() == null){
			TimeAwareContext tac = (TimeAwareContext) agDoc.getContext();
			item.setValidityPeriod(tac.getGlobalPeriod());
		}
		return item;
	}

	protected Context parseOfferContext(Node nextNode) {
		String s;
		TimeAwareContext context = new TimeAwareContext();
		if (nextNode.hasChildNodes()) {
			NodeList childNodesContext = nextNode.getChildNodes();
			// parseamos primero GMTZone y DateFormat porque necesitamos
			// tenerlos para poder parsear los periodos. Aunque parece que
			// no hace falta si aparecen al principio del documento
			for (int j = 0; j < childNodesContext.getLength(); j++) {
				Node nextNodeContext = childNodesContext.item(j);
				if(nextNodeContext.getNodeType() == Node.ELEMENT_NODE) {
					if ( nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"GMTZone")){
						String gmtZone = nextNodeContext.getTextContent().trim();
						if(gmtZone == ""){
							throw new BadSyntaxException("GMTZone cannot be empty");
						}
						context.setGmtZone(gmtZone);
						selectedTimeAwareParser.setGMTZone(gmtZone);
					}else if (nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"DateFormat")){
						String dateFormat = nextNodeContext.getTextContent().trim();
						if(dateFormat == ""){
							throw new BadSyntaxException("DateFormat cannot be empty");
						}
						context.setDateFormat(dateFormat);
						selectedTimeAwareParser.setDateFormat(dateFormat);
					}
				}
			}
			// ahora s-, parseamos todo el contexto
			for (int j = 0; j < childNodesContext.getLength(); j++) {
				Node nextNodeContext = childNodesContext.item(j);
				if (nextNodeContext.getNodeType() == Node.ELEMENT_NODE) {
					if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:AgreementInitiator")) {
						s = nextNodeContext.getTextContent().trim();
						context.setAgreementInitiator(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:AgreementResponder")) {
						s = nextNodeContext.getTextContent().trim();
						context.setAgreementResponder(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:ServiceProvider")) {
						s = nextNodeContext.getTextContent().trim();
						context.setServiceProviderRole(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:TemplateId")) {
						s = nextNodeContext.getTextContent().trim();
						if(s.equalsIgnoreCase("")){
							throw new BadSyntaxException("TemplateId is a mandatory element in an offer");
						}
						context.setTemplateId(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:TemplateName")) {
						s = nextNodeContext.getTextContent().trim();
						if(s.equalsIgnoreCase("")){
							throw new BadSyntaxException("TemplateName is a mandatory element in an offer");
						}
						context.setTemplateName(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:ExpirationTime")) {
						String xmlExpTime = nextNodeContext.getTextContent().trim();
						String date = xmlExpTime.substring(0, xmlExpTime.lastIndexOf("T"));
						String time = xmlExpTime.substring(xmlExpTime.lastIndexOf("T") + 1, xmlExpTime.length());
						CharSequence z = "Z";
						CharSequence mas = "+";
						CharSequence menos = "-";
						String localTime = time;
						String extraTime = null;
						if (time.contains(z))
							localTime = time.substring(0, time.length() - 1);
						if (time.contains(mas)) {
							localTime = time.substring(0, time.lastIndexOf("+"));
							extraTime = time.substring(time.lastIndexOf("+"), time.length());
						}
						if (time.contains(menos)) {
							localTime = time.substring(0, time.lastIndexOf("-"));
							extraTime = time.substring(time.lastIndexOf("-"), time.length());
						}

						// Integer y = new Integer(date.substring(0, 4));
						// Integer m = new Integer(date.substring(5, 7));
						// Integer d = new Integer(date.substring(8, 10));
						// Integer h = new Integer(localTime.substring(0, 2));
						// Integer mt = new Integer(localTime.substring(3, 5));
						// Integer s1 = new Integer(localTime.substring(6, 8));

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
						Date expirationTime = null;
						try {
							String dateTime = date + "T" + localTime;
							expirationTime = sdf.parse(dateTime);
						} catch (ParseException e) {
							System.err.println("ParseException: No se puede parsear expirationTime");
						}
						// Date expirationTime = new Date(y, m, d, h, mt, s1);
						if (expirationTime != null) {
							context.setExpirationTime(expirationTime);
							context.setExtraTime(extraTime);
						}
					}else if(nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"GlobalPeriod")){
						// si tiene globalValidityPeriod lo parseamos
						RealTemporalInterval rti = selectedTimeAwareParser.parseGlobalValidityPeriod(nextNodeContext);
						context.setGlobalPeriod(rti);
						agDoc.setHasTemporality(true);
					}else if(nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"DefinedValidityPeriodSet")){
						if(context.getGmtZone() == null || context.getDateFormat() == null){
							System.err.println("Estamos parseando t-rminos antes de parsear DateFormat y GMTZone");
						}
						Map<String, RealTemporalInterval> periods = selectedTimeAwareParser.parseDefinedValidityPeriodSet(nextNodeContext);
						context.setPeriods(periods);
					}
				}
			}
			// como supusimos al principio que el contexto ten-a temporalidad,
			// en caso de que finalmente no tenga hacemos el casting a Context
			if(agDoc.getHasTemporality()){
				agDoc.setContext(context);
			}else{
				agDoc.setContext((Context) context);
			}
		} else {
			System.err.println("OJO! El contexto es null para el documento "+agDoc.getName());
			agDoc.setContext(null);
		}
		return context;
	}

	protected Context parseContext(Template agDoc, Node nextNode) {
		TimeAwareContext context;
		context = new TimeAwareContext();
		if (nextNode.hasChildNodes()) {
			NodeList childNodesContext = nextNode.getChildNodes();
			// parseamos primero GMTZone y DateFormat porque necesitamos
			// tenerlos para poder parsear los periodos. Aunque parece que
			// no hace falta si aparecen al principio del documento
			for (int j = 0; j < childNodesContext.getLength(); j++) {
				Node nextNodeContext = childNodesContext.item(j);
				if(nextNodeContext.getNodeType() == Node.ELEMENT_NODE) {
					if ( nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"GMTZone")){
						String gmtZone = nextNodeContext.getTextContent().trim();
						if(gmtZone == ""){
							throw new BadSyntaxException("GMTZone cannot be empty");
						}
						context.setGmtZone(gmtZone);
						selectedTimeAwareParser.setGMTZone(gmtZone);
					}else if (nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"DateFormat")){
						String dateFormat = nextNodeContext.getTextContent().trim();
						if(dateFormat == ""){
							throw new BadSyntaxException("DateFormat cannot be empty");
						}
						context.setDateFormat(dateFormat);
						selectedTimeAwareParser.setDateFormat(dateFormat);
					}
				}
			}
			// ahora s-, parseamos todo el contexto
			for (int j = 0; j < childNodesContext.getLength(); j++) {
				Node nextNodeContext = childNodesContext.item(j);
				if (nextNodeContext.getNodeType() == Node.ELEMENT_NODE) {
					String s;
					if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:AgreementInitiator")) {
						s = nextNodeContext.getTextContent().trim();
						context.setAgreementInitiator(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:AgreementResponder")) {
						s = nextNodeContext.getTextContent().trim();
						context.setAgreementResponder(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:ServiceProvider")) {
						s = nextNodeContext.getTextContent().trim();
						context.setServiceProviderRole(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:TemplateId")) {
						s = nextNodeContext.getTextContent().trim();
						context.setTemplateId(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:TemplateName")) {
						s = nextNodeContext.getTextContent().trim();
						context.setTemplateName(s);
					} else if (nextNodeContext.getNodeName().equalsIgnoreCase("wsag:ExpirationTime")) {
						String xmlExpTime = nextNodeContext.getTextContent().trim();
						String date = xmlExpTime.substring(0, xmlExpTime.lastIndexOf("T"));
						String time = xmlExpTime.substring(xmlExpTime.lastIndexOf("T") + 1, xmlExpTime.length());
						CharSequence z = "Z";
						CharSequence mas = "+";
						CharSequence menos = "-";
						String localTime = time;
						String extraTime = null;
						if (time.contains(z))
							localTime = time.substring(0, time.length() - 1);
						if (time.contains(mas)) {
							localTime = time.substring(0, time.lastIndexOf("+"));
							extraTime = time.substring(time.lastIndexOf("+"), time.length());
						}
						if (time.contains(menos)) {
							localTime = time.substring(0, time.lastIndexOf("-"));
							extraTime = time.substring(time.lastIndexOf("-"), time.length());
						}

						// Integer y = new Integer(date.substring(0, 4));
						// Integer m = new Integer(date.substring(5, 7));
						// Integer d = new Integer(date.substring(8, 10));
						// Integer h = new Integer(localTime.substring(0, 2));
						// Integer mt = new Integer(localTime.substring(3, 5));
						// Integer s1 = new Integer(localTime.substring(6, 8));

						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
						Date expirationTime = null;
						try {
							String dateTime = date + "T" + localTime;
							expirationTime = sdf.parse(dateTime);
						} catch (ParseException e) {
							System.err.println("ParseException: No se puede parsear expirationTime");
						}
						// Date expirationTime = new Date(y, m, d, h, mt, s1);
						if (expirationTime != null) {
							context.setExpirationTime(expirationTime);
							context.setExtraTime(extraTime);
						}
					}else if(nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"GlobalPeriod")){
						// si tiene globalValidityPeriod lo parseamos
						RealTemporalInterval rti = selectedTimeAwareParser.parseGlobalValidityPeriod(nextNodeContext);
						context.setGlobalPeriod(rti);
						agDoc.setHasTemporality(true);
					}else if(nextNodeContext.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"DefinedValidityPeriodSet")){
						if(context.getGmtZone() == null || context.getDateFormat() == null){
							System.err.println("Estamos parseando t-rminos antes de parsear DateFormat y GMTZone");
						}
						Map<String, RealTemporalInterval> periods = selectedTimeAwareParser.parseDefinedValidityPeriodSet(nextNodeContext);
						context.setPeriods(periods);
					}
				}
			}
			// como supusimos al principio que el contexto ten-a temporalidad,
			// en caso de que finalmente no tenga hacemos el casting a Context
			if(agDoc.getHasTemporality()){
				agDoc.setContext(context);
			}else{
				agDoc.setContext((Context) context);
			}
			
			this.agDoc = agDoc;
		} else {
			agDoc.setContext(null);
		}
		return context;
	}

	protected void createTerms(NodeList inputTerms, List<Term> node) {

		for (int i = 0; i < inputTerms.getLength(); i++) {
			Node nextNode = inputTerms.item(i);
			if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
				if (nextNode.getNodeName().equalsIgnoreCase("wsag:ServiceDescriptionTerm")) {

					parseSDT(node, nextNode);

				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:ServiceProperties")) {

					parseSP(node, nextNode);

				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:GuaranteeTerm")) {

					parseGT(node, nextNode);

				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:ServiceReference")) {
					// TO DO

				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:All")) {
					// hacer
					// sin pisar el resultTree =
					TermCompositor tc = new TermCompositor();
					tc.setType(TermCompositor.ALL);

					node.add(tc);
					this.createTerms(nextNode.getChildNodes(), tc.getComprisedTerms());

				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:OneOrMore")) {
					// hacer
					TermCompositor tc = new TermCompositor();
					tc.setType(TermCompositor.ONE_OR_MORE);

					node.add(tc);
					this.createTerms(nextNode.getChildNodes(), tc.getComprisedTerms());

					// hemos encontrado un OneOrMore, por lo tanto este documento tiene alternatives
					agDoc.setHasAlternatives(true);
				} else if (nextNode.getNodeName().equalsIgnoreCase("wsag:ExactlyOne")) {
					// hacer
					TermCompositor tc = new TermCompositor();
					tc.setType(TermCompositor.EXACTLY_ONE);

					node.add(tc);
					this.createTerms(nextNode.getChildNodes(), tc.getComprisedTerms());

					// hemos encontrado un ExactlyOne, por lo tanto este documento tiene alternatives
					agDoc.setHasAlternatives(true);
				}
			}
		}

	}

	protected GuaranteeTerm parseGT(List<Term> node, Node nextNode) {
		TimeAwareGuaranteeTerm gt = new TimeAwareGuaranteeTerm();
		gt.setTermName(nextNode.getAttributes().getNamedItem("wsag:Name").getNodeValue());

		Node obligatedNode = nextNode.getAttributes().getNamedItem("wsag:Obligated");
		if (obligatedNode != null) {
			gt.setObligated(obligatedNode.getNodeValue());
		}

		NodeList GuaranteeTermNodes = nextNode.getChildNodes();
		for (int j = 0; j < GuaranteeTermNodes.getLength(); j++) {
			Node nextGTNode = GuaranteeTermNodes.item(j);
			if (nextGTNode.getNodeType() == Node.ELEMENT_NODE) {
				if (nextGTNode.getNodeName().equalsIgnoreCase("wsag:ServiceScope")) {
					// como tiene un scope, ponemos hasViews a true
					agDoc.setHasViews(true);
					
					ServiceScope scope = new ServiceScope();
					scope.setServiceName(nextGTNode.getAttributes().getNamedItem("wsag:ServiceName").getNodeValue());
					scope.setContent(nextGTNode.getTextContent().trim());
					gt.addScope(scope);

				} else if (nextGTNode.getNodeName().equalsIgnoreCase("wsag:QualifyingCondition")) {
					Boolean thisGTHasTemporality = false;
					NodeList qualifyingConditionNodes = nextGTNode.getChildNodes();
					for (int k = 0; k < qualifyingConditionNodes.getLength(); k++){
						Node nextQCNode = qualifyingConditionNodes.item(k);
						if(nextQCNode.getNodeType() == Node.ELEMENT_NODE){
							if(nextQCNode.getNodeName().equalsIgnoreCase("condition")){
								String qc = new String();
								qc = nextQCNode.getTextContent().trim();

								gt.setQualifyingCondition(qc);
							}else if(nextQCNode.getNodeName().equalsIgnoreCase(TA_NAMESPACE+"ValidityPeriod")){
								thisGTHasTemporality = true;
								RealTemporalInterval rti = selectedTimeAwareParser.parseValidityPeriod(nextQCNode);
								gt.setValidityPeriod(rti);
							}
						}
					}
					if(!thisGTHasTemporality){
						// si no tiene temporalidad, seteamos directamente la QC
						String qc = new String();
						qc = nextGTNode.getTextContent().trim();

						gt.setQualifyingCondition(qc);
					}
				} else if (nextGTNode.getNodeName().equalsIgnoreCase("wsag:BusinessValueList")) {
					NodeList BVLNodes = nextGTNode.getChildNodes();
					BusinessValueList bvl = new BusinessValueList();
					for (int k = 0; k < BVLNodes.getLength(); k++) {
						Node nextBVLNode = BVLNodes.item(k);

						if (nextBVLNode.getNodeType() == Node.ELEMENT_NODE) {
							if (nextBVLNode.getNodeName().equalsIgnoreCase("wsag:Importance")) {
								String importanceString = nextBVLNode.getTextContent().trim();
								Integer imp = new Integer(importanceString);

								bvl.setImportance(imp);
							} else if (nextBVLNode.getNodeName().equalsIgnoreCase("wsag:CustomBusinessValue")) {
								// TO DO, ahora mismo no se utiliza
								// para nada
								// Se almacenaria en el
								// Collection<CustomBusinessValue>
								// de la clase
								// BusinessValueList.java
							} else if (nextBVLNode.getNodeName().equalsIgnoreCase("wsag:Penalty")) {
								NodeList PenaltyNodes = nextBVLNode.getChildNodes();
								Penalty p = new Penalty();
								for (int m = 0; m < PenaltyNodes.getLength(); m++) {
									Node nextPenaltyNode = PenaltyNodes.item(m);

									if (nextPenaltyNode.getNodeType() == Node.ELEMENT_NODE) {
										if (nextPenaltyNode.getNodeName().equalsIgnoreCase("wsag:AssesmentInterval")) {
											NodeList AssesmentNodes = nextPenaltyNode.getChildNodes();
											for (int n = 0; n < AssesmentNodes.getLength(); n++) {
												Node nextAssesmentNode = AssesmentNodes.item(n);

												if (nextAssesmentNode.getNodeType() == Node.ELEMENT_NODE) {
													if (nextAssesmentNode.getNodeName().equalsIgnoreCase("wsag:TimeInterval")) {
														StringDuration stringDuration = new StringDuration();
														String duration = nextAssesmentNode.getTextContent().trim();

														stringDuration.setIntervalDuration(duration);
														p.setInterval(stringDuration);
													} else if (nextAssesmentNode.getNodeName().equalsIgnoreCase("wsag:Count")) {
														Count count = new Count();
														String cStr = nextAssesmentNode.getTextContent().trim();
														Integer c = new Integer(cStr);

														count.setCount(c);
														count.setConcept("to be determined");

														p.setInterval(count);
													}
												}
											}

										} else if (nextPenaltyNode.getNodeName().equalsIgnoreCase("wsag:ValueUnit")) {
											String unit = nextPenaltyNode.getTextContent().trim();

											p.setValueUnit(unit);
										} else if (nextPenaltyNode.getNodeName().equalsIgnoreCase("wsag:ValueExpr")) {
											StringValueExpr valueExpr = new StringValueExpr();
											String expr = nextPenaltyNode.getTextContent().trim();

											valueExpr.setValueExpr(expr);
											p.setVExp(valueExpr);
										}
									}
								}

								bvl.addPenalty(p);
							} else if (nextBVLNode.getNodeName().equalsIgnoreCase("wsag:Reward")) {
								NodeList RewardNodes = nextBVLNode.getChildNodes();
								Reward r = new Reward();
								for (int m = 0; m < RewardNodes.getLength(); m++) {
									Node nextRewardNode = RewardNodes.item(m);

									if (nextRewardNode.getNodeType() == Node.ELEMENT_NODE) {
										if (nextRewardNode.getNodeName().equalsIgnoreCase("wsag:AssesmentInterval")) {
											NodeList AssesmentNodes = nextRewardNode.getChildNodes();
											for (int n = 0; n < AssesmentNodes.getLength(); n++) {
												Node nextAssesmentNode = AssesmentNodes.item(n);

												if (nextAssesmentNode.getNodeType() == Node.ELEMENT_NODE) {
													if (nextAssesmentNode.getNodeName().equalsIgnoreCase("wsag:TimeInterval")) {
														StringDuration stringDuration = new StringDuration();
														String duration = nextAssesmentNode.getTextContent().trim();

														stringDuration.setIntervalDuration(duration);
														r.setInterval(stringDuration);
													} else if (nextAssesmentNode.getNodeName().equalsIgnoreCase("wsag:Count")) {
														Count count = new Count();
														String cStr = nextAssesmentNode.getTextContent().trim();
														Integer c = new Integer(cStr);

														count.setCount(c);
														count.setConcept("to be determined");
														r.setInterval(count);
													}
												}
											}

										} else if (nextRewardNode.getNodeName().equalsIgnoreCase("wsag:ValueUnit")) {
											String unit = nextRewardNode.getTextContent().trim();

											r.setValueUnit(unit);
										} else if (nextRewardNode.getNodeName().equalsIgnoreCase("wsag:ValueExpr")) {
											StringValueExpr valueExpr = new StringValueExpr();
											String expr = nextRewardNode.getTextContent().trim();

											valueExpr.setValueExpr(expr);
											r.setVExp(valueExpr);
										}
									}
								}

								bvl.addReward(r);
							} else if (nextBVLNode.getNodeName().equalsIgnoreCase("wsag:Preference")) {

								NodeList PreferenceNodes = nextBVLNode.getChildNodes();

								ServiceDescriptionTerm sdtRef = null;
								Float utility = null;

								for (int m = 0; m < PreferenceNodes.getLength(); m++) {
									Node nextPreferenceNode = PreferenceNodes.item(m);

									// Esto va a-adiendo las
									// preferencias cuando tiene un
									// SDT y su Utilidad
									if ((sdtRef != null) && (utility != null)) {
										Preference pref = new Preference();
										pref.setServiceTermReference(sdtRef);
										pref.setUtility(utility);
										bvl.addPreference(pref);

										sdtRef = null;
										utility = null;
									}

									if (nextPreferenceNode.getNodeType() == Node.ELEMENT_NODE) {
										if (nextPreferenceNode.getNodeName().equalsIgnoreCase("wsag:ServiceTermReference")) {
											String referencedSDTName = nextPreferenceNode.getTextContent().trim();

											Iterator<Term> it = node.iterator();
											while (it.hasNext()) {
												Term t = (Term) it.next();

												if (t.getTermName().equalsIgnoreCase(referencedSDTName)) {
													sdtRef = (ServiceDescriptionTerm) t;
												} else {
												}

											}

										}
										if (nextPreferenceNode.getNodeName().equalsIgnoreCase("wsag:Utility")) {
											String uStr = nextPreferenceNode.getTextContent().trim();
											Float u = new Float(uStr);

											utility = u;

										}
									}

								}

							}
						}

					}

					gt.setBvl(bvl);

				} else if (nextGTNode.getNodeName().equalsIgnoreCase("wsag:ServiceLevelObjective")) {
					NodeList sloDefs = GuaranteeTermNodes.item(j).getChildNodes();
					Node sloDef = sloDefs.item(1);
					if (sloDef.getNodeName().equalsIgnoreCase("wsag:KPITarget")) {
						NodeList kpiChilds = sloDef.getChildNodes();
						for (int kpiIndex = 0; kpiIndex < kpiChilds.getLength(); kpiIndex++) {
							Node kpiNode = kpiChilds.item(kpiIndex);
							if (kpiNode.getNodeName().equalsIgnoreCase("wsag:CustomServiceLevel")) {
								StringSLO slo = new StringSLO();
								slo.setSlo(kpiNode.getTextContent().trim());
								gt.setSlo(slo);
							}
						}
					} else if (sloDef.getNodeName().equalsIgnoreCase("wsag:CustomServiceLevel")) {
						StringSLO slo = new StringSLO();
						slo.setSlo(sloDef.getTextContent().trim());
						gt.setSlo(slo);
					}
				}
			}
		}
		if(agDoc.getHasTemporality() && gt.getValidityPeriod() == null){
			TimeAwareContext tac = (TimeAwareContext) agDoc.getContext();
			gt.setValidityPeriod(tac.getGlobalPeriod());
			if(node == null){
				docTerms.addComprisedTerm(gt);
			}else{
				node.add(gt);
			}
		}else{
			if (node == null) {
				docTerms.addComprisedTerm(gt);
			} else {
				node.add(gt);
			}
		}
		
		return gt;
	}

	protected ServiceProperties parseSP(List<Term> node, Node nextNode) {
		// hacer
		ServiceProperties sp = new ServiceProperties();
		sp.setTermName(nextNode.getAttributes().getNamedItem("wsag:Name").getNodeValue());
		sp.setServiceName(nextNode.getAttributes().getNamedItem("wsag:ServiceName").getNodeValue());

		NodeList servicePropertiesRootNodes = nextNode.getChildNodes();
		Node rootServiceProperties = servicePropertiesRootNodes.item(1);

		if (!rootServiceProperties.getNodeName().equalsIgnoreCase("wsag:VariableSet")) {

		} else {
			// System.out
			// .println("La estructura del service properties es correcta");
			NodeList variableNodes = rootServiceProperties.getChildNodes();
			// ////System.out.println(variableNodes.getLength());
			HashSet<Variable> variables = new HashSet<Variable>();
			for (int j = 0; j < variableNodes.getLength(); j++) {
				Node nextVarNode = variableNodes.item(j);
				// ////System.out.println(serviceFeaturesNodes.item(j).getNodeName());
				if (nextVarNode.getNodeType() == Node.ELEMENT_NODE) {
					Variable v = new Variable();
					v.setUniqueName(nextVarNode.getAttributes().getNamedItem("wsag:Name").getNodeValue());
					// ////System.out.println(v.getUniqueName);
					String metricStr = nextVarNode.getAttributes().getNamedItem("wsag:Metric").getNodeValue();
					// String fileName = metricStr.substring(0,
					// metricStr.lastIndexOf(":")).concat(
					// ".xml");
					// String elementName = metricStr
					// .substring(metricStr.lastIndexOf(":") + 1);
					// // if (metricXML==null) openMetricXML(fileName,
					// // v.getUniqueName());
					// MetricParser metricParser = new
					// ADAMetricParser(fileName);
					// // openMetricXML(fileName);
					// String[] params = new String[3];
					// params = metricParser.getValue(elementName);
					// // params = this.getValue(elementName);
					// // //System.out.println(params[0] + ", " +
					// // params[1]
					// // + ", " + params[2]);
					// m.setDataType(params[0]);
					// m.setMin(params[1]);
					// m.setMax(params[2]);
					MetricParser metricParser = new ADAMetricParser();
					Domain d = metricParser.getValue(metricStr);
					v.setDomain(d);

					NodeList locationNodes = nextVarNode.getChildNodes();
					for (int k = 0; k < locationNodes.getLength(); k++) {
						Node locationNode = locationNodes.item(k);
						if ((locationNode.getNodeType() == Node.ELEMENT_NODE) && (locationNode.getNodeName().equalsIgnoreCase("wsag:Location"))) {

							Location loc = new Location(locationNode.getTextContent().trim());
							v.setLocation(loc);
						}
					}
					variables.add(v);
					vars.put(v.getName(), v);
					// ////System.out.println(variables.toString());
				}

			}
			sp.setVariableSet(variables);
		}
		if (node == null) {
			// docTerms.getRoot().addElement(sp);
			docTerms.addComprisedTerm(sp);
			// ////System.out.println(docTerms.getBreadthFirstList());
		} else {
			node.add(sp);
		}
		return sp;
	}

	protected ServiceDescriptionTerm parseSDT(List<Term> node, Node nextNode) {
		// esto puede aprovecharse
		ServiceDescriptionTerm sdt = null;
		if (selectedSDTParser != null) {
			sdt = selectedSDTParser.parseSDT(nextNode);
		}

		if (sdt != null) {
			node.add(sdt);
		}
		
		if(sdt instanceof TimeAwareServiceDescriptionTerm){
			TimeAwareServiceDescriptionTerm tasdt = (TimeAwareServiceDescriptionTerm) sdt;
			if(agDoc.getHasTemporality() && tasdt.getValidityPeriod() == null){
				TimeAwareContext tac = (TimeAwareContext) agDoc.getContext();
				tasdt.setValidityPeriod(tac.getGlobalPeriod());
			}
		}
		return sdt;
	}

	protected abstract SDTParser initSDTParser();
	
	protected abstract TimeAwareParser initTimeAwareParser();
}
