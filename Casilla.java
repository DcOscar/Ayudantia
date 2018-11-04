/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

/**
 *
 * @author Oscar
 */
public class Casilla {

    private char casilla;

    public Casilla() {
        int casillaAzar = (int) (Math.random() * 3);
        switch (casillaAzar) {
            case 0:
                this.casilla = 'b';
                break;
            case 1:
                this.casilla = 'p';
                break;
            case 2:
                this.casilla = 's';
                break;
            case 3:
                this.casilla = 'd';
                break;
            default:
                break;
        }
    }

    public char getCasilla() {
        return this.casilla;
    }

}
