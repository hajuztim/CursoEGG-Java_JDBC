/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.entidades;

/**
 *
 * @author MegaTecnologia
 */
public class Producto {
    
    private int codigo;
    private String nombre;
    private double precio;
    private Fabricante fabricante;

    
    public Producto() {
        this.fabricante = new Fabricante();
    }

    public Producto(int codigo, String nombre, double precio, Fabricante codigoFabricante) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.fabricante = fabricante;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante codigoFabricante) {
        this.fabricante = fabricante;
    }

    
    
    
    
    
}
