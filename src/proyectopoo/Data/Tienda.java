/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author SANTIAGO
 */
public class Tienda {
    private Inventario inventario;
    private ArrayList<Factura> facturas;

    public Tienda() {
        inventario=new Inventario();
        inventario.AñadirProducto(0, "Lapiz", 10, 800, 1000,0.19);
        
    }
    
    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
}
