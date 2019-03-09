/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import java.awt.GridLayout;
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
public class Compra {
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
    private Button anadirP;
    private Label total;
    

    public Compra() {
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
        this.anadir=new Button("A\u00F1adir");
        gp.add(this.anadir,1,3);
        GridPane.setHalignment(this.anadir, HPos.RIGHT);
        
        
        this.total=new Label("Total: $0.00");
        this.anadirP=new Button("Crear Nuevo Producto");
        this.contabilizar=new Button("Contabilizar");
        BorderPane hb=new BorderPane();
        hb.setPadding(new Insets(10,0,0,0));
        hb.setRight(this.anadirP);
        BorderPane.setMargin(this.anadirP, new Insets(10, 0, 0, 5));
        BorderPane.setAlignment(this.anadirP, Pos.TOP_RIGHT);
        hb.setTop(this.total);
        BorderPane.setAlignment(this.total, Pos.TOP_RIGHT);
        hb.setLeft(gp);
        hb.setBottom(this.contabilizar);
        BorderPane.setAlignment(this.contabilizar, Pos.BOTTOM_RIGHT);
        
        this.tab.getChildren().add(hb);
        
        
        this.tab.setPadding(new Insets(50));
        this.root=new Tab("Compra");
        this.root.setContent(tab);
        this.root.setClosable(false);
    }

    public Tab getRoot() {
        return root;
    }
    
}
