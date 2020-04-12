/* Analizador lexico para el lenguaje de parentesis (Dyck) */
package co.edu.eafit.dis.st0270.dyckcompiler.lexer;

import co.edu.eafit.dis.st0270.dyckcompiler.grammar.Terminal;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.OPar;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.CPar;
import co.edu.eafit.dis.st0270.dyckcompiler.grammar.EndOfString;

%%

%class DyckLexer
%unicode
%line
%column
%function getNextToken
%type Terminal
%public

LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\n]

%%

"("                  { return new OPar(yycolumn + 1, yyline + 1); }
")"                  { return new CPar(yycolumn + 1, yyline + 1); }
{WhiteSpace}         { }
.                    { throw new Error("Illegal character <" +
                                       yytext() + "> at line: " +
                                       (yyline + 1) + " column: " +
                                       yycolumn);
                     }
<<EOF>>              { return new EndOfString(); }