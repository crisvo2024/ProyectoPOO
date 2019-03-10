/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import proyectopoo.Data.Detalle;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Tienda;

/**
 *
 * @author SANTIAGO
 */
public class ControlCompra {
    private Compra compra;
    private ObservableList<Detalle> detalles;
    private Tienda modelo;
    private ObservableList<Producto>productos;
    

    public ControlCompra() {
        this.compra = new Compra();
        this.compra.getAnadir().setOnAction(new anadir());
        this.detalles= FXCollections.observableArrayList();
        this.modelo=new Tienda();
        this.productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos());
        this.compra.getProducto().setConverter(new StringConverter<Producto>() {
            @Override
            public String toString(Producto producto) {
                return producto.getNombre();
            }

            @Override
            public Producto fromString(String string) {
                return null;
            }
        });        
        this.compra.getProducto().setItems(productos);
        this.compra.getProducto().valueProperty().addListener(new combo());
        this.compra.getProd().setCellValueFactory(new PropertyValueFactory("nombreP"));
        this.compra.getCant().setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.compra.getPrecioU().setCellValueFactory(new PropertyValueFactory("precioV"));
        this.compra.getTot().setCellValueFactory(new PropertyValueFactory("total"));
        this.compra.getIva().setCellValueFactory(new PropertyValueFactory("iva"));
        this.compra.getProducto().setItems(productos);
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(),0.0,
            c ->Pattern.matches("\\d*(\\.\\d*)?", c.getText())? c : null);
        this.compra.getPrecio().setTextFormatter(formatter);
        this.compra.getCantidad().setTextFormatter(new TextFormatter<>(new IntegerStringConverter(),0,
            c ->Pattern.matches("\\d*", c.getText())? c : null));
        
        
    }
    class anadir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Producto p=(Producto)compra.getProducto().getValue();
            if(p.getUnidades()>=Integer.parseInt(compra.getCantidad().getText())){
                detalles.add(new Detalle(p.getId(), p.getNombre(), Double.parseDouble(compra.getPrecio().getText()),Integer.parseInt(compra.getCantidad().getText()),p.getIva()));
                compra.getTable().setItems(detalles);
                double total=0;
                for(Detalle d:detalles){
                    total+=d.getTotal();
                }
                compra.getTotal().setText("Total: $"+total);
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No hay suficientes unidades del producto");
                alert.show();
            }
        }        
    }
    class combo implements ChangeListener<Producto>{
        @Override
        public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
             compra.getPrecio().setText(String.valueOf(newValue.getPrecioUnidad()));
        } 
    }

    public Tab getCompra(){
        return compra.getRoot();
    }
    
}
