/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infinitygame;
import java.util.*;

public class Tablero {
 public ArrayList<Character> casillas;

    public Tablero() {
        this.casillas = new ArrayList<Character>();
    }
public void generarTablero(int largoTablero){
 
        for (int i = 1; i < largoTablero; i++) {
            int casillaAzar = (int) (Math.random() * 3);
           switch(casillaAzar) {
               case 0:
                this.casillas.add('b') ;
                break;
               case 1:
                this.casillas.add('p');
                break;
               case 2:
                this.casillas.add('s');
                break;
               case 3:
              this.casillas.add('d');
              break;
            } }
        this. casillas.add(0, 'I'); 
    this.casillas.add(largoTablero, 'F');
}
        
        public void mostrarTablero(){
        System.out.println(this.casillas);}
    
}


