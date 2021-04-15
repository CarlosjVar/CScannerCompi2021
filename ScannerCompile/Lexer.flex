
package Scanner;
import TokenTypes.*;
%%
%class Lexer
%type Token
L=[a-zA-Z_]+
D=[0-9]+
block_comment=["\*"*(\*(?!\/)|[^*])*\*\/]+
espacio=[ ,\t,\r]+
Identifier = [A-Za-z_][A-Za-z_0-9]*

DecInteger = 0 | [1-9][0-9]*
OctInteger = 0[0-7][0-7]*
HexInteger = 0[xX][1-9a-fA-F][0-9a-fA-F]*

DecIntegerLiteral = {DecInteger} [uU]?
OctIntegerLiteral = {OctInteger} [uU]?
HexIntegerLiteral = {HexInteger} [uU]?

LongDecIntegerLiteral = {DecInteger} ( [lL] | [uU][lL] | [lL][uU] )
LongOctIntegerLiteral = {OctInteger} ( [lL] | [uU][lL] | [lL][uU] )
LongHexIntegerLiteral = {HexInteger} ( [lL] | [uU][lL] | [lL][uU] )

HexDigit = [0-9a-fA-F]
HexExpPart = [pP][+-]?[0-9]+
HexFloat = 0[xX] ( {HexDigit}+ \.? {HexDigit}* | \. {HexDigit}+ ) {HexExpPart}
HexDoubleLiteral = {HexFloat} [lL]?
HexFloatLiteral = {HexFloat} [fF]

ExponentPart = [eE][+-]?[0-9]+
Float = ( [0-9]+ ( \. [0-9]* {ExponentPart}? | {ExponentPart} ) | \. [0-9]+ {ExponentPart}? )
DoubleLiteral = ( {Float} [lL]? | {HexDoubleLiteral} )
FloatLiteral = ( {Float} [fF] | {HexFloatLiteral} )

%{
    public String lexeme;
%}
%%
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}
int |
if |
else |
while {lexeme=yytext(); return new Reservadas(yyline,yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"=" {

return new Operador(yyline,yytext());}
"+" {return new Operador(yyline,yytext());}
"-" {return new Operador(yyline,yytext());}
"*" {return new Operador(yyline,yytext());}
"/" {return new Operador(yyline,yytext());}
"\n" {yyline++;}
{L}({L}|{D})* {lexeme=yytext(); return new Literal(yyline,yytext());}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return new Operador(yyline,yytext());}
 . {return new Operador(yyline,yytext());}
