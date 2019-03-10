/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

/**
 *
 * @author SANTIAGO
 */
public class Producto {
    private int id;
    private String nombre;
    private int unidades;
    private double precioUnidad;
    private double iva;

    public Producto(int id, String nombre, int unidades, double precioUnidad, double iva) {
        this.id = id;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnidad = precioUnidad;
        this.iva = iva;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
    
}
