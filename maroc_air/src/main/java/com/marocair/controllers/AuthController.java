package com.marocair.controllers;

import com.marocair.dao.AuthDao;
import com.marocair.models.Admin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AuthController", value = "/authentication")
public class AuthController extends HttpServlet {
//    private final AuthDao authDao = new AuthDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("this is authentication page");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        Admin admin = new Admin();
//        admin.setUsername(username);
//        admin.setPassword(password);
        PrintWriter wr = response.getWriter();
        wr.println(username);
//        try {
//            if(authDao.login(admin))
//                wr.println("welcome "+ admin.getUsername());
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

    }
}
