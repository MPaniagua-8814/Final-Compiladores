/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.*;
import java.nio.file.Files;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import jdk.nashorn.internal.runtime.regexp.joni.Syntax;
/**
 *
 * @author spaniagua
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void analizarLexico() throws IOException{
         int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
 
                case SaltoLinea:
                    cont++;
                    resultado += "\nLINEA " + cont + "\n";
                    break;
                case If:
                    resultado += "<Condicional If>\t\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "<Condicional Else>\t\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "<Reservada While>\t\t" + lexer.lexeme + "\n";
                    break;
                case DeclaracionVariable:
                    resultado += "<Declaracion de variable>\t\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "<Reservada For>\t\t" + lexer.lexeme + "\n";
                    break;
                case Puts:
                    resultado += "<Reservada Puts>\t\t" + lexer.lexeme + "\n";
                    break;
                case Switch:
                    resultado += "<Reservada Switch>\t\t" + lexer.lexeme + "\n";
                    break;
                case Default:
                    resultado += "<Reservada Default>\t\t" + lexer.lexeme + "\n";
                    break;
                case Break:
                    resultado += "<Reservada Break>\t\t" + lexer.lexeme + "\n";
                    break;
                case Continue:
                    resultado += "<Reservada Continue>\t\t" + lexer.lexeme + "\n";
                    break;
                case ComillaDoble:
                    resultado += "<Comillas>\t\t\t" + lexer.lexeme + "\n";
                    break;
                case Expr:
                    resultado += "<Expresion>\t\t\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "<Operador Suma>\t\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "<Operador Resta>\t\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "<Operador Multiplicacion>\t\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "<Operador División>\t\t" + lexer.lexeme + "\n";
                    break;
                case ParentesisApertura:
                    resultado += "<Agrupacion: Parentesis Apertura>\t" + lexer.lexeme + "\n";
                    break;
                case ParentesisCierre:
                    resultado += "<Agrupacion: Parentesis Cierre>\t\t" + lexer.lexeme + "\n";
                    break;
                case LlaveApertura:
                    resultado += "<Agrupacion: Llave Apertura>\t" + lexer.lexeme + "\n";
                    break;
                case LlaveCierre:
                    resultado += "<Agrupacion: Llave Cierre>\t\t" + lexer.lexeme + "\n";
                    break;
                case CorcheteApertura:
                    resultado += "<Agrupacion: Corchete Apertura>\t" + lexer.lexeme + "\n";
                    break;
                case CorcheteCierre:
                    resultado += "<Agrupacion: Corchete Cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Incrementar:
                    resultado += "<Reservada para incrementar>\t" + lexer.lexeme + "\n";
                    break;
                case ObtenerDatoVariable:
                    resultado += "<Obtener Dato de la Variable>\t" + lexer.lexeme + "\n";
                    break;
                case Dolar:
                    resultado += "<Simbolo Dolar>\t\t" + lexer.lexeme + "\n";
                    break;
                case Punto_coma:
                    resultado += "<Punto y Coma>\t\t" + lexer.lexeme + "\n";
                    break;
                case Comparacion:
                    resultado += "<Operador comparacion>\t\t" + lexer.lexeme + "\n";
                    break;
                case Comentario:
                    resultado += "<Comentario>\t\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "<Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "<Numero>\t\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "<ERROR>\t\t\t" + lexer.lexeme + "\n";
                    break;
                case Proc:
                    resultado += "<Reservada para procedimiento>\t" + lexer.lexeme + "\n";
                    break;
                case Return:
                    resultado += "<Reservada Return>\t" + lexer.lexeme + "\n";
                    break;
                default:
                    resultado += "  <Token no encontrado ::: " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnLimpiarSin = new javax.swing.JButton();
        btnAnalizarSin = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        btnAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnArchivo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Sintactico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnLimpiarSin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        btnAnalizarSin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAnalizarSin.setText("Analizar");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(btnAnalizarSin)
                .addGap(316, 316, 316)
                .addComponent(btnLimpiarSin)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Analizador Léxico", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtAnalizarLex.setRows(5);
        jScrollPane4.setViewportView(txtAnalizarLex);

        btnAnalizarLex.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAnalizarLex.setText("Analizar");
        btnAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAnalizarLex)
                        .addGap(314, 314, 314)
                        .addComponent(btnLimpiarLex))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarLex)
                    .addComponent(btnLimpiarLex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Archivo a Analizar", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 18), new java.awt.Color(0, 0, 0))); // NOI18N

        btnArchivo.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnArchivo.setText("Abrir Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtResultado.setRows(5);
        jScrollPane5.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnArchivo)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(btnArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        }catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarLexActionPerformed
        try {
            // TODO add your handling code here:
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAnalizarLexActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        // TODO add your handling code here:
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalizarSin.setText("Análisis Realizado Correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            //txtAnalizarSin.setText("error ==== " + ex);
            txtAnalizarSin.setText("Error de sintaxis. \nLinea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value +"\"");
            txtAnalizarSin.setForeground(Color.red);        
        }
        
        
        
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        // TODO add your handling code here:
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        // TODO add your handling code here:
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
