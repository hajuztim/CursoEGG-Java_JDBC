/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tienda.entidades.Fabricante;

/**
 *
 * @author MegaTecnologia
 */
public class FabricanteDAO extends DAO {

    public void GuardarFabricante(Fabricante aux) throws Exception {
        try {
            if (aux == null) {
                throw new Exception("OBJETO FABRICANTE NULO");
            }
            
            // SENTENCIA DE INSERCIÓN DE SQL
            
            String query = "INSERT INTO fabricante (nombre) VALUES ('" 
                    + aux.getNombre()
                    + "');";
            
            // Llamo al método heredado de DAO
            insertarModificarEliminar(query);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL GUARDAR FABRICANTE");
        }
    }

    public void modificarFabricante(Fabricante aux) throws Exception {
        try {
            if (aux == null) {
                throw new Exception("OBJETO FABRICANTE NULO");
            }

            // SENTENCIA DE MODIFICACION DE SQL
            
            String sql = "UPDATE fabricante SET nombre = '"
                    +aux.getNombre() + "' WHERE (codigo = '"+ aux.getCodigo() + "');";
            
            
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL MODIFICAR FABRICANTE");
        }
    }

    public void eliminarPorCodigo(Integer codigo) throws Exception {
        try {

            String sql = "DELETE FROM Fabricante WHERE codigo = '" + codigo + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL ELIMINAR FABRICANTE");
        }
    }


    public Fabricante buscarPorClavePrincipal(Integer codigo) throws Exception {
        try {

            String sql = "SELECT * FROM Fabricante "
                    + " WHERE codigo = '" + codigo + "'";

            consultarBase(sql);

            Fabricante f = null;
            while (resultado.next()) {
                f = new Fabricante();
                f.setCodigo(resultado.getInt(1));
                f.setNombre(resultado.getString(2));
            }
            return f;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }

    public List<Fabricante> obtenerFabricante() throws Exception {
        try {
            String sql = "SELECT * FROM fabricante";

            consultarBase(sql);

            Fabricante aux = null;
            List<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                aux = new Fabricante();
                
                aux.setCodigo(resultado.getInt(1));
                aux.setNombre(resultado.getString(2));
                
                fabricantes.add(aux);
            }
            return fabricantes;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new Exception("ERROR AL OBTENER FABRICANTE");
        } finally {
            desconectarBase();
        }
    }
    
    
}
