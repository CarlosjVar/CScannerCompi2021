package Scanner;
import TokenTypes.*;
%%
%class Lexer
%type Token
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
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
