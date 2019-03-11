/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
        this.consulta = new Consultas();
        this.consulta.getBuscar().setOnAction(new anadir());
        this.modelo=new Tienda();
        this.facturasV=FXCollections.observableArrayList(this.modelo.getFacturasV());
        this.consulta.getFactura().setConverter(new StringConverter<Factura>() {
            
            @Override
            public Factura fromString(String string) {
               return null;
            }

            @Override
            public String toString(Factura object) {
                return null;
            }
        });
        this.consulta.getFactura().valueProperty().addListener(new fact());
        
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
