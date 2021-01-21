package test;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
////import java.sql.PreparedStatement;
////import java.util.*;
//public class DBUtil {
//public static Connection getDBConnection()
//{
//	Connection con=null;
//
//try {
//	Class.forName("com.mysql.jdbc.Driver");
//	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student?serverTimezone=UTC","root","");
//	
//}
//catch(SQLException e)
//{
//	e.printStackTrace();
//}
//catch(ClassNotFoundException e)
//{
//	e.printStackTrace();
//}
//return con;
//}
//}

import java.sql.Connection;

import java.sql.DriverManager;
//import java.sql.PreparedStatement;

public class DBUtil {
//	static Connection con=null;
//	static
//	{
//		
//	}
public static Connection getDBConnection()
{Connection con=null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM","root");
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
return con;
}
}
