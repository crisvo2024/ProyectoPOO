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
    
    public void AñadirProducto(int id,String nombre,int cantidad,double precioC,double precioV){
        this.productos.add(new Producto(id, nombre, cantidad, precioV));
        this.actual.getProductos().put(id,new Operaciones(cantidad, precioC));
    }
    
    public void añadirRegistro(){
        this.Registros.put(this.actual.getFecha(), this.actual);
        HashMap<Integer,Double[]> nuevo=new HashMap<>();
        for(Map.Entry<Integer,Operaciones> p:this.actual.getProductos().entrySet()){
            double a=p.getValue().getExistencias();
            Double[] dato={a,p.getValue().getPrecioCompra()};
            nuevo.put(p.getKey(),dato);
        }
        this.actual= new Registro(new Date(), nuevo, this.actual.getValorExistencias());
    }    
    
    
}
