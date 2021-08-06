import java.util.Scanner;

public class Mainapp {
    public static void main(String[] args) {
        // Crear un objeto de ClienteDAO
        ClienteDAO cl=new ClienteDAO();

        // Crear un objeto Scanner
        Scanner leer=new Scanner(System.in);

        int opcion=0;
        int sw=0;
        String cedu ="", nomb="", apel="";

        do{
            System.out.println("Seleccion el tipo de operacionm:\n"
            + "1. Crear Clientes\n"
            + "2. Buscar Clientes\n"
            + "3. Actualizar Clientes\n"
            + "4. Eliminar Clientes\n"
            + "5. Listado de Clientes\n"
            + "6. Salir Clientes\n"
            + "OPCION:");
            opcion=leer.nextInt();

            if(sw==0){
              cl.comprobarFichero();
              sw=1;
            }

            switch(opcion){
                case 1: // Crear Cliente
                    System.out.println("Cedula del Cliente:");
                    cedu=leer.next();
                    System.out.println("Nombre del Cliente:");
                    nomb=leer.next();
                    System.out.println("Apellidos del Cliente:");
                    apel=leer.next();
                    cl.crearClientes(cedu, nomb, apel);
                    break;
                case 2: // Buscar Clientes
                    System.out.println("Cedula del Cliente:");
                    cedu=leer.next();
                    System.out.println("**************************************");
                    cl.buscarClientes(cedu);
                    break;
                case 3: // Actualizar Clientes
                    System.out.println("Cedula del Cliente:");
                    cedu=leer.next();
                    System.out.println("**************************************");
                    System.out.println("Nombre del Cliente:");
                    nomb=leer.next();
                    System.out.println("Apellidos del Cliente:");
                    apel=leer.next();
                    cl.actualizarClientes(cedu, nomb, apel);
                    break;
                case 4: // Eliminar Clientes
                    System.out.println("Cedula del Cliente:");
                    cedu=leer.next();
                    System.out.println("**************************************");
                    cl.eliminarClientes(cedu);
                    break;
                case 5: // Listado de Clientes
                    System.out.println("**************************************");
                    cl.mostrarClientes();
                    System.out.println("**************************************");
                    break;
                case 6: // Salir

                    cl.escribirFichero(); // Guarda la informacion en el Archivo
                    System.out.println("Hasta pronto");

                    break;
                default:
                     System.out.println("Error: codigo del menu no valido");
            }
        }while(opcion!=6);
  }
}
