package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import vn.iotstar.impl.UserDAOImpl;
import vn.iotstar.models.UserModel;

public class DBConnectSQLServer {
	 public static Connection getConnection() 
	    {
	       Connection c= null;
	       try {
	       SQLServerDriver driver = new SQLServerDriver();
	       
	       DriverManager.registerDriver(driver);
	      // String url = "jdbc:sqlserver://LEHUNG\\THAIHUNG;databaseName=ltwebct5;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
	       String url = "jdbc:sqlserver://LEHUNG\\THAIHUNG;databaseName=ltwebct5;user=testLogin;password=123456;encrypt=true;trustServerCertificate=true;";

	       
	       c=DriverManager.getConnection(url);
	       
	       return c;
	         }catch(SQLException e)
	       {
	    	 e.printStackTrace();
	    	 return null;
	       }
	    }
	   public static void closeConnection(Connection c)
	   {
		   try
		   {
			   if(c!=null)
				   c.close();
		   }catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		}
	   public static void printInfo(Connection c)
	   {
		   try 
		   {
		      if(c!=null)
		        {
			   System.out.print(c.getMetaData().toString());
		        }
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }
	   }
	   public static void main(String[]arg)
		{
			DBConnectSQLServer.printInfo(getConnection());
				
		}
}
