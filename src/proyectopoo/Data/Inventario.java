/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author dfeli
 */
public class Inventario {
    private ArrayList<Producto> productos;
    private Registro actual;
    private HashMap<Date,Registro> Registros;

    public Inventario(ArrayList<Producto> productos, Registro actual, HashMap<Date, Registro> Registros) {
        this.productos = productos;
        this.actual = actual;
        this.Registros = Registros;
    }
    public void Venta(int id, int cantidad, double precio){
        this.productos.get(id).setUnidades(this.productos.get(id).getUnidades()-cantidad);
        this.actual.venta(id, cantidad, precio);
        
    }
    public void Compra(int id, int cantidad, double precio){
        this.productos.get(id).setUnidades(this.productos.get(id).getUnidades()+cantidad);
        this.actual.compra(id, cantidad, precio);
    }
    
    public void añadirRegistro(){
        Date date = new Date((new Date()).getTime()+86400000);
        
        this.Registros.put(new Date(), this.actual);
        HashMap<Integer,Integer[]> nuevo=new HashMap<>();
        for(Map.Entry<Integer,Operaciones> p:this.actual.getProductos().entrySet()){
            Integer[] dato={p.getValue().getExistencias(),p.getValue().getPrecioCompra()};
            nuevo.put(p.getKey(),dato);
        }
            
        
        this.actual= new Registro(date, this.actual, double valorExistencias);
    }    
    
    
}
