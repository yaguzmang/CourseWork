package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I6 extends PilotState {

    public I6() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I6) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I6";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I6.ordinal();
    }
}
