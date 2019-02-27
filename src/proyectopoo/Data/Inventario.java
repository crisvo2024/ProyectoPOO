/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author dfeli
 */
public class Inventario {
    private ArrayList<Producto> productos;
    private  double valorExistencias;
    private HashMap<Date,Double> costoPorFecha;

    public Inventario() {
        this.productos = productos;
        this.valorExistencias = valorExistencias;
    }
    public void entrada(Date fecha, ArrayList<Producto> unidades, double valor){
        this.valorExistencias+= valor;
    }
}
