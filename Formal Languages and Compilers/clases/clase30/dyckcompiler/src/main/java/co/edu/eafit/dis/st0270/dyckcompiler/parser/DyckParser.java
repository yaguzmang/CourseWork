package co.edu.eafit.dis.st0270.dyckcompiler.parser;

import co.edu.eafit.dis.st0270.dyckcompiler.grammar.NonTerminal;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.Terminal;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.Production;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.GrammarSymbol;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.PilotState;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I0;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I1;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I2;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I3;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I4;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I5;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I6;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I7;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I8;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I9;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.I10;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.S0;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.S;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.OPar;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.CPar;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.EndOfString;
import co.edu.eafit.dis.st0270.dyckcompiler.lexer.DyckLexer;
import co.edu.eafit.dis.st0270.dyckcompiler.parser.DyckParserException;
import co.edu.eafit.dis.st0270.dyckcompiler.abs.DyckAbs;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;


public class DyckParser {

    private DyckLexer  dl = null;
    private Terminal   cc  = null;
    private static Map<PilotState,Map<GrammarSymbol,PilotState>> pilotMap;
    private static Map<PilotState,Map<Terminal,Production>> reductionMap;

    static {
	// I0
	pilotMap     = new HashMap<PilotState, Map<GrammarSymbol,PilotState>>();
	Map<GrammarSymbol,PilotState> nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new S(), new I1());
	nextStateMap.put(new OPar(), new I3());
	pilotMap.put(new I0(), nextStateMap);
	// I1
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new EndOfString(), new I2());
	pilotMap.put(new I1(), nextStateMap);
	// I2
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new I2(), nextStateMap);
	// I3
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new S(), new I4());
	nextStateMap.put(new OPar(), new I7());
	pilotMap.put(new I3(), nextStateMap);
	// I4
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new CPar(), new I5());
	pilotMap.put(new I4(), nextStateMap);
	// I5
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new S(), new I6());
	nextStateMap.put(new OPar(), new I3());
	pilotMap.put(new I5(), nextStateMap);
	// I6
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new I6(), nextStateMap);
	// I7
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new S(), new I8());
	nextStateMap.put(new OPar(), new I7());
	pilotMap.put(new I7(), nextStateMap);
	// I8
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new CPar(), new I9());
	pilotMap.put(new I8(), nextStateMap);
	// I9
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	nextStateMap.put(new S(), new I10());
	nextStateMap.put(new OPar(), new I7());
	pilotMap.put(new I9(), nextStateMap);
	// I10
	nextStateMap = new HashMap<GrammarSymbol, PilotState>();
	pilotMap.put(new I10(), nextStateMap);
	// Implementing the reduction map
	reductionMap = new HashMap<PilotState, Map<Terminal,Production>>();
	// I0
	Map<Terminal,Production> nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new EndOfString(), Production.P3);
	reductionMap.put(new I0(), nextProductionMap);
	// I2
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new EndOfString(), Production.P1);
	reductionMap.put(new I2(), nextProductionMap);
	// I3
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new CPar(), Production.P3);
	reductionMap.put(new I3(), nextProductionMap);
	// I5
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new EndOfString(), Production.P3);
	reductionMap.put(new I5(), nextProductionMap);
	// I6
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new EndOfString(), Production.P2);
	reductionMap.put(new I6(), nextProductionMap);
	// I7
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new CPar(), Production.P3);
	reductionMap.put(new I7(), nextProductionMap);
	// I9
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new CPar(), Production.P3);
	reductionMap.put(new I9(), nextProductionMap);
	// I10
	nextProductionMap = new HashMap<Terminal,Production>();
	nextProductionMap.put(new CPar(), Production.P2);
	reductionMap.put(new I10(), nextProductionMap);
    }

    public DyckParser(DyckLexer dl) {
	this.dl = dl;
    }

    public DyckAbs parser()
	throws DyckParserException, IOException {

	Stack<GrammarSymbol> stack = new Stack<GrammarSymbol>();
	stack.push(new I0());

	cc = dl.getNextToken();

	GrammarSymbol gs = null;

	do {

	    gs = stack.peek();

	    if (gs instanceof PilotState) {
		// Busca primero si existe un movimiento de desplazamiento
		PilotState nps = null;
		try {

		    nps =  pilotMap.get(gs).get(cc);
		    if (nps != null) {
			stack.push(cc);
			stack.push(nps);
		    }
		    else {
			throw new NullPointerException();
		    }

		    cc = dl.getNextToken();

		} catch (NullPointerException npe) {

		    // Busca un movimiento de reducción
		    Production p = reductionMap.get(gs).get(cc);

		    if (p == null) {
			throw new DyckParserException("No reduce option, no shift option");
		    }

		    NonTerminal nt = p.getLHS();
		    GrammarSymbol[] gss = p.getRHS();

		    // Analiza si los elementos esperados en la pila coinciden
		    for (int i = 0; i < gss.length; i++) {

			GrammarSymbol top = stack.pop();
			if (!(top instanceof PilotState)) {
			    throw new DyckParserException("No reduce state " + top + "stack: " + stack);
			}
			else {
			    top = stack.pop();
			    if (!top.equals(gss[i])) {
				throw new DyckParserException("Stack symbol " + top + " different from " + gss[i]);
			    }
			}
		    }

		    gs = stack.peek();
		    if (gs instanceof PilotState) {

			nps =  pilotMap.get(gs).get(nt);
			if (nps != null) {
			    stack.push(nt);
			    stack.push(nps);
			}
		    }
		}
	    }
	    else {

		throw new DyckParserException("Internal Exception");
	    }
	    gs = stack.peek();
	} while (!((gs instanceof PilotState) && gs.equals(new I0()) && cc.equals(new EndOfString())));

	return null;
    }
}
