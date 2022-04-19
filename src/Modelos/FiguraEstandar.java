/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author pipet
 */
public abstract class FiguraEstandar extends FiguraGeometrica{
    private int x;
    private int y;
    private int vida;

    public FiguraEstandar(int x, int y, int vida, Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
        super(borde, colorRelleno, direccionX, direccionY, maquina);
        this.x = x;
        this.y = y;
        this.vida = vida;
    }

    
    
    public FiguraEstandar(int x, int y,int vida, boolean direccionX, boolean direccionY,int maquina) {
        super(null, null,direccionX,direccionY,maquina);
        this.x = x;
        this.y = y;
    }
    
    

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * @param vida the vida to set
     */
    public void setVida(int vida) {
        this.vida = vida;
    }
}
