package com.example.tasktrackerphase1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddTaskServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title=request.getParameter("title");
        String description=request.getParameter("description");

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc::postgresql://localhost:5432/tasktracker","postgres","password");
            PreparedStatement ps = con.prepareStatement("INSERT INTO tasktrackerphase1 (title,description) VALUES (?,?)");
            ps.setString(1, title);
            ps.setString(2, description);
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
           e.printStackTrace();
        }
        response.sendRedirect("viewTasks.jsp");
    }
}
