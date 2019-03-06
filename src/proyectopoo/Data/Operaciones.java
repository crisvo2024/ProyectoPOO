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
public class Operaciones {
    private int existencias;
    private int salidas;
    private double precioVenta;
    private int entradas;
    private double precioCompra;

    public Operaciones(int existencias, double precioCompra) {
        this.existencias = existencias;
        this.salidas=0;
        this.precioVenta=0;
        this.entradas=0;
        this.precioCompra=precioCompra;
    }
    public void salida(int cantidad,double precio){
        this.existencias-=cantidad;
        this.salidas+=cantidad;
        this.precioVenta+=cantidad*precio;
    }
    public void entrada(int cantidad,double precio){
        this.precioCompra=((this.precioCompra*existencias)+(cantidad*precio))/cantidad+existencias; 
        this.entradas+=cantidad;
        this.existencias+=cantidad;
               
    }

    public int getExistencias() {
        return existencias;
    }

    public int getSalidas() {
        return salidas;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public int getEntradas() {
        return entradas;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }
    
}
