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
        
        File archivo3 = new File("Archivos/RegistroActual.txt");
        FileWriter k= new FileWriter(archivo3);
        
        Registro registro= inventario.getActual();
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        k.write(fecha.format(registro.getFecha())+":"+registro.getValorExistencias()+":"+registro.getGanancias()+":"+registro.getCosto()+":"+registro.getIvaC()+":"+registro.getIvaV()+"\n");
            for (Map.Entry<Integer, Operaciones> entry : registro.getProductos().entrySet()) {
                k.write("*"+":"+entry.getKey()+":"+entry.getValue().getFechaK()+":"+entry.getValue().getExistencias()+":"+entry.getValue().getSalidas()+":"+entry.getValue().getPrecioVenta()+":"+entry.getValue().getEntradas()+":"+entry.getValue().getPrecioCompra()+"\n");
                for(int numfac: entry.getValue().getFacturasV()){
                    k.write("-"+":"+numfac+"\n");
                }
                for(int numfac: entry.getValue().getFacturasC()){
                    k.write("+"+":"+numfac+"\n");
                }
            }
            k.close();
        File archivo = new File("Archivos/Productos.txt");
        archivo.createNewFile();
        FileWriter x= new FileWriter(archivo);
        for(Producto p: inventario.getProductos().values()){
            x.write(p.getId()+":"+p.getNombre()+":"+p.getUnidades()+":"+p.getPrecioUnidad()+":"+p.getIva()+"\n");
        }
        x.close();
        
        File archivo2 = new File("Archivos/Registros.txt");
        FileWriter y= new FileWriter(archivo2);
        
        for(Registro reg: inventario.getRegistros().values()){
            SimpleDateFormat fec = new SimpleDateFormat("dd/MM/yyyy");
          
            y.write(fec.format(reg.getFecha())+":"+reg.getValorExistencias()+":"+reg.getGanancias()+":"+reg.getCosto()+":"+reg.getIvaC()+":"+reg.getIvaV()+"\n");
            for (Map.Entry<Integer, Operaciones> entry : reg.getProductos().entrySet()) {
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
        Date fechaop = new Date();
        File archivo = new File("Archivos/Productos.txt");
        FileInputStream fa = new FileInputStream (archivo); 
        BufferedReader x = new BufferedReader(new InputStreamReader(fa));
        HashMap<Integer,Producto> productos = new HashMap<>();
        String b;
        while(x.ready()){
            b=x.readLine();
            String[] lectura = b.split(":");
            //x.write(p.getId()+":"+p.getNombre()+":"+p.getUnidades()+":"+p.getPrecioUnidad()+":"+p.getIva()+"\n");
            int id = parseInt(lectura[0]);
            String nombre = lectura[1];
            int unidades = parseInt(lectura[2]);
            double precioUnidad = parseDouble(lectura[3]);
            double iva = parseDouble(lectura[4]);
            Producto producto = new Producto(id,nombre,unidades,precioUnidad,iva);
            productos.put(id, producto);
            
        }
        Registro act = new Registro();
        File archivo3 = new File("Archivos/RegistroActual.txt");
        FileInputStream qq = new FileInputStream (archivo3); 
        BufferedReader tt = new BufferedReader(new InputStreamReader(qq));
        b = tt.readLine();
        Date fechaopp = new Date();
                String lectura3[]=b.split(":");
                Date fechaRegistroo = fecha.parse(lectura3[0]);
                double ValueExistenciaso =  parseDouble(lectura3[1]);
                double Gananciaso =  parseDouble(lectura3[2]);
                double Costoo =  parseDouble(lectura3[3]);
                double IvaCo =  parseDouble(lectura3[4]);
                double IvaVo =  parseDouble(lectura3[5]);
                b = tt.readLine();
                HashMap <Integer,Operaciones> operacioneso= new HashMap<>();
                while(b!=null&&b.contains("*")){
 //y.write(fecha.format(registro.getFecha())+":"+registro.getValorExistencias()+":"+registro.getGanancias()+":"+registro.getCosto()+":"+registro.getIvaC()+":"+registro.getIvaV()+"\n");
                        lectura3=b.split(":");
                        int key = parseInt(lectura3[1]);
                        fechaop = fecha.parse(lectura3[2]);
                        int Existencias = parseInt(lectura3[3]);
                        int Salidas = parseInt(lectura3[4]);
                        Double precioVenta = parseDouble(lectura3[5]);
                        int Entradas = parseInt(lectura3[6]);
                        Double precioCompra = parseDouble(lectura3[7]);
                        b=tt.readLine();
                        ArrayList<Integer> fVentas = new ArrayList<>();
                        ArrayList<Integer> fCompras = new ArrayList<>();
                        while(b!=null&&b.contains("-")){
                            //y.write("-"+":"+numfac+"\n");
                            lectura3 = b.split(":");
                            for(int i=0;i<lectura3.length-1;i++){
                                fVentas.add(parseInt(lectura3[i+1]));
                            }
                            b=tt.readLine();
                        }
                        while(b!=null&&b.contains("+")){
                            //y.write("-"+":"+numfac+"\n");
                            lectura3 = b.split(":");
                            for(int i=0;i<lectura3.length-1;i++){
                                fCompras.add(parseInt(lectura3[i+1]));
                            }
                            b=tt.readLine();
                        }
                    Operaciones ope = new Operaciones(fechaop,Existencias,Salidas,precioVenta,Entradas,precioCompra,fVentas,fCompras);
                    operacioneso.put(key, ope);
                }
                
                //Registro(Date fecha, HashMap<Integer, Operaciones> productos, double valorExistencias, double Ganancias, double costo, double ivaC, double ivaV)
                    Registro registroact = new Registro(fechaop,operacioneso,ValueExistenciaso,Gananciaso,Costoo,IvaVo,IvaCo);
        
        
        
        
        
        
        
        HashMap<Date,Registro> registros = new HashMap<>();
        File archivo2 = new File("Archivos/Registros.txt");
        FileInputStream pp = new FileInputStream (archivo2); 
        BufferedReader yy = new BufferedReader(new InputStreamReader(pp));
        b = yy.readLine();
        
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
                            for(int i=0;i<lectura2.length-1;i++){
                                fVentas.add(parseInt(lectura2[i+1]));
                            }
                            b=yy.readLine();
                        }
               
                        while(b.contains("+")){
                            //y.write("-"+":"+numfac+"\n");
                            lectura2 = b.split(":");
                            for(int i=0;i<lectura2.length-1;i++){
                                fCompras.add(parseInt(lectura2[i+1]));
                            }
                            b=yy.readLine();
                        }
                    Operaciones ope = new Operaciones(fechaop,Existencias,Salidas,precioVenta,Entradas,precioCompra,fVentas,fCompras);
                    operaciones.put(key, ope);
                }
                
                //Registro(Date fecha, HashMap<Integer, Operaciones> productos, double valorExistencias, double Ganancias, double costo, double ivaC, double ivaV)
                    Registro registro = new Registro(fechaop,operaciones,ValueExistencias,Ganancias,Costo,IvaV,IvaC);
                    registros.put(fechaop, registro);
                }
        
            
            
                    
            
        Inventario inventario = new Inventario(productos,registroact,registros);
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
            
            x.write(fecha.format(f.getFecha())+":"+f.getNumero()+":"+f.getCliente()+":"+f.getDocCliemte()+"\n");
            
            for(Detalle d: f.getEntradas()){
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
            String nCliente = lectura[2]; 
            int cedula = parseInt(lectura[3]); 
            b = x.readLine();
            while(b.contains("-")){
            lectura = b.split(":");
            dt.add(new Detalle(parseInt(lectura[1]),lectura[2],parseDouble(lectura[3]),parseInt(lectura[4]),parseDouble(lectura[5])));
            b = x.readLine();
            }
            
            fc.add(new Factura(fecha,numero,dt,nCliente,cedula));
        }
        x.close();
        return fc;
    }
}
