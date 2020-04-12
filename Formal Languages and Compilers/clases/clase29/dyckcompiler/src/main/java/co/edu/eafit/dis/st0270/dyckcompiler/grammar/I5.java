package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I5 extends PilotState {

    public I5() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I5) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I5";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I5.ordinal();
    }
}
