package com.marocair.controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TestController", value = "/TestController")
public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String roundTrip = request.getParameter("round-trip");
        String departureCity = request.getParameter("departure-city");
        String destinationCity = request.getParameter("destination-city");
        String persons = request.getParameter("persons");
        String departureDate = request.getParameter("departure-date");
        String returnDate = (roundTrip.equals("AllerSimple")) ? null : request.getParameter("return-date") ;

        response.getWriter().println("<h1>departureCity : " + departureCity + "</h1>");
        response.getWriter().println("<h1>destinationCity : " + destinationCity + "</h1>");
        response.getWriter().println("<h1>roundTrip : " + roundTrip + "</h1>");
        response.getWriter().println("<h1>persons : " + persons + "</h1>");
        response.getWriter().println("<h1>departureDate : " + departureDate + "</h1>");
        response.getWriter().println("<h1>returnDate : " + returnDate + "</h1>");
    }
}
