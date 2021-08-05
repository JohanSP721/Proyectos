import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ClienteDAO
{
	// Crear el objeto tipo File
	File flCliente = new File("Cliente.dat");

	// ArrayList para almacenar los datos
	ArrayList<Cliente> cliente;

	// Constructor

	public ClienteDAO()
	{
		cliente = new ArrayList<>();
	}

	// ************************************** Persistencia
	// *********************************************

	// Método para escribir en el fichero
	public void escribirFichero()
	{
		try
		{
			ObjectOutputStream escFichero = new ObjectOutputStream(new FileOutputStream("Cliente.dat"));
			escFichero.writeObject(cliente);
			escFichero.close();

		} catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}

	// Método para leer el fichero
	public void leerFichero()
	{
		try
		{
			ObjectInputStream leerFichero = new ObjectInputStream(new FileInputStream("Cliente.dat"));
			cliente = (ArrayList<Cliente>) leerFichero.readObject();
			leerFichero.close();

		} catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}

	// Comprobar la existencia del Archivo
	public void comprobarFichero()
	{
		try
		{
			if (!flCliente.exists())
			{
				flCliente.createNewFile();
			} else
			{
				this.leerFichero();
			}

		} catch (Exception ex)
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}

	// ******************** Operación del CRUD ************************************

	// Crear nuevos Clientes
	public void crearClientes(String cedu, String nomb, String apel)
	{
		Cliente cli = new Cliente(cedu, nomb, apel);
		cliente.add(cli);
		System.out.println("Cliente: " + cli.getCedula() + "ha sido guardado satisfactoriamente");
	}

	// Eliminar Clientes

	public void eliminarClientes(String cedula)
	{
		Iterator<Cliente> it = cliente.iterator();
		while (it.hasNext())
		{
			Cliente cl = it.next();
			if (cl.getCedula().equals(cedula))
			{
				it.remove();
				System.out.println("Registro Eliminado satisfactoriamente");
			}
		}

	}

	// Listado de Clientes
	public void mostrarClientes()
	{
		for (Cliente c : cliente)
		{
			System.out.println(c.getCedula() + " " + c.getNombre() + " " + c.getApellidos());

		}
	}

	// Buscar Clientes
	public void buscarClientes(String cedula)
	{
		Iterator<Cliente> it = cliente.iterator();
		while (it.hasNext())
		{
			Cliente cl = it.next();
			if (cl.getCedula().equals(cedula))
			{
				System.out.println("*************************************");
				System.out.println("Nombre: " + cl.getNombre() + " " + "Apellidos: " + cl.getApellidos());
			}
		}
	}

	// Actualizar Clientes
	public void actualizarClientes(String cedu, String nomb, String apel)
	{
		Iterator<Cliente> it = cliente.iterator();
		while (it.hasNext())
		{
			Cliente cl = it.next();
			if (cl.getCedula().equals(cedu))
			{
				cl.setNombre(nomb);
				cl.setApellidos(apel);
				System.out.println("Registro Actualizado satisfactoriamente");
			}
		}

	}
}
