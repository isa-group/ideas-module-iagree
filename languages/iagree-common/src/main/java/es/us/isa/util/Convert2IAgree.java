package es.us.isa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.error.IAgreeError;
import es.us.isa.parser.iAgreeParser;

public class Convert2IAgree {

	public static String getContext(Document doc) {
		String result = "";

		Node nodeTempName = doc.getElementsByTagName("wsag:TemplateName").item(
				0);
		if (nodeTempName != null) {
			String templateName = nodeTempName.getTextContent();
			result += " for " + templateName;
		}

		Node nodeTempId = doc.getElementsByTagName("wsag:TemplateId").item(0);
		if (nodeTempId != null) {
			String templateId = nodeTempId.getTextContent();
			result += " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.VERSION])
					+ " " + templateId + "\n";
		}

		Node responder = doc.getElementsByTagName("wsag:AgreementResponder")
				.item(0);
		if (responder != null)
			result += "\t"
					+ responder.getTextContent()
					+ " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AS])
					+ " "
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.RESPONDER])
					+ "\n";

		Node dateFormat = doc.getElementsByTagName("twsag4people:DateFormat")
				.item(0);
		if (dateFormat != null)
			result += "\tDateFormat: " + dateFormat.getTextContent() + "\n";

		Node GMTZone = doc.getElementsByTagName("wsag:GMTZone").item(0);
		if (GMTZone != null)
			result += "\tGMTZone: " + GMTZone.getTextContent() + "\n";

		Node GlobalPeriod = doc.getElementsByTagName(
				"twsag4people:GlobalPeriod").item(0);
		if (GlobalPeriod != null)
			result += "\tGlobalPeriod: " + GlobalPeriod.getTextContent() + "\n";

		return result;
	}

	public static String getMetrics(Document doc) {
		String result = Util
				.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.METRICS])
				+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP])
				+ "\n";

		NodeList nList = doc.getElementsByTagName("met:metric");

		for (int i = 0; i < nList.getLength(); i++) {
			Element node = (Element) nList.item(i);
			String nodeId = node.getAttribute("id");
			String nodeType = node.getAttribute("type");
			if (!nodeId.equals("boolean")) {
				result += "\t\t" + nodeId + ": " + nodeType;
				if (nodeType.equals("integer")) {
					String min = node.getAttribute("min");
					String max = node.getAttribute("max");
					result += "["
							+ min
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.RANGE_SEPARATOR])
							+ max + "]\n";
				} else if (nodeType.equals("enumerated")) {
					NodeList values = node.getElementsByTagName("met:value");
					Element value = (Element) values.item(0);
					if(value != null)
						result += " {" + value.getAttribute("value");
					for (int j = 1; j < values.getLength(); j++) {
						value = (Element) values.item(j);
						result += ", " + value.getAttribute("value");
					}
					result += "}\n";
				}
			}
		}
		return result;
	}

	public static String getAgreementTerms(Document doc) {
		Element service = (Element) doc.getElementsByTagName("wsag:Terms")
				.item(0);
		String result = Util
				.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AGREEMENT_TERMS])
				+ "\n\t"
				+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.SERVICE])
				+ " " + service.getAttribute("wsag:Name") + " ";

		Node serviceReference = doc.getElementsByTagName(
				"wsag:ServiceReference").item(0);
		if (serviceReference != null) {
			result += Util
					.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AVAL_AT])
					+ " \"" + serviceReference.getTextContent() + "\"";
		}

		Node globalDescription = doc.getElementsByTagName(
				"wsag:ServiceDescriptionTerm").item(0);
		if (globalDescription != null) {
			result += "\n\t\t"
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GLOBALDESCRIPTION]);

			NodeList nList = doc.getElementsByTagName("OfferItem");

			for (int i = 0; i < nList.getLength(); i++) {
				Element node = (Element) nList.item(i);

				result += "\n\t\t\t"
						+ node.getAttribute("name")
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);

				String type = node.getAttribute("wsag:Metric");
				String[] aux = type.split(":");
				result += " " + aux[1];

				if (!node.getTextContent().isEmpty()) {
					result += " "
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.IGUAL])
							+ " "
							+ node.getTextContent()
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.SEMICOLON]);
				}
			}
		}

		Node monitorableProps = doc.getElementsByTagName(
				"wsag:ServiceProperties").item(0);
		if (monitorableProps != null) {
			result += "\n\n\t"
					+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.MONITORABLEPROPERTIES])
					+ "\n\t\t";

			NodeList nList = doc.getElementsByTagName("wsag:Variable");
			if (nList != null) {

				result += Util
						.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GLOBAL])
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);

				for (int i = 0; i < nList.getLength(); i++) {
					Element node = (Element) nList.item(i);

					result += "\n\t\t\t"
							+ node.getAttribute("wsag:Name")
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);

					String type = node.getAttribute("wsag:Metric");
					String[] aux = type.split(":");
					result += " " + aux[1];
				}
			}

			NodeList guaranteeTerms = doc
					.getElementsByTagName("wsag:GuaranteeTerm");
			if (guaranteeTerms != null) {
				result += "\n\n\t\t"
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GUARANTEE_TERMS]);
				for (int i = 0; i < guaranteeTerms.getLength(); i++) {

					Element node = (Element) guaranteeTerms.item(i);

					if (!node.getParentNode().getNodeName().equals("wsag:All")) {

						String gName = node.getAttribute("wsag:Name");
						String name = gName.substring(0, gName.indexOf("."));

						if (!result.contains(name)) {
							result += "\n\t\t\t"
									+ name
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP])
									+ "\t"
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONE_OR_MORE])
									+ " "
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.OF]);
						}

						result += "\n\t\t\t\t"
								+ node.getAttribute("wsag:Name")
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);
					} else {
						result += "\n\t\t\t"
								+ node.getAttribute("wsag:Name")
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);
					}

					String exp = node
							.getElementsByTagName("wsag:CustomServiceLevel")
							.item(0).getTextContent();
					result += "\t"
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.PROVIDER])
							+ " "
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.GUARANTEES])
							+ " " + Util.decodeEntities(exp) + ";";

					Node qualifCond = node.getElementsByTagName(
							"wsag:QualifyingCondition").item(0);

					if (qualifCond != null) {
						exp = qualifCond.getTextContent();
						exp = exp.trim().replace("(", "").replace(")", "");
						result += "\n\t\t\t\t"
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
								+ " (" + exp + ");\n";
					} else {
						result += "\n";
					}
				}

			}
		}

		return result;
	}

	public static String getCreationConstraints(Document doc) {

		String result = "";

		Element cc = (Element) doc.getElementsByTagName(
				"wsag:CreationConstraints").item(0);

		if (cc != null) {
			result += Util
					.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.CREATION_CONSTRAINTS]);

			NodeList nList = cc.getElementsByTagName("wsag:Constraint");

			for (int i = 0; i < nList.getLength(); i++) {
				Element constraint = (Element) nList.item(i);
				result += "\n\t"
						+ constraint.getElementsByTagName("Name").item(0)
								.getTextContent() + ":";

				String content = constraint.getElementsByTagName("Content")
						.item(0).getTextContent();
				if (content.contains("OR")) {
					content = content.replace("(", "").replace(")", "");
					String[] aux = content.split("OR");

					Map<String, List<String>> mapa = new HashMap<String, List<String>>();

					for (int j = 0; j < aux.length; j++) {
						String elem = aux[j];
						String[] aux2 = elem.split("=");

						String key = aux2[0].trim();
						String value = Util.withoutDoubleQuotes(aux2[1].trim());

						if (mapa.containsKey(key)) {
							List<String> l = mapa.get(key);
							l.add(value);
							mapa.put(key, l);
						} else {
							List<String> l = new ArrayList<String>();
							l.add(value);
							mapa.put(key, l);
						}
					}

					for (String k : mapa.keySet()) {

						String values = mapa.get(k).toString();

						result += "\t"
								+ k
								+ " "
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.BELONGS])
								+ " "
								+ values.replace("[", "{").replace("]", "}")
								+ ";\n";
					}
				} else if (content.contains("IMPLIES")) {
					String[] aux = content.split("IMPLIES");
					result += "\t" + Util.decodeEntities(aux[1].trim()) + ";";

					result += "\n\t\t"
							+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.ONLY_IF])
							+ " (" + Util.decodeEntities(aux[0].trim())
							+ ");\n";
				} else {
					result += "\t" + Util.decodeEntities(content.trim())
							+ ";\n";
				}
			}
		}

		return result;
	}
}
