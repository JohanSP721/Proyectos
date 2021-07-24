import java.util.ArrayList;
import java.util.Iterator;

public class StudentDAO
{
	// Arreglo de estudiantes

	ArrayList<Student> students;

	// Constructor
	public StudentDAO()
	{
		students = new ArrayList<Student>();
	}

	// Métodos de menu

	// Crear Estudiante

	public void CreateStudent( String names, String lastNames, String birthDate, String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
	{
		Student student = new Student();

		student.setNames(names);
		student.setLastNames(lastNames);
		student.setBirthDate(birthDate);
		student.setInstitutionalEmail(institutionalEmail);
		student.setPersonalEmail(personalEmail);
		student.setAcademicProgram(academicProgram);
		student.setCellphoneNumber(cellphoneNumber);
		student.setPhoneNumber(phoneNumber);

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
