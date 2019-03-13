/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import static java.lang.Integer.parseInt;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.util.StringConverter;
import proyectopoo.Data.Detalle;
import proyectopoo.Data.Operaciones;
import proyectopoo.Data.Producto;
import proyectopoo.Data.Tienda;

/**
 *
 * @author dfeli
 */
public class ControlModificar {
    private Modificar modificar;
    private Tienda modelo;
    private ObservableList<Producto>productos;
    

    public ControlModificar() {
        Singleton s=Singleton.getSingleton();
        this.modelo=s.getModelo();
        this.modificar = new Modificar();
        this.modificar.getGuardar().setOnAction(new guardar());        
        this.productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos().values());
        this.modificar.getProductos().setConverter(new StringConverter<Producto>() {
            @Override
            public String toString(Producto producto){
                return producto.getNombre();
            }

            @Override
            public Producto fromString(String string) {
               return null;
            }
        });
        this.modificar.getProductos().setItems(productos);
        this.modificar.getProductos().setOnAction(new cambio());
        this.modificar.getRoot().setOnSelectionChanged(new selected());
    }
    class selected implements EventHandler<Event>{

        @Override
        public void handle(Event event) {
            productos.clear();
            productos.addAll(modelo.getInventario().getProductos().values());
        }
        
    }
    class guardar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            Producto p=modelo.getInventario().getProductos().get(((Producto)modificar.getProductos().getValue()).getId());
            if(parseInt(modificar.getNewexistencias().getText())<=p.getUnidades()){
                p.setUnidades(parseInt(modificar.getNewexistencias().getText()));
            }else{
                Alert a=new Alert(Alert.AlertType.ERROR);
                a.setContentText("Solo puede quitar unidades, para aumentaras haga la factura de compra");
                a.getDialogPane().getStylesheets().add(this.getClass().getResource("project.css").toExternalForm());
                a.show();
                return;
            }
            p.setNombre(modificar.getNewname().getText());
            p.setPrecioUnidad(Double.parseDouble(modificar.getNewprecio().getText()));
            p.setIva(Double.parseDouble(modificar.getNewIVA().getText()));
            
        }        
    }
    class cambio implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Producto p=(Producto)modificar.getProductos().getValue();
            if(p!=null){
                modificar.getNewIVA().setText(String.valueOf(p.getIva()));
                modificar.getNewexistencias().setText(String.valueOf(p.getUnidades()));
                modificar.getNewname().setText(p.getNombre());
                modificar.getNewprecio().setText(String.valueOf(p.getPrecioUnidad()));
            }
        }
        
    }
    public Tab getModificar(){
        return modificar.getRoot();
    }
}
