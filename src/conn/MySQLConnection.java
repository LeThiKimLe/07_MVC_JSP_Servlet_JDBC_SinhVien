package conn;

import java.sql.*;

public class MySQLConnection {
	public static Connection initializeDatabase() 
	        throws SQLException, ClassNotFoundException 
	    { 
	        String dbDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
	        String dbURL = "jdbc:sqlserver://localhost:1433"; 
	        // Database name to access 
	        String dbName = "myfirst"; 
	        String dbUsername = "sa"; 
	        String dbPassword = "123456"; 
	        String connectionURL = dbURL + ";databaseName=" + dbName;
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
