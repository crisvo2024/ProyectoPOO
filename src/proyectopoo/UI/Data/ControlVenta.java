/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        this.venta.getAnadir().setOnAction(new anadir());
        this.detalles= FXCollections.observableArrayList();
        this.modelo=new Tienda();
        this.productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos());
        
        this.venta.getProducto().setItems(productos);
        
    }
    class anadir implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            venta.getTable().setItems(detalles);
        }        
    }
    
    
}
