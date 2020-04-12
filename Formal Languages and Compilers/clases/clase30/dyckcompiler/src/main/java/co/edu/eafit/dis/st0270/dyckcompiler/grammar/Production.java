package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class Production {

    public static Production P1;
    public static Production P2;
    public static Production P3;

    static {
	GrammarSymbol[] rhsP1 = { new S(), new EndOfString() };
	P1 = new Production(new S0(), rhsP1);
	GrammarSymbol[] rhsP2 = { new OPar(), new S(), new CPar(), new S() };
	P2 = new Production(new S(), rhsP2);
	GrammarSymbol[] rhsP3 = { };
	P3 = new Production(new S(), rhsP3);
    }

    private NonTerminal nt = null;
    private GrammarSymbol[] gss = null;

    public Production(NonTerminal nt, GrammarSymbol[] gss) {
	this.nt = nt;
	this.gss = gss;
    }

    public NonTerminal getLHS() {
	return nt;
    }

    public GrammarSymbol[] getRHS() {
	GrammarSymbol[] ret = new GrammarSymbol[gss.length];

	for (int i = gss.length - 1, j = 0; i >= 0; i--, j++) {
	    ret[j] = gss[i];
	}

	return ret;
    }
}
