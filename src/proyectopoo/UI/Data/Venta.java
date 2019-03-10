/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


/**
 *
 * @author SANTIAGO
 */
public class Venta {
    private Tab root;
    private TableView table;
    private Label numero;
    private ComboBox producto;
    private TextField cantidad;
    private TextField precio;
    private Button anadir;
    private Button contabilizar;
    private Label total;
    

    public Venta() {
        this.numero=new Label("Factura: 1234");        
        BorderPane head=new BorderPane();
        head.setPadding(new Insets(5));
        head.setLeft(new Label("Cuenta"));
        head.setRight(numero);
        
        VBox tab=new VBox(head);
        
        TableColumn cant=new TableColumn("Cantidad");
        TableColumn produto=new TableColumn("Producto");
        TableColumn precioU=new TableColumn("Precio Unitario");
        TableColumn iva=new TableColumn("IVA");
        TableColumn tot=new TableColumn("Total");
        
        this.table=new TableView();
        this.table.getColumns().addAll(cant,produto,precioU,iva,tot);
        tab.getChildren().add(this.table);
        
        GridPane gp=new GridPane();
        gp.setStyle("-fx-border-radius:18;-fx-background-radius:18;");
        gp.setVgap(5);
        gp.add(new Label("Producto"), 0, 0);
        this.producto=new ComboBox();
        gp.add(this.producto, 1, 0);
        gp.add(new Label("Cantidad"),0,1);
        this.cantidad=new TextField();
        gp.add(this.cantidad,1,1);
        gp.add(new Label("Valor Unitario"), 0, 2);
        this.precio=new TextField();
        gp.add(this.precio,1,2);
        this.anadir=new Button("A\u00F1adir");
        gp.add(this.anadir,1,3);
        GridPane.setHalignment(this.anadir, HPos.RIGHT);
        
        this.contabilizar=new Button("Contabilizar");
        this.total=new Label("Total: $0.00");
        BorderPane hb=new BorderPane();
        hb.setLeft(gp);
        hb.setTop(this.total);
        BorderPane.setAlignment(this.total, Pos.TOP_RIGHT);
        BorderPane.setMargin(this.total, new Insets(10, 0, 10, 0));
        hb.setBottom(this.contabilizar);
        BorderPane.setAlignment(this.contabilizar, Pos.BOTTOM_RIGHT);
        tab.getChildren().add(hb);
        
        
        
        tab.setPadding(new Insets(50));
        this.root=new Tab("Venta");
        this.root.setContent(tab);
        this.root.setClosable(false);
    }

    public Tab getRoot() {
        return root;
    }

    public TableView getTable() {
        return table;
    }

    public Label getNumero() {
        return numero;
    }

    public ComboBox getProducto() {
        return producto;
    }

    public TextField getCantidad() {
        return cantidad;
    }

    public TextField getPrecio() {
        return precio;
    }

    public Button getAnadir() {
        return anadir;
    }

    public Button getContabilizar() {
        return contabilizar;
    }

    public Label getTotal() {
        return total;
    }
    
    
}
