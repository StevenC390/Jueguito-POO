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
public abstract class FiguraGeometrica {

    /**
     * @return the maquina
     */


    /**
     * @return the area
     */
    public Rectangle getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Rectangle area) {
        this.area = area;
    }
    private Color borde;
    private Color colorRelleno;
    private boolean direccionX;
    private boolean direccionY;
    private int maquina;
    private Rectangle area;

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
        this.borde = borde;
        this.colorRelleno = colorRelleno;
        this.direccionX = direccionX;
        this.direccionY = direccionY;
        this.maquina = maquina;
        this.area = null;
    }

    public abstract void actualizarArea();

    

    /**
     * @return the borde
     */
    public Color getBorde() {
        return borde;
    }

    /**
     * @param borde the borde to set
     */
    public void setBorde(Color borde) {
        this.borde = borde;
    }

    /**
     * @return the colorRelleno
     */
    public Color getColorRelleno() {
        return colorRelleno;
    }

    /**
     * @param colorRelleno the colorRelleno to set
     */
    public void setColorRelleno(Color colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    /**
     * @return the direccionX
     */
    public boolean isDireccionX() {
        return direccionX;
    }

    /**
     * @param direccionX the direccionX to set
     */
    public void setDireccionX(boolean direccionX) {
        this.direccionX = direccionX;
    }

    /**
     * @return the direccionY
     */
    public boolean isDireccionY() {
        return direccionY;
    }

    /**
     * @param direccionY the direccionY to set
     */
    public void setDireccionY(boolean direccionY) {
        this.direccionY = direccionY;
    }

    /**
     * @return the maquina
     */
    public int getMaquina() {
        return maquina;
    }

    /**
     * @param maquina the maquina to set
     */
    public void setMaquina(int maquina) {
        this.maquina = maquina;
    }
     
}
