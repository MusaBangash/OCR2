/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocr2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 *
 * @author MUSA Bangash
 */
public class apiClass extends javax.swing.JFrame {

   
    fileChoose filechoose=new fileChoose();
  
    
    public apiClass() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Tesseract");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("OCR Space");

        jButton3.setText("OCR Rest");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(303, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
              try {                                         
                  
                 // System.out.println("path"+filechoose.path);
                  File image=new File(filechoose.path);
                  ITesseract instance = new Tesseract();
                  instance.setDatapath("C:\\Users\\MUSA Bangash\\Downloads\\Compressed\\Tess4J\\tessdata");
                  try {
                      String fileName="out.txt";
                      String result = instance.doOCR(image);
                      // String result2=instance.doOCR(imageFile2);
                      System.out.println(result);
                      //  System.out.println();
                      // System.out.println(result);
                      
                      //  System.out.println(result.compareTo(result));
                      // System.out.println(result.equals(result));
                      //public static final String ANSI_RESET = "\u001B[0m";
                      //  System.out.println(result.);
                      
                      PrintWriter outputStream=new PrintWriter(fileName);
                      outputStream.write(result);
                      outputStream.close();
                      // System.out.println("Done");
                      
                      
                      
                  } catch (TesseractException e) {
                      System.err.println(e.getMessage());
                  } catch (FileNotFoundException ex) {
                      Logger.getLogger(apiClass.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  String filecontent="";
                  File file=new File("C:\\Users\\MUSA Bangash\\Documents\\E-Voting-Systems\\TesseractExample/out.txt");
                  Scanner scan=new Scanner(file);
                  
                  while(scan.hasNextLine()){
                      filecontent=filecontent.concat(scan.nextLine()+"\n");
                      
                  }
                  System.out.println("From File:"+filecontent);
                  
                 System.out.println("Comparing:"+filechoose.imgText.compareTo(filecontent));
                  
              } catch (FileNotFoundException ex) {
            Logger.getLogger(apiClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        java.awt.EventQueue.invokeLater(() -> {
            new apiClass().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
