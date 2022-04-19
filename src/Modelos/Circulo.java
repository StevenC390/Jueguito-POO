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
public class Circulo extends FiguraEstandar{
    private int radio;

    public Circulo() {
        super(0, 0,0, null, null, true, true,0);
    }

    public Circulo(int radio, int x, int y, int vida, boolean direccionX, boolean direccionY, int maquina) {
        super(x, y, vida, direccionX, direccionY, maquina);
        this.radio = radio;
    }


    

    

    

    

    /**
     * @return the radio
     */
    public int getRadio() {
        return radio;
    }

    /**
     * @param radio the radio to set
     */
    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public void actualizarArea() {
        Rectangle area=new Rectangle(this.getX(), this.getY(), this.radio*2, this.radio*2);
        this.setArea(area);
    }
    
}
