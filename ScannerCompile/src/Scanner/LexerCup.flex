package Scanner;
import TokenTypes.Symbols;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol


espacio=[ ,\t,\r]+

IdentificadorMalo= [A-Za-z_][A-Za-z_0-9]* ñ [A-Za-z_0-9]*
Zero = 0
DecInt = [1-9][0-9]*
OctalInt = 0[0-7]+
HexInt = "-"?"0"[xX][0-9A-F]+
Integer = ( {Zero} | {DecInt} | {OctalInt} | {HexInt} )[lL]?

Identificadores = [A-Za-z_$] [A-Za-z_$0-9]*
CChar = [^\'\\\n\r] | {EscChar}
EscChar = \\[ntbrf\\\'\"] | {OctalEscape}
OctalEscape = \\[0-7] | \\[0-7][0-7] | \\[0-3][0-7][0-7]
String = \"(.[^\"]*)\"
CharLiteral = \'(.[^\']*)\'

%{
    private Symbol symbol(Symbols type, Object value){
        return new Symbol(type, yyline, yycolumn, Object.toString(value));
    }
    private Symbol symbol(Symbols type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

"//".* {/*Ignore*/}
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}

"("     {return new Symbol(Symbols.Parentesis_a,yychar,yyline,yytext());}
")"     {return new Symbol(Symbols.Parentesis_c,yychar,yyline,yytext());}
"{"     {return new Symbol(Symbols.Llave_a,yychar,yyline,yytext());}
"}"     {return new Symbol(Symbols.Llave_c,yychar,yyline,yytext());}

( "++" | "--“ | "=" | "+" | "-" | "*” | "/" | "%" | "(" ")" |"+=" | "-=" | "*=" | "/=" )    {return new Symbol(Symbols.Aritmeticos,yychar,yyline,yytext());}

( "==" | ">=" | ">" | "<=" | "<" | "!=" | "||" | "&&" | "!" )   {return new Symbol(Symbols.Relacionales,yychar,yyline,yytext());}



int     {return new Symbol(Symbols.Int,yychar,yyline,yytext());}
break   {return new Symbol(Symbols.Break,yychar,yyline,yytext());}
case    {return new Symbol(Symbols.Case,yychar,yyline,yytext());}
char    {return new Symbol(Symbols.Char,yychar,yyline,yytext());}
const   {return new Symbol(Symbols.Const,yychar,yyline,yytext());}
continue    {return new Symbol(Symbols.Continue,yychar,yyline,yytext());}
default     {return new Symbol(Symbols.Default,yychar,yyline,yytext());}
do      {return new Symbol(Symbols.Do,yychar,yyline,yytext());}
else    {return new Symbol(Symbols.Else,yychar,yyline,yytext());}
for     {return new Symbol(Symbols.For,yychar,yyline,yytext());}
if      {return new Symbol(Symbols.If,yychar,yyline,yytext());}
long    {return new Symbol(Symbols.Long,yychar,yyline,yytext());}
return  {return new Symbol(Symbols.Return,yychar,yyline,yytext());}
short   {return new Symbol(Symbols.Short,yychar,yyline,yytext());}
switch  {return new Symbol(Symbols.Switch,yychar,yyline,yytext());}
void    {return new Symbol(Symbols.Void,yychar,yyline,yytext());}
while   {return new Symbol(Symbols.While,yychar,yyline,yytext());}
{Identificadores}   {return new Symbol(Symbols.Identificador,yychar,yyline,yytext());} 
";"     {return new Symbol(Symbols.Scolon,yychar,yyline,yytext());}
"main"  {return new Symbol(Symbols.Main,yychar,yyline,yytext());}
{Integer}   { return new Literal(yyline,yytext());}


( "[" )     {return new Symbol(Symbols.Corchete_a, yychar, yyline, yytext());}
( "]" )     {return new Symbol(Symbols.Corchete_c, yychar, yyline, yytext());}

{Identificadores}({Identificadores}|{Integer})* {return new Symbol(Symbols.Identificador, yychar, yyline, yytext());}
("(-"{Integer}+")")|{Integer}+ {return new Symbol(Symbols.Numero, yychar, yyline, yytext());}

{espacio} {/*Ignore*/}


{String } { return new Literal(yyline,yytext());}

{CharLiteral } { return new Literal(yyline,yytext());}

"\n" {return new Symbol(Symbols.Linea,yychar,yyline,yytext);}

 . {return new ErrorLexico(yyline,yytext());}
