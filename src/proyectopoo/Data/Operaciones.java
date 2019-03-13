/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author SANTIAGO
 */
public class Operaciones {
    private Date fecha;
    private int existencias;
    private int salidas;
    private double precioVenta;
    private int entradas;
    private double precioCompra;
    private ArrayList<Integer>facturasV;
    private ArrayList<Integer>facturasC;

    public Operaciones(int existencias, double precioCompra, Date fecha) {
        this.existencias = existencias;
        this.salidas=0;
        this.precioVenta=0;
        this.entradas=0;
        this.precioCompra=precioCompra;
        this.facturasV=new ArrayList<>();
        this.facturasC=new ArrayList<>();
        this.fecha=fecha;
    }
    public void salida(int cantidad,double precio, int factura){
        this.existencias-=cantidad;
        this.salidas+=cantidad;
        this.precioVenta+=cantidad*precio;
        this.facturasV.add(factura);
    }
    public void entrada(int cantidad,double precio, int factura){
        this.precioCompra=((this.precioCompra*existencias)+(cantidad*precio))/(cantidad+existencias); 
        this.entradas+=cantidad;
        this.existencias+=cantidad;
        this.facturasC.add(factura);
    }
    public double getValorE(){
        return existencias*precioCompra;
    }
    public Date getFecha() {
        return fecha;
    }
    public String getFechaK(){
        SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
        return s.format(fecha);
    }
    public String getDetalles(){
        String r="Facturas de venta: ";
        for(Integer i:facturasV){
            r+=i+",";
        }
        r+="\nFacturas de compra: ";
        for(Integer i:facturasC){
            r+=i;
            if(!Objects.equals(i, facturasC.get(facturasC.size()-1))){
                r+=",";
            }
        }
        return r;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
