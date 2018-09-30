/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infinitygame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class InfinityGameTest {
    
    InfinityGame game= new InfinityGame();
    Tablero tablero= new Tablero();
    Jugador jugador= new Jugador();
    int indice;
    public InfinityGameTest() {
    }
    
  
    @Test
    public void testLanzarDados() {
        System.out.println("Metodo lanzar dados");
        for(int i=0; i<500; i++){
        int resultado= game.lanzarDados();
        boolean condicion= false;
        if(resultado>1 && resultado<13){
           condicion= true; }
        else{System.out.println("error");}
        assertTrue(condicion);
        }
    }
    @Test
    public void testCasillaPortal(){
       int posicionInicial;
       int posicionFinal;
        tablero.generarTablero(20);
        System.out.println(tablero.casillas);
        for(int i=0; i<tablero.casillas.size(); i++){
        if(tablero.casillas.get(i).equals('p')){
            this.indice= i;
            break;  
        }}
     
        jugador.posicionJugadores.add(indice);
        
        posicionInicial= jugador.getPosicion(0);
        System.out.println(posicionInicial);
        game.casillaPortal(jugador.posicionJugadores, tablero.casillas,indice, 20,1);
        posicionFinal= jugador.getPosicion(0);
        System.out.println(posicionFinal);
        assertNotEquals(posicionInicial,posicionFinal);
    }
    @Test 
    public void testCasillaSalud(){
        jugador.saludJugadores.add(5);
        
        game.casillaSalud(jugador.saludJugadores,0);
        boolean condicion= false;
        if(jugador.saludJugadores.get(0)>1 && jugador.saludJugadores.get(0)<9){
        condicion= true;}
        else{System.out.println("error");}
         assertTrue(condicion);
        }
        
    
}
