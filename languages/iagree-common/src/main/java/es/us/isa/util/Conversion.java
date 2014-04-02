package es.us.isa.util;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import es.us.isa.error.IAgreeError;
import es.us.isa.error.IAgreeErrorListener;
import es.us.isa.parser.MiAgreeListener;
import es.us.isa.parser.iAgreeLexer;
import es.us.isa.parser.iAgreeParser;
import es.us.isa.parser.iAgreeParser.EntryContext;

public class Conversion {

	private static List<IAgreeError> errors = new LinkedList<IAgreeError>();

	public static String getWSAG(String code) {
		// Get our lexer
		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(code));

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
		return res;
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

	public static String getMetrics(String code) {

		// Get our lexer
		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(code));

		// Get a list of matched tokens
		CommonTokenStream tokens = new CommonTokenStream(lexer);

		// Pass the tokens to the parser
		iAgreeParser parser = new iAgreeParser(tokens);

		// Specify our entry point
		EntryContext context = parser.entry();

		// Walk it and attach our listener
		ParseTreeWalker walker = new ParseTreeWalker();
		MiAgreeListener listener = new MiAgreeListener();
		walker.walk(listener, context);

		return listener.metricsTemplate;
	}

}
