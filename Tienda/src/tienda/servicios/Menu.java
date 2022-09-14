/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import tienda.entidades.Fabricante;

/**
 *
 * @author MegaTecnologia
 */
public class Menu {
    
    Scanner leer = new Scanner(System.in);
    private int var;
    private ServicioFabricante sf;
    private ServicioProducto sp;

    public Menu() {
        var = 0;
        sf = new ServicioFabricante();
        sp = new ServicioProducto();
    }
    
    
    
    
    
    
    public void menuPrincipal() {
        
        do {
                
            try {
                 
                System.out.println(" MENU PRINCIPAL ");
                System.out.println(" 1. Ver el nombre de los productos ");
                System.out.println(" 2. Ver los productos por nombre y precio");
                System.out.println(" 3. Ver productos que el rango de precio sea entre $120 y $202");
                System.out.println(" 4. Ver todos los portátiles");
                System.out.println(" 5. Ver el producto más baráto");
                System.out.println(" 6. Ingresar nuevo producto");
                System.out.println(" 7. Ingresar nuevo fabricante");
                System.out.println(" 8. Editar un producto");
                System.out.println(" 9. SALIR");
            
                var = leer.nextInt();
            
                switch(var) {
                
                case 1:
                    System.out.println("Vamos a mostrar solo los nombres de TODOS los productos");
                    sp.muestraProducto();
                    break;
                case 2:
                    System.out.println("Vamos a mostrar solos los nombres y precios de los productos");
                    sp.muestraProductoPrecio();
                    break;
                case 3:
                    System.out.println("Productos entre 120 y 202");
                    sp.muestraProductoPrecio120202();
                    break;
                case 4: 
                    System.out.println("Mostrar todos los portátiles");
                    sp.muestraPortatiles();
                    break;
                case 5:
                    System.out.println("Producto más barato");
                    sp.muestraMasBarato();
                    break;
                case 6: nuevoProducto();
                    break;
                case 7: nuevoFabricante();
                    break;
                case 8:
                    System.out.println("Editar un producto");
                                        
                    break;
                case 9:
                    System.out.println("ADIÓS");
                default:
                    System.out.println("OPCIÓN NO EXISTENTE");
                    
                }
                  
                  
            } catch (InputMismatchException e){
                System.out.println("NO INTRODUZCA LETRAS");
                leer.next();
            } catch (Exception e) {
                System.out.println("NO INTRODUZCA LETRAS");
                e.getMessage();
            }
            
            
        } while(var != 9);
          
        
        
    }
    
    private void nuevoFabricante() throws Exception {
        
        System.out.println("Ingrese el nombre del nuevo fabricante");
        try {
            
            String palabra = leer.next().trim();
            sf.crearFabricante(palabra);
            
        } catch(Exception e) {
            e.getMessage();
        }
        
    }
    
    private void nuevoProducto() throws Exception {
        
        Fabricante fabri = null;
        
        try {
            System.out.println("Ingrese el nombre del nuevo producto");
            String palabra = leer.next().toUpperCase().trim();
            
            System.out.println("Ingrese el precio");
            Double precio = leer.nextDouble();
            
            System.out.println("Ingrese el código de fabricante");
            int codigo = leer.nextInt();
            fabri = sf.verificarFabricante(codigo);
            
            sp.crearProducto(palabra, precio, fabri);
            
            
        } catch(Exception e) {
            // throw new Exception("");
            System.out.println(e.getMessage());
        }
        
    }
    
     private void editarProducto() throws Exception {
        
        System.out.println("Estos son los productos y sus codigos");
        sp.muestraProducto();
         System.out.println("\n\n");
        System.out.println("Ingrese el codigo del producto a modificar");
        try {
            
            String palabra = leer.next().trim();
            sf.crearFabricante(palabra);
            
        } catch(Exception e) {
            e.getMessage();
        }
        
    }
    
}
