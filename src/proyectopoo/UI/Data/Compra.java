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
    private TableColumn cant;
    private TableColumn precioU;
    private TableColumn iva;
    private TableColumn tot;
    private TableColumn prod;  
    private Label numero;
    private TextField cliente;
    private TextField docCliente;
    private ComboBox producto;
    private TextField cantidad;
    private TextField precio;
    private Button anadir;
    private Button contabilizar;
    private Button anadirP;
    private Button quitar;
    private Label total;
    

    public Compra() {
        this.numero=new Label("Factura: 1234");        
        this.head=new BorderPane();
        this.head.setPadding(new Insets(5));
        this.head.setBottom(new Label("Cuenta"));
        this.head.setRight(numero);
        this.cliente=new TextField();
        this.docCliente=new TextField();
        HBox cl=new HBox(new Label("Cliente: "));
        cl.setSpacing(10);
        cl.setPadding(new Insets(10));
        cl.getChildren().add(this.cliente);
        cl.getChildren().add(new Label("Documento: "));
        cl.getChildren().add(this.docCliente);
        head.setLeft(cl);
        this.tab=new VBox(head);
        
        this.cant=new TableColumn("Cantidad");
        this.prod=new TableColumn("Producto");
        this.precioU=new TableColumn("Precio Unitario");
        this.iva=new TableColumn("IVA");
        this.tot=new TableColumn("Total");
        
        this.table=new TableView();
        this.table.getColumns().addAll(this.cant,this.prod,this.precioU,this.iva,this.tot);
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
        this.quitar=new Button("Quitar");
        this.quitar.setVisible(false);
        this.tab.alignmentProperty().set(Pos.CENTER_RIGHT);
        this.tab.getChildren().add(quitar);
        this.tab.getChildren().add(hb);
        
        
        this.tab.setPadding(new Insets(50));
        this.root=new Tab("Compra");
        this.root.setContent(tab);
        this.root.setClosable(false);
    }

    public Tab getRoot() {
        return root;
    }

    public Button getQuitar() {
        return quitar;
    }
    
    public VBox getTab() {
        return tab;
    }

    public TextField getCliente() {
        return cliente;
    }

    public TextField getDocCliente() {
        return docCliente;
    }
    
    public BorderPane getHead() {
        return head;
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

    public Button getAnadirP() {
        return anadirP;
    }

    public Label getTotal() {
        return total;
    }

    public TableColumn getCant() {
        return cant;
    }

    public TableColumn getPrecioU() {
        return precioU;
    }

    public TableColumn getIva() {
        return iva;
    }

    public TableColumn getTot() {
        return tot;
    }

    public TableColumn getProd() {
        return prod;
    }
    
}
