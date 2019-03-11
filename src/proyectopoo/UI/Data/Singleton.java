/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.stage.Stage;
import proyectopoo.Data.Tienda;

/**
 *
 * @author SANTIAGO
 */
public class Singleton {
    public static Singleton singleton=null;
    private Tienda modelo;

    public static Singleton getSingleton(){
        if(singleton==null)singleton=new Singleton();
        return singleton;
    }

    public Tienda getModelo() {
        return modelo;
    }

    public void setModelo(Tienda modelo) {
        this.modelo = modelo;
    }

    
    
}
