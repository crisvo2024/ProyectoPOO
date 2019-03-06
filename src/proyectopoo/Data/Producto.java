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

    public Producto(int id, String nombre, int unidades, double precioUnidad) {
        this.id = id;
        this.nombre = nombre;
        this.unidades = unidades;
        this.precioUnidad = precioUnidad;
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
    
    
}
