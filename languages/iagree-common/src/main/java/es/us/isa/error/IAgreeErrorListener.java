package es.us.isa.error;

import java.util.LinkedList;
import java.util.List;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

import es.us.isa.util.Error.ERROR_SEVERITY;

public class IAgreeErrorListener extends BaseErrorListener {

	public static IAgreeErrorListener INSTANCE = new IAgreeErrorListener();
	private List<IAgreeError> errors = new LinkedList<IAgreeError>();

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		int charEndOffset = charPositionInLine;
		if (offendingSymbol != null && offendingSymbol instanceof Token) {
			charEndOffset = ((Token) offendingSymbol).getStopIndex()
					- ((Token) offendingSymbol).getStartIndex();
		}

		// System.out.println("IAgreeErrorListener ERROR:\n" + "line " +
		// line + ":" + charPositionInLine+1 + ":" + charEndOffset+1 + " " +
		// msg);

		errors.add(new IAgreeError(Integer.valueOf(line).intValue() - 1,
				charPositionInLine + 1, charEndOffset + 1,
				ERROR_SEVERITY.ERROR, "line " + line + ":" + charPositionInLine
						+ " " + msg));

	}

	public List<IAgreeError> getErrors() {
		return errors;
	}

	public boolean hasErrors() {
		return !errors.isEmpty();
	}

	public void clearErrors() {
		errors.clear();
	}

	@Override
	public String toString() {
		return "IAgreeErrorListener [errors=" + errors + "]";
	}

}
