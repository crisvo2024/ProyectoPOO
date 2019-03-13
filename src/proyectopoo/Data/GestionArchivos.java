/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectopoo.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dfeli
 */
public class GestionArchivos {
    public void GuardarRegistro(Inventario inventario) throws IOException{
        File archivo = new File("Archivos/Productos.txt");
        archivo.createNewFile();
        FileWriter x= new FileWriter(archivo);
        for(Producto p: inventario.getProductos().values()){
            x.write(p.getId()+":"+p.getNombre()+":"+p.getUnidades()+":"+p.getPrecioUnidad()+":"+p.getIva()+"\n");
        }
        x.close();
        
        File archivo2 = new File("Archivos/Registros.txt");
        archivo.createNewFile();
        FileWriter y= new FileWriter(archivo2);
        
        for(Registro registro: inventario.getRegistros().values()){
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
          //this.valorExistencias = valorExistencias;
        //this.Ganancias = Ganancias;
        //this.costo = costo;
        //this.ivaC = ivaC;
        //this.ivaV = ivaV;
            y.write(fecha.format(registro.getFecha())+":"+registro.getValorExistencias()+":"+registro.getGanancias()+":"+registro.getCosto()+":"+registro.getIvaC+":"+registro.getIvaV+"\n);
            
            
            
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    public void GuardarFactura(ArrayList<Factura> factura, String ruta) throws IOException{
        File archivo = new File(ruta);
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileWriter x= new FileWriter(archivo);
        for(Factura f: factura){
            SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
            
            x.write(fecha.format(f.fecha)+":"+f.numero+"\n");
            
            for(Detalle d: f.Entradas){
            x.write("-"+":"+d.idP+":"+d.getNombreP()+":"+d.precioV+":"+d.cantidad+":"+d.iva+"\n");
            }
            x.write("\n");
        }
        x.close();
    }
    public ArrayList<Factura> LeerFactura(String ruta) throws IOException, ParseException{
        ArrayList<Factura> fc = new ArrayList<>();
        ArrayList<Detalle> dt = new ArrayList<>();
        File archivo = new File(ruta);
        FileInputStream fa = new FileInputStream (archivo); 
        BufferedReader x = new BufferedReader(new InputStreamReader(fa));
        String b="";
        while(x.ready()){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            b = x.readLine();
            String[] lectura = b.split(":");
            Date fecha = format.parse(lectura[0]);
            int numero = parseInt(lectura[1]); 
            b = x.readLine();
            while(b.contains("-")){
            lectura = b.split(":");
            dt.add(new Detalle(parseInt(lectura[1]),lectura[2],parseDouble(lectura[3]),parseInt(lectura[4]),parseDouble(lectura[5])));
            b = x.readLine();
            }
            
            fc.add(new Factura(fecha,numero,dt));
        }
        x.close();
        return fc;
    }
}
