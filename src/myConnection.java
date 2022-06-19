import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class myConnection {

	public static Connection getConnection()
	{
		Connection conn=null;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("\n DRIVER REGISTERED SUCCESSFULLY");
	   
	 		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SMEETS123","SMEETS123");
			System.out.println("\n DATABASE CONNECTED SUCCESSFULLY");

			Statement st=conn.createStatement();
			 
		}
		catch(Exception ex)
		{
			System.out.println("\nError occured in connection");
		}
		return conn;
	}
}
