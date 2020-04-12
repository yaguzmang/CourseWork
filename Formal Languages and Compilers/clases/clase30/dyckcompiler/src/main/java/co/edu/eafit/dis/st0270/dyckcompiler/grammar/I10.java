package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I10 extends PilotState {

    public I10() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I10) {
    	    ret = true;
    	}
    	return ret;
    }


    public String toString() {
	return "I10";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I10.ordinal();
    }
}
