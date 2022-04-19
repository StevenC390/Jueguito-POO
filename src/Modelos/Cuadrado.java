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
public class Cuadrado extends FiguraEstandar{
    private int lado;

    public Cuadrado() {
        super(0, 0,0, null, null,true,true,0);
    }

    public Cuadrado(int lado, int x, int y, int vida, Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
        super(x, y, vida, borde, colorRelleno, direccionX, direccionY, maquina);
        this.lado = lado;
    }

    /**
     * @return the lado
     */
    public int getLado() {
        return lado;
    }

    /**
     * @param lado the lado to set
     */
    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.getLado(), this.getLado());
        this.setArea(area);
    }

    
    
}
