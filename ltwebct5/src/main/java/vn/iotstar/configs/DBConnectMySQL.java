package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectMySQL {
	  private static Connection con = null;
	   private static String USERNAME = "root";
	   private static String PASSWORD = "your_mysql_password";
	   private static String DRIVER = "com.mysql.cj.jdbc.Driver";
	   private static String URL = "jdbc:mysql://localhost:3306/ltwebct5";

	   public static Connection getDatabaseConnection() throws ClassNotFoundException{
		   try
		   {
	       Class.forName(DRIVER);
	       return setCon(DriverManager.getConnection(URL,USERNAME,PASSWORD));
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }
		   return null;
	   }

	public static Connection getCon() {
		return con;
	}

	public static Connection setCon(Connection con) {
		DBConnectMySQL.con = con;
		return con;
	}
	public static void main(String[] args)
	{
		try
		{
			new DBConnectMySQL();
			System.out.print(DBConnectMySQL.getDatabaseConnection());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
