/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import com.sun.deploy.uitoolkit.impl.fx.ui.FXAboutDialog;
import java.text.SimpleDateFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private ObservableList<Detalle>detalles;
    

    public ControlConsulta() {
        this.consulta = new Consultas();
        Singleton s=Singleton.getSingleton();
        this.modelo=s.getModelo();
        this.detalles=FXCollections.observableArrayList();
        
        
        this.consulta.getCantidad().setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.consulta.getPrecioU().setCellValueFactory(new PropertyValueFactory("precioV"));
        this.consulta.getProducto().setCellValueFactory(new PropertyValueFactory("nombreP"));
        this.consulta.getIva().setCellValueFactory(new PropertyValueFactory("iva"));
        this.consulta.getTotal().setCellValueFactory(new PropertyValueFactory("total"));
        this.consulta.getBuscar().setOnAction(new buscar());
        
        this.facturasV=FXCollections.observableArrayList(this.modelo.getFacturasV());
        this.facturasC=FXCollections.observableArrayList(this.modelo.getFacturasC());
        
        ObservableList<String> items=FXCollections.observableArrayList("Venta","Compra");
        
        this.consulta.getFactura().valueProperty().addListener(new fact());
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
    
    class buscar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Factura f=(Factura)consulta.getNumFactura().getValue();
            detalles=FXCollections.observableArrayList(f.getEntradas());
            consulta.getTable().setItems(detalles);
            consulta.getSelecFac().setText(String.valueOf(f.getNumero()));
            SimpleDateFormat s=new SimpleDateFormat("dd/MM/yyyy");
            consulta.getDateFecha().setText(s.format(f.getFecha()));
            consulta.getValueCompra().setText(String.valueOf(f.getTotal()));
            consulta.getCliente().setText(f.getCliente());
            consulta.getDocumento().setText(String.valueOf(f.getDocCliemte()));
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

    public Tab getConsulta() {
        return consulta.getRoot();
    }
    
}
