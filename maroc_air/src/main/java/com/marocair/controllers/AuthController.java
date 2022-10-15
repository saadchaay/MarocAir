package com.marocair.controllers;

import com.marocair.dao.AuthDao;
import com.marocair.models.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AuthController", urlPatterns = {"/admin/*"})
public class AuthController extends HttpServlet {
    private final AuthDao authDao = new AuthDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("views/auth.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        PrintWriter wr = response.getWriter();
//        wr.println("User: >>  "+ dotenv.get("USER"));
//        wr.println("PASSWORD: >>  "+ dotenv.get("PASSWORD"));
        try {
            if(authDao.login(admin)) {
                response.sendRedirect("/views/dashboard.jsp");
            } else {
                wr.println("hello : Im not logged in!!");
                HttpSession session = request.getSession();
                session.setAttribute("username", admin.getUsername());
                response.sendRedirect("/admin");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
