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

    public Inventario() {
        this.productos=new ArrayList<>();
        this.actual=new Registro();
        this.Registros=new HashMap<>();
    }
    public ArrayList<Operaciones> getKardex(int producto, Date fechaI, Date fechaF){
        ArrayList<Operaciones> kardex=new ArrayList<>();
        for(Map.Entry<Date,Registro> m:Registros.entrySet()){
            if(m.getKey().after(fechaI)&&m.getKey().before(fechaF)){
                kardex.add(m.getValue().getProductos().get(producto));
            }
        }
        return kardex;
    }
    
    public void Venta(ArrayList<Detalle>detalles, int factura){
        for(Detalle d:detalles){
            this.productos.get(d.getIdP()).setUnidades(this.productos.get(d.getIdP()).getUnidades()-d.getCantidad());
            this.actual.venta(d.getIdP(), d.getCantidad(),d.getPrecioV(),factura);
        }
        
        
    }
    public void Compra(ArrayList<Detalle>detalles, int factura){
        for(Detalle d:detalles){
            this.productos.get(d.getIdP()).setUnidades(this.productos.get(d.getIdP()).getUnidades()+d.getCantidad());
            this.actual.compra(d.getIdP(), d.getCantidad(),d.getPrecioV(),factura);
        }
    }
    
    public void AñadirProducto(int id,String nombre,double precioV, double iva){
        this.productos.add(new Producto(id, nombre, 0, precioV,iva));
        this.actual.getProductos().put(id,new Operaciones(0, 0, new Date()));
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

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public HashMap<Date, Registro> getRegistros() {
        return Registros;
    }

    public Registro getActual() {
        return actual;
    }
     
    
}
