import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQLite
{
	Connection connection;

	public ConnectionSQLite()
	{
		connection = null;
	}

	public void openConnection()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:bd_estudiantes.db";

			connection = DriverManager.getConnection(url);
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void closeConnection()
	{
		try
		{
			if(!connection.isClosed())
			{
				connection.close();
			}
		}

		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
