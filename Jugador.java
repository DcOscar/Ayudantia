/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import java.util.*;

public class Jugador {

    private int salud;
    private int posicion;
    private String nombre;
    private int meditar;
    private boolean reliquia;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.posicion = 0;
        this.salud = 15;
        this.meditar = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPosicion() {
        return this.posicion;
    }

    public int getSalud() {
        return this.salud;
    }

    public void setPosicion(int cambio) {
        this.posicion += cambio;
    }

    public void setSalud(int cambio) {
        this.salud += cambio;
    }

    public void setSaludExtremos(int cambio) {
        this.salud = cambio;
    }

    public void setPosicionExtremos(int cambio) {
        this.posicion = cambio;
    }

    public void setMeditar(int cambio) {
        this.meditar++;
        this.posicion += cambio;
    }

    public int getMeditar() {
        return this.meditar;
    }

    public void estadoJugador() {
        System.out.println("Jugador: " + this.nombre + ", posicion: " + (this.posicion + 1) + ", salud:  " + this.salud);
    }

    public void addMeditar() {
        this.meditar = -1;
    }
}
