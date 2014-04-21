package es.us.isa.ideas.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import es.us.isa.ideas.error.IAgreeError;
import es.us.isa.ideas.error.IAgreeErrorListener;
import es.us.isa.ideas.parser.MiAgreeListener;
import es.us.isa.ideas.parser.iAgreeLexer;
import es.us.isa.ideas.parser.iAgreeParser;
import es.us.isa.ideas.parser.iAgreeParser.EntryContext;

public class Convert {

	public static Map<String, String> metricsMap = new HashMap<String, String>();
	public static Stack<String> metricsStack = new SizedStack<String>(3);
	
	private static List<IAgreeError> errors = new LinkedList<IAgreeError>();

	public static String[] getWsagFromIAgree(String content) {
		// Get our lexer
		System.out.println("conversion start");
		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(content));
		System.out.println(lexer);

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

		String[] res = new String[3];
		String metricUri = listener.getMetricUri();
		String metrics = listener.getMetrics();
		
		if (!errorListener.hasErrors()) {
			res[0] = listener.wsag.getResult();
			System.out.println(res[0]);
			res[1] = metricUri + ".xml";
			res[2] = metrics;
		} else {
			errors = errorListener.getErrors();
		}


		String metricTitle = metricUri + "_" + listener.getTimeStamp();
		
		if(metricsMap.size() < 100){
			metricsStack.push(metricTitle);
			metricsMap.put(metricTitle, metrics);
		} else {
			for(String key:metricsMap.keySet()){
				if(!metricsStack.contains(key)){
					metricsMap.remove(key);
				}
			}
		}
		
		System.out.println("Stack : " + metricsStack.toString());
		System.out.println("Map : " + metricsMap.toString());
		
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

			Pattern pattern = Pattern.compile("(\"metrics/)(\\w*)");
			Matcher matcher = pattern.matcher(content);
			matcher.find();

			String metrics = metricsMap.get(matcher.group(2));

			Document doc_metrics = dBuilder.parse(new InputSource(
					new StringReader(metrics)));
			doc_metrics.getDocumentElement().normalize();

			Element root = doc.getDocumentElement();

			if (root.getNodeName().equals("wsag:Template")) {

				String name = doc.getElementsByTagName("wsag:Name").item(0)
						.getTextContent();

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
