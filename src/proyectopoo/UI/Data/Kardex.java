/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author SANTIAGO
 */
public class Kardex {
    private Tab root;
    private GridPane head;
    private Label producto;
    private ComboBox selecproducto;
    private Label Finicio;
    private Label Ffinal;
    private DatePicker ini;
    private DatePicker fin;
    private TableView table;
    private TableColumn tfecha;
    private TableColumn tdetalle;
    private TableColumn tvendidos;
    private TableColumn tcomprados;
    private TableColumn texistencias;
    private TableColumn tvalor;
    private Label existAct;
    private Label totalExist;
    private Label ValorActual;
    private Label Valuexist;

    public Kardex() {
        this.head = new GridPane();
        this.producto = new Label("Producto:");
        this.selecproducto = new ComboBox();
        this.Finicio = new Label("Fecha de inicio");
        this.Ffinal = new Label("Fecha final");
        this.ini = new DatePicker();
        this.fin = new DatePicker();
        this.table = new TableView();
        this.tfecha = new TableColumn("Fecha");;
        this.tdetalle = new TableColumn("Detalle");
        this.tvendidos = new TableColumn("Vendidos");
        this.tcomprados = new TableColumn("Comprados");
        this.texistencias = new TableColumn("Existencias");
        this.tvalor = new TableColumn("Valor");
        this.existAct = new Label("Existencias actuales:");
        this.totalExist = new Label(" *** ");
        this.ValorActual = new Label("Valor actual existencias:");
        this.Valuexist = new Label("$***.**");
        this.root = new Tab();
        this.table.getColumns().addAll(tfecha,tdetalle,tvendidos,tcomprados,texistencias,tvalor);
        
        head.add(this.producto, 0, 0,1,2);
        head.add(this.selecproducto, 1,0,2,2);
        head.add(this.Finicio, 5, 0,7,1);
        head.add(this.Ffinal, 5, 1,7,1);
        head.add(this.ini, 8, 0);
        head.add(this.fin, 8, 1);
        head.add(table, 0, 2,12,5);
        head.setAlignment(Pos.CENTER);
        this.head.setPadding(new Insets(50));
        head.setHgap(20);
        head.setVgap(30);
        head.add(existAct, 0, 7,10,1);
        head.add(totalExist, 5, 7);
        head.add(ValorActual, 0, 8,10,1);
        head.add(Valuexist, 5, 8);
        
        
        root.setContent(head);
        root.setClosable(false);
        root.setText("Kardex");
    }

    public Label getValuexist() {
        return Valuexist;
    }

    public Label getTotalExist() {
        return totalExist;
    }
    
    public TableView getTable() {
        return table;
    }
    
    public Tab getRoot() {
        return root;
    }

    public void setRoot(Tab root) {
        this.root = root;
    }
    
    public ComboBox getSelecproducto() {
        return selecproducto;
    }

    public void setSelecproducto(ComboBox selecproducto) {
        this.selecproducto = selecproducto;
    }

    public DatePicker getIni() {
        return ini;
    }

    public void setIni(DatePicker ini) {
        this.ini = ini;
    }

    public DatePicker getFin() {
        return fin;
    }

    public void setFin(DatePicker fin) {
        this.fin = fin;
    }

    public TableColumn getTfecha() {
        return tfecha;
    }

    public void setTfecha(TableColumn tfecha) {
        this.tfecha = tfecha;
    }

    public TableColumn getTdetalle() {
        return tdetalle;
    }

    public void setTdetalle(TableColumn tdetalle) {
        this.tdetalle = tdetalle;
    }

    public TableColumn getTvendidos() {
        return tvendidos;
    }

    public void setTvendidos(TableColumn tvendidos) {
        this.tvendidos = tvendidos;
    }

    public TableColumn getTcomprados() {
        return tcomprados;
    }

    public void setTcomprados(TableColumn tcomprados) {
        this.tcomprados = tcomprados;
    }

    public TableColumn getTexistencias() {
        return texistencias;
    }

    public void setTexistencias(TableColumn texistencias) {
        this.texistencias = texistencias;
    }

    public TableColumn getTvalor() {
        return tvalor;
    }

    public void setTvalor(TableColumn tvalor) {
        this.tvalor = tvalor;
    }

    public Label getExistAct() {
        return existAct;
    }

    public void setExistAct(Label existAct) {
        this.existAct = existAct;
    }

    
    
    
    
}
