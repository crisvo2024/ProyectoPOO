/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.io.IOException;
import java.util.ArrayList;
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
public class ProyectoPOO extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Singleton singleton=Singleton.getSingleton();
        singleton.setModelo(new Tienda());
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
            System.out.println("hola");
            GestionArchivos p= new GestionArchivos();
            try {
                p.GuardarFactura(singleton.getModelo().getFacturasV(), "Archivos/FacturasV.txt");
                p.GuardarFactura(singleton.getModelo().getFacturasC(), "Archivos/FacturasC.txt");
                p.GuardarRegistro(singleton.getModelo().getInventario());
            } catch (IOException ex) {
                Logger.getLogger(ProyectoPOO.class.getName()).log(Level.SEVERE, null, ex);
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
