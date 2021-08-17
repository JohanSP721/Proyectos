import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

		catch (ClassNotFoundException | SQLException e)
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

		catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
