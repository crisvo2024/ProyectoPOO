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
    private DatePicker fechai;
    private DatePicker fechaf;
    private TableView tventas;
    private Label gtvalue;
    private Label ctvalue;
    private Label bgvalue;
    private Button Consultar;
    private TableColumn fechat;
    private TableColumn productot;
    private TableColumn cantidadt; 
    private TableColumn ivat;
    private TableColumn ingresot;


    
    public VBalance() {
        this.head = new VBox();
        GridPane l1 = new GridPane();
        GridPane l6 = new GridPane();
        GridPane l7 = new GridPane();
        this.fechai = new DatePicker();
        this.fechaf = new DatePicker();;
        this.tventas = new TableView();
        Label Gtotales = new Label("Ganancias Totales");
        Label Ctotales = new Label("Costol Totales");
        Label BGeneral = new Label("Balance General");
        Label Finicio = new Label("Fecha de Inicio:");
        Label Ffinal = new Label("Fecha final:");
        this.Consultar = new Button("Consultar");
        this.gtvalue = new Label("$*****");
        this.ctvalue = new Label("$*****");
        this.bgvalue = new Label("$*****");
        this.root = new Tab();
        
        
        Finicio.setMinSize(30, 40);
        Ffinal.setMinSize(30, 40);
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
        
        
        
        
        Label Ventas = new Label("Registros");
        Ventas.setMinSize(30, 40);
        
        Gtotales.setMinSize(30, 40);
        this.gtvalue.setMinSize(30, 40);
        Ctotales.setMinSize(30, 40);
        this.ctvalue.setMinSize(30, 40);
        this.bgvalue.setMinSize(30, 40);
        BGeneral.setMinSize(30, 40);
        
        head.getChildren().add(Ventas);
        head.getChildren().add(tventas);
        this.fechat=new TableColumn("Fecha:");
        this.productot=new TableColumn("Producto:");
        this.cantidadt=new TableColumn("Cantidad:");
        this.ivat=new TableColumn("IVA:");
        this.ingresot=new TableColumn("Ganancias:");
        this.tventas.getColumns().addAll(fechat,productot,cantidadt,ivat,ingresot);
        
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

    public TableColumn getFechat() {
        return fechat;
    }

    public TableColumn getProductot() {
        return productot;
    }

    public TableColumn getCantidadt() {
        return cantidadt;
    }

    public TableColumn getIvat() {
        return ivat;
    }

    public TableColumn getIngresot() {
        return ingresot;
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

    public Button getConsultar() {
        return Consultar;
    }

    public void setConsultar(Button Consultar) {
        this.Consultar = Consultar;
    }
    
    
    
    
}
