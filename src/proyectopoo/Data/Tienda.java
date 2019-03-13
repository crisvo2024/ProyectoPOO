/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author SANTIAGO
 */
public class Tienda {
    private Inventario inventario;
    private ArrayList<Factura> facturasV;
    private ArrayList<Factura> facturasC;

    public Tienda() {
        inventario=new Inventario();
        facturasC=new ArrayList<>();
        facturasV=new ArrayList<>();
        inventario.AñadirProducto(0, "Lapiz", 1000,0.19);
        
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Factura> getFacturasV() {
        return facturasV;
    }
    public void venta(ArrayList<Detalle> detalles, int factura){
        this.inventario.Venta(detalles, factura);
        this.facturasV.add(new Factura(new Date(), factura, detalles));
    }
    
    public void compra(ArrayList<Detalle> detalles, int factura){
        this.inventario.Compra(detalles, factura);
        this.facturasC.add(new Factura(new Date(), factura, detalles));
    }

    public ArrayList<Factura> getFacturasC() {
        return facturasC;
    }
    
    public ArrayList<Operaciones> getKardex(int producto, Date fechaI, Date fechaF){
        return this.inventario.getKardex(producto, fechaI, fechaF);
    }
    public Balance getBalance(Date fechaI,Date fechaF){
        ArrayList<Registro>reg=new ArrayList<>();
        if(this.inventario.getActual().getFecha().after(fechaI)&&this.inventario.getActual().getFecha().before(fechaF)){
            reg.add(this.inventario.getActual());
        }
        for(Map.Entry<Date,Registro> r:this.inventario.getRegistros().entrySet()){
            if(r.getKey().after(fechaI)&&r.getKey().before(fechaF)){
                reg.add(r.getValue());
            }
        }
        return new Balance(fechaI, fechaF, reg);
    }
}
