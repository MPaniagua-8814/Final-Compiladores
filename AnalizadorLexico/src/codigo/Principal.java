/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author spaniagua
 */
public class Principal {
    
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/Lexer.flex";
        String ruta2 = "C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/LexerCup.flex";
        String[] rutaSintactico = {"-parser", "Sintax", "C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/Sintax.cup"};
        generarLexer(ruta1, ruta2, rutaSintactico);
    }
    
    public static void generarLexer( String ruta1, String ruta2, String[] rutaSintactico ) throws IOException, Exception{
        
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        java_cup.Main.main(rutaSintactico);
        
        Path rutaSym = Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/sym.java");
        if(Files.exists(rutaSym)){
            Files.delete(rutaSym);
        }        
        Files.move(
                Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/sym.java"), 
                Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/sym.java")
        );
        
        
        Path rutaSin = Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/Sintax.java");
        if(Files.exists(rutaSin)){
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/Sintax.java"), 
                Paths.get("C:/Users/spaniagua/Documents/NetBeansProjects/AnalizadorLexico/src/codigo/Sintax.java")
        );
                
                
    }
    
}
