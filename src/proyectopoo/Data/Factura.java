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
    private Date fecha;
    private double total;
    private int numero;
    private ArrayList<Detalle> Entradas;
    private String Cliente;
    private int docCliemte;
    public Factura(Date fecha, int numero, ArrayList<Detalle> Entradas, String Cliente, int docCliemte) {
        this.fecha = fecha;
        this.numero = numero;
        this.Entradas = Entradas;
        this.total =0;
        this.Cliente = Cliente;
        this.docCliemte = docCliemte;
        for(Detalle d:Entradas){
            this.total+=d.getTotal();
        }
    }

    public String getCliente() {
        return Cliente;
    }

    public int getDocCliemte() {
        return docCliemte;
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
