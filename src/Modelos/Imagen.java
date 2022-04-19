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
public class Imagen extends FiguraEstandar{
    private String ruta;
    private int ancho;
    private int alto;

    public Imagen(String ruta, int ancho, int alto, int x, int y, int vida, Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
        super(x, y, vida, borde, colorRelleno, direccionX, direccionY, maquina);
        this.ruta = ruta;
        this.ancho = ancho;
        this.alto = alto;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the ancho
     */
    public int getAncho() {
        return ancho;
    }

    /**
     * @param ancho the ancho to set
     */
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    /**
     * @return the alto
     */
    public int getAlto() {
        return alto;
    }

    /**
     * @param alto the alto to set
     */
    public void setAlto(int alto) {
        this.alto = alto;
    }

    @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.ancho, this.alto);
        this.setArea(area);
    }
    
}
