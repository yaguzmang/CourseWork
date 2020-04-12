package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class EndOfString extends Terminal {

    public EndOfString() {
	super(-1,-1);
    }

    public boolean equals(Object obj) {
	boolean ret = false;
	if (obj instanceof EndOfString) {
	    ret = true;
	}
	return ret;
    }

    public String toString() {
	String res = super.toString();

	return new String("End of String " + res);
    }

    public int hashCode() {
	return EnumGrammarSymbol.EndOfString.ordinal();
    }
}
