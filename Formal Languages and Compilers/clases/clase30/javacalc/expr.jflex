import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column

%%

"("	{ return new Symbol(sym.LPAREN);}
")"	{ return new Symbol(sym.RPAREN);}
"+"	{ return new Symbol(sym.PLUS);}
"-"	{ return new Symbol(sym.SUB);}
"*"	{ return new Symbol(sym.TIMES);}
"/" 	{ return new Symbol(sym.DIVIDE);}
[0-9]+	{ return new Symbol(sym.NUMBER, yytext());}
. 	{ return new Symbol(sym.error);}