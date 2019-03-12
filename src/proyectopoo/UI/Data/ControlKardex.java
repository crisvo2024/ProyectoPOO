/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.time.ZoneId;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import proyectopoo.Data.Operaciones;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Tienda;

/**
 *
 * @author Santiago
 */
public class ControlKardex {
    private Kardex kardex;
    private ObservableList<Producto> productos;
    private ObservableList<Operaciones>operaciones;
    private Tienda modelo;

    public ControlKardex() {
        Singleton s=Singleton.getSingleton();
        this.modelo=s.getModelo();
        this.kardex=new Kardex();
        productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos());
        this.kardex.getSelecproducto().setConverter(new StringConverter<Producto>() {
            @Override
            public String toString(Producto producto) {
                return producto.getNombre();
            }

            @Override
            public Producto fromString(String string) {
                return null;
            }
        });
        this.kardex.getSelecproducto().setItems(productos);
        this.kardex.getTcomprados().setCellValueFactory(new PropertyValueFactory("entradas"));
        this.kardex.getTexistencias().setCellValueFactory(new PropertyValueFactory("existencias"));
        this.kardex.getTfecha().setCellValueFactory(new PropertyValueFactory("fecha"));
        
        this.kardex.getTvalor().setCellValueFactory(new PropertyValueFactory(""));
        this.operaciones=FXCollections.observableArrayList();
        kardex.getTable().setItems(operaciones);
        this.kardex.getSelecproducto().setOnAction(new cambio());
        this.kardex.getIni().setOnAction(new cambio());
        this.kardex.getFin().setOnAction(new cambio());
        this.kardex.getRoot().setOnSelectionChanged(new selected());
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            productos.clear();
            productos.addAll(modelo.getInventario().getProductos());
        }
        
    }
    class cambio implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(kardex.getIni().getValue()!=null&&kardex.getFin().getValue()!=null&&kardex.getSelecproducto().getValue()!=null){
                operaciones=FXCollections.observableArrayList(modelo.getKardex(((Producto)kardex.getSelecproducto().getValue()).getId(), Date.from(kardex.getIni().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(kardex.getFin().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())));
            }
        }
        
    }
    public Tab getKardex(){
        return kardex.getRoot();
    }
}
