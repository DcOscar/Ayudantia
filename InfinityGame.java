/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;
import java.util.*;


public class InfinityGame {
     

   public int lanzarDados() {
        int numeroAleatorio = (int) (Math.random() * 10 + 2);
        return numeroAleatorio;
    }
   private void meditar(ArrayList<Jugador> jugadores, int indice, int largoTablero, int nJugadores){
     int mover;
     int cantidadMeditar;
     cantidadMeditar= jugadores.get(indice).getMeditar();
     if(cantidadMeditar>5){
     jugadores.get(indice).setSalud(-1);}
     else{
     do{
   System.out.println("Puede moverse dentro de 3 casillas a la redonda, indique cuantas casillas se movera");
   mover= leerDato();
     }while(mover>3 || mover<-3);
     jugadores.get(indice).setMeditar(mover);
     jugadores.get(indice).setSalud(1);
   }
   extremosPosiciones(jugadores, indice, largoTablero);
   extremosSalud(jugadores, nJugadores);}
   private int leerCantidadJugadores(){
   int cantidadJugadores;
   do{
   cantidadJugadores=leerDato();
   }while(cantidadJugadores<1);
   return cantidadJugadores;}
   
   private int jugadoresActivos(ArrayList<Jugador> jugadores){
  return jugadores.size(); }
   
   private void casillaFinal(ArrayList<Jugador> jugadores, int indice, int largoTablero){
   int posicion;
   posicion= jugadores.get(indice).getPosicion();
   if(posicion==largoTablero){
   System.out.println("Ganó el jugador n°"+indice+1);}
   }
   
   private void agregarJugadores(ArrayList<Jugador>jugadores,int cantidadJugadores){
      String nombreJugador;
     for(int i=0; i<cantidadJugadores; i++){
     nombreJugador= asignarNombre();   
     jugadores.add(new Jugador(nombreJugador));}
   }
 
   private String asignarNombre(){
     String nombreJugador;
    Scanner teclado= new Scanner(System.in);
   System.out.println("Diga un nombre de jugador");
   nombreJugador= teclado.next();
   return nombreJugador;
   }
   private void mostrarJugadores(ArrayList<Jugador>jugadores,int cantidadJugadores){
       String nombre;
       int salud;
       int posicion;
      for(int i=0; i<cantidadJugadores; i++){
     nombre= jugadores.get(i).getNombre();
     salud=jugadores.get(i).getSalud();
     posicion= jugadores.get(i).getPosicion();
      System.out.println((i+1)+"- "+nombre+", salud: "+salud+", posición: "+posicion);}
   }
private void casillaDesafio(ArrayList<Jugador>jugadores,int indice, int nJugadores, int largoTablero ){
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
    extremosSalud(jugadores,nJugadores);
    extremosPosiciones(jugadores, indice, largoTablero);
    }
private void extremosSalud(ArrayList<Jugador> jugadores, int nJugadores){
         for(int i=0; i<nJugadores; i++){
        if(jugadores.get(i).getSalud()>15){
        jugadores.get(i).setSaludExtremos(15);}
        
         if(jugadores.get(i).getSalud()<0){
           
          jugadores.get(i).setSaludExtremos(0);
          System.out.println("El jugador n°"+i+1+"a perdido todas sus vidas, por lo tanto dejará de jugar");
          jugadores.remove(i);
         }}}
private void extremosPosiciones(ArrayList<Jugador> jugadores, int indice, int largoTablero){
  
        if(jugadores.get(indice).getPosicion()>largoTablero){
        jugadores.get(indice).setPosicionExtremos(largoTablero);}
        
         if(jugadores.get(indice).getPosicion()<0){
          jugadores.get(indice).setPosicionExtremos(0);
         }
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
   posicionPortales.remove(aux);
   aux--;}}   // se elimina la posicion actual, en la suposicion de que es una casilla portal 
   }
   portalAzar= (int)(Math.random()*posicionPortales.size());   
  jugadores.get(indice).setPosicionExtremos(posicionPortales.get(portalAzar)); //se cambia de posicion a un portal aleatorio
  System.out.println("Se ha transportado a la casilla n°"+jugadores.get(indice).getPosicion());
  
}
public  void casillaSalud(ArrayList<Jugador> jugadores, int indice, int nJugadores){
int azar= (int)(Math.random()*2);
int obtenerSalud= (int)(Math.random()*3+1);
int perderSalud= -obtenerSalud;
System.out.println("Entro en una casilla salud");
if(azar==0){
 jugadores.get(indice).setSalud(obtenerSalud); //obtiene entre 1 y 3 de vida
}
else{
 jugadores.get(indice).setSalud(perderSalud);

}
extremosSalud(jugadores, nJugadores);
}
private int leerDato(){
    int verificarDato;
  Scanner leer= new Scanner(System.in);
  do{
    try{
        System.out.println("Ingrese un número válido");
        verificarDato= leer.nextInt();
        break;
 }
  catch(Exception e){
  System.out.println("error, ingresa nuevamente un dato");
  leer.nextLine();}
}while(true);
  
  return verificarDato;
  }

private void elegirJugada(ArrayList<Jugador> jugadores, int indice, int largoTablero, int cantidadJugadores){
 int opcion;
 int mover;
System.out.println("1-Lanzar dados");
System.out.println("2-Meditar");
System.out.println("Elija una opción");
do{
       opcion= leerDato();
     }while(opcion<0 && opcion>3);
if(opcion==1){
        mover=lanzarDados();
        jugadores.get(indice).setPosicion(mover);
        extremosPosiciones(jugadores, indice, largoTablero);
}
else if(opcion==2){
        meditar(jugadores, indice, largoTablero, cantidadJugadores);}
jugadores.get(indice).estadoJugador();
   
}


private void casillaOpcion(ArrayList<Character> casillas, ArrayList<Jugador> jugadores, int indice, int largoTablero, int cantidadJugadores, int posicion){
   posicion-=1;
    if(posicion>=largoTablero){
  posicion= largoTablero;}
    switch(casillas.get(posicion)){
        case 'p':
            casillaPortal(jugadores, casillas,largoTablero, indice, posicion);
            break;
        case 's':
            casillaSalud(jugadores,indice, cantidadJugadores);
            break;
        case 'd':
            casillaDesafio(jugadores, indice, cantidadJugadores, largoTablero);
            break;
        case 'b':
            System.out.println("Entro en una casilla en blanco");
            break;
        case 'I':
            break;
            case'F':
                casillaFinal(jugadores, indice, largoTablero);
                System.exit(0);
                break;
    
    }
   
    
}
public void bienvenida(){
    System.out.println("Bienvenidos a Infinity Game\n");
    System.out.println("Indique la cantidad de jugadores");
    generarJuego();
}
private void generarJuego(){
   Tablero t= new Tablero();
    int cantidadJugadores;
    int largoTablero;
    int jugadoresActivos;
    int posicion;
    int turno=0;
    ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
    ArrayList<Character> casillas= t.getCasillas();
    
     cantidadJugadores= leerCantidadJugadores();
    agregarJugadores(jugadores, cantidadJugadores);
  t.leerLargoTablero();
  t.generarTablero();
  t.mostrarTablero();
  largoTablero= t.getLargoTablero();
  mostrarJugadores(jugadores, cantidadJugadores);
  do{
   jugadoresActivos= jugadoresActivos(jugadores);
  for(int indice=0; indice<jugadoresActivos; indice++){
   t.mostrarTablero();
  System.out.println(jugadores.get(indice).getNombre()+" es su turno");
  elegirJugada(jugadores, indice, largoTablero, cantidadJugadores);
  posicion= jugadores.get(indice).getPosicion();
  casillaOpcion(casillas,jugadores,indice,largoTablero,jugadoresActivos,posicion);
   
}
  turno++;
}while(true);}


}


