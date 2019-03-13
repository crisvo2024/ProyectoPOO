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
import proyectopoo.Data.Detalle;
import proyectopoo.Data.Factura;
import proyectopoo.Data.Operaciones;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Tienda;

/**
 *
 * @author dfeli
 */
public class ControlBalance {
    private VBalance balance;
    private Tienda modelo;
    private ObservableList<Operaciones>operaciones;

    public ControlBalance() {
        this.balance = new VBalance();
        Singleton s=Singleton.getSingleton();
        this.modelo = s.getModelo();
        
        this.balance.getCantidadc().setCellValueFactory(new PropertyValueFactory("entradas"));
        this.balance.getFechac().setCellValueFactory(new PropertyValueFactory("fechaK"));
        this.balance.getFechat().setCellValueFactory(new PropertyValueFactory("fechaK"));
        this.balance.getCantidadt().setCellValueFactory(new PropertyValueFactory("salidas"));
        this.balance.getIngresot().setCellValueFactory(new PropertyValueFactory("precioVenta"));
        this.balance.getIvat().setCellFactory(new PropertyValueFactory("iva"));
        this.balance.getIvac().setCellFactory(new PropertyValueFactory("iva"));
        this.balance.getCostoc().setCellValueFactory(new PropertyValueFactory("costo"));
        
        this.balance.getRoot().setOnSelectionChanged(new selected());
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            
        }
        
    }
   class cambio implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            if(balance.getFechai().getValue()!=null&&balance.getFechaf().getValue()!=null){
//                ArrayList<Operaciones> o=modelo.getKardex(((Producto)kardex.getSelecproducto().getValue()).getId(), Date.from(kardex.getIni().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(kardex.getFin().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//                operaciones=FXCollections.observableArrayList(o);
//                kardex.getTable().setItems(operaciones);
//                kardex.getTotalExist().setText(String.valueOf(o.get(o.size()-1).getExistencias()));
//                kardex.getValuexist().setText(String.valueOf(o.get(o.size()-1).getValorE()));
                
            }
        }
        
    }
   public Tab getRoot(){
       return balance.getRoot();
   }
}
