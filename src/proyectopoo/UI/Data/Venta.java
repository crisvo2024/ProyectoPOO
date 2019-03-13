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
    private Button quitar;
    private Label total;
    

    public Venta() {
        this.numero=new Label("Factura: 1234");        
        BorderPane head=new BorderPane();
        head.setPadding(new Insets(5));
        head.setBottom(new Label("Cuenta"));
        head.setRight(numero);
        this.cliente=new TextField();
        this.docCliente=new TextField();
        HBox cl=new HBox(new Label("Cliente: "));
        cl.setSpacing(10);
        cl.setPadding(new Insets(10));
        cl.getChildren().add(this.cliente);
        cl.getChildren().add(new Label("Documento: "));
        cl.getChildren().add(this.docCliente);
        head.setLeft(cl);
        
        
        VBox tab=new VBox(head);
        
        this.cant=new TableColumn("Cantidad");
        this.prod=new TableColumn("Producto");
        this.precioU=new TableColumn("Precio Unitario");
        this.iva=new TableColumn("IVA");
        this.tot=new TableColumn("Total");
        
        this.table=new TableView();
        this.table.getColumns().addAll(cant,prod,precioU,iva,tot);
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
        this.quitar=new Button("Quitar");
        this.quitar.setVisible(false);
        tab.alignmentProperty().set(Pos.CENTER_RIGHT);
        tab.getChildren().add(quitar);
        tab.getChildren().add(hb);
        
        
        
        tab.setPadding(new Insets(50));
        this.root=new Tab("Venta");
        this.root.setContent(tab);
        this.root.setClosable(false);
    }

    public Tab getRoot() {
        return root;
    }

    public Button getQuitar() {
        return quitar;
    }

    public TextField getCliente() {
        return cliente;
    }

    public TextField getDocCliente() {
        return docCliente;
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
