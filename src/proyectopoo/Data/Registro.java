/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.*;

/**
 *
 * @author SANTIAGO
 */
public class Registro {
    private Date fecha;
    private HashMap<Integer, Operaciones>productos;
    private double valorExistencias;
    private double Ganancias;
    private double costo;
    private double ivaC;
    private double ivaV;

    public Registro(Date fecha, HashMap<Integer, Double[]> datos, double valorExistencias) {
        this.fecha = fecha;
        this.productos = new HashMap<>();
        for(Map.Entry<Integer,Double[]> e:datos.entrySet()){
            double a=e.getValue()[0];
            this.productos.put(e.getKey(),new Operaciones((int)a,e.getValue()[1],fecha,e.getValue()[2]));
        }
        this.valorExistencias = valorExistencias;
        this.Ganancias = 0;
        this.costo=0;
        this.ivaC=0;
        this.ivaV=0;
    }

    public Registro() {
        this.fecha = new Date();
        this.productos = new HashMap<>();
        this.valorExistencias=0;
        this.Ganancias = 0;
    }
    
    public void venta(int id,int cantidad,double precio, int factura){
        this.valorExistencias-=cantidad*this.productos.get(id).getPrecioCompra();
        this.Ganancias+=cantidad*precio;
        this.productos.get(id).salida(cantidad, precio,factura);        
    }
    
    public void compra(int id,int cantidad,double precio, int factura){
        this.valorExistencias+=cantidad*precio;
        this.costo+=cantidad*precio;
        this.productos.get(id).entrada(cantidad, precio,factura);  
    }

    public double getCosto() {
        return costo;
    }
    
    public Date getFecha() {
        return fecha;
    }

    public double getGanancias() {
        return Ganancias;
    }

    public HashMap<Integer, Operaciones> getProductos() {
        return productos;
    }

    public double getValorExistencias() {
        return valorExistencias;
    }
    
    
    
}
