/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.awt.GridLayout;
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
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
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
        Singleton s=Singleton.getSingleton();
        this.modelo=s.getModelo();
        this.compra.getAnadir().setOnAction(new anadir());
        this.detalles= FXCollections.observableArrayList();
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
        this.compra.getNumero().setText("Factura: "+this.modelo.getFacturasC().size());
        this.compra.getAnadirP().setOnAction(new nuevo());
        
        this.compra.getContabilizar().setOnAction(new contabilizar());
        this.compra.getRoot().setOnSelectionChanged(new selected());
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            productos.clear();
            productos.addAll(modelo.getInventario().getProductos());
        }
        
    }
    class nuevo implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Dialog<String[]> d=new Dialog<>();
            d.getDialogPane().getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
            d.setTitle("Añadir Producto");
            GridPane gp=new GridPane();
            gp.add(new Label("Nombre: "),0,0);
            TextField nombre=new TextField();
            gp.add(nombre,1,0);
            gp.add(new Label("Precio de venta: "),0,1);
            TextField precio=new TextField();
            TextFormatter<Double> formatter = new TextFormatter<>(new DoubleStringConverter(),0.0,
            c ->Pattern.matches("\\d*(\\.\\d*)?", c.getText())? c : null);
            precio.setTextFormatter(formatter);
            gp.add(precio,1,1);
            gp.add(new Label("Iva: "), 0, 2);
            TextField iva=new TextField();
            iva.setTextFormatter(new TextFormatter<>(new DoubleStringConverter(),0.0,
            c ->Pattern.matches("\\d*(\\.\\d*)?", c.getText())? c : null));
            gp.add(iva, 1, 2);
            d.getDialogPane().setContent(gp);
            d.getDialogPane().getButtonTypes().addAll(ButtonType.CANCEL,ButtonType.OK);
            d.setResultConverter((param) -> {
                if(param==ButtonType.OK){
                    String[] res={nombre.getText(),precio.getText(),iva.getText()};
                    return res;  
                }else{
                    return null;
                }
                              
            });
            Optional<String[]> result = d.showAndWait();
            if(result.isPresent()){
                double p=Double.parseDouble(result.get()[1]);
                double i=Double.parseDouble(result.get()[2]);
                modelo.getInventario().AñadirProducto(modelo.getInventario().getProductos().size(), result.get()[0], p, i);
                productos.clear();
                productos.addAll(modelo.getInventario().getProductos());
            }
        }
        
    }
    class contabilizar implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
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
                modelo.compra(de, modelo.getFacturasV().size());
                compra.getProducto().setValue(null);
                compra.getCantidad().setText("0");
                compra.getPrecio().setText("0.0");
                compra.getTotal().setText("Total: 0.0");
                detalles.clear();
            }
            compra.getNumero().setText("Factura: "+modelo.getFacturasC().size());
        }
        
    }
    class anadir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Producto p=(Producto)compra.getProducto().getValue();
            detalles.add(new Detalle(p.getId(), p.getNombre(), Double.parseDouble(compra.getPrecio().getText()),Integer.parseInt(compra.getCantidad().getText()),p.getIva()));
            compra.getTable().setItems(detalles);
            double total=0;
            double totaliva=0;
            for(Detalle d:detalles){
                total+=d.getTotal();
                total+=d.getTotal();
            }
            compra.getTotal().setText("Total Iva: $"+totaliva+"Total: $"+total);            
        }        
    }
    class combo implements ChangeListener<Producto>{
        @Override
        public void changed(ObservableValue<? extends Producto> observable, Producto oldValue, Producto newValue) {
             if(newValue!=null){
                 System.out.println(modelo.getInventario().getProductos().get(newValue.getId()).getUnidades());
             }
        } 
    }

    public Tab getCompra(){
        return compra.getRoot();
    }
    
}
