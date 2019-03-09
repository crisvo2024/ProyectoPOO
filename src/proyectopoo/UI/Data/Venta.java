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
    private VBox tab;
    private BorderPane head;
    private TableView table;
    private Label numero;
    private ComboBox producto;
    private TextField cantidad;
    private TextField precio;
    private Button anadir;
    private Button contabilizar;
    

    public Venta() {
        this.numero=new Label("Factura: 1234");        
        this.head=new BorderPane();
        this.head.setPadding(new Insets(5));
        this.head.setLeft(new Label("Cuenta"));
        this.head.setRight(numero);
        this.tab=new VBox(head);
        
        TableColumn cantidad=new TableColumn("Cantidad");
        TableColumn produto=new TableColumn("Producto");
        TableColumn precioU=new TableColumn("Precio Unitario");
        TableColumn iva=new TableColumn("IVA");
        TableColumn total=new TableColumn("Total");
        
        this.table=new TableView();
        this.table.getColumns().addAll(cantidad,produto,precioU,iva,total);
        this.tab.getChildren().add(this.table);
        
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
        this.tab.getChildren().add(gp);
        
        this.contabilizar=new Button("Contabilizar");
        BorderPane hb=new BorderPane();
        hb.setPadding(new Insets(10,10,10,170));
        this.anadir=new Button("A\u00F1adir");
        hb.setLeft(this.anadir);
        hb.setRight(this.contabilizar);
        this.tab.getChildren().add(hb);
        
        
        this.tab.setPadding(new Insets(20));
        this.root=new Tab("Venta");
        this.root.setContent(tab);
        this.root.setClosable(false);
        this.tab.setStyle("-fx-base:black;");
    }

    public Tab getRoot() {
        return root;
    }
    
}
