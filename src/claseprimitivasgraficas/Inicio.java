/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseprimitivasgraficas;

import Modelos.Circulo;
import Modelos.Cuadrado;
import Modelos.Disparo;
import Modelos.Imagen;
import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author pipet
 */
public class Inicio extends javax.swing.JFrame {
    Imagen player;
    Imagen nave;
    Disparo bala;
    Disparo enemigo1;
    Imagen enemigoiz;
    Imagen enemigode;
    Thread proceso;
    int c=0;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        int random = ThreadLocalRandom.current().nextInt(0,10 +1);
        System.out.println(random);
        //Cuadrado nave= new Cuadrado(30, 0, 0,1000, Color.blue, Color.green, true, false, 0);
        //this.player = new Cuadrado(30, 640/2, 360-31,100, Color.blue, Color.red, true, true, 1);
        this.nave = new Imagen("src/Imagenes/Nave.png", 100, 100, 1600/2, 0, 10000,Color.BLACK,Color.BLACK, true, false, 0);
        this.player = new Imagen("src/Imagenes/rocket-league.png", 100, 100, 1600/2, 800, 500,Color.BLACK,Color.BLACK, true, true, 1);
        this.bala= new Disparo(25,10, this.player.getX()+5, this.player.getY()-15,50, Color.black, Color.black, true, true, 2);
        this.enemigo1 = new Disparo(10, 30, this.nave.getX()-50, this.nave.getY()+100, 250, Color.blue, Color.green, true, true, 3);
        this.enemigoiz = new Imagen("src/Imagenes/Nave.png", 50, 50, 1600-50, 800-30, 100, Color.blue, Color.green, true, false, 4);
        this.enemigode = new Imagen("src/Imagenes/Nave.png", 50, 50, 0, 800-30, 100, Color.blue, Color.green, true, false, 5);
        //Imagen bla = new Imagen("src/Imagenes/rocket-league.png", 60, 60, 600, 300, 100000000, false, false, 0);
        //this.lienzo1.getFiguras().add(bla);
        this.lienzo1.setSize(1900,1000);
        
        this.lienzo1.getFiguras().add(nave);
        this.lienzo1.getFiguras().add(enemigo1);
        this.lienzo1.getFiguras().add(enemigoiz);
        this.lienzo1.getFiguras().add(enemigode);
        this.lienzo1.getFiguras().add(this.player);
        this.lienzo1.getFiguras().add(bala);
        proceso = new Thread(this.lienzo1);
        this.lienzo1.setJugando(true);
        proceso.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo1 = new claseprimitivasgraficas.Lienzo();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1920, 1080));
        setPreferredSize(new java.awt.Dimension(800, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lienzo1.setBackground(new java.awt.Color(255, 255, 255));
        lienzo1.setForeground(new java.awt.Color(255, 255, 255));
        lienzo1.setAlignmentX(0.0F);
        lienzo1.setAlignmentY(0.0F);
        lienzo1.setPreferredSize(new java.awt.Dimension(1600, 900));

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1600, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 788, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lienzo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 741, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
        this.setFocusable(true);
        
        if(evt.getKeyChar()=='a'){
            this.player.setX(this.player.getX()-20);
            if(this.lienzo1.isArriba() == false){
                this.bala.setX(this.bala.getX()-20);
            }
        }else if(evt.getKeyChar()=='d'){
            this.player.setX(this.player.getX()+20);
            if(this.lienzo1.isArriba() == false){
                this.bala.setX(this.bala.getX()+20);
            }
        }else if(evt.getKeyChar()=='i'){
            this.lienzo1.setArriba(true);
            this.lienzo1.setIzquierda(false);
            this.lienzo1.setDerecha(false);
        }else if(evt.getKeyChar()=='j'){
            this.lienzo1.setIzquierda(true);
            this.lienzo1.setArriba(false);
            this.lienzo1.setDerecha(false);
        }else if(evt.getKeyChar()=='l'){
            this.lienzo1.setIzquierda(false);
            this.lienzo1.setArriba(false);
            this.lienzo1.setDerecha(true);
        }
        else if(evt.getKeyCode()==27){
            c++;
            if(c==1){
                this.proceso.suspend();
                c++;
            }else if(c >1){
                this.proceso.resume();
                c=0;
            }
        }
        System.out.println("Codigo: "+ evt.getKeyCode());
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private claseprimitivasgraficas.Lienzo lienzo1;
    // End of variables declaration//GEN-END:variables
}
