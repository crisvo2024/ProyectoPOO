/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
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
public class ControlVenta {
    private Venta venta;
    private ObservableList<Detalle> detalles;
    private Tienda modelo;
    private ObservableList<Producto>productos;
    

    public ControlVenta() {
        this.venta = new Venta();
        Singleton s=Singleton.getSingleton();
        this.modelo=s.getModelo();
        this.venta.getAnadir().setOnAction(new anadir());
        this.detalles= FXCollections.observableArrayList();
        this.productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos().values());
        this.venta.getProducto().setConverter(new StringConverter<Producto>() {
            @Override
            public String toString(Producto producto) {
                return producto.getNombre();
            }

            @Override
            public Producto fromString(String string) {
                return null;
            }
        });        
        this.venta.getProducto().setItems(productos);
        this.venta.getProducto().valueProperty().addListener(new combo());
        this.venta.getProd().setCellValueFactory(new PropertyValueFactory("nombreP"));
        this.venta.getCant().setCellValueFactory(new PropertyValueFactory("cantidad"));
        this.venta.getPrecioU().setCellValueFactory(new PropertyValueFactory("precioV"));
        this.venta.getTot().setCellValueFactory(new PropertyValueFactory("total"));
        this.venta.getIva().setCellValueFactory(new PropertyValueFactory("iva"));
        this.venta.getProducto().setItems(productos);
        TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(),0.0,
            c ->Pattern.matches("\\d*(\\.\\d*)?", c.getText())? c : null);
        this.venta.getPrecio().setTextFormatter(formatter);
        this.venta.getCantidad().setTextFormatter(new TextFormatter<>(new IntegerStringConverter(),0,
            c ->Pattern.matches("\\d*", c.getText())? c : null));
        this.venta.getNumero().setText("Factura: "+this.modelo.getFacturasV().size());
        this.venta.getContabilizar().setOnAction(new contabilizar());
        this.venta.getRoot().setOnSelectionChanged(new selected());
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            productos.clear();
            productos.addAll(modelo.getInventario().getProductos().values());
        }
        
    }
    class contabilizar implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(detalles.isEmpty()){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Añada un producto");
                a.getDialogPane().getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
                a.show();
                return;
            }
            Alert a=new Alert(Alert.AlertType.CONFIRMATION);
            a.setContentText("¿Desea guardar asi?");
            a.getDialogPane().getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
            ButtonType ok=ButtonType.YES;
            ButtonType cancel=ButtonType.CANCEL;
            a.getButtonTypes().setAll(ok,cancel);
            Optional<ButtonType> result = a.showAndWait();
            if(result.get()==ok){
                ArrayList<Detalle>de=new ArrayList<>();
                de.addAll(detalles);
                modelo.venta(de, modelo.getFacturasV().size());
                venta.getProducto().setValue(null);
                venta.getCantidad().setText("0");
                venta.getPrecio().setText("0.0");
                venta.getTotal().setText("Total: 0.0");
                detalles.clear();
            }
            venta.getNumero().setText("Factura: "+modelo.getFacturasV().size());
        }
        
    }
    class anadir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Producto p=(Producto)venta.getProducto().getValue();
            if(p==null){
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Seleccine un producto");
                a.getDialogPane().getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
                a.show();
                return;
            }
            if(p.getUnidades()>=Integer.parseInt(venta.getCantidad().getText())){
                detalles.add(new Detalle(p.getId(), p.getNombre(), Double.parseDouble(venta.getPrecio().getText()),Integer.parseInt(venta.getCantidad().getText()),p.getIva()));
                p.setUnidades(p.getUnidades()-Integer.parseInt(venta.getCantidad().getText()));
                venta.getTable().setItems(detalles);
                double total=0;
                double totaliva=0;
                for(Detalle d:detalles){
                    total+=d.getTotal();
                    totaliva+=d.getIva()*d.getTotal();
                }
                venta.getTotal().setText("Total Iva: $"+totaliva+"\nTotal: $"+total);
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("No hay suficientes unidades del producto");
                DialogPane d=alert.getDialogPane();
                d.getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
                alert.show();
            }
        }        
    }
    class combo implements ChangeListener<Producto>{
        @Override
        public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
             if(newValue!=null){
                 System.out.println(modelo.getInventario().getProductos().get(newValue.getId()).getUnidades());
                 venta.getPrecio().setText(String.valueOf(newValue.getPrecioUnidad()));
             }
        } 
    }

    public Tab getVenta(){
        return venta.getRoot();
    }
    
}
