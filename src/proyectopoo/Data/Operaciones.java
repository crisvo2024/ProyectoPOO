/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.ArrayList;

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
    private ArrayList<Integer>facturasV;
    private ArrayList<Integer>facturasC;

    public Operaciones(int existencias, double precioCompra) {
        this.existencias = existencias;
        this.salidas=0;
        this.precioVenta=0;
        this.entradas=0;
        this.precioCompra=precioCompra;
    }
    public void salida(int cantidad,double precio, int factura){
        this.existencias-=cantidad;
        this.salidas+=cantidad;
        this.precioVenta+=cantidad*precio;
        this.facturasV.add(factura);
    }
    public void entrada(int cantidad,double precio, int factura){
        this.precioCompra=((this.precioCompra*existencias)+(cantidad*precio))/cantidad+existencias; 
        this.entradas+=cantidad;
        this.existencias+=cantidad;
        this.facturasC.add(factura);
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

    public ArrayList<Integer> getFacturasV() {
        return facturasV;
    }

    public ArrayList<Integer> getFacturasC() {
        return facturasC;
    }
    
}
