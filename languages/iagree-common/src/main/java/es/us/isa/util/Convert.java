package es.us.isa.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import es.us.isa.error.IAgreeError;
import es.us.isa.error.IAgreeErrorListener;
import es.us.isa.parser.MiAgreeListener;
import es.us.isa.parser.iAgreeLexer;
import es.us.isa.parser.iAgreeParser;
import es.us.isa.parser.iAgreeParser.EntryContext;

public class Convert {

	private static List<IAgreeError> errors = new LinkedList<IAgreeError>();

	public static String getWsagFromIAgree(String content) {
		// Get our lexer
		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(content));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		iAgreeParser parser = new iAgreeParser(tokens);

		IAgreeErrorListener errorListener = new IAgreeErrorListener();
		parser.addErrorListener(errorListener);

		// Specify our entry point
		EntryContext context = parser.entry();

		// Walk it and attach our listener
		MiAgreeListener listener = new MiAgreeListener();
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, context);

		String res = "";
		if (!errorListener.hasErrors()) {
			res = listener.wsag.getResult();
		} else {
			errors = errorListener.getErrors();
		}

		String title = listener.getTemplateName();
		String metrics = listener.getMetrics();

		PrintWriter writer, writerMetrics;
		try {
			writer = new PrintWriter("./samples/" + title + ".xml");
			writer.println(res);
			writer.close();

			writerMetrics = new PrintWriter("./metrics/" + title + "_"
					+ listener.getTimeStamp() + ".xml");
			writerMetrics.println(metrics);
			writerMetrics.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return res;
	}

	public static String getIAgreeFromWsag(String content) {
		String result = "";
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(new InputSource(new StringReader(
					content)));
			doc.getDocumentElement().normalize();
			Element root = doc.getDocumentElement();

			if (root.getNodeName().equals("wsag:Template")) {

				String name = doc.getElementsByTagName("wsag:Name").item(0)
						.getTextContent();

				String metrics = "";
				Element offerItem = (Element) doc.getElementsByTagName(
						"OfferItem").item(0);
				if (offerItem != null) {
					String aux = offerItem.getAttribute("wsag:Metric");
					String title = aux.substring(0, aux.indexOf(':'));

					metrics = Util.loadSample(title + ".xml");
				} else {
					Element variable = (Element) doc.getElementsByTagName(
							"wsag:Variable").item(0);
					if (variable != null) {
						String aux = variable.getAttribute("wsag:Metric");
						String title = aux.substring(0, aux.indexOf(':'));

						metrics = Util.loadSample(title + ".xml");
					}
				}
				Document doc_metrics = dBuilder.parse(new InputSource(
						new StringReader(metrics)));
				doc_metrics.getDocumentElement().normalize();

				String version = root.getAttribute("wsag:TemplateId");

				result = Util
						.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.TEMPLATE])
						+ " "
						+ name
						+ " "
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.VERSION])
						+ " " + version;

				result += "\n"
						+ Convert2IAgree.getContext(doc)
						+ "\n\t"
						+ Convert2IAgree.getMetrics(doc_metrics)
						+ "\n"
						+ Convert2IAgree.getAgreementTerms(doc)
						+ "\n"
						+ Convert2IAgree.getCreationConstraints(doc)
						+ "\n"
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.END_TEMPLATE]);
			} else if (root.getNodeName().equals("wsag:AgreementOffer")) {
				String name = doc.getElementsByTagName("wsag:Name").item(0)
						.getTextContent();
				String templateName = doc
						.getElementsByTagName("wsag:TemplateName").item(0)
						.getTextContent();

				String metrics = Util.loadSample("./metrics/" + templateName
						+ "Metrics.xml");
				Document doc_metrics = dBuilder.parse(new InputSource(
						new StringReader(metrics)));
				doc_metrics.getDocumentElement().normalize();

				String version = root.getAttribute("wsag:AgreementId");

				result = Util
						.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.AG_OFFER])
						+ " "
						+ name
						+ " "
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.VERSION])
						+ " " + version;

				result += Convert2IAgree.getContext(doc)
						+ "\n\t"
						+ Convert2IAgree.getMetrics(doc_metrics)
						+ "\n"
						+ Convert2IAgree.getAgreementTerms(doc)
						+ "\n"
						+ Util.withoutQuotes(iAgreeParser.tokenNames[iAgreeParser.END_AG_OFFER]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<IAgreeError> getErrors() {
		return errors;
	}

	public static boolean hasErrors() {
		return !errors.isEmpty();
	}

	public static void clearErrors() {
		errors.clear();
	}
}
