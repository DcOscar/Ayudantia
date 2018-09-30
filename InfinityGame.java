/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;
import java.util.*;


public class InfinityGame {
     

    public static void main(String[] args){
     
    Jugador j= new Jugador();
    Tablero t= new Tablero();
     Scanner teclado= new Scanner(System.in);  
     int nJugadores;
     int largoTablero;
    System.out.println("Bienvenidos a Infinity Game\n");
    do{
    System.out.println("Ingrese la cantidad de Jugadores:");
    nJugadores= teclado.nextInt(); }while(nJugadores<0);
    j.jugadores(nJugadores);
    j.mostrarJugadores(nJugadores);
 do{
    System.out.println("Ingrese la cantidad de casillas del tablero(minimo 20 casillas):");
    largoTablero= teclado.nextInt()-1; }while(largoTablero<19);
    t.generarTablero(largoTablero);
    t.mostrarTablero();
   System.out.println("Juego en mantención");
    }
   public  int lanzarDados() {
        int numeroAleatorio = (int) (Math.random() * 10 + 2);
        return numeroAleatorio;
    }
    
public static void casillaDesafio(ArrayList<Integer> saludJugadores, ArrayList<Integer> posicionJugadores, int indice, int nJugadores ){
    int posibilidad= (int)(Math.random()*2); //"0" se puede avanzar o retroceder, "1" gana o pierde vida
    int azar= (int)(Math.random()*2); // 0= perder vida o retroceder, 1 ganar vida o avanzar
    int mover= (int)(Math.random()*5+1);
    int salud= (int)(Math.random()*4+1);
    
    if(posibilidad==0){
    
    if(azar==0){
       posicionJugadores.set(indice, posicionJugadores.get(indice)-mover);
   
    }
    else if (azar==1){
        posicionJugadores.set(indice, posicionJugadores.get(indice)+mover);
    }
    }
    else if(posibilidad==1){
        if(azar==0){
        for(int i=0; i<nJugadores; i++){
        saludJugadores.set(i,saludJugadores.get(i)-salud);
        }
        saludJugadores.set(indice, saludJugadores.get(indice)+salud);
        }
  
        else if(azar==1){
        for(int i=0; i<nJugadores; i++){
        saludJugadores.set(i,saludJugadores.get(i)+salud);
        }
        saludJugadores.set(indice, saludJugadores.get(indice)-salud);
        }
   
    }
    }
public void extremosSalud(ArrayList<Integer> saludJugadores, int nJugadores){
         for(int i=0; i<nJugadores; i++){
        if(saludJugadores.get(i)>15){
        saludJugadores.set(i,15);}
        
         if(saludJugadores.get(i)<0){
          saludJugadores.set(i,0);
         }}}
public void extremosPosiciones(ArrayList<Integer> posicionJugadores, int nJugadores, int largoTablero){
     for(int i=0; i<nJugadores; i++){
        if(posicionJugadores.get(i)>largoTablero){
        posicionJugadores.set(i,largoTablero);}
        
         if(posicionJugadores.get(i)<0){
          posicionJugadores.set(i,0);
         }}
}

public void casillaPortal(ArrayList<Integer> posicionJugadores, ArrayList<Character> casillas, int posicionTablero, int largoTablero, int nJugador){
   
   nJugador=-1;
    int mover= (int)(Math.random()*1); // 0= se mueve en busca de otra casilla portal hacia atras, 1= se mueve en busca de otra casilla portal hacia adelante
   
    if(mover==0){
        
    for(int i= posicionTablero-1; i>0; i--){
    if(casillas.get(i)=='p'){
    posicionJugadores.set(nJugador, i);
    
    break;}}
    
    }
    else{
    for(int i= posicionTablero+1; i<largoTablero; i++){
    if(casillas.get(i)=='p'){
    posicionJugadores.set(nJugador,i);
   
    
    break;}
    }}
}
public void casillaSalud(ArrayList<Integer> saludJugadores, int indice){
int azar= (int)(Math.random()*2);
int salud= (int)(Math.random()*3+1);
if(azar==0){
 saludJugadores.set(indice, saludJugadores.get(indice)+salud); // obtiene entre 1 y 3 de vida   
}
else if(azar==1){
saludJugadores.set(indice, saludJugadores.get(indice)-salud); // obtiene entre 1 y 3 de vida
}}
}
