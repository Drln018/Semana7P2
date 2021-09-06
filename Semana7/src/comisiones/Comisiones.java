
package comisiones;

import java.util.Scanner;
import negocio.CatalogoEmpleadosImpl;
import negocio.CatalogoEmpleados;

public class Comisiones {

    private static final Scanner scanner = new Scanner(System.in);
    private static int opcion = -1;
    private static final String nombreArchivo = "C:\\Users\\13237\\OneDrive\\Desktop\\JAVA\\archivotexto.txt";
    private static final CatalogoEmpleados catalogoEmp = new CatalogoEmpleadosImpl();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Mientras la opcion elegida sea 0, preguntamos al usuario
        while (opcion != 0) {
            try {
                System.out.println("Elige opcion:\n1.Iniciar catalogo peliculas"
                        + "\n2.- Agregar empleado\n"
                        + "3.- Listar empleados\n"
                        + "4.- Buscar empleado\n"
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());

                //Ejemplo de switch case en Java
                switch (opcion) {
                    case 1:
                        //1. Creamos el objeto que administra el catalogo de personas
                        //La creacion del archivo es opcional, de todas maneras se creara 
                        //al escribir por primera vez en el archivo
                        catalogoEmp.iniciarArchivo(nombreArchivo);
                        break;
                    case 2:
                        //2. agregar informacion archivo
                        System.out.println("Introduce el nombre de el empleado a agregar:");
                        String nombre = scanner.nextLine();
                        System.out.println("Enero");
                        int enero=scanner.nextInt();
                        System.out.println("Febrero");
                        int febrero=scanner.nextInt();
                        System.out.println("Marzo");
                        int marzo=scanner.nextInt();
                        catalogoEmp.agregarEmpleados(nombre, enero, febrero, marzo,nombreArchivo);       
                        break;
                    case 3:
                        //3. listar catalogo completo
                        catalogoEmp.listarEmpleados(nombreArchivo);
                        break;
                    case 4:
                        //4. Buscar pelicula
                        System.out.println("Introduce el nombre del empleado a buscar:");
                        String buscar = scanner.nextLine();
                        catalogoEmp.buscarEmpelados(nombreArchivo, buscar);
                        break;
                    case 0:
                        System.out.println("!Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opcion no reconocida");
                        break;
                }
                System.out.println("\n");

            } catch (Exception e) {
                System.out.println("Error!");
            }
        }

    }
}
