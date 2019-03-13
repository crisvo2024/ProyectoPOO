/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.time.ZoneId;
import java.util.ArrayList;
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
        productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos().values());
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
        this.kardex.getSelecproducto().getSelectionModel().clearSelection();
        this.kardex.getTcomprados().setCellValueFactory(new PropertyValueFactory("entradas"));
        this.kardex.getTexistencias().setCellValueFactory(new PropertyValueFactory("existencias"));
        this.kardex.getTfecha().setCellValueFactory(new PropertyValueFactory("fechaK"));
        this.kardex.getTvendidos().setCellValueFactory(new PropertyValueFactory("salidas"));
        this.kardex.getTdetalle().setCellValueFactory(new PropertyValueFactory("detalles"));
        this.kardex.getTvalor().setCellValueFactory(new PropertyValueFactory("valorE"));
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
            productos.addAll(modelo.getInventario().getProductos().values());
            if(kardex.getIni().getValue()!=null&&kardex.getFin().getValue()!=null&&kardex.getSelecproducto().getValue()!=null){
                ArrayList<Operaciones> o=modelo.getKardex(((Producto)kardex.getSelecproducto().getValue()).getId(), Date.from(kardex.getIni().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(kardex.getFin().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                operaciones=FXCollections.observableArrayList(o);
                kardex.getTable().setItems(operaciones);
                kardex.getTotalExist().setText(String.valueOf(o.get(o.size()-1).getExistencias()));
                kardex.getValuexist().setText(String.valueOf(o.get(o.size()-1).getValorE()));
            }
        }
        
    }
    class cambio implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(kardex.getIni().getValue()!=null&&kardex.getFin().getValue()!=null&&kardex.getSelecproducto().getValue()!=null){
                ArrayList<Operaciones> o=modelo.getKardex(((Producto)kardex.getSelecproducto().getValue()).getId(), Date.from(kardex.getIni().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(kardex.getFin().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                operaciones=FXCollections.observableArrayList(o);
                kardex.getTable().setItems(operaciones);
                kardex.getTotalExist().setText(String.valueOf(o.get(o.size()-1).getExistencias()));
                kardex.getValuexist().setText(String.valueOf(o.get(o.size()-1).getValorE()));
            }
        }
        
    }
    public Tab getKardex(){
        return kardex.getRoot();
    }
}
