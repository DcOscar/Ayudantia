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
public class Guardian {
    private int saludGuardian;
    public Guardian(ArrayList<Jugador> jugadores){
      for(int i=0; i<jugadores.size(); i++){
          this.saludGuardian+= jugadores.get(i).getSalud();
      }
      System.out.println("La salud del guardian es de "+this.saludGuardian);
    }
    
    public void furiaGuardian(ArrayList<Jugador> jugadores){
    for(int i=0; i<jugadores.size(); i++){
    jugadores.get(i).setSalud(-1);
    if(jugadores.get(i).getSalud()<=0){
    jugadores.remove(i);}}
    this.saludGuardian+=2;
    
    }
   public void lanzarDadosGuardian(ArrayList<Jugador> jugadores, int indice, int x, int turno){
   this.saludGuardian-=x;
   System.out.println("Has dañado en "+x+" puntos de salud al guardian");
   if(this.saludGuardian<=0){
       System.out.println("El jugador "+jugadores.get(indice).getNombre()+" ha ganado en el turno "+turno);
       System.exit(0);
   }
   }
  public int getSaludGuardian(){
  return this.saludGuardian;}
  
}
