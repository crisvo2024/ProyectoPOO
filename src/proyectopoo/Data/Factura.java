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
    int numero;
    ArrayList<Detalle> Entradas;

    public Factura(Date fecha, int numero, ArrayList<Detalle> Entradas) {
        this.fecha = fecha;
        this.numero = numero;
        this.Entradas = Entradas;
        this.total =0;
        for(Detalle d:Entradas){
            this.total+=d.getTotal();
        }
    }

    public int getNumero() {
        return numero;
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
    
}
