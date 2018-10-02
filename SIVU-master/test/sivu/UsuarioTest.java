/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class UsuarioTest {
    ArrayList<Venta> ventas; //se creará un arreglo para simular ventas
    ArrayList<Venta> ventasTotales; //se creará un arreglo para simular ventas totales
    
    Usuario usuario= new Usuario("name", "pass");
    public UsuarioTest() {
        this.ventas = new ArrayList<Venta>();
        this.ventasTotales= new ArrayList<Venta>();
        for(int i=1; i<6; i++){
        ventas.add(new Venta(i*1000,i+1,5));
        
       } // se agregaran 5 ventas como prueba 
        for(int i=1; i<15; i++){
        this.ventasTotales.add(new Venta(i*1000,i+1,5));}  // se agregarán 14 ventas totales a modo de prueba
    }
    
 //test que verifica que se registre el total de ventas del usuario
    @Test
    public void testTotalVentas() {
    int valorEsperado;
    int valorObtenido;
    valorEsperado=5;  //el valor que debe tener es 5 para una comparación
    valorObtenido= usuario.totalVentas(this.ventas);
    assertEquals(valorEsperado,valorObtenido);
    }
    
   @Test
   // test que verifica el funcionamiento de poder registrar la cantidad total de productos que vendió el  usuario
   public void testCantidadVendida(){
   int valorEsperado;
   int valorObtenido;
   valorObtenido=usuario.cantidadVendida(this.ventas);
   valorEsperado=25; // Al agregar 5 ventas como modo de prueba, las agregamos con 5 articulos cada venta, por ello es 25
   assertEquals(valorEsperado,valorObtenido);  
}
   //test que verifica el funcionamiento de registrar el total de valor monetario de las ventas del usuario
  @Test
  public void testValorVendido(){
  int valorEsperado;
  int valorObtenido;
   valorObtenido=usuario.valorVendido(this.ventas);
   valorEsperado=15000; // Al agregar 5 ventas como modo de prueba, cada venta comenzaba en $1000 adicionales
   assertEquals(valorEsperado,valorObtenido); }
  
  @Test
  // test que verifica el porcentaje vendido por el usuario contra las ventas totales
  public void testPorcentajeVendido(){
  double valorObtenido;
  boolean condicion= false;
  valorObtenido= usuario.porcentajeVendido(this.ventas, this.ventasTotales);
  if(valorObtenido<=100){   // El valor obtenido tiene que ser menor que 100%, dado las ventas de este usuario (this.ventas) son menores que las ventas totales(this.ventasTotales)
  condicion= true;}
  else{System.out.println("Error");}
   assertTrue(condicion);
  }
  @Test
  // Test que verifica el porcentaje de valor monetario de las ventas del usuario con respecto a las ventas totales
  public void testPorcentajeValorVentas(){
      double valorObtenido;
  boolean condicion= false;
  valorObtenido= usuario.porcentajeValorVentas(this.ventas, this.ventasTotales);
  if(valorObtenido<=100){   // El valor obtenido tiene que ser menor que 100%, dado las ventas de este usuario (this.ventas) son menores que las ventas totales(this.ventasTotales)
  condicion= true;}
  else{System.out.println("Error");}
   assertTrue(condicion);
  }
}
