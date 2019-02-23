/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author SANTIAGO
 */
public class Factura {
    Date fecha;
    double total;
    ArrayList<Detalle> Entradas;

    public Factura(Date fecha, double total, ArrayList<Detalle> Entradas) {
        this.fecha = fecha;
        this.total = total;
        this.Entradas = Entradas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public ArrayList<Detalle> getEntradas() {
        return Entradas;
    }

    public void setEntradas(ArrayList<Detalle> Entradas) {
        this.Entradas = Entradas;
    }
    
    
}
