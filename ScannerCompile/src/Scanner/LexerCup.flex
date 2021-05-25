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

"("     {return new Symbol(sym.Parentesis_a,yychar,yyline,yytext());}
")"     {return new Symbol(sym.Parentesis_c,yychar,yyline,yytext());}
"{"     {return new Symbol(sym.Llave_a,yychar,yyline,yytext());}
"}"     {return new Symbol(sym.Llave_c,yychar,yyline,yytext());}

( "++" | "--“ | "=" | "+" | "-" | "*” | "/" | "%" | "(" ")" |"+=" | "-=" | "*=" | "/=" )    {return new Symbol(Symbols.Aritmeticos,yychar,yyline,yytext());}

( "==" | ">=" | ">" | "<=" | "<" | "!=" | "||" | "&&" | "!" )   {return new Symbol(Symbols.Relacionales,yychar,yyline,yytext());}



int     {return new Symbol(sym.Int,yychar,yyline,yytext());}
break   {return new Symbol(sym.Break,yychar,yyline,yytext());}
case    {return new Symbol(sym.Case,yychar,yyline,yytext());}
char    {return new Symbol(sym.Char,yychar,yyline,yytext());}
const   {return new Symbol(sym.Const,yychar,yyline,yytext());}
continue    {return new Symbol(sym.Continue,yychar,yyline,yytext());}
default     {return new Symbol(sym.Default,yychar,yyline,yytext());}
do      {return new Symbol(sym.Do,yychar,yyline,yytext());}
else    {return new Symbol(sym.Else,yychar,yyline,yytext());}
for     {return new Symbol(sym.For,yychar,yyline,yytext());}
if      {return new Symbol(sym.If,yychar,yyline,yytext());}
long    {return new Symbol(sym.Long,yychar,yyline,yytext());}
return  {return new Symbol(sym.Return,yychar,yyline,yytext());}
short   {return new Symbol(sym.Short,yychar,yyline,yytext());}
switch  {return new Symbol(sym.Switch,yychar,yyline,yytext());}
void    {return new Symbol(sym.Void,yychar,yyline,yytext());}
while   {return new Symbol(sym.While,yychar,yyline,yytext());}
{Identificadores}   {return new Symbol(sym.Identificador,yychar,yyline,yytext());} 
";"     {return new Symbol(sym.Scolon,yychar,yyline,yytext());}
"main"  {return new Symbol(sym.Main,yychar,yyline,yytext());}
{Integer}   { return new Literal(yyline,yytext());}


( "[" )     {return new Symbol(sym.Corchete_a, yychar, yyline, yytext());}
( "]" )     {return new Symbol(sym.Corchete_c, yychar, yyline, yytext());}

{Identificadores}({Identificadores}|{Integer})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{Integer}+")")|{Integer}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}

{espacio} {/*Ignore*/}


{String } { return new Literal(yyline,yytext());}

{CharLiteral } { return new Literal(yyline,yytext());}

"\n" {return new Symbol(sym.Linea,yychar,yyline,yytext);}

 . {return new ErrorLexico(yyline,yytext());}
