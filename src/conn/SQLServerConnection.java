package conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    { 
	        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	        String dbURL ="jdbc:sqlserver://181.215.242.83:18016";
	        // Database name to access 
	        String dbName = "myfirst"; 
	        String dbUsername = "admin"; 
	        String dbPassword = "Conchosu@1"; 
	        String connectionURL = dbURL + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
	        Connection conn = null;
	        try {
	            Class.forName(dbDriver);
	            conn = DriverManager.getConnection(connectionURL, dbUsername, dbPassword);
	            System.out.println("connect successfully!");
	        } catch (Exception ex) {
	            System.out.println("connect failure!");
	            ex.printStackTrace();
	        }
	        return conn; 
	    } 
}
