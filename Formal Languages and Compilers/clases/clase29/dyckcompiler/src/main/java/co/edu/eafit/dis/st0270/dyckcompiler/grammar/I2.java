package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public class I2 extends PilotState {

    public I2() {
    }

    public boolean equals(Object obj) {
    	boolean ret = false;
    	if (obj instanceof I2) {
    	    ret = true;
    	}
    	return ret;
    }

    public String toString() {
	return "I2";
    }

    public int hashCode() {
	return EnumGrammarSymbol.I2.ordinal();
    }
}
