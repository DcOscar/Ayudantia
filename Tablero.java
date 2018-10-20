/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infinitygame;
import java.util.*;

public class Tablero {
 private ArrayList<Character> casillas;
 private int largoTablero;
 

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
this.largoTablero= leerDato(); }while(this.largoTablero<20);
this.largoTablero--;
    
}
public void setLargoTablero(int cambio){
    this.largoTablero=cambio;
}
private int leerDato(){
    int verificarDato;
  Scanner leer= new Scanner(System.in);
  do{
    try{
        verificarDato= leer.nextInt();
        break;
 }
  catch(Exception e){
  System.out.println("error, ingresa nuevamente un dato");
  leer.nextLine();}
}while(true);
  
  return verificarDato;
  }


public int getLargoTablero(){
return this.casillas.size();}

public ArrayList getCasillas(){
return this.casillas;}
}