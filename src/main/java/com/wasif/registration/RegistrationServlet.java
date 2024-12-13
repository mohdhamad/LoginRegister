package com.wasif.registration;




import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
   
           
       

        String uname = request.getParameter("name");
        String uemail = request.getParameter("email");
        String upwd = request.getParameter("pass");
        String address = request.getParameter("address");
        String DOJ = request.getParameter("DOJ");
        String umobile = request.getParameter("contact");
        RequestDispatcher dispatcher=null;
      

        try  {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","@hammad");
        	PreparedStatement pst=con.prepareStatement("INSERT INTO users (uname, uemail, upwd, address, doj, umobile) VALUES (?, ?, ?, ?, ?, ?)");
        	pst.setString(1, uname);
        	pst.setString(2, uemail);
        	pst.setString(3, upwd);
        	pst.setString(4, address);
        	pst.setString(5, DOJ);
        	pst.setString(6, umobile);
           

            int rowCount=pst.executeUpdate();
            dispatcher=request.getRequestDispatcher("registration.jsp");

               
                if (rowCount > 0) {
                    request.setAttribute("status", "success");
                } else {
                    request.setAttribute("status", "error");
                }
                dispatcher.forward(request, response);
                
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                request.setAttribute("status", "error");
            }

          
        }
    }

