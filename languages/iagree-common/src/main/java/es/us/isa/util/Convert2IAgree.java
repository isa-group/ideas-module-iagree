package es.us.isa.util;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.error.IAgreeError;
import es.us.isa.parser.iAgreeParser;

public class Convert2IAgree {

	private static List<IAgreeError> errors = new LinkedList<IAgreeError>();

	public static String getIAgreeFromWSAG(String code) {

		try {
			File fXmlFile = new File("samples/example.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();

			if (root.getNodeName().equals("wsag:Template")) {
				String name = doc.getElementsByTagName("wsag:Name").item(0)
						.getTextContent();
				String version = root.getAttribute("wsag:TemplateId");

				String result = Util
						.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.TEMPLATE])
						+ " "
						+ name
						+ " "
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.VERSION])
						+ " " + version;
				result += "\n" + getContext(doc);
				result += "\n\t" + getMetrics(doc);
				result += "\n" + getAgreementTerms(doc);

				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	public static String getContext(Document doc) {
		String result = "";
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
		// TODO obtener metricas de archivo metrics.xml
		String result = Util
				.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.METRICS])
				+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP])
				+ "\n";
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

					if (node.getParentNode().getNodeName()
							.equals("wsag:OneOrMore")) {

						String gName = node.getAttribute("wsag:Name");
						String name = gName.substring(0, gName.indexOf("."));

						if (!result.contains(name)) {
							result += "\n\t\t\t"
									+ name
									+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);
						}

						result += "\n\t\t\t\t"
								+ node.getAttribute("wsag:Name")
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);
					} else {
						result += "\n\t\t\t"
								+ node.getAttribute("wsag:Name")
								+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.DP]);
					}
				}

			}
		}

		return result;
	}
}
