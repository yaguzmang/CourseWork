package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I8 extends PilotState {

    public I8() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I8) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I8";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I9.ordinal();
    }
    
}
