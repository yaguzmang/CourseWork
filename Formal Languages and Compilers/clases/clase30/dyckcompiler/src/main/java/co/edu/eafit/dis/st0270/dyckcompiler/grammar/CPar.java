package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class CPar extends Terminal {

    public CPar(int col, int lin) {
	super(col, lin);
    }

    public CPar() {
	super(-1,-1);
    }
    
    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof CPar) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	String res = super.toString();
	return new String(") "+ res);
    }


    public int hashCode() {
	return EnumGrammarSymbol.CPar.ordinal();
    }
}
