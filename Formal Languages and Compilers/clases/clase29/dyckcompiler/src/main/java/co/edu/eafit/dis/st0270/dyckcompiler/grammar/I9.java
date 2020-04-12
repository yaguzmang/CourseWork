package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I9 extends PilotState {

    public I9() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I9) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I9";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I9.ordinal();
    }
}
