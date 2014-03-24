package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import es.us.isa.parser.MiAgreeListener;
import es.us.isa.parser.iAgreeLexer;
import es.us.isa.parser.iAgreeParser;
import es.us.isa.parser.iAgreeParser.EntryContext;

public class Test {

	public static void main(String[] args) {

		String sample = loadSample("samples/example.txt");
		// System.out.println(sample);

		// Get our lexer
		iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(sample));

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

		System.out.println(listener.getWSAG());		
	}

	private static String loadSample(String filePath) {
		// Location of file to read
		File f = new File(filePath);
		FileInputStream is;
		String res = "";
		try {
			is = new FileInputStream(f);
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(is));
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
			res = sb.toString();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
