/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

/**
 *
 * @author SANTIAGO
 */
public class Detalle {
    int idP;
    String nombreP;
    double precioV;
    int cantidad;
    double total;
    double iva;

    public Detalle(int idP, String nombreP, double precioV, int cantidad, double iva) {
        this.idP = idP;
        this.nombreP = nombreP;
        this.precioV = precioV;
        this.cantidad = cantidad;
        this.iva = iva;
        this.total = precioV*cantidad;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public double getPrecioV() {
        return precioV;
    }

    public void setPrecioV(double precioV) {
        this.precioV = precioV;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }
    
}
