package Scanner;
import TokenTypes.Symbols;
import TokenTypes.*;
import java_cup.runtime.Symbol;

%%
%cup
%public
%class Lexer
%type java_cup.runtime.Symbol
%line
%column
LineEnd = \r|\n|\r\n
espacio = {LineEnd}|[ \t\f]
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
    
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
%}
%%

"//".* {/*Ignore*/}
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}

"("     {return new Symbol(sym.Parentesis_a,yycolumn,yyline ,yytext());}
")"     {return new Symbol(sym.Parentesis_c,yycolumn,yyline ,yytext());}
"{"     {return new Symbol(sym.Llave_a,yycolumn,yyline ,yytext());}
"}"     {return new Symbol(sym.Llave_c,yycolumn,yyline ,yytext());}



( "~" | "++" | "--" )   {return new Symbol(sym.Unarios,yycolumn,yyline ,yytext());}

( "==" | ">=" | ">" | "<=" | "<" | "!=" )   {return new Symbol(sym.Relacionales,yycolumn,yyline ,yytext());}


read {return new Symbol(sym.Read,yycolumn,yyline ,yytext());}
write {return new Symbol(sym.Write,yycolumn,yyline ,yytext());}
"int"     {return new Symbol(sym.Int,yycolumn,yyline ,yytext());}
break   {return new Symbol(sym.Break,yycolumn,yyline ,yytext());}
case    {return new Symbol(sym.Case,yycolumn,yyline ,yytext());}
char    {return new Symbol(sym.Char,yycolumn,yyline ,yytext());}
const   {return new Symbol(sym.Const,yycolumn,yyline ,yytext());}
continue    {return new Symbol(sym.Continue,yycolumn,yyline ,yytext());}
default     {return new Symbol(sym.Default,yycolumn,yyline ,yytext());}
do      {return new Symbol(sym.Do,yycolumn,yyline ,yytext());}
else    {return new Symbol(sym.Else,yycolumn,yyline ,yytext());}
for     {return new Symbol(sym.For,yycolumn,yyline ,yytext());}
if      {return new Symbol(sym.If,yycolumn,yyline ,yytext());}
long    {return new Symbol(sym.Long,yycolumn,yyline ,yytext());}
return  {return new Symbol(sym.Return,yycolumn,yyline ,yytext());}
short   {return new Symbol(sym.Short,yycolumn,yyline ,yytext());}
switch  {return new Symbol(sym.Switch,yycolumn,yyline ,yytext());}
void    {return new Symbol(sym.Void,yycolumn,yyline ,yytext());}
while   {return new Symbol(sym.While,yycolumn,yyline ,yytext());}
main    {return new Symbol(sym.Main,yycolumn,yyline ,yytext());}
{Identificadores}   {return new Symbol(sym.Identificador,yycolumn,yyline ,yytext());} 
";"     {return new Symbol(sym.Scolon,yycolumn,yyline ,yytext());}
{Integer}   {  return new Symbol(sym.Literal,yycolumn,yyline ,yytext());}
"=" {return new Symbol(sym.Asignacion,yycolumn,yyline ,yytext());}
"||" {return new Symbol(sym.Or,yycolumn,yyline ,yytext());}
"&&" {return new Symbol(sym.And,yycolumn,yyline ,yytext());}
"!"  {return new Symbol(sym.Not,yycolumn,yyline ,yytext());}
"+" {return new Symbol(sym.Mas,yycolumn,yyline ,yytext());}
"-" {return new Symbol(sym.Menos,yycolumn,yyline ,yytext());}
":" { return new Symbol(sym.Dos_puntos,yycolumn,yyline ,yytext());}
"*" {return new Symbol(sym.Multiplicacion,yycolumn,yyline ,yytext());}
"/" {return new Symbol(sym.Division,yycolumn,yyline ,yytext());}"
"%" {return new Symbol(sym.Modulo,yycolumn,yyline ,yytext());}"

, {System.out.println("koma"); return new Symbol(sym.Coma,yycolumn,yyline ,yytext());}


( "[" )     {return new Symbol(sym.Corchete_a,yycolumn,yyline ,yytext());}
( "]" )     {return new Symbol(sym.Corchete_c,yycolumn,yyline ,yytext());}

{Identificadores}({Identificadores}|{Integer})* {return new Symbol(sym.Identificador,yycolumn,yyline ,yytext());}
("(-"{Integer}+")")|{Integer}+ {return new Symbol(sym.Numero,yycolumn,yyline ,yytext());}

{espacio}+ {/*Ignore*/}


{String } {System.out.println("String"); return new Symbol(sym.Literal,yycolumn,yyline ,yytext());}

{CharLiteral } { System.out.println("Char"); return new Symbol(sym.Literal,yycolumn,yyline ,yytext());}

"\n" {return new Symbol(sym.Linea,yycolumn,yyline ,yytext());}

 . { return new Symbol(sym.LEX_ERROR,yycolumn,yyline ,yytext());}