package co.edu.eafit.dis.st0270.automata;

// import junit.framework.Test;
// import junit.framework.TestCase;
// import junit.framework.TestSuite;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
   Automata autoSwitch = new AutoNumPunFlo();
   Automata autoTable  = new AutoNumPunFloT();
   Automata autoMap    = new AutoNumPunFloM();
   @Test
   public void evalAutomataSwitchCorrect() {

      autoSwitch.reset();
      autoSwitch.process("1.234");
      assertTrue(autoSwitch.accepted());
   }

   @Test
   public void evalAutomataSwitchIncorrect() {

      autoSwitch.reset();
      autoSwitch.process("00.0");
      assertFalse(autoSwitch.accepted());
   }

   @Test
   public void evalAutomataTableCorrect() {
      
      autoTable.reset();
      autoTable.process("1.234");
      assertTrue(autoTable.accepted());
   }

   @Test
   public void evalAutomataTableIncorrect() {
      
      autoTable.reset();
      autoTable.process("00.0");
      assertFalse(autoTable.accepted());
   }

   @Test
   public void evalAutomataMapCorrect() {
      
      autoMap.reset();
      autoMap.process("1.234");
      assertTrue(autoMap.accepted());
   }

   @Test
   public void evalAutomataMapIncorrect() {
      
      autoMap.reset();
      autoMap.process("00.0");
      assertFalse(autoMap.accepted());
   }
}
