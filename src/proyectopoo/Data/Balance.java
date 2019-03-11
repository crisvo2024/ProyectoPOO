/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.util.Date;

/**
 *
 * @author SANTIAGO
 */
public class Balance {
    private Date fechaInicio;
    private Date fechaCorte;
    private double ganancias;
    private double costos;

    public Balance(Date fechaInicio, Date fechaCorte, double ganancias, double costos) {
        this.fechaInicio = fechaInicio;
        this.fechaCorte = fechaCorte;
        this.ganancias = ganancias;
        this.costos = costos;
    }
    
}
