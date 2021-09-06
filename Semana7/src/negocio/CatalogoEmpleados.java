/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

public interface CatalogoEmpleados {
    public void agregarEmpleados(String nombre,int enero, int febrero, int marzo, String nombreArchivo);
    public void listarEmpleados(String nombreArchivo);
    public void buscarEmpelados(String nombreArchivo, String buscar);
    public void iniciarArchivo(String nombreArchivo);

}
