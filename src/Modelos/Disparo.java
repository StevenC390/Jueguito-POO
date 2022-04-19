/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.awt.Color;

/**
 *
 * @author User
 */
public class Disparo extends Cuadrado{
    private int daño;

    public Disparo() {
    }

    public Disparo(int daño) {
        this.daño = daño;
    }

    public Disparo(int daño, int lado, int x, int y, int vida, Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
        super(lado, x, y, vida, borde, colorRelleno, direccionX, direccionY, maquina);
        this.daño = daño;
    }

    

    

    

    

    /**
     * @return the daño
     */
    public int getDaño() {
        return daño;
    }

    /**
     * @param daño the daño to set
     */
    public void setDaño(int daño) {
        this.daño = daño;
    }
    
    
}
