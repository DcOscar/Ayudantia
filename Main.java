/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infinitygame;
import java.util.*;
/**
 * 
 * @author Oscar
 */
public class Main {
    
   public static void main(String[]args){
   ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    Tablero t= new Tablero();
    InfinityGame game= new InfinityGame();
     Scanner teclado= new Scanner(System.in);  
     int nJugadores;
     int largoTablero;
     int cantidadJugadores;
     int turno=0;
     int posicion;
     boolean condicionJuego= true;
    System.out.println("Bienvenidos a Infinity Game\n");
    System.out.println("Indique la cantidad de jugadores");
    cantidadJugadores= game.cantidadJugadores();
    game.agregarJugadores(jugadores, cantidadJugadores);
  t.leerLargoTablero();
  t.generarTablero();
  t.mostrarTablero();
  largoTablero= t.getLargoTablero();
  game.mostrarJugadores(jugadores, cantidadJugadores);
 do{
    
  for(int indice=0; indice<cantidadJugadores; indice++){
   t.mostrarTablero();
  System.out.println(jugadores.get(indice).getNombre()+" es su turno");
  game.elegirJugada(jugadores, indice);
  posicion= jugadores.get(indice).getPosicion();
  game.casillaOpcion(t.casillas,jugadores,indice,largoTablero,cantidadJugadores,posicion,condicionJuego);
  cantidadJugadores= game.cantidadJugadores();   
     
     
  }
     
     
     
turno++; }while(condicionJuego==false);
    
   
   
   
   
   }

}
