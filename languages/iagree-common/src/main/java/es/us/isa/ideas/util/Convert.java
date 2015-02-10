package es.us.isa.ideas.util;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
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

import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.error.IAgreeError;
import es.us.isa.ideas.error.IAgreeErrorListener;
import es.us.isa.ideas.parser.MiAgreeListener;
import es.us.isa.ideas.parser.iAgreeLexer;
import es.us.isa.ideas.parser.iAgreeParser;
import es.us.isa.ideas.parser.iAgreeParser.EntryContext;

public class Convert {

	public static Map<String, String> metricsMap = new ConcurrentHashMap<String, String>();
	public static Stack<String> metricsStack = new SizedStack<String>(4);

	private static List<AppAnnotations> annotations = new LinkedList<AppAnnotations>();

	public static Map<String, Object> getWsagFromIAgree(String content, Boolean simplified) {

		System.out.println("MetricsMap Size: " + metricsMap.size());

		// Get our lexer
		System.out.println("conversion start");

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
		listener.setSimplified(simplified);
		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(listener, context);

		Map<String, Object> res = new HashMap<String, Object>();
		String metricUri = listener.getMetricUri();
		String metrics = listener.getMetrics();

		annotations.clear();

		res.put("data", listener.wsag.getResult());
		res.put("metricUri", metricUri + ".xml");
		res.put("metrics", metrics);
		
		if (errorListener.hasErrors()) {
			// Construct error structures
			for (IAgreeError error : errorListener.getErrors()) {

				Integer lineNo = error.getLineNo() - 1;
				Integer columnNo = error.getCharStart();

				AppAnnotations appAnnot = new AppAnnotations();
				appAnnot.setRow(lineNo.toString());
				appAnnot.setColumn(columnNo.toString());
				appAnnot.setText(error.getMessage().replace("\"", "'"));
				appAnnot.setType("error");
				annotations.add(appAnnot);
			}
		}

		res.put("annotations", annotations);

		// Cuando se inicia la app con un template erroneo intenta insertar en
		// el mapa un Null y
		// causa NullPointerException

		if (metricsMap.size() >= 7) {

			Iterator<String> it = metricsMap.keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();

				if (!metricsStack.contains(key)) {
					metricsMap.remove(key);
				}
			}
		}

		if (metricUri != null && metrics != null) {
			metricsStack.push(metricUri);
			metricsMap.put(metricUri, metrics);
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

			Pattern pattern = Pattern.compile("(\"metrics/)(\\w+(-\\w+)*)");
			Matcher matcher = pattern.matcher(content);
			matcher.find();
			
			String metrics = metricsMap.get(matcher.group(2));

			if (metrics != null) {
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
			} else {
				System.err.println("Error al obtener el fichero de metricas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
}
