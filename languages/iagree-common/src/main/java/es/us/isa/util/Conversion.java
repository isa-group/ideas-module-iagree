package es.us.isa.util;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import es.us.isa.parser.MiAgreeListener;
import es.us.isa.parser.iAgreeLexer;
import es.us.isa.parser.iAgreeParser;
import es.us.isa.parser.iAgreeParser.EntryContext;

public class Conversion {

	public static String getWSAG(String code) {

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

		return listener.wsag.getResult();
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
