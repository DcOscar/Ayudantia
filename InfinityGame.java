/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;
import java.util.*;


public class InfinityGame {
     int verificarDato;

   public int lanzarDados() {
        int numeroAleatorio = (int) (Math.random() * 10 + 2);
        return numeroAleatorio;
    }
   public void meditar(ArrayList<Jugador> jugadores, int indice){
     int mover;
     int cantidadMeditar;
     cantidadMeditar= jugadores.get(indice).getMeditar();
     if(cantidadMeditar>5){
     jugadores.get(indice).setSalud(-1);}
     else{
     do{
       mover= leerDato();
   System.out.println("Puede moverse dentro de 3 casillas a la redonda, indique cuantas casillas se movera");
     }while(mover>3 && mover<-3);
     jugadores.get(indice).setMeditar(mover);
     jugadores.get(indice).setSalud(1);
   }}
   public  int cantidadJugadores(){
   int cantidadJugadores;
   do{
   cantidadJugadores=leerDato();
   }while(cantidadJugadores<1);
   return cantidadJugadores;}
   
   public void casillaFinal(ArrayList<Jugador> jugadores, int indice, int largoTablero){
   int posicion;
   posicion= jugadores.get(indice).getPosicion();
   if(posicion==largoTablero){
   System.out.println("Ganó el jugador n°"+indice+1);}
   }
   
   public void agregarJugadores(ArrayList<Jugador>jugadores,int cantidadJugadores){
      String nombreJugador;
     for(int i=0; i<cantidadJugadores; i++){
     nombreJugador= asignarNombre();   
     jugadores.add(new Jugador(nombreJugador));}
   }
   public int leerCantidadJugadores(){
    int cantidadJugadores;
   Scanner teclado= new Scanner(System.in);
   cantidadJugadores= teclado.nextInt();
   return cantidadJugadores;
   }
   public String asignarNombre(){
     String nombreJugador;
    Scanner teclado= new Scanner(System.in);
   System.out.println("Diga un nombre de jugador");
   nombreJugador= teclado.next();
   return nombreJugador;
   }
   public void mostrarJugadores(ArrayList<Jugador>jugadores,int cantidadJugadores){
       String nombre;
       int salud;
       int posicion;
      for(int i=0; i<cantidadJugadores; i++){
     nombre= jugadores.get(i).getNombre();
     salud=jugadores.get(i).getSalud();
     posicion= jugadores.get(i).getPosicion();
      System.out.println((i+1)+"- "+nombre+", salud: "+salud+", posición: "+posicion);}
   }
public void casillaDesafio(ArrayList<Jugador>jugadores,int indice, int nJugadores ){
    int posibilidad= (int)(Math.random()*2); //"0" se puede avanzar o retroceder, "1" gana o pierde vida
    int azar= (int)(Math.random()*2); // 0= perder vida o retroceder, 1 ganar vida o avanzar
    int obtenerSalud;
    int perderSalud;
    int retroceder;
    int avanzar;
System.out.println("Entro en una casilla desafio");
    if(posibilidad==0){
      avanzar= (int)(Math.random()*5+1);
      retroceder= -avanzar;
    if(azar==0){
      jugadores.get(indice).setPosicion(retroceder);
   
    }
    else if (azar==1){
          jugadores.get(indice).setPosicion(avanzar);
    }
    }
    else if(posibilidad==1){
       obtenerSalud= (int)(Math.random()*4+1);
       perderSalud= -obtenerSalud;
        if(azar==0){
        for(int i=0; i<nJugadores; i++){
         jugadores.get(i).setSalud(perderSalud);
        }
        jugadores.get(indice).setSalud(obtenerSalud);
        }
  
        else if(azar==1){
        for(int i=0; i<nJugadores; i++){
        jugadores.get(i).setSalud(obtenerSalud);
        }
        jugadores.get(indice).setSalud(perderSalud);
        }
   
    }
    }
public  void extremosSalud(ArrayList<Jugador> jugadores, int nJugadores){
         for(int i=0; i<nJugadores; i++){
        if(jugadores.get(i).getSalud()>15){
        jugadores.get(i).setSaludExtremos(15);}
        
         if(jugadores.get(i).getSalud()<0){
           
          jugadores.get(i).setSaludExtremos(0);
          System.out.println("El jugador n°"+i+1+"a perdido todas sus vidas, por lo tanto dejará de jugar");
          jugadores.remove(i);
         }}}
public void extremosPosiciones(ArrayList<Jugador> jugadores, int nJugadores, int largoTablero){
     for(int i=0; i<nJugadores; i++){
        if(jugadores.get(i).getPosicion()>largoTablero){
        jugadores.get(i).setPosicionExtremos(largoTablero);}
        
         if(jugadores.get(i).getPosicion()<0){
          jugadores.get(i).setPosicionExtremos(0);
         }}
}

public void casillaPortal(ArrayList<Jugador> jugadores,ArrayList<Character> casillas, int largoTablero, int indice, int posicion){
  ArrayList<Integer> posicionPortales= new ArrayList<Integer>();
  int portalAzar;
  int aux=-1; 
  System.out.println("Entro en una casilla portal");
   for(int i=0; i<largoTablero; i++){
   if(casillas.get(i).equals('p')){  //cada vez que encuentra una casilla portal, agrega su posicion a un array
   posicionPortales.add(i);
   aux++;
   if(i==posicion){
   posicionPortales.remove(aux);}}   // se elimina la posicion actual, en la suposicion de que es una casilla portal 
   }
   portalAzar= (int)(Math.random()*posicionPortales.size());   
   System.out.println("portal azar "+portalAzar);    
  jugadores.get(indice).setPosicionExtremos(posicionPortales.get(portalAzar)); //se cambia de posicion a un portal aleatorio
  
}
public  void casillaSalud(ArrayList<Jugador> jugadores, int indice){
int azar= (int)(Math.random()*2);
int obtenerSalud= (int)(Math.random()*3+1);
int perderSalud= -obtenerSalud;
System.out.println("Entro en una casilla salud");
if(azar==0){
 jugadores.get(indice).setSalud(obtenerSalud); //obtiene entre 1 y 3 de vida
}
else{
 jugadores.get(indice).setSalud(perderSalud);

}}
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

public void elegirJugada(ArrayList<Jugador> jugadores, int indice){
 int opcion;
System.out.println("1-Lanzar dados");
System.out.println("2-Meditar");
System.out.println("Elija una opción");
do{
       opcion= leerDato();
     }while(opcion<0 && opcion>3);
if(opcion==1){
        lanzarDados();
}
else if(opcion==2)
        meditar(jugadores, indice);
        
}


public void casillaOpcion(ArrayList<Character> casillas, ArrayList<Jugador> jugadores, int indice, int largoTablero, int cantidadJugadores, int posicion, boolean condicion){
    extremosSalud(jugadores, cantidadJugadores);
    extremosPosiciones(jugadores, cantidadJugadores, largoTablero);
    switch(casillas.get(posicion)){
        case 'p':
            casillaPortal(jugadores, casillas,largoTablero, indice, posicion);
            break;
        case 's':
            casillaSalud(jugadores,indice);
            break;
        case 'd':
            casillaDesafio(jugadores, indice, cantidadJugadores);
            break;
        case 'b':
            System.out.println("Entro en una casilla en blanco");
            break;
        case 'I':
            break;
            case'F':
                casillaFinal(jugadores, indice, largoTablero);
                condicion= false;
                break;
    
    }
    extremosSalud(jugadores, cantidadJugadores);
    extremosPosiciones(jugadores, cantidadJugadores, largoTablero);
    
}

}
