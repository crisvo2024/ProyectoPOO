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
import proyectopoo.Data.Balance;
import proyectopoo.Data.Detalle;
import proyectopoo.Data.Factura;
import proyectopoo.Data.Operaciones;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Registro;
import proyectopoo.Data.Tienda;

/**
 *
 * @author dfeli
 */
public class ControlBalance {
    private VBalance balance;
    private Tienda modelo;
    private ObservableList<Registro>registros;

    public ControlBalance() {
        this.balance = new VBalance();
        Singleton s=Singleton.getSingleton();
        this.modelo = s.getModelo();
        this.balance.getCostos().setCellValueFactory(new PropertyValueFactory("costo"));
        this.balance.getFechat().setCellValueFactory(new PropertyValueFactory("fechaK"));
        this.balance.getGanancias().setCellValueFactory(new PropertyValueFactory("Ganancias"));
        this.balance.getIvaV().setCellValueFactory(new PropertyValueFactory("ivaV"));
        this.balance.getIvac().setCellValueFactory(new PropertyValueFactory("ivaC"));        
        
        this.balance.getTventas().setItems(registros);
        
        this.balance.getFechaf().setOnAction(new cambio());
        this.balance.getFechai().setOnAction(new cambio());
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
                Balance b=modelo.getBalance( Date.from(balance.getFechai().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(balance.getFechaf().getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                registros=FXCollections.observableArrayList(b.getRegistros());
                balance.getTventas().setItems(registros);
                balance.getBgvalue().setText("$"+(b.getGanancias()-b.getCostos()-b.getIVA()));
                balance.getGtvalue().setText("$"+b.getGanancias());
                balance.getIvaT().setText("$"+b.getIVA());
                balance.getCtvalue().setText("$"+b.getCostos());
            }
        }
        
    }
   public Tab getRoot(){
       return balance.getRoot();
   }
}
