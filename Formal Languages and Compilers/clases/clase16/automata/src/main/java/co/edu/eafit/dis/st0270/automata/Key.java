package co.edu.eafit.dis.st0270.automata;

/**
 * Key - Esta es una clase privada para manejar las claves del Map.
 *
 * @author Juan Francisco Cardona McCormick
 */
class Key {

   // Valores de la clave de la clase.
   private AutoState state;
   private char     cChar;

   public Key(AutoState s, char c) {

      this.state = s;
      this.cChar = c;
   }

   public int hashCode() {

      if (this.cChar == '.')
         return this.state.ordinal() * 100;
      else
         return this.state.ordinal() * 2 +
            Integer.valueOf(""+this.cChar);
   }

   public boolean equals(Object o) {

      if (o instanceof Key) {

         Key other = (Key) o;

         if (other.state.equals(this.state) && other.cChar == this.cChar)
            return true;
      }

      return false;
   }
}
