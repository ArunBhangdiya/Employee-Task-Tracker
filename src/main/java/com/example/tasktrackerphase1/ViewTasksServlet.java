package com.example.tasktrackerphase1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/viewTasks")
public class ViewTasksServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           Class.forName("org.postgresql.Driver");
           Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/tasktracker","postgres","password");
           PreparedStatement ps = con.prepareStatement("SELECT * FROM tasks ORDER BY id");
           ResultSet rs = ps.executeQuery();
           req.setAttribute("taskList",rs);
           req.getRequestDispatcher("viewTasks.jsp").forward(req,resp);
           rs.close();
           ps.close();
           con.close();
       }catch (Exception e){
           e.printStackTrace();
           resp.getWriter().println("Error" + e.getMessage());
       }
    }
}
