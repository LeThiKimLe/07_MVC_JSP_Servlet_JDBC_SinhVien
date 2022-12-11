package conn;

import java.sql.*;

public class DBConnection {
	public static Connection getConnection() 
            throws ClassNotFoundException, SQLException {
      // su dung DB nao thi mo ra o day
      //return OracleConnUtils.getOracleConnection();       
      // return OracleConnUtils.getOracleConnection();
       //return MySQLConnection.getMySQLConnection();
      return SQLServerConnection.initializeDatabase();
      // return SQLServerConnUtils_SQLJDBC.getSQLServerConnection_SQLJDBC();
      // return PostGresConnUtils.getPostGresConnection();
	}   
  
}
