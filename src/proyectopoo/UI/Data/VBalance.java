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
    private Label ivaT;
    private Button Consultar;
    private TableColumn fechat;
    private TableColumn costos;
    private TableColumn ivac; 
    private TableColumn ivaV;
    private TableColumn ganancias;


    
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
        Label IvaP=new Label("Iva a pagar:");
        Label Finicio = new Label("Fecha de Inicio:");
        Label Ffinal = new Label("Fecha final:");
        this.Consultar = new Button("Consultar");
        this.gtvalue = new Label("$*****");
        this.ctvalue = new Label("$*****");
        this.bgvalue = new Label("$*****");
        this.ivaT = new Label("$*****");
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
        this.fechat=new TableColumn("Fecha");
        this.ivac=new TableColumn("IVA Comprado");
        this.ivaV=new TableColumn("IVA Vendido");
        this.ganancias=new TableColumn("Ganancias");
        this.costos=new TableColumn("Costos");
        this.tventas.getColumns().addAll(fechat,ivac,ivaV,ganancias,costos);
        
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
        l7.add(IvaP,1,1);
        l7.add(ivaT,2,1);
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

    public VBox getHead() {
        return head;
    }

    public DatePicker getFechai() {
        return fechai;
    }

    public DatePicker getFechaf() {
        return fechaf;
    }

    public TableView getTventas() {
        return tventas;
    }

    public Label getGtvalue() {
        return gtvalue;
    }

    public Label getCtvalue() {
        return ctvalue;
    }

    public Label getBgvalue() {
        return bgvalue;
    }

    public Label getIvaT() {
        return ivaT;
    }

    public Button getConsultar() {
        return Consultar;
    }

    public TableColumn getFechat() {
        return fechat;
    }

    public TableColumn getCostos() {
        return costos;
    }

    public TableColumn getIvac() {
        return ivac;
    }

    public TableColumn getIvaV() {
        return ivaV;
    }

    public TableColumn getGanancias() {
        return ganancias;
    }
    
}
