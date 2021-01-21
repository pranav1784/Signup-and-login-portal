package test;
import java.io.*;

import java.sql.*;
//import java.util.HashMap;

import javax.servlet.*;
import javax.servlet.http.*;
public class SignUpServlet extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		PrintWriter out=res.getWriter();
		String st;
		String q2 = req.getParameter("r1");
		try {
			st=req.getParameter("r1");
			
			if(st.equals("b"))
			{
				st="male";
			}
			else
				st="female";
				
			int t1=insertLoginInfo(req.getParameter("n1"),req.getParameter("p1"));
			int t2=insertUserInfo(req.getParameter("n1"),req.getParameter("n2"),st,req.getParameter("a1"),req.getParameter("o1"),req.getParameter("s1"));
			if(t1==1&&t2==1)
			{ out.println("<h4 style='color:green;'>SIGNUP SUCCESSFULL NOW PLEASE LOGIN!</h4>");
				 RequestDispatcher rd=req.getRequestDispatcher("login.html");  
				  rd.include(req,res);
				  
			}
			else
			{
				out.println("<h2 style='color:red;'>SOME ERROR OCCURRED PLEASE TRY AGAIN</h2>");
				RequestDispatcher rd=req.getRequestDispatcher("SignUp.html");  
				  rd.include(req,res);
				  
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public int insertLoginInfo(String name,String pass) throws SQLException
	{
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps = con.prepareStatement("insert into pranav.logininfo values (?,?)");
		ps.setString(1,name);
		
		ps.setString(2,pass);
		
	int	t=ps.executeUpdate();
	return t;
		
	}
	public int insertUserInfo(String uname,String name,String gen,String age, String occu,String sal) throws SQLException
	{
		Connection con=DBUtil.getDBConnection();
		int a=Integer.parseInt(age);
		int s=Integer.parseInt(sal);
		PreparedStatement ps = con.prepareStatement("insert into pranav.userinfo values (?,?,?,?,?,?)");
		ps.setString(1,uname);
		
		ps.setString(2,name);
		ps.setString(3, gen);
		ps.setInt(4, a);
		ps.setString(5, occu);
		ps.setInt(6, s);
		
	int	t=ps.executeUpdate();
	return t;
	}
	
}

