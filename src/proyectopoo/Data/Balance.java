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
    private double IVA;
    private ArrayList<Registro>registros;

    public Balance(Date fechaInicio, Date fechaCorte, ArrayList<Registro> registros) {
        this.fechaInicio = fechaInicio;
        this.fechaCorte = fechaCorte;
        this.ganancias = 0;
        this.costos = 0;
        this.IVA=0;
        this.registros =registros;
        for(Registro r:registros){
            this.costos+=r.getCosto();
            this.ganancias+=r.getGanancias();
            this.IVA+=r.getIvaV();
            this.IVA-=r.getIvaC();
        }
    }
    

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaCorte() {
        return fechaCorte;
    }

    public double getGanancias() {
        return ganancias;
    }

    public double getCostos() {
        return costos;
    }

    public ArrayList<Registro> getRegistros() {
        return registros;
    }

    public double getIVA() {
        return IVA;
    }
    
    
    
    
}
