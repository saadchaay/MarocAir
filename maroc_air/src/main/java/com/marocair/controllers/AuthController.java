package com.marocair.controllers;

import com.marocair.dao.AuthDao;
import com.marocair.models.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Objects;

@WebServlet(name = "AuthController", value = "/admin/authentication")
public class AuthController extends HttpServlet {
    private final AuthDao authDao = new AuthDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.sendRedirect("/admin/auth.jsp");
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
        try {
            if(authDao.login(admin)) {
                Cookie loginCookie = new Cookie("username", admin.getUsername());
                //setting cookie to expiry in 30 mins
                loginCookie.setMaxAge(30*60);
                response.addCookie(loginCookie);
//                HttpSession session = request.getSession();
//                session.setAttribute("username", admin.getUsername());
                response.sendRedirect("/admin/route-trip");
            } else {
//                wr.println("hello : Im not logged in!!");
                request.setAttribute("msgError", "Failed, Your username or password is incorrect");
                request.getRequestDispatcher("/admin/auth.jsp").forward(request, response);
//                response.sendRedirect("/admin/authentication");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
