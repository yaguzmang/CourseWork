package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I7 extends PilotState {

    public I7() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I7) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I7";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I7.ordinal();
    }

}
