/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.awt.Color;

/**
 *
 * @author Steven
 */
public class Enemigo extends Cuadrado{
    private int daño;

    public Enemigo() {
    }

    public Enemigo(int daño) {
        this.daño = daño;
    }

    public Enemigo(int daño, int lado, int x, int y, int vida, Color borde, Color colorRelleno, boolean direccionX, boolean direccionY, int maquina) {
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
