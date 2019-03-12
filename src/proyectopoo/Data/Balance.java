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
public class Balance {
    private Date fechaInicio;
    private Date fechaCorte;
    private double ganancias;
    private double costos;
    private ArrayList<Registro>operaciones;

    public Balance(Date fechaInicio, Date fechaCorte, ArrayList<Registro> operaciones) {
        this.fechaInicio = fechaInicio;
        this.fechaCorte = fechaCorte;
        this.ganancias = 0;
        this.costos = 0;
        this.operaciones = operaciones;        
    }

    
    
}
