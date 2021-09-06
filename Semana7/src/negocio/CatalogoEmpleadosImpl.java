/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import datos.AccesoDatos;
import datos.AccesoDatosImpl;
import dominio.Empleado;
import excepciones.AccesoDatosEx;
import excepciones.LecturaDatosEx;
import java.util.List;

/**
 *
 * @author Darlin
 */
public class CatalogoEmpleadosImpl implements CatalogoEmpleados{

    private final AccesoDatos datos;
    
    public CatalogoEmpleadosImpl(){
        this.datos = new AccesoDatosImpl(); //poner * en el import datos.*
    }
    @Override
    public void agregarEmpleados(String nombreEmpleado, int enero, int febrero, int marzo, String nombreArchivo) {
       Empleado empleado = new Empleado(nombreEmpleado);
        boolean anexar = false;
        try {
            anexar = datos.existe(nombreArchivo);//bandera si anexa o no
            datos.escribir(empleado, nombreArchivo, anexar);
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }
    @Override
    public void listarEmpleados(String nombreArchivo) {
        try {
            List<Empleado> empleados = datos.listar(nombreArchivo);
            System.out.println("Nombre\tEnero\tFebrero\tMarzo");
            for(Empleado empleado : empleados){
                System.out.println(empleado);
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }
    }

    
    @Override
    public void buscarEmpelados(String nombreArchivo, String buscar) {
        String resultado = null;
        try {
           
            resultado = datos.buscar(nombreArchivo, buscar);
        } catch (LecturaDatosEx ex) {
            System.out.println("Error al buscar el empleado");
            ex.printStackTrace();
        }
         System.out.println("Resultado Busqueda:"+resultado);
    }

    @Override
    public void iniciarArchivo(String nombreArchivo) {
        
        try {
            if(datos.existe(nombreArchivo)){
                datos.borrar(nombreArchivo);
                datos.crear(nombreArchivo);
            } else {
                //crearmos archivo
                datos.crear(nombreArchivo);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace();
        }

    }

}
