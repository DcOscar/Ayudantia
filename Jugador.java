/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infinitygame;
import java.util.*;

public class Jugador {
 
  public ArrayList<Integer> saludJugadores;
  private ArrayList<String> nombreJugadores;
  public ArrayList<Integer> posicionJugadores;
  private String nombreJugador;
  
  public Jugador(){
        this.posicionJugadores = new ArrayList<Integer>();
        this.nombreJugadores = new ArrayList<String>();
        this.saludJugadores = new ArrayList<Integer>();
  }
  
 public void jugadores(int cJugadores){
 
     for(int i=0; i<cJugadores; i++){
    leerNombre();
    this.nombreJugadores.add(this.nombreJugador); 
     this.posicionJugadores.add(1);
     this.saludJugadores.add(15);
     System.out.println("Jugador agregado\n");}
         
         
 }
 private void leerNombre(){
  System.out.println("Diga un nombre");
 Scanner teclado= new Scanner(System.in);
 this.nombreJugador= teclado.next(); }

public String getNombre(int indice){
return this.nombreJugadores.get(indice);}

 public int getPosicion(int indice){
return this.posicionJugadores.get(indice); }
 
 public int getSalud(int indice){
 return this.saludJugadores.get(indice);}
 
 public void mostrarJugadores(int cJugadores){
 for(int i=0; i<cJugadores; i++){
 System.out.println((i+1)+ ": "+"Nombre jugador: "+ this.nombreJugadores.get(i) );}}
}




