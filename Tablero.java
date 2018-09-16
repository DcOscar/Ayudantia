/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablero;
import java.util.*;
/**
 *
 * @author Oscar
 */
public class Tablero {

    public static int lanzarDados() {
        int numeroAleatorio = (int) (Math.random() * 12 + 1);
        return numeroAleatorio;
    }

    public static char[] generarTablero(int largoTablero) {
        char tipoCasilla[] = new char[largoTablero];
        tipoCasilla[0] = 'I';
        tipoCasilla[largoTablero - 1] = 'F';
        for (int i = 1; i < largoTablero; i++) {
            int casillaAzar = (int) (Math.random() * 3);
            if (casillaAzar == 0) {
                tipoCasilla[i] = 'b';
            } else if (casillaAzar == 1) {
                tipoCasilla[i] = 'p';
            } else if (casillaAzar == 2) {
                tipoCasilla[i] = 's';
            } else if (casillaAzar == 3) {
                tipoCasilla[i] = 'd';
            }
        }
        return tipoCasilla;
    }
    public static void mostrarTablero(char tipoCasilla[]){
    for(int x=0; x<tipoCasilla.length; x++){
    System.out.println(tipoCasilla[x]+"\n");}}
    
    public static int casillaBlanco(int turno) {
        turno++;
        return turno;
    }
    public static boolean casillaFinal(String jugadores[][], char tablero[], int turno) {
        boolean ganador = true;
        if (String.valueOf(tablero[Integer.parseInt(jugadores[turno][2])]).equals("F")) {
            ganador = false;
        }
        return ganador;
    }
    public static String[][] casillaDesafio(String jugadores[][],int turno,int largoTablero ){
    int posibilidad= (int)(Math.random()*1); //"0" se puede avanzar o retroceder, "1" gana o pierde vida
    if(posibilidad==0){
    mover(jugadores,largoTablero,turno);}
    else if(posibilidad==1){
    vidas(turno,jugadores);}
    return jugadores;}
    
    public static String[][] mover(String jugadores[][], int turno, int largoTablero) {
        int mover;
        int posibilidad = (int) (Math.random() * 1);
        if (posibilidad == 0) {
            mover = (int) (Math.random() * 5 + 1);
            if ((Integer.parseInt(jugadores[turno][2]) + mover) > largoTablero - 1) {
                jugadores[turno][2] = String.valueOf((Integer.parseInt(jugadores[turno][2]) + mover) - largoTablero);
            } else {
                jugadores[turno][2] = String.valueOf(Integer.parseInt(jugadores[turno][2]) + mover);
            }
            System.out.println("Avanza " + mover + " espacios");
        }
        else if(posibilidad == 1) {
            mover = (int) (Math.random() * -5 - 1);
            if ((Integer.parseInt(jugadores[turno][2]) + mover) < 0) {
                jugadores[turno][2] = String.valueOf((Integer.parseInt(jugadores[turno][2]) + mover) + largoTablero);
            } else {
                jugadores[turno][2] = String.valueOf(Integer.parseInt(jugadores[turno][2]) + mover);
            }
            System.out.println("Retrocede " + mover + " espacios");
        }
        return jugadores;
    }

    public static String[][] vidas(int turno, String jugadores[][]) {
        int puntoSalud;
        int posibilidad = (int) (Math.random() * 1); //"0" obtiene más vidas, "1" pierde vidas
        if (posibilidad == 0) {
            puntoSalud = (int) (Math.random() * 4 + 1);
            if ((Integer.parseInt(jugadores[turno][1]) + puntoSalud) > 15) {
                jugadores[turno][1] = "15";
            } else {
                jugadores[turno][1] = String.valueOf(Integer.parseInt(jugadores[turno][1]) + puntoSalud);
            }
        }
        if (posibilidad == 1) {
            puntoSalud = (int) (Math.random() * -4 - 1);
            if ((Integer.parseInt(jugadores[turno][1]) + puntoSalud) <= 0) {
                jugadores[turno][1] = "0";
            } else {
                jugadores[turno][1] = String.valueOf(Integer.parseInt(jugadores[turno][1]) + puntoSalud);
            }
        }
        return jugadores;
    }
    public static String[][] casillaVidas(int turno, String jugadores[][]){
     int puntoSalud;
        int posibilidad = (int) (Math.random() * 1); //"0" obtiene más vidas, "1" pierde vidas
        if (posibilidad == 0) {
            puntoSalud = (int) (Math.random() * 3 + 1);
            if ((Integer.parseInt(jugadores[turno][1]) + puntoSalud) > 15) {
                jugadores[turno][1] = "15";
            } else {
                jugadores[turno][1] = String.valueOf(Integer.parseInt(jugadores[turno][1]) + puntoSalud);
            }
        }
        if (posibilidad == 1) {
            puntoSalud = (int) (Math.random() * -3 - 1);
            if ((Integer.parseInt(jugadores[turno][1]) + puntoSalud) <= 0) {
                jugadores[turno][1] = "0";
            } else {
                jugadores[turno][1] = String.valueOf(Integer.parseInt(jugadores[turno][1]) + puntoSalud);
            }
        }
        return jugadores;}
    
    public static String[][] agregarJugador(String jugadores[][], Scanner teclado){
    for(int x=0; x<jugadores.length; x++ ){
        jugadores[0][x]=teclado.next();
     
    } return jugadores;}    
    public static String[][] asignarVidas(String jugadores[][]){
    for(int x=0; x<jugadores.length; x++){
    jugadores[1][x]= "15";}
    return jugadores;}
    
    public static void main(String[] args) {
        int largoTablero;
        int turno=0;
        int cantidadJugadores;
        int modoDeJuego;
        Scanner teclado= new Scanner(System.in);
        String jugadores[][];
        do{
        System.out.println("Indique el largo del tablero, como mínimo son 20 casillas");
        largoTablero= teclado.nextInt();  
        }while(largoTablero<20);
        char tipoCasilla[]=generarTablero(largoTablero);
        do{
        System.out.println("Bienvenido(s) a Infinity Game\n");
     System.out.println("Choose a game mode\n");
        System.out.println("1: Solo");
        System.out.println("2: Multijugador");
        System.out.println("3: Salir");
        modoDeJuego= teclado.nextInt();
        }while(modoDeJuego>3 || modoDeJuego<1);
        switch (modoDeJuego){
            case 1:
        System.out.println("Modo solitario");
        cantidadJugadores=1;
        jugadores=new String[1][3];
        System.out.println("Ingrese un nombre de usuario");
        agregarJugador(jugadores,teclado);
        asignarVidas(jugadores);
        
        }
    }}
    

