package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I3 extends PilotState {

    public I3() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I3) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I3";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I3.ordinal();
    }

    
}
