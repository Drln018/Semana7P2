/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;


import dominio.Empleado;
import excepciones.*;
import java.util.*;

public interface AccesoDatos {
    boolean existe(String nombreArchivo) throws AccesoDatosEx;//metodo que valide si existe o no 
    //listar devuelve el estado de las peliculas
    public List<Empleado> listar(String nombreArchivo) throws LecturaDatosEx;
    
    //void escribir(Empleado empleado, Empleado enero, Empleado febrero, Empleado marzo, String nombreArchivo, boolean anexar) throws EscrituraDatosEx;
    
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx;
    
    public void crear(String nombreArchivo) throws AccesoDatosEx;
    public void borrar(String nombreArchivo) throws  AccesoDatosEx;

    public void escribir(Empleado empleado, String nombreArchivo, boolean anexar);

}
