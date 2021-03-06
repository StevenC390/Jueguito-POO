/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseprimitivasgraficas;

import Modelos.Circulo;
import Modelos.Cuadrado;
import Modelos.Disparo;
import Modelos.FiguraEstandar;
import Modelos.FiguraGeometrica;
import Modelos.Imagen;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author pipet
 */
public class Lienzo extends javax.swing.JPanel implements Runnable {

    private LinkedList<FiguraGeometrica> figuras;
    private boolean jugando;
    private int xp;
    private int yp;
    private int xn;
    private int yn;
    private int vidaBoss;
    int vidaPlayer;
    private boolean izquierda;
    private boolean derecha;
    private boolean arriba;
    boolean yaiz;
    boolean yade;
    boolean ya = false;
    boolean saliriz = false;
    boolean salirde = false;
    int c = 0;

    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        this.figuras = new LinkedList<>();
        this.jugando = false;
        this.vidaBoss = 10000;
        this.vidaPlayer = 500;
        this.yade = false;
        this.yaiz = false;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarFiguras(g);
    }

    public void dibujarFiguras(Graphics g) {
        for (FiguraGeometrica estaFigura : this.getFiguras()) {
            if (estaFigura instanceof Cuadrado) {
                dibujarCuadrado(g, (Cuadrado) estaFigura);
            } else if (estaFigura instanceof Circulo) {
                dibujarCirculo(g, (Circulo) estaFigura);
            } else if (estaFigura instanceof Imagen) {
                dibujarImagen(g, (Imagen) estaFigura);
            }
        }
        g.drawString("Vida Nave = " + this.getVidaBoss(), 1400, 120);
        g.drawString("Vida Player = " + this.vidaPlayer, 120, 120);
    }

    public void dibujarCuadrado(Graphics g, Cuadrado square) {
        g.setColor(square.getColorRelleno());
        g.fillRect(square.getX(), square.getY(), square.getLado(), square.getLado());
        g.setColor(square.getBorde());
        g.drawRect(square.getX(), square.getY(), square.getLado(), square.getLado());
    }

    public void dibujarCirculo(Graphics g, Circulo elCirculo) {
        g.setColor(elCirculo.getColorRelleno());
        g.fillOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
        g.setColor(elCirculo.getBorde());
        g.drawOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
    }

    public void dibujarImagen(Graphics g, Imagen laImagen) {
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(laImagen.getRuta());
        g.drawImage(imagen, laImagen.getX(), laImagen.getY(), laImagen.getAncho(), laImagen.getAlto(), this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(640, 360));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return the figuras
     */
    public LinkedList<FiguraGeometrica> getFiguras() {
        return figuras;
    }

    /**
     * @param figuras the figuras to set
     */
    public void setFiguras(LinkedList<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }

    @Override
    public void run() {

        while (this.isJugando()) {
            actualizarareas();
            for (FiguraGeometrica actual : this.getFiguras()) {
                if (actual instanceof Disparo && actual.getMaquina() == 2) {
                    operacionBalasPlayer((Disparo) actual);
                }
                if (actual instanceof FiguraEstandar) {
                    if (actual.getMaquina() == 0) {
                        operacionNaveBoss((FiguraEstandar) actual);
                    } else if (actual.getMaquina() == 1) {
                        this.setXp(sacarposicionactual((FiguraEstandar) actual, false));
                        this.setYp(sacarposicionactual((FiguraEstandar) actual, true));
                        calcularVidaPlayer((FiguraEstandar) actual);
                    } else if (actual.getMaquina() == 4) {
                        operacionEnemigoDerecha((FiguraEstandar) actual);
                    } else if (actual.getMaquina() == 5) {
                        operacionEnemigoIzquierda((FiguraEstandar) actual);
                    }
                    operacionBalaEnemiga((FiguraEstandar) actual);
                    actual.actualizarArea();
                    repaint();
                    esperar(2);
                }

            }
        }
    }

    public void operacionBalasPlayer(Disparo actual) {
        if (isArriba() == true) {
            ((Disparo) actual).setY(((Disparo) actual).getY() - 35);
            fronterasbala((Disparo) actual);
        } else if (isIzquierda() == true) {
            ((Disparo) actual).setX(((Disparo) actual).getX() - 35);
            fronterasbala((Disparo) actual);
        } else if (isDerecha() == true) {
            ((Disparo) actual).setX(((Disparo) actual).getX() + 35);
            fronterasbala((Disparo) actual);
        }
    }

    public void operacionNaveBoss(FiguraEstandar actual) {
        if (((FiguraEstandar) actual).getX() == 400 || ((FiguraEstandar) actual).getX() == 1200) {
            ya = true;
        }
        this.setXn(sacarposicionactual((FiguraEstandar) actual, false));
        this.setYn(sacarposicionactual((FiguraEstandar) actual, true));
        if (actual.isDireccionX()) {
            ((FiguraEstandar) actual).setX(((FiguraEstandar) actual).getX() + 5);
        } else {
            ((FiguraEstandar) actual).setX(((FiguraEstandar) actual).getX() - 5);
        }
        validarFronteras((FiguraEstandar) actual);
        if (verificarColisiones(actual)) {
            ((FiguraEstandar) actual).setVida(((FiguraEstandar) actual).getVida() - 25);
            this.setVidaBoss(((FiguraEstandar) actual).getVida());
            ((FiguraEstandar) actual).setVida(this.getVidaBoss());
            if (((FiguraEstandar) actual).getVida() == 0) {
                this.setJugando(false);
                JOptionPane.showMessageDialog(this, "Ganaste bro");
            }
        }
    }

    public void calcularVidaPlayer(FiguraEstandar actual) {
        if (verificarColisiones(actual)) {
            ((FiguraEstandar) actual).setVida(((FiguraEstandar) actual).getVida() - 10);
            this.vidaPlayer = (((FiguraEstandar) actual).getVida());
            ((FiguraEstandar) actual).setVida(this.vidaPlayer);
            if (((FiguraEstandar) actual).getVida() == 0) {
                this.setJugando(false);
                JOptionPane.showMessageDialog(this, "Perdiste bro");
            }
        }
    }

    public void operacionEnemigoIzquierda(FiguraEstandar actual) {
        if (this.yade && actual.isDireccionX()) {
            if (salirde == true) {
                ((FiguraEstandar) actual).setVida(100);
            }
            ((FiguraEstandar) actual).setX(((FiguraEstandar) actual).getX() + 8);
            if (verificarColisiones(actual)) {
                System.out.println(((FiguraEstandar) actual).getVida());
                ((FiguraEstandar) actual).setVida(((FiguraEstandar) actual).getVida() - 25);
                salirde = false;
                if (((FiguraEstandar) actual).getVida() <= 0) {
                    yade = false;
                    salirde = true;
                }
            }
        } else if (yade == false) {
            ((FiguraEstandar) actual).setX(0);
        }
    }

    public void operacionEnemigoDerecha(FiguraEstandar actual) {
        if (this.yaiz && actual.isDireccionX()) {
            if (saliriz == true) {
                ((FiguraEstandar) actual).setVida(100);
            }
            ((FiguraEstandar) actual).setX(((FiguraEstandar) actual).getX() - 8);
            if (verificarColisiones(actual)) {
                System.out.println(((FiguraEstandar) actual).getVida());
                ((FiguraEstandar) actual).setVida(((FiguraEstandar) actual).getVida() - 25);
                saliriz = false;
                if (((FiguraEstandar) actual).getVida() <= 0) {
                    yaiz = false;
                    saliriz = true;
                }
            }
        } else if (yaiz == false) {
            ((FiguraEstandar) actual).setX(1600 - 50);
        }
    }

    public void operacionBalaEnemiga(FiguraEstandar actual) {
        if (actual.getMaquina() == 3) {
            if (ya == false) {
                ((FiguraEstandar) actual).setX(xn);
            } else {
                ((Disparo) actual).setY(((Disparo) actual).getY() + 8);
                if (fronterasbalaNave((Disparo) actual)) {
                    ya = false;
                    ((FiguraEstandar) actual).setY(this.yn + 100);
                }
            }
            if (verificarColisiones((FiguraEstandar) actual)) {
                ((FiguraEstandar) actual).setVida(((FiguraEstandar) actual).getVida() - 25);
                if (((FiguraEstandar) actual).getVida() == 0) {
                    ((FiguraEstandar) actual).setY(this.yn + 100);
                    ya = false;
                }
            }
        }
    }

    public void actualizarareas() {
        for (FiguraGeometrica actual : this.getFiguras()) {
            actual.actualizarArea();
        }
    }

    public int sacarposicionactual(FiguraEstandar este, boolean xoy) {
        int posx = este.getX();
        int posy = este.getY();
        if (xoy == false) {
            return posx;
        } else {
            return posy;
        }
    }

    public void fronterasbala(Disparo laFigura) {
        if (laFigura.getY() <= 0) {
            laFigura.setY(this.getYp() - 15);
            laFigura.setX(this.getXp() + 5);
        } else if (laFigura.getX() <= 0) {
            laFigura.setY(this.getYp() - 15);
            laFigura.setX(this.getXp() + 5);
        } else if (laFigura.getX() > 1600) {
            laFigura.setY(this.getYp() - 15);
            laFigura.setX(this.getXp() + 5);
        }
    }

    public boolean fronterasbalaNave(Disparo laFigura) {
        boolean si = false;
        if (laFigura.getY() > 900) {
            laFigura.setY(yp + 100);
            si = true;
        }
        return si;
    }

    public void validarFronteras(FiguraEstandar laFigura) {
        if (laFigura.getX() + 30 >= 1550) {
            laFigura.setDireccionX(false);
            yaiz = true;
            yade = false;
        } else if (laFigura.getX() <= 0) {
            laFigura.setDireccionX(true);
            yaiz = false;
            yade = true;
        }
        if (laFigura.getY() + 30 >= 900) {
            laFigura.setDireccionY(true);
        } else if (laFigura.getY() <= 0) {
            laFigura.setDireccionY(false);
        }
    }

    public void esperar(int ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

    public boolean verificarColisiones(FiguraGeometrica jugador) {
        boolean res = false;
        int i = 0;
        while (i < this.getFiguras().size() && !res) {
            if (jugador != this.getFiguras().get(i) && jugador.getArea().intersects(this.getFiguras().get(i).getArea())) {
                res = true;
            }
            i++;
        }
        return res;
    }

    /**
     * @return the jugando
     */
    public boolean isJugando() {
        return jugando;
    }

    /**
     * @param jugando the jugando to set
     */
    public void setJugando(boolean jugando) {
        this.jugando = jugando;
    }

    /**
     * @return the vidaBoss
     */
    public int getVidaBoss() {
        return vidaBoss;
    }

    /**
     * @param vidaBoss the vidaBoss to set
     */
    public void setVidaBoss(int vidaBoss) {
        this.vidaBoss = vidaBoss;
    }

    /**
     * @return the xp
     */
    public int getXp() {
        return xp;
    }

    /**
     * @param xp the xp to set
     */
    public void setXp(int xp) {
        this.xp = xp;
    }

    /**
     * @return the yp
     */
    public int getYp() {
        return yp;
    }

    /**
     * @param yp the yp to set
     */
    public void setYp(int yp) {
        this.yp = yp;
    }

    /**
     * @return the xn
     */
    public int getXn() {
        return xn;
    }

    /**
     * @param xn the xn to set
     */
    public void setXn(int xn) {
        this.xn = xn;
    }

    /**
     * @return the yn
     */
    public int getYn() {
        return yn;
    }

    /**
     * @param yn the yn to set
     */
    public void setYn(int yn) {
        this.yn = yn;
    }

    /**
     * @return the izquierda
     */
    public boolean isIzquierda() {
        return izquierda;
    }

    /**
     * @param izquierda the izquierda to set
     */
    public void setIzquierda(boolean izquierda) {
        this.izquierda = izquierda;
    }

    /**
     * @return the derecha
     */
    public boolean isDerecha() {
        return derecha;
    }

    /**
     * @param derecha the derecha to set
     */
    public void setDerecha(boolean derecha) {
        this.derecha = derecha;
    }

    /**
     * @return the arriba
     */
    public boolean isArriba() {
        return arriba;
    }

    /**
     * @param arriba the arriba to set
     */
    public void setArriba(boolean arriba) {
        this.arriba = arriba;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
