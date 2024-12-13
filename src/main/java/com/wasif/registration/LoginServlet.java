package com.wasif.registration;



import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail = request.getParameter("username");
        String upwd = request.getParameter("password");
        PrintWriter out=response.getWriter();

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "@hammad");

            // Prepare SQL query
            PreparedStatement pst = con.prepareStatement("select* from  db.users where  uemail=? and upwd=? ");
            pst.setString(1, uemail);
            pst.setString(2, upwd);
           
            
                ResultSet rs=pst.executeQuery();
                
                if(rs.next()) {
                	
                	HttpSession session=request.getSession();
                	session.setAttribute("session_name", rs.getString("uname"));
                	session.setAttribute("uemail", uemail);
                	session.setAttribute("upwd", upwd);
                	session.setAttribute("address",rs.getString("address"));
                	session.setAttribute("DOJ", rs.getString("DOJ"));
                	session.setAttribute("umobile", rs.getString("umobile"));
                	
                	
                	
                	RequestDispatcher rd=request.getRequestDispatcher("/Welcome.jsp");
                	
                	rd.forward(request,response);
                }else  {
                	
                	response.setContentType("text/html");
                	
                	
                	out.print("<h3 style='color:red'>  email id didnot matched</h3>");
                	RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
                	rd.include(request, response);
                	
                
                
                
                }
	}catch(Exception e) {
		e.printStackTrace();
		response.setContentType("text/html");
		out.print("<h3 style='color:red'>  Error occured:"+e.getMessage()+" </h3>");
		RequestDispatcher rd=request.getRequestDispatcher("/login.jsp");
		rd.include(request, response);
		
		
	}
	}
}
