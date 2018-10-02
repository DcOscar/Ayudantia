/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sivu;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oscar
 */
public class ProductoTest {
    Producto producto= new Producto("dulce",200,10,2);  //Parametros,  1= nombre producto; 2= Precio unitario; 3= Stock; 4= codigo
    public ProductoTest() {
    }
    
    
    @Test
    // test que verifique el funcionamiento al sumar un valor a un precio registrado
    public void testSumarPrecio() {
        int precioInicial;
        int precioFinal;
        boolean condicion= false;
   precioInicial=  producto.getPrecio();
   producto.sumarPrecio(100); // Al precio inicial le estamos sumando $100, es decir el precio debe ser diferente
   precioFinal= producto.getPrecio();
   if(precioInicial!=precioFinal){
   condicion= true;}
   else{System.out.println("Error");}
    assertTrue(condicion);
     
     
      
    }
    @Test 
    //test que verifica el funcionamiento al sumar un valor al stock
    public void testSumarStock(){
    int stockInicial;
    int stockFinal;
    boolean condicion= false;
    stockInicial= producto.getStock();
    producto.sumarStock(2); //Al stock inicial (10) le sumaremos 2
    stockFinal= producto.getStock();
    if(stockInicial!=stockFinal){
    condicion= true;}
    else{System.out.println("Error");}
     assertTrue(condicion);
    
    
    }
    @Test
    // test que verifica que el stock no puede ser negativo
    public void testSetStock(){
    int stockInicial;
    int stockFinal;
    boolean condicion= false;
    stockInicial= producto.getStock();
    producto.setStock(-1); // como se le entrega un stock de -1, debería no haber algun cambio en el stock porque el valor es invalido
    stockFinal= producto.getStock();
    if(stockInicial==stockFinal){
    condicion= true;}
     assertTrue(condicion);
   
    }
    
}
