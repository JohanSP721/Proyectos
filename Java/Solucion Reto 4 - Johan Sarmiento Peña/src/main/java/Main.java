import java.util.Scanner;

public class Main
{
	// Clase Main
	public static void main(String[] args)
	{
		// Instancia Métodos de menu, Estudiante y Scanner
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student();
		Scanner inputs = new Scanner( System.in );

		//	Variable opción

		int option = 0;

		while(true)
		{
			// Menu

			System.out.println("INSTITUTO LA FLORESTA\n" +
			"Seleccione tarea a realizar:\n" +
			"1. Ingresar estudiante\n" +
			"2. Buscar estudiante\n" +
			"3. Modificar estudiante\n" +
			"4. Eliminar Estudiante\n" +
			"5. Ver directorio de estudiantes\n" +
			"6. Salir\n" +
			"Opción:");

			try
			{
				option = inputs.nextInt();
			}

			catch (Exception e)
			{
				System.out.println("Digite un numero entero");
			}

			inputs.nextLine();


			// Switch de Opciones

			switch(option)
			{
				case 1:

					System.out.println( "Ingresar estudiante" );

					System.out.println( "Ingresar nombres:" );
					student.setNames(inputs.nextLine());
					System.out.println( "Ingresar apellidos:" );
					student.setLastNames(inputs.nextLine());
					System.out.println( "Ingresar fecha de nacimiento (YYYY-MM-DD):" );
					student.setBirthDate(inputs.nextLine());
					System.out.println( "Ingresar correo institucional:" );
					student.setInstitutionalEmail(inputs.nextLine());
					System.out.println( "Ingresar correo personal:" );
					student.setPersonalEmail(inputs.nextLine());
					System.out.println( "Ingresar número de celular:" );

					try
					{
						student.setCellphoneNumber(inputs.nextLong());
					}

					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar número fijo:" );

					try
					{
						student.setPhoneNumber(inputs.nextLong());
					}

					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar programa:" );
					student.setAcademicProgram(inputs.nextLine());

					studentDAO.createStudent(student.getNames(), student.getLastNames(), student.getBirthDate(), student.getInstitutionalEmail(), student.getPersonalEmail(), student.getAcademicProgram(), student.getCellphoneNumber(), student.getPhoneNumber());

					break;

				case 2:

					subMenu(inputs);

					break;

				case 3:

					System.out.println( "Modificar estudiante" );

					System.out.println( "Ingresar correo institucional:" );
					student.setInstitutionalEmail(inputs.nextLine());
					System.out.println( "Ingresar correo personal:" );
					student.setPersonalEmail(inputs.nextLine());
					System.out.println( "Ingresar número de celular:" );

					try
					{
						student.setCellphoneNumber(inputs.nextLong());
					}

					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar número de teléfono fijo:" );

					try
					{
						student.setPhoneNumber(inputs.nextLong());
					}

					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar programa:" );
					student.setAcademicProgram(inputs.nextLine());

					studentDAO.UpdateStudent( student.getInstitutionalEmail(), student.getPersonalEmail(), student.getAcademicProgram(), student.getCellphoneNumber(), student.getPhoneNumber() );

					break;

				case 4:

					System.out.println( "Eliminar estudiante" );

					System.out.println( "Ingresar correo institucional:" );
					student.setInstitutionalEmail(inputs.nextLine());

					studentDAO.DeleteStudent( student.getInstitutionalEmail() );

					break;

				case 5:

					System.out.println( "El directorio de los estudiantes" );

					studentDAO.ShowStudents();

					break;

				case 6:

					System.out.println( "Hasta pronto" );

					inputs.close();

					studentDAO.Finalize();

					System.exit(0);

				default:

					System.out.println( "Error: opción invalida" );

					break;

			}
		}
	}

	public static void subMenu(Scanner inputs)
	{
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student();

		//	Variable opción

		int optionSearch = 0;

		while (true)
		{
			System.out.println( "Buscar estudiante" );

			System.out.println("Seleccione la tarea a realizar:\n" +
			"1. Buscar por Correo Institucional\n" +
			"2. Buscar por Apellidos\n" +
			"3. Buscar por Programa\n" +
			"4. Mostrar Estudiantes por Programa\n" +
			"5. Buscar por Fecha de Nacimiento\n" +
			"6. Buscar por Numero de Celular\n" +
			"7. Salir\n" +
			"Opción:");

			try
			{
				optionSearch = inputs.nextInt();
			}

			catch (Exception e)
			{
				System.out.println("Digite un numero entero");
			}

			inputs.nextLine();

			switch (optionSearch)
			{
				case 1:

					System.out.println( "Ingresar correo institucional:" );
					student.setInstitutionalEmail(inputs.nextLine());

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, student.getInstitutionalEmail(), 0);

					break;

				case 2:

					System.out.println( "Ingresar el/los apellidos:" );
					student.setLastNames(inputs.nextLine());

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, student.getLastNames(), 0);

					break;

				case 3:

					System.out.println( "Ingresar programa:" );
					student.setAcademicProgram(inputs.nextLine());

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, student.getAcademicProgram(),0);

					break;

				case 4:

					System.out.println( "Ingresar programa:" );
					student.setAcademicProgram(inputs.nextLine());

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, student.getAcademicProgram(), 0);

					break;

				case 5:

					System.out.println( "Ingresar fecha de nacimiento:" );
					student.setBirthDate(inputs.nextLine());

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, student.getBirthDate(), 0);

					break;

				case 6:

					System.out.println( "Ingresar numero de celular:" );

					try
					{
						student.setCellphoneNumber(inputs.nextLong());
					}

					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent(optionSearch, "", student.getCellphoneNumber());

					break;

				case 7:

					break;

				default:

					System.out.println("Opción Invalida");
					break;
			}

			if (optionSearch == 7)
			{
				break;
			}
		}
	}
}
