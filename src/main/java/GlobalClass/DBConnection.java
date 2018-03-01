package GlobalClass;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class DBConnection {

    static Connection connection = getConnection();
    public static Connection getConnection() throws ClassNotFoundException
    {
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            //connection = (Connection) DriverManager.getConnection("jdbc:mysql://xyz_db","abc_User","xyz_Pwd");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/xyz_db","root","");
        }
        catch(SQLException exception)
        {
            exception.printStackTrace();
        }
        return connection;
    }
}
