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

    public Registro(Date fecha, HashMap<Integer, Double[]> datos, double valorExistencias) {
        this.fecha = fecha;
        this.productos = new HashMap<>();
        for(Map.Entry<Integer,Double[]> e:datos.entrySet()){
            double a=e.getValue()[0];
            this.productos.put(e.getKey(),new Operaciones((int)a,e.getValue()[1]));
        }
        this.valorExistencias = valorExistencias;
        this.Ganancias = 0;
    }

    public Registro() {
        this.fecha = new Date();
        this.productos = new HashMap<>();
        this.valorExistencias=0;
        this.Ganancias = 0;
    }
    
    public void venta(int id,int cantidad,double precio){
        this.valorExistencias-=cantidad*this.productos.get(id).getPrecioCompra();
        this.Ganancias+=cantidad*precio;
        this.productos.get(id).salida(cantidad, precio);        
    }
    public void compra(int id,int cantidad,double precio){
        this.valorExistencias+=cantidad*precio;
        this.productos.get(id).entrada(cantidad, precio);  
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
