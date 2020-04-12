package co.edu.eafit.dis.st0270.dyckcompiler.abs;

import co.edu.eafit.dis.st0270.dyckcompiler.visitor.Visitor;

/**
 * <code>Element</code> is the other part implementation Visitor pattern.
 * @see co.edu.eafit.dis.st0270.dyckcompiler.visitor.Visitor
 *
 * @author Juan Francisco Cardona McCormick
 * @version 0.0.1.27
 * @since   0.0.1.27
 */
public interface Element {
   /**
    * <code>accept</code> 
    */ 
   void accept(Visitor visitor);
}

