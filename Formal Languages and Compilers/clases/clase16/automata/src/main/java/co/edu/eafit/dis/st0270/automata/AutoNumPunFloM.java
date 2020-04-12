package co.edu.eafit.dis.st0270.automata;
/**
 * AutoNumPunFloM
 * Una implementación manual de la autómata que reconoce números decimales
 * utilizando un mapa(M).
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
 * 22/09/2017 - Utilizando iteradores en vez de un for sobre la longitud
 *              del arreglo de entrada.
 * 06/09/2016 - Modificando los estados para trabajen con Enum AutoState.
 * 10/03/2016 - Arreglando para que funcionen con Maven.
 * 01/03/2012 - Arreglando la identación y algunos cambios menores.
 *
 */
import java.util.Map;
import java.util.HashMap;

/**
 * AutoNumPunFloM
 *
 *  @author Juan Francisco Cardona McCormick
 */
public class AutoNumPunFloM implements Automata {

   private AutoState state;

   static private Map<Key,AutoState> delta;

   static {
      delta = new HashMap<Key,AutoState>();

      delta.put(new Key(AutoState.q0,'0'), AutoState.q2);
      delta.put(new Key(AutoState.q0,'1'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'2'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'3'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'4'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'5'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'6'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'7'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'8'), AutoState.q1);
      delta.put(new Key(AutoState.q0,'9'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'0'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'1'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'2'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'3'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'4'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'5'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'6'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'7'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'8'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'9'), AutoState.q1);
      delta.put(new Key(AutoState.q1,'.'), AutoState.q3);
      delta.put(new Key(AutoState.q2,'.'), AutoState.q3);
      delta.put(new Key(AutoState.q3,'0'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'1'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'2'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'3'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'4'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'5'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'6'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'7'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'8'), AutoState.q4);
      delta.put(new Key(AutoState.q3,'9'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'0'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'1'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'2'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'3'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'4'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'5'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'6'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'7'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'8'), AutoState.q4);
      delta.put(new Key(AutoState.q4,'9'), AutoState.q4);
   }

   /**
    * Re-establece el actual estado al estado de inicio
    */
   public void reset() {

      state = AutoState.q0;
   }

   /**
    * Realiza una transición en cada carácter en la cadena
    * dada.
    * @param in  cadena a procesar.
    */
   public void process(String in) {

      for (char c : in.toCharArray()) {
         try {
            AutoState tmp = delta.get(new Key(state,c));
            state = tmp == null ? AutoState.qe : tmp;
         } catch (NumberFormatException nfe) {
            state = AutoState.qe;
         }
      }
   }
   /**
    * Examina si el DFA aceptó la cadena.
    * @return true si el estado final fue de aceptación false en otro caso
    */
   public boolean accepted() {

      return state == AutoState.q4;
   }
}
