package co.edu.eafit.dis.st0270.dyckcompiler;

import gnu.getopt.Getopt;
import java.io.StringReader;
import java.io.FileReader;
import java_cup.runtime.Symbol;
import co.edu.eafit.dis.st0270.dyckcompiler.abs.AbsTree;
import co.edu.eafit.dis.st0270.dyckcompiler.lexer.DyckLexer;
import co.edu.eafit.dis.st0270.dyckcompiler.lexer.DyckCupLexer;
import co.edu.eafit.dis.st0270.dyckcompiler.parser.DyckParser;
import co.edu.eafit.dis.st0270.dyckcompiler.parser.DyckParserException;
import co.edu.eafit.dis.st0270.dyckcompiler.parser.DyckCompilerCupParser;
import co.edu.eafit.dis.st0270.dyckcompiler.visitor.DepthVisitor;
import co.edu.eafit.dis.st0270.dyckcompiler.visitor.ShowVisitor;

/**
 * <code>DyckMain</code> is responsable to start the
 * implementation of a LR(1) compiler, in two different versions: manual
 * and cup.
 *
 * @author Juan Francisco Cardona McCormick
 * @version 0.0.1.26
 * @since   0.0.1.0
 */
public class DyckMain {

   private enum CompilerKind { MANUAL, CUP };

   /**
    * <code>usage</code> shows a commands lines, every time there an error on the
    * format command line this static fuction is called.
    */
   public static void usage() {
      System.err.println("Usage: java DyckMain [-p [{manual|cup}] [-s] [<filename>] ...");
      System.exit(1);
   }

   /**
    * <code>main</code> is the start point of the execution of the DyckCompiler package.
    */
   public static void main(String args[]) {

      Getopt getOpt = new Getopt("DyckMain", args, "p:s:");
      int c;
      String str = null;
      CompilerKind ck = CompilerKind.MANUAL;

      while ((c = getOpt.getopt()) != -1) {
         switch (c) {
         case 'p':
            if(getOpt.getOptarg().equals("manual")) {
               ck = CompilerKind.MANUAL;
            }
            else if (getOpt.getOptarg().equals("cup")) {
               ck = CompilerKind.CUP;
            }
            else {
               usage();
            }
            break;

         case 's':
            str = getOpt.getOptarg();
            break;

         default:
            usage();
            break;
         }
      }

      int startFiles = getOpt.getOptind();

      if (str == null && startFiles == args.length) usage();

      switch(ck) {
      case MANUAL:
         {
            DyckParser dp = null;

            if (str != null) {
               try {
                  dp = new DyckParser(new DyckLexer(new StringReader(str)));
		  dp.parser();
                  System.out.println("Valid expression: " + str);
               }
               catch (Exception e) {
                  System.err.println(e);
                  System.err.println("Invalid expression: " + str);
               }
            }

            for (int i = startFiles; i < args.length; ++i) {
               try {
                  dp = new DyckParser(new DyckLexer(new FileReader(args[i])));
		  dp.parser();
                  System.err.println("Valid file: " + args[i]);
               }
               catch (Exception e) {
                  System.err.println(e);
                  System.err.println("Invalid File: " + args[i]);
               }
            }
         }
         break;

      case CUP:
         {
            DyckCompilerCupParser dccp = null;

            if (str != null) {

               try {
                  dccp = new DyckCompilerCupParser(new DyckCupLexer(new StringReader(str)));
                  Symbol symbol = dccp.parse();


                  AbsTree tree = (AbsTree) symbol.value;

                  DepthVisitor dv  = new DepthVisitor();
		  ShowVisitor  sv  = new ShowVisitor();
		  ShowVisitor  sv2 = new ShowVisitor('{','}');

                  tree.accept(dv);
                  tree.accept(sv);
                  tree.accept(sv2);

                  System.out.println("Valid expression: " + str);

                  System.out.println("Depth: " + dv.getDepth());

		  System.out.println("String: " + sv.getSB());
		  System.out.println("Translate: " + sv2.getSB());
               }
               catch (Exception e) {
                  System.err.println("Exception " + e);
                  System.err.println("Invalid expression: " + str);
               }
            }

            for (int i = startFiles; i < args.length; ++i) {
               try {
                  dccp = new DyckCompilerCupParser(new DyckCupLexer(new FileReader(args[i])));
                  Symbol symbol = dccp.parse();

                  AbsTree tree = (AbsTree) symbol.value;

                  DepthVisitor dv = new DepthVisitor();
		  ShowVisitor sv = new ShowVisitor();
		  ShowVisitor sv2 = new ShowVisitor('{','}');

                  tree.accept(dv);
		  tree.accept(sv);
		  tree.accept(sv2);

                  System.out.println("Valid file: " + args[i]);

                  System.out.println("Depth: " + dv.getDepth());

		  System.out.println("String: " + sv.getSB());
		  System.out.println("Translate: " + sv2.getSB());

               }
               catch (Exception e) {
                  System.err.println("Invalid file: " + args[i]);
               }
            }
         }
         break;
      }
      System.exit(0);
   }
}
