import java.util.Scanner;

public class Main
{
	// Clase Main
	public static void main(String[] args)
	{
		// Instancia Métodos de menu y Scanner
		StudentDAO studentDAO = new StudentDAO();
		Scanner inputs = new Scanner( System.in );

		//	Variable opción

		int option = 0;

		// Variables Estudiante

		String names, lastNames, birthDate, institutionalEmail, personalEmail, academicProgram;;
		long cellphoneNumber = 0;
		long phoneNumber = 0;

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
					names = inputs.nextLine();
					System.out.println( "Ingresar apellidos:" );
					lastNames = inputs.nextLine();
					System.out.println( "Ingresar fecha de nacimiento (YYYY-MM-DD):" );
					birthDate = inputs.nextLine();
					System.out.println( "Ingresar correo institucional:" );
					institutionalEmail = inputs.nextLine();
					System.out.println( "Ingresar correo personal:" );
					personalEmail = inputs.nextLine();
					System.out.println( "Ingresar número de celular:" );

					try
					{
						cellphoneNumber = inputs.nextLong();
					}
					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar número fijo:" );

					try
					{
						phoneNumber = inputs.nextLong();
					}
					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar programa:" );
					academicProgram = inputs.nextLine();

					studentDAO.CreateStudent( names, lastNames, birthDate, institutionalEmail, personalEmail, academicProgram, cellphoneNumber, phoneNumber );

					break;

				case 2:

					System.out.println( "Buscar estudiante" );

					System.out.println( "Ingresar correo institucional:" );
					institutionalEmail = inputs.nextLine();

					System.out.println( "Información del estudiante" );
					studentDAO.SearchStudent( institutionalEmail );

					break;

				case 3:

					System.out.println( "Modificar estudiante" );

					System.out.println( "Ingresar correo institucional:" );
					institutionalEmail = inputs.nextLine();
					System.out.println( "Ingresar correo personal:" );
					personalEmail = inputs.nextLine();
					System.out.println( "Ingresar número de celular:" );

					try
					{
						cellphoneNumber = inputs.nextLong();
					}
					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar número fijo:" );

					try
					{
						phoneNumber = inputs.nextLong();
					}
					catch (Exception e)
					{
						System.out.println("Digite un numero entero");
					}

					inputs.nextLine();

					System.out.println( "Ingresar programa::" );
					academicProgram = inputs.nextLine();

					studentDAO.UpdateStudent( institutionalEmail, personalEmail, academicProgram, cellphoneNumber, phoneNumber );

					break;

				case 4:

					System.out.println( "Eliminar estudiante" );

					System.out.println( "Ingresar correo institucional:" );
					institutionalEmail = inputs.nextLine();

					studentDAO.DeleteStudent( institutionalEmail );

					break;

				case 5:

					System.out.println( "El directorio de los estudiantes" );

					studentDAO.ShowStudents();

					break;

				case 6:

					System.out.println( "Hasta pronto" );

					inputs.close();

					System.exit(0);

				default:

					break;

			}
		}
	}
}
