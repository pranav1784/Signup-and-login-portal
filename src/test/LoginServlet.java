package test;
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import javax.servlet.*;
import javax.servlet.http.*;



public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HashMap<String,String> map=new HashMap<>();
		Connection con=DBUtil.getDBConnection(); 
		   try
		   {
		
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from pranav.logininfo");
		while(rs.next())
		{
			String n=rs.getString(1);
			String p=rs.getString(2);
			map.put(n,p);
			//System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+" "+rs.getInt(3));
		}
		con.close();
		   }
		  
		   catch(Exception e)
		   {
			   
		   }
		  
		  String name=req.getParameter("username");
		  String pwd=req.getParameter("password");
		 if(map.containsKey(name))
		 {
			 if(map.get(name).equals(pwd))
			 {PrintWriter out=res.getWriter();
				
				 RequestDispatcher rd=req.getRequestDispatcher("pranav2");  
				  rd.forward(req,res);
			 }
			 else
			 {
				 PrintWriter out=res.getWriter();
				 out.println("<h3 class='a1'>Access denied!<br>Invalid Password</h3>");
				 RequestDispatcher rd=req.getRequestDispatcher("login.html");
				  rd.include(req, res);
			 }
		 }
		 else
		 {
			 PrintWriter out=res.getWriter();
			 out.println("<h3 class='a1'>Username Not Found<br>Please SIGN UP and try again</h3>");
			 RequestDispatcher rd=req.getRequestDispatcher("login.html");
			  rd.include(req, res);
		 }
		  
		  

	
}
}
