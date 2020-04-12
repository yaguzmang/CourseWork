package co.edu.eafit.dis.st0270.automata;
/**
 * AutoNumPunFloT
 * Una implementación manual de la autómata que reconoce números decimales
 * utilizando una tabla.
 *
 * Creación: 25/08/2011.
 * Autor:    fcardona
 * email:    fcardona@eafit.edu.co
 *
 * re = (0|[1..9][0..9]*).[0..9]+
 *
 * Registro de modificación:
 *
 * 11/03/2019 - Actualización cosméticax
 * 22/09/2017 - Utilizando iteradores en vez de un for sobre la longitud
 *              del arreglo de entrada.
 * 10/03/2016 - Arreglando para que funcionen con Maven.
 * 01/03/2012 - Arreglando la identación y algunos cambios menores.
 * 26/08/2011 - Valor del estado de error en la excepción incorrecto.
 *              El número de elementos del arreglo de accepting estaba incorrecto
 *              se añadio para el estado de error.
 *              Adición de comentarios. fcardona
 *
 */
public class AutoNumPunFloT implements Automata {

   /*
    * Constantes estáticas q0, q1, q2, q3, q4 y qe
    * representan los estados,
    * la variable privada state contiene el estado actual
    * de la máquina
    */
   // private static final int q0 = 0;
   // private static final int q1 = 1;
   // private static final int q2 = 2;
   // private static final int q3 = 3;
   // private static final int q4 = 4;
   // private static final int qe = 5;

   private AutoState state;

   /**
    * El control se maneja a través de una tabla
    * que contiene la descripción completa del autómata de estado
    * finito.
    */
   static private AutoState[][] delta = {
      // 0   1   2   3   4   5   6   7   8   9   .
      {  AutoState.q2, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1,
	 AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.qe}, // Estado 0 (q0)
      {  AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1,
	 AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q1, AutoState.q3}, // Estado 1 (q1)
      {  AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe,
	 AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.q3}, // Estado 2 (q2)
      {  AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4,
	 AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.qe}, // Estado 3 (q3)
      {  AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4,
	 AutoState.q4, AutoState.q4, AutoState.q4, AutoState.q4, AutoState.qe}, // Estado 4 (q4)
      {  AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe,
	 AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe, AutoState.qe}  // Estado Error (qe)
   };

   /**
    * Tabla que indica los estados de aceptación.
    */
   static private boolean[] accepting = { false, false, false, false, true, false };

   /**
    * Restablece el estado inicial del autómata.
    */
   public void reset() {

      state = AutoState.q0;
   }

   static private int obtPos(char c) {

      if (c == '.') return '9' - '0' + 1;
      return c - '0';
   }

   /**
    * Realiza una transición en cada carácter en la cadena
    * dada.
    * @param in cadena a procesar
    */
   public void process(String in) {

      // for (int i = 0; i < in.length(); i++) {
       for (char c : in.toCharArray()) {
	   // char c = in.charAt(i);

	 try {

	    state = delta[state.ordinal()][obtPos(c)];
	 } catch (ArrayIndexOutOfBoundsException ex) {

	    state = AutoState.qe;
	 }
       }
   }

   /**
    * Examina si el DFA aceptó la cadena.
    * @return true si el estado final fue de aceptación
    */
   public boolean accepted() {

      return accepting[state.ordinal()];
   }
}
