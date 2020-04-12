package co.edu.eafit.dis.st0270.dyckcompiler.visitor;

import co.edu.eafit.dis.st0270.dyckcompiler.abs.DyckAbs;
import co.edu.eafit.dis.st0270.dyckcompiler.abs.ProgAbs;

public interface Visitor {
   void visit(ProgAbs element);
   void visit(DyckAbs element);
}
