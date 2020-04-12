package co.edu.eafit.dis.st0270.dyckcompiler.parser;

import co.edu.eafit.dis.st0270.dyckcompiler.grammar.GrammarSymbol;

public class DyckParserException extends Exception {

    public static final long serialVersionUID = 4487924422002636L;

    public DyckParserException(String cause, GrammarSymbol gs) {
	super(cause + " at " + gs);
    }

    public DyckParserException(String cause) {
	super(cause);
    }

}
