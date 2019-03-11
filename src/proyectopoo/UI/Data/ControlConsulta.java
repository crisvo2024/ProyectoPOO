/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXAboutDialog;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.util.StringConverter;
import proyectopoo.Data.Detalle;
import proyectopoo.Data.Factura;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Tienda;

/**
 *
 * @author dfeli
 */
public class ControlConsulta {
    private Consultas consulta;
    private Tienda modelo;
    private ObservableList<Factura>facturasV;
    private ObservableList<Factura>facturasC;
    

    public ControlConsulta() {
        Singleton singleton = new Singleton();
        this.consulta = new Consultas();
        this.consulta.getBuscar().setOnAction(new anadir());
        this.modelo=singleton.getModelo();
        this.facturasV=FXCollections.observableArrayList(this.modelo.getFacturasV());
        this.facturasC=FXCollections.observableArrayList(this.modelo.getFacturasC());
        this.consulta.getFactura().valueProperty().addListener(new fact());
        ObservableList<String> items=FXCollections.observableArrayList("Venta","Compra");
        this.consulta.getFactura().setItems(items);
        this.consulta.getNumFactura().setConverter(new StringConverter<Factura>() {
            
            @Override
            public Factura fromString(String string) {
               return (Factura)consulta.getNumFactura().getItems().get(Integer.parseInt(string));
            }

            @Override
            public String toString(Factura object) {
                return String.valueOf(object.getNumero());
            }
        });
        this.consulta.getFactura().valueProperty().addListener(new fact());
        this.consulta.getRoot().setOnSelectionChanged(new selected());
        
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            facturasV=FXCollections.observableArrayList(modelo.getFacturasV());
            facturasC=FXCollections.observableArrayList(modelo.getFacturasC());
        }
        
    }
    
    class anadir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            
        }        
    }
    class fact implements ChangeListener<String>{
        
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue.contains("Venta")){
                consulta.getNumFactura().setItems(facturasV);
            }else if(newValue.contains("Compra")){
                consulta.getNumFactura().setItems(facturasC);
            }
        }
    }
    
}
