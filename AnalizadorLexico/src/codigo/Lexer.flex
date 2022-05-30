package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r]+
%{
    public String lexeme;
%}
%%
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {return SaltoLinea;}
("\"") {lexeme=yytext(); return ComillaDoble;}

//Reservadas del lenguaje
"incr" {lexeme=yytext(); return Incrementar;}
"proc" {lexeme=yytext(); return Proc;}
"return" {lexeme=yytext(); return Return;}
";" {lexeme=yytext(); return Punto_coma;}
"expr" {lexeme=yytext(); return Expr;}
if {lexeme=yytext(); return If;}
else {lexeme=yytext(); return Else;}
while {lexeme=yytext(); return While;}
set {lexeme=yytext(); return DeclaracionVariable;}
for {lexeme=yytext(); return For;}
puts {lexeme=yytext(); return Puts;}
switch {lexeme=yytext(); return Switch;}
default {lexeme=yytext(); return Default;}
break {lexeme=yytext(); return Break;}
continue {lexeme=yytext(); return Continue;}

//Operadores Aritmeticos
"+" {lexeme=yytext(); return Suma;}
"-" {lexeme=yytext(); return Resta;}
"*" {lexeme=yytext(); return Multiplicacion;}
"/" {lexeme=yytext(); return Division;}

//Apertura y Cierre
"(" {lexeme=yytext(); return ParentesisApertura;}
")" {lexeme=yytext(); return ParentesisCierre;}
"{" {lexeme=yytext(); return LlaveApertura;}
"}" {lexeme=yytext(); return LlaveCierre;}
"[" {lexeme=yytext(); return CorcheteApertura;}
"]" {lexeme=yytext(); return CorcheteCierre;}

//Operadores Relacionales
("<" | ">" | "==" | "<=" | ">=" ) {lexeme=yytext(); return Comparacion;}

//Cadenas y numeros
"#" ({L}|{D})* {lexeme=yytext(); return Comentario;}
("$"{L}({L}|{D})*) {lexeme=yytext(); return ObtenerDatoVariable;}
( "$" ) {lexeme=yytext(); return Dolar;}
{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
({L}(L|D|espacio)*) {lexeme = yytext(); return Cadena;}

//Error
 . {return ERROR;}


//Operadores Relacionales para cadenas
eq {return IgualQue;}
ne {return NoIgualQue;}
in {return ListadoSi;}
ni {return ListadoNo;}

//Operadores logicos
"&&" {return And;}
"||" {return Or;}
"!" {return Not;}

//Operadores Booleanos
(true | false) {lexeme = yytext(); return OperadorBooleano;}