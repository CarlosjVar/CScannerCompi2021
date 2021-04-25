package Scanner;
import TokenTypes.*;
%%
%class Lexer
%type Token


espacio=[ ,\t,\r]+

IdentificadorMalo= [A-Za-z_][A-Za-z_0-9]* ñ [A-Za-z_0-9]*
Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = "-"?"0"[xX][0-9A-F]+
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
InvalidIdentifier = [0-9]+ [A-Za-z_$]+
Reservadas = auto |break |case |char |const |continue |default |do |double |else |enum |extern |float |for |goto |if |int |long |register |return |short |signed |sizeof |static |struct |switch |typedef |union |unsigned |void |volatile |while
Operadores = "," |";" |"++" |"--" |"=="|">=" |">" |"?" |"<=" |"<" |"!=" |"||" |"&&" |"!" |"=" |"+" |"-" |"*" |"/" |"%" |"(" | ")" | "[" | "]" |"{" | "}" | ":" |"." |"+=" |"-=" |"*=" |"/=" |"&" |"^" |"|" |">>" |"<<" |"~" |"%=" |"&=" |"^=" |"|=" |"<<=" |">>=" |"->"
%{
    public String lexeme;
%}
%%
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}


{Reservadas} { return new Reservadas(yyline,yytext());}

{espacio} {/*Ignore*/}


{IdentificadorMalo} {return new ErrorLexico(yyline,yytext());}

{Identificadores} { return new Identificador(yyline,yytext());} 

{Integer} { return new Literal(yyline,yytext());}
{Float} { return new Literal(yyline,yytext());}

{Operadores} { return new Operador(yyline,yytext());}

{String} { return new Literal(yyline,yytext());}

"\n" { yyline++;}


{InvalidIdentifier} { return new ErrorLexico(yyline,yytext());} 

 . {return new ErrorLexico(yyline,yytext());}
