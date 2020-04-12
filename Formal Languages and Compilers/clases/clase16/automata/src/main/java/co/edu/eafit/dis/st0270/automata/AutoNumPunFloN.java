package co.edu.eafit.dis.st0270.automata;

/*
 * AutoNumPunFloN
 * Una implementación manual de la autómata que reconoce números decimales
 * utilizando un autómata no determinista
 *
 * Creación: 19/03/2019
 * Autor:    Juan Francisco Cardona Mc'Cormick
 * email:    jfcmacro@gmail.com (fcardona@eafit.edu.co)
 *
 * re = [0|(1..9)].(0..9)+
 */
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
/**
 * AutoNumPunFloN Implements an automaton of the regular expression
 * with an implements a non-deterministic automaton
 *
 * @author Juan Francisco Cardona Mc'Cormick
 * @version 1.0.38
 *
 */
public class AutoNumPunFloN implements Automata {

    // Variable de control que mantiene el estado actual del autómata.
    private Set<AutoState> states;
    static private Set<AutoState> accepting;
    static private Map<Key,Set<AutoState>> delta;

    static Set<AutoState> newSet(AutoState ...states) {
	HashSet<AutoState> ss = new HashSet();
	for (AutoState q : states)
	    ss.add(q);
	return ss;
    }

    static {
	delta = new HashMap();
	accepting = new HashSet();

	delta.put(new Key(AutoState.q0,'0'), newSet(AutoState.q2));
	delta.put(new Key(AutoState.q0,'\0'), newSet(AutoState.q2));
	delta.put(new Key(AutoState.q0,'1'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'2'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'3'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'4'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'5'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'6'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'7'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'8'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'9'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q0,'.'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'0'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'1'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'2'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'3'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'4'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'5'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'6'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'7'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'8'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'9'), newSet(AutoState.q1));
	delta.put(new Key(AutoState.q1,'.'), newSet(AutoState.qe));
	delta.put(new Key(AutoState.q1,'\0'), newSet(AutoState.q2));
	delta.put(new Key(AutoState.q2,'.'), newSet(AutoState.q3));
	delta.put(new Key(AutoState.q3,'0'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'1'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'2'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'3'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'4'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'5'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'6'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'7'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'8'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'9'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q3,'.'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'0'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'1'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'2'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'3'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'4'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'5'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'6'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'7'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'8'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'9'), newSet(AutoState.q4));
	delta.put(new Key(AutoState.q4,'.'), newSet(AutoState.qe));
    }

    /**
     *
     */
    public AutoNumPunFloN() {
	states = new HashSet<>();
	states.add(AutoState.q0);
	accepting.add(AutoState.q4);
    }

    /**
     * La función de transición
     * @param s current sets
     * @param c carácter para hacer una transición
     * @return el siguiente estado del código
     */
    static private Set<AutoState> delta (Set<AutoState> s, char c) {
	Set<AutoState> nextStates = new HashSet<>();
	for (AutoState cs : s) {
	    try {
		Set<AutoState> tmp = delta.get(new Key(cs,c));
		if (tmp == null)
		    nextStates.add(AutoState.qe);
		else
		    for (AutoState ns : tmp)
			nextStates.add(ns);

	    } catch (NumberFormatException nfe) {
		nextStates.add(AutoState.qe);
	    }
	}

	return nextStates;
    }

    /**
     * reset implements the corresponding method
     * @see co.edu.eafit.dis.st0270.automatas.Automata#reset()
     */
    @Override
    public void reset() {
	states = new HashSet<>();
	states.add(AutoState.q0);
    }

    /* (non-Javadoc)
     * @see co.edu.eafit.dis.st0270.automatas.Automata#process(java.lang.String)
     */
    @Override
    public void process(String in) {

    	// for (int i = 0; i < in.length(); i++) {
	//     char c = in.charAt(i);
	//     state = AutoNumPunFlo.delta(state, c);
    	// }
	for (char c : in.toCharArray())
	    states = AutoNumPunFloN.delta(states, c);
    }

    /* (non-Javadoc)
     * @see co.edu.eafit.dis.st0270.automatas.Automata#accepted()
     */
    @Override
    public boolean accepted() {
	boolean result = false;
    	for (AutoState q : states) {
	    if (accepting.contains(q)) {
		result = true;
		break;
	    }
	}
	return result;
    }

}
