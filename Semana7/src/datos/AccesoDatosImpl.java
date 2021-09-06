/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.Empleado;
import excepciones.AccesoDatosEx;
import excepciones.EscrituraDatosEx;
import excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//implementacion; que esto se base en acceso a datos
public class AccesoDatosImpl implements AccesoDatos {
    //verificar si el archivo existe
    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEx {
        File archivo = new File(nombreArchivo);
        return archivo.exists(); // devolver v o f
    }
    
    @Override
    //lista de tipo pelicula
    //devoverá array list
    public List<Empleado> listar(String nombreArchivo) throws LecturaDatosEx {
          List<Empleado> empleados = new ArrayList();
        try {
           BufferedReader entrada = null; 
            File archivo = new File(nombreArchivo);
           
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            while (linea != null){
                Empleado empleado = new Empleado(linea);
                empleados.add(empleado);
                Empleado enero= new Empleado(linea);
                empleados.add(enero);
                Empleado febrero= new Empleado(linea);
                empleados.add(febrero);
                Empleado marzo= new Empleado(linea);
                empleados.add(marzo);
                linea = entrada.readLine();
            }   
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) { 
            ex.printStackTrace(System.out);
        }
        return empleados;
    }
    //pelicula a buscar
    @Override
    public String buscar(String nombreArchivo,String buscar){
        BufferedReader entrada = null;
        String resultado = null;
        try {
            File archivo = new File(nombreArchivo);
            
            entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            int i=0;
            linea = entrada.readLine();
            while (linea != null){//no importa si en M o m
                if(buscar != null && buscar.equalsIgnoreCase(linea)){
                    resultado = "Empleado: "+ linea + " encontrado en el indice " + i;
                    break;
                }
                linea = entrada.readLine();
                i++;
            }   entrada.close();
        } catch (FileNotFoundException ex) {
             ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                entrada.close();
            } catch (IOException ex) {
                 ex.printStackTrace(System.out);
            }
        }
        return resultado;
    }

public void crear(String nombreArchivo){
    PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
          } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
}
   
@Override
public void borrar(String nombreArchivo) throws AccesoDatosEx{
    File archivo = new File(nombreArchivo);
    archivo.delete();//eliminar el archivo completo
    System.out.println("Se ha borrado el archivo");
}

    @Override
    public void escribir(Empleado empleado, String nombreArchivo, boolean anexar) {
            PrintWriter salida = null;
        try {
            File archivo = new File(nombreArchivo);
            salida = new PrintWriter(new FileWriter(archivo,anexar));
            salida.println(empleado.toString());
//            salida.println(enero);
//            salida.println(febrero);
//            salida.println(marzo);
            salida.close();
            System.out.println("Se ha escrito el registro en el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        } finally {
            salida.close();
        }
    }
}
