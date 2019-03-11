/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author SANTIAGO
 */
public class VBalance {
    private Tab root;
    private VBox head;
    private GridPane l1;
    private GridPane l6;
    private GridPane l7;
    private Label Ventas;
    private DatePicker fechai;
    private Label Compras;
    private DatePicker fechaf;
    private TableView tventas;
    private TableView tcompras;
    private Label gtvalue;
    private Label ctvalue;
    private Label Gtotales;
    private Label Ctotales;
    private Label BGeneral;
    private Label bgvalue;
    private Label Finicio;
    private Label Ffinal;
    private Button Consultar;
    private TableColumn fechat;
    private TableColumn productot;
    private TableColumn cantidadt; 
    private TableColumn ivat;
    private TableColumn costot;

    
    public VBalance() {
        this.head = new VBox();
        this.l1 = new GridPane();
        this.l6 = new GridPane();
        this.l7 = new GridPane();
        this.Ventas = new Label("Ventas");
        this.fechai = new DatePicker();
        this.Compras = new Label("Compras");
        this.fechaf = new DatePicker();;
        this.tventas = new TableView();
        this.tcompras = new TableView();
        this.Gtotales = new Label("Ganancias Totales");
        this.Ctotales = new Label("Costol Totales");
        this.BGeneral = new Label("Balance General");
        this.Finicio = new Label("Fecha de Inicio");
        this.Ffinal = new Label("Fecha final");
        this.Consultar = new Button("Consultar");
        this.gtvalue = new Label("$*****");
        this.ctvalue = new Label("$*****");
        this.bgvalue = new Label("$*****");
        this.root = new Tab();
        
        
        this.Finicio.setMinSize(30, 40);
        this.Ffinal.setMinSize(30, 40);
        GridPane fechas = new GridPane();
        fechas.add(Finicio, 0, 0);
        fechas.add(Ffinal, 1, 0);
        fechas.setHgap(150);
        fechas.setAlignment(Pos.CENTER);
        head.getChildren().add(fechas);
        l1.add(fechai,1,0,1,3);
        l1.add(fechaf,5,0,1,3);
        l1.setAlignment(Pos.CENTER);
        l1.setHgap(10);
        l1.setVgap(10);
        head.getChildren().add(l1);
        
        
        
        this.Ventas.setMinSize(30, 40);
        this.Compras.setMinSize(30, 40);
        this.Gtotales.setMinSize(30, 40);
        this.gtvalue.setMinSize(30, 40);
        this.Ctotales.setMinSize(30, 40);
        this.ctvalue.setMinSize(30, 40);
        this.bgvalue.setMinSize(30, 40);
        this.BGeneral.setMinSize(30, 40);
        
        head.getChildren().add(Ventas);
        head.getChildren().add(tventas);
        this.fechat=new TableColumn("Cantidad:");
        this.productot=new TableColumn("Producto:");
        this.cantidadt=new TableColumn("Precio Unitario:");
        this.ivat=new TableColumn("IVA:");
        this.costot=new TableColumn("Precio Total:");
        this.tventas.getColumns().addAll(fechat,productot,cantidadt,ivat,costot);
        
        head.getChildren().add(Compras);
        head.getChildren().add(tcompras);
        l6.add(Gtotales,1,0);
        l6.add(gtvalue,2,0);
        l6.add(Ctotales,4,0);
        l6.add(ctvalue,5,0);
        l6.setAlignment(Pos.CENTER);
        l6.setHgap(10);
        l6.setVgap(10);
        head.getChildren().add(l6);
        l7.add(BGeneral,1,0);
        l7.add(bgvalue,2,0);
        l7.setAlignment(Pos.CENTER);
        l7.setHgap(10);
        l7.setVgap(10);
        head.getChildren().add(l7);
        head.setAlignment(Pos.CENTER);
        head.setMinSize(8, 4);
        this.head.setPadding(new Insets(50));
        root.setContent(head);
        root.setText("Balance");
        root.setClosable(false);
        
    }

    public Tab getRoot() {
        return root;
    }

    public void setRoot(Tab root) {
        this.root = root;
    }
    
    
    public DatePicker getFechai() {
        return fechai;
    }

    public void setFechai(DatePicker fechav) {
        this.fechai = fechav;
    }

    public DatePicker getFechaf() {
        return fechaf;
    }

    public void setFechaf(DatePicker fechac) {
        this.fechaf = fechac;
    }

    
    
    public TableView getTventas() {
        return tventas;
    }

    public void setTventas(TableView tventas) {
        this.tventas = tventas;
    }

    public TableView getTcompras() {
        return tcompras;
    }

    public void setTcompras(TableView tcompras) {
        this.tcompras = tcompras;
    }

    public Button getConsultar() {
        return Consultar;
    }

    public void setConsultar(Button Consultar) {
        this.Consultar = Consultar;
    }
    
    
    
    
}
