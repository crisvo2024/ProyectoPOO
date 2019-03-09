/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author dfeli
 */
public class Modificar {
    private Tab root;
    private GridPane head;
    private Label Producto;
    private Label Nombre;
    private Label PrecioDeVenta;
    private Label Existencias;
    private Label IVA;
    private Label Nota;
    private ComboBox productos;
    private TextField newname;
    private TextField newprecio;
    private TextField newexistencias;
    private TextField newIVA;
    
    private Button Guardar;
    
   public Modificar() {
       
        this.Producto=new Label("Producto");
        this.Nombre=new Label("Nombre"); 
        this.PrecioDeVenta=new Label("Precio de Venta"); 
        this.Existencias=new Label("Existencias"); 
        this.Nota=new Label("Nota: no se puede deshacer la \n modificacion  de las existencias"); 
        this.IVA=new Label("IVA"); 
        this.productos = new ComboBox();
        
        this.root= new Tab();
        this.head=new GridPane();
        this.head.setPadding(new Insets(50));
        head.setStyle("-fx-border-radius:18;-fx-background-radius:18;");
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(25);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(55);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(15);
        
        
        this.head.getColumnConstraints().addAll(col1,col2,col3);
        this.newname =new TextField();
        this.newprecio =new TextField();
        this.newexistencias =new TextField();
        this.newIVA =new TextField();
        
        this.head.add(Producto, 0, 1);
        this.head.add(Nombre, 0, 2);
        this.head.add(PrecioDeVenta, 0, 3);
        this.head.add(Existencias, 0, 4);
        this.head.add(IVA, 0, 5);
        this.head.add(Nota, 1, 6);
       
        this.head.add(productos, 1, 1);
        this.head.add(newname, 1, 2);
        this.head.add(newprecio, 1, 3);
        this.head.add(newexistencias, 1, 4);
        this.head.add(newIVA, 1, 5);
        
        head.setHgap(20);
        head.setVgap(15);
        this.Guardar = new Button("Guardar");
        this.head.add(Guardar, 2, 6);
        this.root.setClosable(false);
        this.root.setContent(head);
    }

    public GridPane getRoot() {
        return head;
    } 
}
