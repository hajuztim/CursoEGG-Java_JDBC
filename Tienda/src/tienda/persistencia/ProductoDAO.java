/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 *
 * @author MegaTecnologia
 */
public class ProductoDAO extends DAO {
    
    
    public void GuardarProducto(Producto aux) throws Exception {
        try {
            if (aux == null) {
                throw new Exception("OBJETO FABRICANTE NULO");
            }
            
            // SENTENCIA DE INSERCIÓN DE SQL
            
            String query = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) VALUES ('" 
                    + aux.getCodigo()
                    + "'," + aux.getNombre() + "', '"
                    + aux.getPrecio()+"', '"
                    + aux.getFabricante().getCodigo()
                    + "');";
            
            // Llamo al método heredado de DAO
            insertarModificarEliminar(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL GUARDAR PRODUCTO");
        }
    }

    public void modificarProducto(Producto aux) throws Exception {
        try {
            if (aux == null) {
                throw new Exception("OBJETO PRODUCTO NULO");
            }

            // SENTENCIA DE MODIFICACION DE SQL
            
            String sql = "UPDATE producto SET nombre = '"
                    +aux.getNombre() 
                    +"' precio = " + aux.getPrecio() + "', codigo_fabricante = '"
                    + aux.getFabricante().getCodigo()
                    + "' WHERE (codigo = '"+ aux.getCodigo() + "');";
            
            insertarModificarEliminar(sql);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL MODIFICAR PRODUCTO");
        }
    }

    public void eliminarPorCodigo(Integer codigo) throws Exception {
        try {

            String sql = "DELETE FROM producto WHERE codigo = '" + codigo + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL ELIMINAR PRODUCTO");
        }
    }

    public Producto buscarPorClavePrincipal(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante"
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Producto p = null;
            Fabricante f = null;
            
            while (resultado.next()) {
                p = new Producto();
                f = new Fabricante();
                
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                
                f.setCodigo(resultado.getInt(5));
                f.setNombre(resultado.getString(6));
                p.setFabricante(f);
                
                
            }
            return p;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }

    public List<Producto> obtenerProducto() throws Exception {
        try {
            
            String sql = "SELECT * FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante;";

            consultarBase(sql);

            Producto p = null;
            Fabricante f = null;
            
            List<Producto> productos = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                f = new Fabricante();
                
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                
                f.setCodigo(resultado.getInt(5));
                f.setNombre(resultado.getString(6));
                p.setFabricante(f);
                
                productos.add(p);
            }
            return productos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    public List<Producto> obtenerProductoRangoPrecio() throws Exception {
        try {
            
            String sql = "SELECT * FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante"
                    + "WHERE p.precio BETWEEN 120 AND 202;";

            consultarBase(sql);

            Producto p = null;
            Fabricante f = null;
            
            List<Producto> productos = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                f = new Fabricante();
                
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                
                f.setCodigo(resultado.getInt(5));
                f.setNombre(resultado.getString(6));
                p.setFabricante(f);
                
                productos.add(p);
            }
            return productos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    public List<Producto> obtenerPortatiles() throws Exception {
        try {
            
            String sql = "SELECT * FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante"
                    + "WHERE p.nombre LIKE '%Portátil%';";

            consultarBase(sql);

            Producto p = null;
            Fabricante f = null;
            
            List<Producto> productos = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                f = new Fabricante();
                
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                
                f.setCodigo(resultado.getInt(5));
                f.setNombre(resultado.getString(6));
                p.setFabricante(f);
                
                productos.add(p);
            }
            return productos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
    public List<Producto> obtenerMasBarato() throws Exception {
        try {
            
            String sql = "SELECT nombre FROM producto p JOIN fabricante f ON f.codigo = p.codigo_fabricante"
                    + "ORDER BY p.precio"
                    + "LIMIT 1;";

            consultarBase(sql);

            Producto p = null;
            Fabricante f = null;
            
            List<Producto> productos = new ArrayList();
            
            while (resultado.next()) {
                p = new Producto();
                f = new Fabricante();
                
                
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                
                f.setCodigo(resultado.getInt(5));
                f.setNombre(resultado.getString(6));
                p.setFabricante(f);
                
                productos.add(p);
            }
            return productos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER PRODUCTO");
        } finally {
            desconectarBase();
        }
    }
    
}
