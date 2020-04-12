package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I1 extends PilotState {

    public I1() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I1) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I1";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I1.ordinal();
    }
}
