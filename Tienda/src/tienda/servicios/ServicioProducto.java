/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.List;
import tienda.entidades.Fabricante;
import tienda.persistencia.ProductoDAO;
import tienda.entidades.Producto;

/**
 *
 * @author MegaTecnologia
 */
public class ServicioProducto {
    
    private ProductoDAO p_DAO;
    
    public ServicioProducto() {
        p_DAO = new ProductoDAO();
    }
    
    
    
    
    
    // CREAR NUEVO
    public void crearProducto(String nombre, Double precio, Fabricante f) throws Exception {
        
        try {
            
            // VALIDACIÓN NOMBRE
            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN NOMBRE");
            }
            
            Producto aux = new Producto();

            aux.setNombre(nombre);
            
            // VALIDACIÓN PRECIO
            if (precio == null | precio < 0) {
                throw new Exception("EL PRECIO NO ES VIABLE");
            }
            aux.setPrecio(precio);
            // VALIDACIÓN FABRICANTE
            
            if(f == null) {
                System.out.println("EL FABRICANTE ESTÁ VACÍO");
               throw new Exception("EL FABRICANTE NO ES VIABLE");
            }
            
            aux.setFabricante(f);
            
            // Llamo al método del ProductoDAO que persiste un fabricante
            p_DAO.GuardarProducto(aux);
          
        } catch (Exception e) {
            // e.printStackTrace();
            throw new Exception ("ERROR DE SISTEMA");
        }
      
    }
    
    
    // MODIFICA
    public void modificarProducto(Integer codigo, String nombre, Double precio, Integer codigo_fabricante) throws Exception {
        
        try {
            
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new Exception("DEBE INGRESAR UN CÓDIGO");
            }
            
            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN NOMBRE");
            }
            
            if (precio == null | nombre.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN PRECIO");
            }
            
            if (codigo_fabricante == null) {
                throw new Exception("DEBE INGRESAR UN FABRICANTE");
            }
            
            Producto aux = p_DAO.buscarPorClavePrincipal(codigo);
            
            if (aux == null) {
                throw new Exception("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            
            aux.setNombre(nombre);
            aux.setFabricante(codigo_fabricante);
            aux.setPrecio(precio);
            
            p_DAO.modificarProducto(aux);
            
        } catch (Exception e) {
            // e.printStackTrade();
            throw new Exception("ERROR DE SISTEMA");
        } 
        
    }
    
    
    //MUESTRA
    
    public void muestraProducto() throws Exception {
        
        try {
            
            List<Producto> productos = p_DAO.obtenerProducto();
            
            if (productos.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.println("%-15s%-15s\n" + "NOMBRE"); 
                
                for (Producto aux : productos) {
                    System.out.println(aux.getNombre());
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
    
    public void muestraProductoPrecio() throws Exception {
        
        try {
            
            List<Producto> productos = p_DAO.obtenerProducto();
            
            if (productos.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.println("NOMBRE, " + "PRECIO"); 
                
                for (Producto aux : productos) {
                    System.out.println("["+ aux.getNombre()+"]" + "  " + aux.getPrecio());
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
    
    
    public void muestraProductoPrecio120202() throws Exception {
        
        try {
            
            List<Producto> productos = p_DAO.obtenerProductoRangoPrecio();
            
            if (productos.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.println("NOMBRE, " + "PRECIO"); 
                
                for (Producto aux : productos) {
                    System.out.println("["+aux.getCodigo()+"]"+"["+ aux.getNombre()+"]" + "  " + aux.getPrecio());
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
    
    public void muestraPortatiles() throws Exception {
        
        try {
            
            List<Producto> productos = p_DAO.obtenerPortatiles();
            
            if (productos.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.println("CODIGO " + " NOMBRE " + " PRECIO " + " FABRICANTE"); 
                
                for (Producto aux : productos) {
                    System.out.println("["+aux.getCodigo()+"]"+"["+ aux.getNombre()+"]" + "  " + aux.getPrecio() + aux.getFabricante());
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
    
     public void muestraMasBarato() throws Exception {
        
        try {
            
            List<Producto> productos = p_DAO.obtenerMasBarato();
            
            if (productos.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE PRODUCTOS ***");
                System.out.println("CODIGO " + " NOMBRE " + " PRECIO " + " FABRICANTE"); 
                
                for (Producto aux : productos) {
                    System.out.println("["+aux.getCodigo()+"]"+"["+ aux.getNombre()+"]" + "  " + aux.getPrecio() + aux.getFabricante());
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
}
