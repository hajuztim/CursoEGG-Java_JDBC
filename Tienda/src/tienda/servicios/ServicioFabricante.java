/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author MegaTecnologia
 */
public class ServicioFabricante {
    
    private FabricanteDAO f_DAO;
    
    public ServicioFabricante() {
        f_DAO = new FabricanteDAO();
    }
    
    /*
    
    CRUD 
            Create - Release - Update - Delete
    
    */
    
    // CREAR NUEVO
    public void crearFabricante(String nombre) throws Exception {
        
        try {
            
            // VALIDACIÓN
            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN NOMBRE");
            }
            
            Fabricante fabricante = new Fabricante();

            fabricante.setNombre(nombre);
            f_DAO.GuardarFabricante(fabricante);
          
        } catch (Exception e) {
            // e.printStackTrace();
            throw new Exception ("ERROR DE SISTEMA");
        }
      
    }
    
    
    // MODIFICA
    public void modificarFabricante(Integer codigo, String nombre) throws Exception {
        
        try {
            
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new Exception("DEBE INGRESAR UN CÓDIGO");
            }
            
            if (nombre == null | nombre.trim().isEmpty()) {
                throw new Exception("DEBE INGRESAR UN NOMBRE");
            }
            
            Fabricante aux = f_DAO.buscarPorClavePrincipal(codigo);
            
            if (aux == null) {
                throw new Exception("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            
            aux.setNombre(nombre);
            
            f_DAO.modificarFabricante(aux);
            
        } catch (Exception e) {
            // e.printStackTrade();
            throw new Exception("ERROR DE SISTEMA");
        } 
        
    }
    
    // ELIMINA
    public void eliminarFabricante(Integer codigo) throws Exception {
        
        try {
            
            // VALIDACIÓN
            if (codigo == null | codigo < 0) {
                throw new Exception("DEBE INGRESAR UN CÓDIGO");
            }
            
            Fabricante fabricante = f_DAO.buscarPorClavePrincipal(codigo);
            
            if (fabricante == null) {
                throw new Exception("EL CODIGO INGRESADO NO ESTÁ ASOCIADO A NINGÚN FABRICANTE");
            }
            System.out.println("Se eliminará el fabricante "+fabricante.getNombre());
            
            f_DAO.eliminarPorCodigo(codigo);
            
        } catch (Exception e) {
            // e.printStackTrade();
            throw new Exception("ERROR DE SISTEMA");
        } 
        
    }
    
    //MUESTRA
    
    public void muestraFabricante() throws Exception {
        
        try {
            
            List<Fabricante> fabricantes = f_DAO.obtenerFabricante();
            
            if (fabricantes.isEmpty()) {
                throw new Exception("NO EXISTEN FABRICANTES");
            } else {
                System.out.println("*** LISTA DE FABRICANTES ***");
                System.out.println("%-15s%-15s\n" + "CODIGO," + "NOMBRE"); 
                for (Fabricante aux : fabricantes) {
                    System.out.println(aux);
                }
                System.out.println();
            
            }
              
        }catch (Exception e) {
            // e.printStackTrace();
            throw new Exception("ERROR DE SISTEMA");
        }
         
    }
    
    public Fabricante verificarFabricante(int codigo) throws Exception  {
        
        Fabricante f = null;
        
        try {
            
            f = f_DAO.buscarPorClavePrincipal(codigo);
            
                        
        } catch (Exception ex) {
            ex.getMessage();
            System.out.println("ALGO FALLÓ");
            
        }
        
        return f;
    }
    
    
    
    
    
    
    
}
