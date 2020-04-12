package co.edu.eafit.dis.st0270.automata;
/*
 * AutoNumPunFlo
 * Una implementación manual de la autómata que reconoce números decimales
 * utilizando como control switch/case
 *
 * Creación: 25/08/2011.
 * Autor:    fcardona
 * email:    fcardona@eafit.edu.co
 *
 * re = (0|[1..9][0..9]*).[0..9]+
 *
 * Registro de modificación:
 *
 * 11/03/2019 - Actualización cosmética
 * 10/03/2016 - Arreglando para que funcionen con Maven.
 * 01/03/2012 - Arreglo de identación para que sea visible desde eclipse
 *              Adición de comentarios. fcardona
 *
 */

/**
 * AutoNumPunFlo Implements an automaton of the regular expression
 * (0|[1..9][0..9]*).[0..9]+ by implements the interface Automata
 * and using switch case constructor.
 *
 * @author Juan Francisco Cardona Mc'Cormick
 * @version 1.0.38
 *
 */
public class AutoNumPunFlo implements Automata {

    // Variable de control que mantiene el estado actual del autómata.
    private AutoState state = AutoState.q0;

    /**
     * La función de transición
     * @param s codigo de estado (un int)
     * @param c carácter para hacer una transición
     * @return el siguiente estado del código
     */
    static private AutoState delta (AutoState s, char c) {
    	AutoState result;

    	switch (s) {
    	case q0:
	    switch (c) {
	    case '0':
		result = AutoState.q2;
		break;
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		result = AutoState.q1;
		break;
	    case '.':
	    default:
	    	result = AutoState.qe;
	    	break;
	    }
	    break; // Fin estado q0

    	case q1:
	    switch (c) {
	    case '0':
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		result = AutoState.q1;
		break;
	    case '.':
		result = AutoState.q3;
		break;
	    default:
		result = AutoState.qe;
		break;
	    }
	    break; // Fin estado q1

    	case q2:
	    switch (c) {
	    case '0':
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		result = AutoState.qe;
		break;
	    case '.':
		result = AutoState.q3;
		break;
	    default:
		result = AutoState.qe;
		break;
	    }
	    break; // Fin estado q2

    	case q3:
	    switch(c) {
	    case '0':
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		result = AutoState.q4;
		break;
	    case '.':
	    default:
		result = AutoState.qe;
		break;
	    }
	    break; // Fin estado q3

    	case q4:
	    switch(c) {
	    case '0':
	    case '1':
	    case '2':
	    case '3':
	    case '4':
	    case '5':
	    case '6':
	    case '7':
	    case '8':
	    case '9':
		result = AutoState.q4;
		break;
	    case '.':
	    default:
		result = AutoState.qe;
    		break;
	    }
	    break; // Fin estado q3

    	default: // Estado de error.
	    result = AutoState.qe;
	    break;
        }

	return result;
    }

    /**
     * reset implements the corresponding method
     * @see co.edu.eafit.dis.st0270.automatas.Automata#reset()
     */
    @Override
    public void reset() {
	state = AutoState.q0;
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
       for (char c : in.toCharArray()) {

          state = AutoNumPunFlo.delta(state, c);
       }
    }

    /* (non-Javadoc)
     * @see co.edu.eafit.dis.st0270.automatas.Automata#accepted()
     */
    @Override
    public boolean accepted() {

    	return state == AutoState.q4;
    }

}
