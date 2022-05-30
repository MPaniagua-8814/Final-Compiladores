package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%

( if ) {return new Symbol(sym.If, yychar, yyline, yytext());}
else {return new Symbol(sym.Else, yychar, yyline, yytext());}
while {return new Symbol(sym.While, yychar, yyline, yytext());}
set {return new Symbol(sym.DeclaracionVariable, yychar, yyline, yytext());}
for {return new Symbol(sym.For, yychar, yyline, yytext());}
puts {return new Symbol(sym.Puts, yychar, yyline, yytext());}
switch {return new Symbol(sym.Switch, yychar, yyline, yytext());}
default {return new Symbol(sym.Default, yychar, yyline, yytext());}
break {return new Symbol(sym.Break, yychar, yyline, yytext());}
continue {return new Symbol(sym.Continue, yychar, yyline, yytext());}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"#" ({L}|{D})* {/*Ignore*/}
("\"") {return new Symbol(sym.ComillaDoble, yychar, yyline, yytext());}
"expr" {return new Symbol(sym.Expr, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Division, yychar, yyline, yytext());}
"(" {return new Symbol(sym.ParentesisApertura, yychar, yyline, yytext());}
")" {return new Symbol(sym.ParentesisCierre, yychar, yyline, yytext());}
"{" {return new Symbol(sym.LlaveApertura, yychar, yyline, yytext());}
"}" {return new Symbol(sym.LlaveCierre, yychar, yyline, yytext());}
"[" {return new Symbol(sym.CorcheteApertura, yychar, yyline, yytext());}
"]" {return new Symbol(sym.CorcheteCierre, yychar, yyline, yytext());}
"incr" {return new Symbol(sym.Incrementar, yychar, yyline, yytext());}
"proc" {return new Symbol(sym.Proc, yychar, yyline, yytext());}
"return" {return new Symbol(sym.Return, yychar, yyline, yytext());}
";" {return new Symbol(sym.Punto_coma, yychar, yyline, yytext());}
( "$" ) {return new Symbol(sym.Dolar, yychar, yyline, yytext());}
("<" | ">" | "==" | "<=" | ">=" ) {return new Symbol(sym.Comparacion, yychar, yyline, yytext());}
("$"{L}({L}|{D})*) {return new Symbol(sym.ObtenerDatoVariable, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Identificador, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
 . {return new Symbol(sym.ERROR, yychar, yyline, yytext());}



//Operadores Relacionales para cadenas
eq {return new Symbol(sym.IgualQue, yychar, yyline, yytext());}
ne {return new Symbol(sym.NoIgualQue, yychar, yyline, yytext());}
in {return new Symbol(sym.ListadoSi, yychar, yyline, yytext());}
ni {return new Symbol(sym.ListadoNo, yychar, yyline, yytext());}

//Operadores logicos
"&&" {return new Symbol(sym.And, yychar, yyline, yytext());}
"||" {return new Symbol(sym.Or, yychar, yyline, yytext());}
"!" {return new Symbol(sym.Not, yychar, yyline, yytext());}

//Operadores Booleanos
(true | false){return new Symbol(sym.OperadorBooleano, yychar, yyline, yytext());}


({L}({L|D|espacio})*) {return new Symbol(sym.Cadena, yychar, yyline, yytext());}