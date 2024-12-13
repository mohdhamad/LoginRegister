package com.wasif.registration;



import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProfileServlet")
public class editProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        String uemail = req.getParameter("uemail");
        String address = req.getParameter("address");
        String DOJ = req.getParameter("DOJ");
        String umobile = req.getParameter("umobile");
        
        
        

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "@hammad")) {
          
            String query = "UPDATE users SET uname = ?,uemail=?, address = ?,DOJ=?,umobile=?  where uemail=? ";
            try (PreparedStatement ps = con.prepareStatement(query)) {
                ps.setString(1, uname);
                ps.setString(2, uemail);
                ps.setString(3, address);
                ps.setString(4, DOJ);
                ps.setString(5, umobile);
                ps.setString(6, uemail);
                
                

                int rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    // Redirect to profile page after successful update
                    res.sendRedirect("Profile");
                } else {
                    req.setAttribute("errorMessage", "Failed to update profile. Please try again.");
                    req.getRequestDispatcher("editProfile.jsp").forward(req, res);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
            req.getRequestDispatcher("editProfile.jsp").forward(req, res);
        }
    }
}
