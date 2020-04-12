package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I0 extends PilotState {

    public I0() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I0) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I0";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I0.ordinal();
    }
}
