package co.edu.eafit.dis.st0270.dyckcompiler.grammar;

public abstract class Terminal extends GrammarSymbol {

    private int col;
    private int lin;

    public Terminal(int col, int lin) {
	this.col = col;
	this.lin = lin;
    }

    public int getCol() {
	return col;
    }

    public int getLin() {
	return lin;
    }

    public String toString() {
	return new String ("column: " + col + " line: " + lin);
    }
}