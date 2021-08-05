import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class StudentDAO
{
	// Crear el objeto tipo File

	File studentsFile = new File("datos_estudiantes.dat");

	// ArrayList para almacenar los datos

	ArrayList<Student> students;

	// Constructor

	public StudentDAO()
	{
		students = new ArrayList<>();
	}

	// Método para escribir en el fichero

	public void writeFile()
	{
		try
		{
			ObjectOutputStream writeFile = new ObjectOutputStream( new FileOutputStream( "datos_estudiantes.dat" ) );
			writeFile.writeObject( students );
			writeFile.close();

		} catch ( Exception ex )
		{
			System.out.println("Error: " + ex.getMessage());
		}
	}

	// Método para leer el fichero

	public void readFile()
	{
		try
		{
			ObjectInputStream readFile = new ObjectInputStream( new FileInputStream( "datos_estudiantes.dat" ) );
			students = ( ArrayList<Student> ) readFile.readObject();
			readFile.close();

		} catch ( Exception ex )
		{
			System.out.println( "Error: " + ex.getMessage() );
		}
	}

	// Comprobar la existencia del Archivo

	public void findOutFile()
	{
		try
		{
			if ( !studentsFile.exists() )
			{
				studentsFile.createNewFile();
			}
			else
			{
				this.readFile();
			}

		} catch ( Exception ex )
		{
			System.out.println( "Error: " + ex.getMessage() );
		}
	}

	// Métodos de menu

	// Crear Estudiante

	public void CreateStudent( String names, String lastNames, String birthDate, String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
	{
		Student student = new Student(names,lastNames,birthDate,institutionalEmail,personalEmail, academicProgram,cellphoneNumber, phoneNumber);

		students.add(student);

		System.out.println( "Se agregó el estudiante" );
	}

	// Buscar Estudiante

	public void SearchStudent( String institutionalEmail )
	{
		Iterator<Student> iterator = students.iterator();

		while ( iterator.hasNext() )
		{
			Student student = iterator.next();

			if ( student.getInstitutionalEmail().equals( institutionalEmail ) )
			{
				System.out.println( "Nombres: " + student.getNames() + "\n" +
									"Apellidos: " + student.getLastNames() + "\n" +
									"Fecha nacimiento: " + student.getBirthDate() + "\n" +
									"Correo institucional: " + student.getInstitutionalEmail() + "\n" +
									"Correo personal: " + student.getPersonalEmail() + "\n" +
									"Número de teléfono celular: " + student.getCellphoneNumber() + "\n" +
									"Número de teléfono fijo: " + student.getPhoneNumber() + "\n" +
									"Programa académico: " + student.getAcademicProgram()
				);
			}
		}
	}

	// Actualizar Estudiante

	public void UpdateStudent( String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
	{
		Iterator<Student> iterator = students.iterator();

		while ( iterator.hasNext() )
		{
			Student student = iterator.next();

			if ( student.getInstitutionalEmail().equals( institutionalEmail ) )
			{
				student.setPersonalEmail(personalEmail);
				student.setAcademicProgram(academicProgram);
				student.setCellphoneNumber(cellphoneNumber);
				student.setPhoneNumber(phoneNumber);

				System.out.println( "Se modificó el estudiante" );
			}
		}
	}

	// Eliminar Estudiante

	public void DeleteStudent( String institutionalEmail )
	{
		Iterator<Student> iterator = students.iterator();

		while ( iterator.hasNext() )
		{
			Student student = iterator.next();

			if ( student.getInstitutionalEmail().equals( institutionalEmail ) )
			{
				iterator.remove();

				System.out.println( "Se eliminó el estudiante" );
			}
		}
	}

	// Mostrar Listado de Estudiantes
	public void ShowStudents()
	{
		Iterator<Student> iterator = students.iterator();
		while ( iterator.hasNext() )
		{
			Student student = iterator.next();

			System.out.println( "Nombres: " + student.getNames() + "\n" +
								"Apellidos: " + student.getLastNames() + "\n" +
								"Fecha nacimiento: " + student.getBirthDate() + "\n" +
								"Correo institucional: " + student.getInstitutionalEmail() + "\n" +
								"Correo personal: " + student.getPersonalEmail() + "\n" +
								"Número de teléfono celular: " + student.getCellphoneNumber() + "\n" +
								"Número de teléfono fijo: " + student.getPhoneNumber() + "\n" +
								"Programa académico: " + student.getAcademicProgram()
			);
		}
	}
}
