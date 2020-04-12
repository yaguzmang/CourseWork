/* Analizador lexico para el lenguaje Jay - Tucker y Noonan */
package co.edu.eafit.dis.st0270.dyckcompiler.lexer;

import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import co.edu.eafit.dis.st0270.dyckcompiler.parser.DyckCompilerSymbolsCup;
%%

%class DyckCupLexer
%unicode
%line
%column
%cup
%public

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\n]

%%

"("                  { return new Symbol(DyckCompilerSymbolsCup.LPAREN); }
")"                  { return new Symbol(DyckCompilerSymbolsCup.RPAREN); }
{WhiteSpace}         { }
.                    { return new Symbol(DyckCompilerSymbolsCup.error); }
<<EOF>>              { return new Symbol(DyckCompilerSymbolsCup.EOF);   }