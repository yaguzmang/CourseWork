package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I4 extends PilotState {

    public I4() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I4) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I4";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I4.ordinal();
    }
}
