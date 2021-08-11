import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO
{
	// Crear la nueva instancia de la clase de conexión

	ConnectionSQLite connectionSQLite = new ConnectionSQLite();

	// Constructor

	public StudentDAO()
	{
		connectionSQLite.openConnection();
	}

	// Métodos de menu

	// Crear Estudiante

	public void createStudent( String names, String lastNames, String birthDate, String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
	{
		try
		{
			PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Insert into estudiantes values (?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, names.toLowerCase());
			preparedStatement.setString(2, lastNames.toLowerCase());
			preparedStatement.setString(3, birthDate.toLowerCase());
			preparedStatement.setString(4, institutionalEmail.toLowerCase());
			preparedStatement.setString(5, personalEmail.toLowerCase());
			preparedStatement.setString(6, academicProgram.toLowerCase());
			preparedStatement.setLong(7, cellphoneNumber);
			preparedStatement.setLong(8, phoneNumber);

			preparedStatement.executeUpdate();

			System.out.println( "Se agregó el estudiante" );

			preparedStatement.close();
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
			System.out.println("Error: La identificación " + institutionalEmail + " Ya existe");
		}
	}

	// Buscar Estudiante

	public void SearchStudent(int optionSearch, String stringParameter, long longParameter )
	{
		try
		{
			switch ( optionSearch )
			{
				case 1:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement1 = connectionSQLite.connection.prepareStatement("Select * from estudiantes where institutionalEmail like ?");

					preparedStatement1.setString(1, stringParameter);

					ResultSet resultSet1 = preparedStatement1.executeQuery();

					if ( resultSet1.next() )
					{
						System.out.println("Nombres: " + resultSet1.getString("name") + "\n" +
						"Apellidos: " + resultSet1.getString("lastName") + "\n" +
						"Fecha nacimiento: " +  resultSet1.getString("birthDate") + "\n" +
						"Correo institucional: " + resultSet1.getString("institutionalEmail") + "\n" +
						"Correo personal: " + resultSet1.getString("personalEmail") + "\n" +
						"Número de teléfono celular: " + resultSet1.getLong("cellphoneNumber") + "\n" +
						"Número de teléfono fijo: " + resultSet1.getLong("phoneNumber") + "\n" +
						"Programa académico: " + resultSet1.getString("academicProgram"));
					}

					preparedStatement1.close();

					break;
				}

				else
				{
					System.out.println("El correo institucional otorgado no esta registrado en la base de datos\n");

					break;
				}

				case 2:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement2 = connectionSQLite.connection.prepareStatement("Select * from estudiantes where lastName like ?");

					preparedStatement2.setString(1, stringParameter);

					ResultSet resultSet2 = preparedStatement2.executeQuery();

					while ( resultSet2.next() )
					{
						System.out.println("Nombres: " + resultSet2.getString("name") + "\n" +
						"Apellidos: " + resultSet2.getString("lastName") + "\n" +
						"Fecha nacimiento: " +  resultSet2.getString("birthDate") + "\n" +
						"Correo institucional: " + resultSet2.getString("institutionalEmail") + "\n" +
						"Correo personal: " + resultSet2.getString("personalEmail") + "\n" +
						"Número de teléfono celular: " + resultSet2.getLong("cellphoneNumber") + "\n" +
						"Número de teléfono fijo: " + resultSet2.getLong("phoneNumber") + "\n" +
						"Programa académico: " + resultSet2.getString("academicProgram"));
					}

					preparedStatement2.close();

					break;
				}

				else
				{
					System.out.println("Los apellidos otorgados no están registrados en la base de datos\n");

					break;
				}

				case 3:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement3 = connectionSQLite.connection.prepareStatement("Select * from estudiantes where academicProgram like ?");

					preparedStatement3.setString(1, stringParameter);

					ResultSet resultSet3 = preparedStatement3.executeQuery();

					while ( resultSet3.next() )
					{
						System.out.println("Nombres: " + resultSet3.getString("name") + "\n" +
						"Apellidos: " + resultSet3.getString("lastName"));
					}

					preparedStatement3.close();

					break;
				}

				else
				{
					System.out.println("El programa académico otorgado no esta registrado en la base de datos\n");

					break;
				}

				case 4:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement4 = connectionSQLite.connection.prepareStatement("Select count(*) from estudiantes where academicProgram like ?");

					preparedStatement4.setString(1, stringParameter);

					ResultSet resultSet4 = preparedStatement4.executeQuery();

					if ( resultSet4.next() )
					{
						System.out.println("Están registrados: " + resultSet4.getInt(1) + " estudiantes con el programa " + stringParameter);
					}

					preparedStatement4.close();

					break;
				}

				else
				{
					System.out.println("El programa académico otorgado no esta registrado en la base de datos\n");

					break;
				}

				case 5:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement5 = connectionSQLite.connection.prepareStatement("Select * from estudiantes where birthDate like ?");

					preparedStatement5.setString(1, stringParameter);

					ResultSet resultSet5 = preparedStatement5.executeQuery();

					while ( resultSet5.next() )
					{
						System.out.println("Nombres: " + resultSet5.getString("name") + "\n" +
						"Apellidos: " + resultSet5.getString("lastName") + "\n" +
						"Fecha nacimiento: " +  resultSet5.getString("birthDate") + "\n" +
						"Correo institucional: " + resultSet5.getString("institutionalEmail") + "\n" +
						"Correo personal: " + resultSet5.getString("personalEmail") + "\n" +
						"Número de teléfono celular: " + resultSet5.getLong("cellphoneNumber") + "\n" +
						"Número de teléfono fijo: " + resultSet5.getLong("phoneNumber") + "\n" +
						"Programa académico: " + resultSet5.getString("academicProgram"));
					}

					preparedStatement5.close();

					break;
				}

				else
				{
					System.out.println("La fecha de nacimiento otorgada no esta registrada en la base de datos\n");

					break;
				}

				case 6:

				if( checkFields(stringParameter, longParameter) )
				{
					PreparedStatement preparedStatement6 = connectionSQLite.connection.prepareStatement("Select * from estudiantes where cellphoneNumber=?");

					preparedStatement6.setLong(1, longParameter);

					ResultSet resultSet6 = preparedStatement6.executeQuery();

					if ( resultSet6.next() )
					{
						System.out.println("Nombres: " + resultSet6.getString("name") + "\n" +
						"Programa académico: " + resultSet6.getString("academicProgram"));
					}

					preparedStatement6.close();

					break;
				}

				else
				{
					System.out.println("El numero de celular otorgado no esta registrado en la base de datos\n");

					break;
				}
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Actualizar Estudiante

	public void UpdateStudent( String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
	{
		try
		{
			if( checkFields(institutionalEmail, 0) )
			{
				PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Update estudiantes set personalEmail=?, academicProgram=?, cellphoneNumber=?, phoneNumber=? where institutionalEmail=?");

				preparedStatement.setString(1, personalEmail);
				preparedStatement.setString(2, academicProgram);
				preparedStatement.setLong(3, cellphoneNumber);
				preparedStatement.setLong(4, phoneNumber);
				preparedStatement.setString(5, institutionalEmail);

				preparedStatement.executeUpdate();
				System.out.println("Se modificó el estudiante");

				preparedStatement.close();
			}

			else
			{
				System.out.println("El correo institucional otorgado no esta registrado en la base de datos\n");
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Eliminar Estudiante

	public void DeleteStudent( String institutionalEmail )
	{
		try
		{
			if( checkFields(institutionalEmail, 0) )
			{
				PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Delete from estudiantes where institutionalEmail=?");

				preparedStatement.setString(1, institutionalEmail);

				preparedStatement.executeUpdate();
				System.out.println("Se eliminó el estudiante");

				preparedStatement.close();
			}

			else
			{
				System.out.println("El correo institucional otorgado no esta registrado en la base de datos\n");
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Mostrar Listado de Estudiantes

	public void ShowStudents()
	{
		try
		{
			PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Select * from estudiantes");

			ResultSet resultSet = preparedStatement.executeQuery();

			while ( resultSet.next() )
			{
				System.out.println("Nombres: " + resultSet.getString("name") + "\n" +
				"Apellidos: " + resultSet.getString("lastName") + "\n" +
				"Fecha nacimiento: " +  resultSet.getString("birthDate") + "\n" +
				"Correo institucional: " + resultSet.getString("institutionalEmail") + "\n" +
				"Correo personal: " + resultSet.getString("personalEmail") + "\n" +
				"Número de teléfono celular: " + resultSet.getString("cellphoneNumber") + "\n" +
				"Número de teléfono fijo: " + resultSet.getString("phoneNumber") + "\n" +
				"Programa académico: " + resultSet.getString("academicProgram"));
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	// Verificar Campos

	public boolean checkFields( String stringParameter, long longParameter )
	{
		try
		{
			PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Select count(*) from estudiantes where institutionalEmail like ? OR academicProgram like ?  OR lastName like ? OR birthDate like ? OR cellphoneNumber like ?");

			preparedStatement.setString(1, stringParameter);
			preparedStatement.setString(2, stringParameter);
			preparedStatement.setString(3, stringParameter);
			preparedStatement.setString(4, stringParameter);
			preparedStatement.setLong(5, longParameter);

			ResultSet resultSet = preparedStatement.executeQuery();

			System.out.println();

			if ( resultSet.getInt(1) >= 1 )
			{
				preparedStatement.close();

				return true;
			}

			else
			{
				preparedStatement.close();

				return false;
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());

			return false;
		}
	}

	// Cerrar Conexión

	public void Finalize()
	{
		connectionSQLite.closeConnection();
	}
}
