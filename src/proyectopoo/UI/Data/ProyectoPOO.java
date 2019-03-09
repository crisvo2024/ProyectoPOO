/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

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

/**
 *
 * @author SANTIAGO
 */
public class ProyectoPOO extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Singleton singleton=Singleton.getSingleton();
        singleton.setStage(primaryStage);
        
        Modificar modificar = new Modificar();
        Venta venta = new Venta();
        TabPane root=new TabPane();
        Tab mod = new Tab("Modificar");
        mod.setContent(modificar.getRoot());
        root.getTabs().add(new Venta().getRoot());
        root.getTabs().add(mod);
        
        root.setStyle("-fx-background:DimGrey;-fx-font-weight: bold;");
        Scene value =new Scene(root, 500, 500);
        value.getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
        primaryStage.setScene(value);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
