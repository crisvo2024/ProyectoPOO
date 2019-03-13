/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.text.TableView;
import proyectopoo.Data.Factura;
import proyectopoo.Data.GestionArchivos;
import proyectopoo.Data.Tienda;

/**
 *
 * @author SANTIAGO
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Singleton singleton=Singleton.getSingleton();
        File f=new File("Archivos");
        if(!f.exists()){
            f.mkdir();
        }
        GestionArchivos p= new GestionArchivos();
        Tienda t=new Tienda();
        try {
            t.setFacturasV(p.LeerFactura("Archivos/FacturasV.txt"));
            t.setFacturasC(p.LeerFactura("Archivos/FacturasC.txt"));
            t.setInventario(p.LeerRegistro());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        Calendar c=Calendar.getInstance();
        Calendar actual= Calendar.getInstance();
        actual.setTime(t.getInventario().getActual().getFecha());
        if(actual.get(Calendar.DAY_OF_MONTH)!=c.get(Calendar.DAY_OF_MONTH)){
            t.getInventario().añadirRegistro();
        }
        
        singleton.setModelo(t);
        TabPane root=new TabPane();
        root.getTabs().add(new ControlVenta().getVenta());
        root.getTabs().add(new ControlCompra().getCompra());
        root.getTabs().add(new ControlModificar().getModificar());
        root.getTabs().add(new ControlConsulta().getConsulta());
        root.getTabs().add(new ControlBalance().getRoot());
        root.getTabs().add(new ControlKardex().getKardex());
        
        Scene value =new Scene(root, 800, 500);
        value.getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
        primaryStage.setScene(value);
        
        primaryStage.show();
        primaryStage.setOnCloseRequest((observable) -> {
            try {
                p.GuardarFactura(singleton.getModelo().getFacturasV(), "Archivos/FacturasV.txt");
                p.GuardarFactura(singleton.getModelo().getFacturasC(), "Archivos/FacturasC.txt");
                p.GuardarRegistro(singleton.getModelo().getInventario());
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
}
