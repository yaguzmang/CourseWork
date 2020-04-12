package co.edu.eafit.dis.st0270.dyckcompiler.abs;

import  co.edu.eafit.dis.st0270.dyckcompiler.visitor.Visitor;

public abstract class AbsTree implements Element {
   public abstract void accept(Visitor visitor);
}
