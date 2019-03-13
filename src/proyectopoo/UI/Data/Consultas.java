/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.UI.Data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author dfeli
 */
public class Consultas {
    
    private Label selecFac;
    private Label dateFecha;
    private Label ValueCompra;
    private Label Cliente;
    private Label Documento;
    private ComboBox Factura;
    private ComboBox NumFactura;
    private Button buscar;
    private TableView table;
    private TableColumn cantidad;
    private TableColumn producto;
    private TableColumn precioU; 
    private TableColumn iva;
    private TableColumn total;
    private GridPane head;
    private Tab root;

    public Consultas() {
        this.Factura = new ComboBox();
        this.NumFactura = new ComboBox();
        this.selecFac = new Label("#********");
        this.dateFecha = new Label("DD/MM/YYYY");
        this.ValueCompra = new Label("$***.***");
        this.Cliente=new Label();
        this.Documento=new Label();
        this.buscar = new Button("Buscar");
        this.table = new TableView();
        this.head = new GridPane();
        this.head.setAlignment(Pos.CENTER);
        
        buscar.setMinSize(100, 20);
        
        this.cantidad=new TableColumn("Cantidad");
        this.producto=new TableColumn("Producto");
        this.precioU=new TableColumn("Precio Unitario");
        this.iva=new TableColumn("IVA");
        this.total=new TableColumn("Precio Total");
        this.cantidad.setMinWidth(0);
        
        
        this.table.getColumns().addAll(cantidad,producto,precioU,iva,total);
        
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(20);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(20);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(20);
        ColumnConstraints col4 = new ColumnConstraints();
        col3.setPercentWidth(20);
        ColumnConstraints col5 = new ColumnConstraints();
        col3.setPercentWidth(20);
        
        this.head.getColumnConstraints().addAll(col1,col2,col3,col4,col5);
        
        
        this.head.add(new Label("Tipo de factura: "), 0, 0,2,1);
        this.head.add(new Label ("Numero de la factura: "), 0, 1,2,1);
        this.head.add(new Label("Factura:"), 0, 4,1,1);
        this.head.add(new Label("Cliente: "),0,5,1,1);
        this.head.add(new Label("Documento: "), 2,5);
        this.head.add(table, 0, 6,7,2);
        
        this.head.add(Factura, 2, 0);
        this.head.add(NumFactura, 2, 1);
        this.head.add(Cliente, 1, 5);
        
        this.head.add(new Label("Fecha:"), 3, 4);
        this.head.add(dateFecha, 4, 4,2,1);
        this.head.add(buscar,4, 0,2,2);
        this.head.add(Documento, 3, 5);
        
        this.head.add(selecFac, 1, 4);
        this.head.add(new Label("Total Compra: "), 4, 8);
        this.head.add(this.ValueCompra, 5, 8);
        head.setHgap(10);
        head.setVgap(10);
        this.head.setPadding(new Insets(50));
        this.root=new Tab("Consultas");
        this.root.setContent(head);
        this.root.setClosable(false);
    }
    public Tab getRoot() {
        return root;
    }

    public Label getCliente() {
        return Cliente;
    }

    public Label getDocumento() {
        return Documento;
    }


    public TableColumn getIva() {
        return iva;
    }
    
    public Label getValueCompra() {
        return ValueCompra;
    }

    public void setValueCompra(Label ValueCompra) {
        this.ValueCompra = ValueCompra;
    }

    public Button getBuscar() {
        return buscar;
    }

    public void setBuscar(Button buscar) {
        this.buscar = buscar;
    }
    
    
    public void setRoot(Tab root) {
        this.root = root;
    }
    public Label getSelecFac() {
        return selecFac;
    }

    public void setSelecFac(Label selecFac) {
        this.selecFac = selecFac;
    }

    public Label getDateFecha() {
        return dateFecha;
    }

    public void setDateFecha(Label dateFecha) {
        this.dateFecha = dateFecha;
    }
    public ComboBox getFactura() {
        return Factura;
    }
    public void setFactura(ComboBox Factura) {
        this.Factura = Factura;
    }
    public ComboBox getNumFactura() {
        return NumFactura;
    }
    public void setNumFactura(ComboBox NumFactura) {
        this.NumFactura = NumFactura;
    }
    public TableView getTable() {
        return table;
    }
    public void setTable(TableView table) {
        this.table = table;
    }
    public TableColumn getCantidad() {
        return cantidad;
    }
    public void setCantidad(TableColumn cantidad) {
        this.cantidad = cantidad;
    }
    public TableColumn getProducto() {
        return producto;
    }
    
    public void setProducto(TableColumn producto) {
        this.producto = producto;
    }

    public TableColumn getPrecioU() {
        return precioU;
    }

    public void setPrecioU(TableColumn precioU) {
        this.precioU = precioU;
    }

    public TableColumn getTotal() {
        return total;
    }

    public void setTotal(TableColumn total) {
        this.total = total;
    }

    public GridPane getHead() {
        return head;
    }

    public void setHead(GridPane head) {
        this.head = head;
    }
    
    
}
