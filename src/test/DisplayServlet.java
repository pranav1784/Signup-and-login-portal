package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
{
		PrintWriter out=res.getWriter();
		
		try
		   {
			
		Connection con=DBUtil.getDBConnection(); 
		String name=req.getParameter("username");
		//Statement st=con.createStatement();
		//ResultSet rs=st.executeQuery("select * from pranav.userinfo");
		out.println("<h2>LOGGED IN SUCCESSFULLY</h2>");
		PreparedStatement ps=con.prepareStatement("select * from pranav.userinfo where username=?");
		ps.setString(1,name);
		//ps.setInt(1,20);
		ResultSet rs=ps.executeQuery();

	while(rs.next())
		{
			//PrintWriter out=res.getWriter();
		out.println(rs.getString(1)+"<br>"+rs.getString(2)+"<br>"+rs.getString(3)+"<br>"+rs.getInt(4)+"<br>"+rs.getString(5)+"<br>"+rs.getInt(6)+"<br>");
		}	
		

		
		con.close();
		   }
		   catch(SQLException e)
		   {
			   
		   }

	
}
}
