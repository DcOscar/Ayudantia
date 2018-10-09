/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infinitygame;
import java.util.*;

public class Tablero {
 public ArrayList<Character> casillas;
 private int largoTablero;
 private int verificarDato;

    public Tablero() {
        
        this.casillas = new ArrayList<Character>();
    }
public void generarTablero(){
    
        for (int i = 1; i < this.largoTablero; i++) {
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
    this.casillas.add(this.largoTablero, 'F');
}
        
        public void mostrarTablero(){
        System.out.println(this.casillas);}
    
public void leerLargoTablero(){
    do{  
 
System.out.println("Ingrese el largo del tablero, minimo 20 casillas");
this.largoTablero= leerDato(); }while(this.largoTablero<19);
    
}
public void setLargoTablero(int cambio){
    this.largoTablero=cambio;
}
public int leerDato(){
  Scanner leer= new Scanner(System.in);
  do{
    try{
        this.verificarDato= leer.nextInt();
        break;
 }
  catch(Exception e){
  System.out.println("error, ingresa nuevamente un dato");
  leer.nextLine();}
}while(true);
  
  return this.verificarDato;
  }


public int getLargoTablero(){
return this.casillas.size();}


}