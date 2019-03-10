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
public class Tienda {
    private Inventario inventario;
    private ArrayList<Factura> facturas;

    public Inventario getInventario() {
        return inventario;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
    
}
