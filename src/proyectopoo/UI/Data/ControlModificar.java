/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import static java.lang.Integer.parseInt;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.StringConverter;
import proyectopoo.Data.Detalle;
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
        this.modificar = new Modificar();
        this.modificar.getGuardar().setOnAction(new guardar());
        this.modelo=new Tienda();
        this.productos=FXCollections.observableArrayList(this.modelo.getInventario().getProductos());
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
        
        
        
    }
    
    class guardar implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent event) {
            for(Producto p: modelo.getInventario().getProductos()){
                if(p.equals(modificar.getProductos().getValue())){
                    p.setNombre(modificar.getNewname().getText());
                    p.setPrecioUnidad(parseInt(modificar.getNewprecio().getText()));
                    p.setIva(parseInt(modificar.getNewIVA().getText()));
                    if(parseInt(modificar.getNewexistencias().getText())>p.getUnidades()){
                        p.setIva(parseInt(modificar.getNewexistencias().getText()));
                    }
                    break;
                }
            }
            for(Producto p: productos){
                if(p.equals(modificar.getProductos().getValue())){
                    p.setNombre(modificar.getNewname().getText());
                    p.setPrecioUnidad(parseInt(modificar.getNewprecio().getText()));
                    p.setIva(parseInt(modificar.getNewIVA().getText()));
                    if(parseInt(modificar.getNewexistencias().getText())>p.getUnidades()){
                        p.setIva(parseInt(modificar.getNewexistencias().getText()));
                    }
                    break;
                }
            }
        }        
    }
    
}
