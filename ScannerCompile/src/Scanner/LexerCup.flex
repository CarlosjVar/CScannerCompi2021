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

    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

"//".* {/*Ignore*/}
"/*"((\*+[^/*])|([^*]))*\**"*/" {System.out.println("Bloque de comentarios");}

"("     {return new Symbol(sym.Parentesis_a, new DataHolder(yyline,yytext()));}
")"     {return new Symbol(sym.Parentesis_c,new DataHolder(yyline,yytext()));}
"{"     {return new Symbol(sym.Llave_a,new DataHolder(yyline,yytext()));}
"}"     {return new Symbol(sym.Llave_c,new DataHolder(yyline,yytext()));}



( "~" | "++" | "--" )   {return new Symbol(sym.Unarios,new DataHolder(yyline,yytext()));}

( "==" | ">=" | ">" | "<=" | "<" | "!=" )   {return new Symbol(sym.Relacionales,new DataHolder(yyline,yytext()));}

( "*" | "/" | "%" ) {return new Symbol(sym.Timesslash,new DataHolder(yyline,yytext()));}


read {return new Symbol(sym.Read,new DataHolder(yyline,yytext()));}
write {return new Symbol(sym.Write,new DataHolder(yyline,yytext()));}
"int"     {return new Symbol(sym.Int,new DataHolder(yyline,yytext()));}
break   {return new Symbol(sym.Break,new DataHolder(yyline,yytext()));}
case    {return new Symbol(sym.Case,new DataHolder(yyline,yytext()));}
char    {return new Symbol(sym.Char,new DataHolder(yyline,yytext()));}
const   {return new Symbol(sym.Const,new DataHolder(yyline,yytext()));}
continue    {return new Symbol(sym.Continue,new DataHolder(yyline,yytext()));}
default     {return new Symbol(sym.Default,new DataHolder(yyline,yytext()));}
do      {return new Symbol(sym.Do,new DataHolder(yyline,yytext()));}
else    {return new Symbol(sym.Else,new DataHolder(yyline,yytext()));}
for     {return new Symbol(sym.For,new DataHolder(yyline,yytext()));}
if      {return new Symbol(sym.If,new DataHolder(yyline,yytext()));}
long    {return new Symbol(sym.Long,new DataHolder(yyline,yytext()));}
return  {return new Symbol(sym.Return,new DataHolder(yyline,yytext()));}
short   {return new Symbol(sym.Short,new DataHolder(yyline,yytext()));}
switch  {return new Symbol(sym.Switch,new DataHolder(yyline,yytext()));}
void    {return new Symbol(sym.Void,new DataHolder(yyline,yytext()));}
while   {return new Symbol(sym.While,new DataHolder(yyline,yytext()));}
main    {return new Symbol(sym.Main,new DataHolder(yyline,yytext()));}
{Identificadores}   {return new Symbol(sym.Identificador,new DataHolder(yyline,yytext()));} 
";"     {return new Symbol(sym.Scolon,new DataHolder(yyline,yytext()));}
{Integer}   {  return new Symbol(sym.Literal, new DataHolder(yyline,yytext()));}
"=" {return new Symbol(sym.Asignacion,new DataHolder(yyline,yytext()));}
"||" {return new Symbol(sym.Or,new DataHolder(yyline,yytext()));}
"&&" {return new Symbol(sym.And,new DataHolder(yyline,yytext()));}
"!"  {return new Symbol(sym.Not,new DataHolder(yyline,yytext()));}
"+" {return new Symbol(sym.Mas,new DataHolder(yyline,yytext()));}
"-" {return new Symbol(sym.Menos,new DataHolder(yyline,yytext()));}
":" { return new Symbol(sym.Dos_puntos,new DataHolder(yyline,yytext()));}

, {System.out.println("koma"); return new Symbol(sym.Coma,new DataHolder(yyline,yytext()));}


( "[" )     {return new Symbol(sym.Corchete_a, new DataHolder(yyline,yytext()));}
( "]" )     {return new Symbol(sym.Corchete_c, new DataHolder(yyline,yytext()));}

{Identificadores}({Identificadores}|{Integer})* {return new Symbol(sym.Identificador, new DataHolder(yyline,yytext()));}
("(-"{Integer}+")")|{Integer}+ {return new Symbol(sym.Numero, new DataHolder(yyline,yytext()));}

{espacio}+ {/*Ignore*/}


{String } {System.out.println("String"); return new Symbol(sym.Literal, new DataHolder(yyline,yytext()));}

{CharLiteral } { System.out.println("Char"); return new Symbol(sym.Literal, new DataHolder(yyline,yytext()));}

"\n" {return new Symbol(sym.Linea,new DataHolder(yyline,yytext()));}

 . { return new Symbol(sym.LEX_ERROR,new DataHolder(yyline,yytext()));}