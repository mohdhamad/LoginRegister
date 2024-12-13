package com.wasif.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Profile")
public class profileServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        
        String email = (String) session.getAttribute("uemail");
        String password = (String) session.getAttribute("upwd");
        
        
        if (email == null || password == null) {
            res.sendRedirect("login.jsp"); // Redirect to login if session data is missing
            return;
        }

        try {
            // Database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "@hammad");

            // Query to fetch user details
            String query = "SELECT * FROM users WHERE uemail = ? AND upwd = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Setting user details in request attributes
                req.setAttribute("id", rs.getInt("id"));
                req.setAttribute("uname", rs.getString("uname"));
                req.setAttribute("uemail", rs.getString("uemail"));
                req.setAttribute("upwd", rs.getString("upwd"));
                req.setAttribute("address", rs.getString("address"));
                req.setAttribute("DOJ", rs.getString("DOJ"));
                req.setAttribute("umobile", rs.getString("umobile"));
            } else {
                req.setAttribute("errorMessage", "No user found. Please check your credentials.");
            }

            // Close resources
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("errorMessage", e.getMessage());
        }

        // Forward to JSP
        RequestDispatcher rd = req.getRequestDispatcher("Profile.jsp");
        rd.forward(req, res);
    }
}

