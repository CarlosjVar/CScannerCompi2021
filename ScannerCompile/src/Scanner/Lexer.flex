package Scanner;
import TokenTypes.*;
%%
%class Lexer
%type Token


espacio=[ ,\t,\r]+


Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = 0[xX][0-9a-fA-F]+
Integer = ( {Zero} | {DecInt} | {OctalInt} | {HexInt} )[lL]?
Exponent = [eE] [\+\-]? [0-9]+
Float1 = [0-9]+ \. [0-9]+ {Exponent}?
Float2 = \. [0-9]+ {Exponent}?
Float3 = [0-9]+ \. {Exponent}?
Float4 = [0-9]+ {Exponent}
Float = ( {Float1} | {Float2} | {Float3} | {Float4} ) [fFdD]? |
[0-9]+ [fFDd]
Identificadores = [A-Za-z_$] [A-Za-z_$0-9]*
CChar = [^\'\\\n\r] | {EscChar}
SChar = [^\"\\\n\r] | {EscChar}
EscChar = \\[ntbrf\\\'\"] | {OctalEscape}
OctalEscape = \\[0-7] | \\[0-7][0-7] | \\[0-3][0-7][0-7]
String = \"(.[^\"]*)\"

Reservadas = auto |break |case |char |const |continue |default |do |double |else |enum |extern |float |for |goto |if |int |long |register |return |short |signed |sizeof |static |struct |switch |typedef |union |unsigned |void |volatile |while
Operadores = "," |";" |"++" |"--" |"=="|">=" |">" |"?" |"<=" |"<" |"!=" |"||" |"&&" |"!" |"=" |"+" |"-" |"*" |"/" |"%" |"(" ")" |"[" "]" |"{" "}"| ":" |"." |"+=" |"-=" |"*=" |"/=" |"&" |"^" |"|" |">>" |"<<" |"~" |"%=" |"&=" |"^=" |"|=" |"<<=" |">>=" |"->"
%{
    public String lexeme;
%}
%%
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}

{espacio} {/*Ignore*/}

{Reservadas} { return new Reservadas(yyline,yytext());}

{Identificadores} { return new Identificador(yyline,yytext());} 


{Operadores} { return new Operador(yyline,yytext());}

{String} { return new Literal(yyline,yytext());}

"\n" { yyline++;}



{Integer} { return new Literal(yyline,yytext());}
{Float} { return new Literal(yyline,yytext());}
 . {System.out.println("Error lexico");}
