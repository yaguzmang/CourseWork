package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class OPar extends Terminal {

    public OPar(int col, int lin) {
	super(col, lin);
    }

    public OPar() {
	super(-1,-1);
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof OPar) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String("( "+ res);
    }

    public int hashCode() {
	return EnumGrammarSymbol.OPar.ordinal();
    }
}
