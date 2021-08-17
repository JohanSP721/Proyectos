import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

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

    public SQLException CreateStudent( String names, String lastNames, String birthDate, String institutionalEmail, String personalEmail, String academicProgram, long cellphoneNumber, long phoneNumber )
    {
        try
        {
            PreparedStatement preparedStatement = connectionSQLite.connection.prepareStatement("Insert into estudiantes values (?,?,?,?,?,?,?,?)");

            preparedStatement.setString(1, names);
            preparedStatement.setString(2, lastNames);
            preparedStatement.setString(3, birthDate);
            preparedStatement.setString(4, institutionalEmail);
            preparedStatement.setString(5, personalEmail);
            preparedStatement.setString(6, academicProgram);
            preparedStatement.setLong(7, cellphoneNumber);
            preparedStatement.setLong(8, phoneNumber);

            preparedStatement.executeUpdate();

            System.out.println( "Se agregó el estudiante" );
            
            preparedStatement.close();
            
            SQLException sQLException = null;
            
            return sQLException;
        }

        catch (SQLException e)
        {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Error: La identificación " + institutionalEmail + " Ya existe");
            JOptionPane.showMessageDialog(null, "Error: La identificación " + institutionalEmail + " Ya existe", "Registro Estudiantes", JOptionPane.ERROR_MESSAGE);
            return e;
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

        catch (SQLException e)
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

        catch (SQLException e)
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

        catch (SQLException e)
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

        catch (SQLException e)
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
