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
          
            y.write(fecha.format(registro.getFecha())+":"+registro.getValorExistencias()+":"+registro.getGanancias()+":"+registro.getCosto()+":"+registro.getIvaC()+":"+registro.getIvaV()+"\n");
            for (Map.Entry<Integer, Operaciones> entry : registro.getProductos().entrySet()) {
                y.write("*"+":"+entry.getKey()+":"+entry.getValue().getFecha()+":"+entry.getValue().getExistencias()+":"+entry.getValue().getSalidas()+":"+entry.getValue().getPrecioVenta()+":"+entry.getValue().getEntradas()+":"+entry.getValue().getPrecioCompra()+"\n");
                for(int numfac: entry.getValue().getFacturasV()){
                    y.write("-"+":"+numfac+"\n");
                }
                for(int numfac: entry.getValue().getFacturasC()){
                    y.write("+"+":"+numfac+"\n");
                }
            }
            y.write("\n");
        }
    }
    
    public Inventario LeerRegistro() throws IOException, ParseException{
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        Inventario inventario = new Inventario();
        File archivo = new File("Archivos/Productos.txt");
        FileInputStream fa = new FileInputStream (archivo); 
        BufferedReader x = new BufferedReader(new InputStreamReader(fa));
        HashMap<Integer,Producto> productos = new HashMap<>();
        String b="";
        while(x.ready()){
            b=x.readLine();
            String[] lectura = b.split(":");
            //x.write(p.getId()+":"+p.getNombre()+":"+p.getUnidades()+":"+p.getPrecioUnidad()+":"+p.getIva()+"\n");
            int id = parseInt(lectura[0]);
            String nombre = lectura[1];
            int unidades = parseInt(lectura[2]);
            double precioUnidad = parseDouble(lectura[3]);
            double iva = parseDouble(lectura[4]);
        }
        
        HashMap<Date,Registro> registros = new HashMap<>();
        File archivo2 = new File("Archivos/Registros.txt");
        FileInputStream pp = new FileInputStream (archivo2); 
        BufferedReader yy = new BufferedReader(new InputStreamReader(pp));
        b = yy.readLine();
        Date fechaop = new Date();
            while(yy.ready()){
                String lectura2[]=b.split(":");
                Date fechaRegistro = fecha.parse(lectura2[0]);
                double ValueExistencias =  parseDouble(lectura2[1]);
                double Ganancias =  parseDouble(lectura2[2]);
                double Costo =  parseDouble(lectura2[3]);
                double IvaC =  parseDouble(lectura2[4]);
                double IvaV =  parseDouble(lectura2[5]);
                b = yy.readLine();
                HashMap <Integer,Operaciones> operaciones= new HashMap<>();
                while(b.contains("*")){
 //y.write(fecha.format(registro.getFecha())+":"+registro.getValorExistencias()+":"+registro.getGanancias()+":"+registro.getCosto()+":"+registro.getIvaC()+":"+registro.getIvaV()+"\n");
                        
                        int key = parseInt(lectura2[1]);
                        fechaop = fecha.parse(lectura2[2]);
                        int Existencias = parseInt(lectura2[3]);
                        int Salidas = parseInt(lectura2[4]);
                        Double precioVenta = parseDouble(lectura2[5]);
                        int Entradas = parseInt(lectura2[6]);
                        Double precioCompra = parseDouble(lectura2[7]);
                        b=yy.readLine();
                        ArrayList<Integer> fVentas = new ArrayList<>();
                        ArrayList<Integer> fCompras = new ArrayList<>();
                        while(b.contains("-")){
                            //y.write("-"+":"+numfac+"\n");
                            lectura2 = b.split(":");
                            for(int i=0;i<lectura2.length;i++){
                                fVentas.add(parseInt(lectura2[i]));
                            }
                            b=yy.readLine();
                        }
               
                        while(b.contains("+")){
                            //y.write("-"+":"+numfac+"\n");
                            lectura2 = b.split(":");
                            for(int i=0;i<lectura2.length;i++){
                                fCompras.add(parseInt(lectura2[i]));
                            }
                            b=yy.readLine();
                        }
                    Operaciones ope = new Operaciones(fechaop,Existencias,Salidas,precioVenta,Entradas,precioCompra,fVentas,fCompras);
                    operaciones.put(key, ope);
                }
                
                //Registro(Date fecha, HashMap<Integer, Operaciones> productos, double valorExistencias, double Ganancias, double costo, double ivaC, double ivaV)
                //Registro registro = new Registro(fechaop,operaciones);
                
            }
        
            
            
            
        
        return inventario;
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
