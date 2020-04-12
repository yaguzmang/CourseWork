package co.edu.eafit.dis.st0270.automata;
/*
 * Automata
 *
 * Interfaz del automáta de estado finito.
 *
 * Creación: 25/08/2011.
 * Autor:    fcardona
 * email:    fcardona@eafit.edu.co
 *
 * re = (0|[1..9][0..9]*).[0..9]+
 *
 * Registro de modificación:
 *
 * 11/03/2018 - Actualización cosmética
 * 10/03/2016 - Arreglando para que funcionen con Maven.
 * 01/03/2012 - Arreglo de identación para que sea visible desde eclipse
 *              Adición de comentarios. fcardona
 *
 */

/**
 * Automata represent the service given by an automaton implementation
 *
 * @author Juan Francisco Cardona Mc'Cormick
 */
public interface Automata {

	/**
	 * reset the automaton to initial state
	 */
	public abstract void reset();

	/**
	 * Process a string
	 * @param in
	 */
	public abstract void process(String in);

	/**
	 * accepted after the processing, the automaton is checked whether is valid or not.
	 * @return true si el estado final fue de aceptación
	 */
	public abstract boolean accepted();

}
