package com.marocair.controllers;

import com.marocair.dao.RoutesDao;
import com.marocair.models.Routes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        int departureCity = Integer.parseInt( request.getParameter("departure-city"));
        int destinationCity = Integer.parseInt( request.getParameter("destination-city"));
        String persons = request.getParameter("persons");
        String departureDate = request.getParameter("departure-date");
        String returnDate = (roundTrip.equals("AllerSimple")) ? null : request.getParameter("return-date") ;

        if(departureCity == destinationCity){
//            response.getWriter().println("<h1> Departure city mush be different than Destination city !! </h1>");
            return;
        }
        RoutesDao routesDao = new RoutesDao();
        List<Routes> routes = new ArrayList<>();
        ArrayList<Routes> possibleEscales = new ArrayList<>();
        ArrayList<ArrayList<Routes>> possibleRoutes = new ArrayList<>();

        Routes currentRoute;

        try {
            routes = routesDao.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        response.getWriter().println(routes);

        for(Routes route: routes){
            possibleEscales = new ArrayList<>();
            if(route.getStart_city() == departureCity){
                if(route.getArrival_city() == destinationCity){
                    possibleEscales.add(route);
                    possibleRoutes.add(possibleEscales);
                    continue;
                }
                possibleEscales.add(route);
                currentRoute = route;

                for(Routes innerRoute: routes){
                    if(currentRoute.equals(innerRoute)){
                        continue;
                    }
                    if(currentRoute.getArrival_city() == innerRoute.getStart_city()){
                        if(currentRoute.getStart_city() == innerRoute.getArrival_city()){
                            continue;
                        }
                        possibleEscales.add(innerRoute);
                        currentRoute = innerRoute;
                    }
                    if(currentRoute.getArrival_city() == destinationCity){
                        break;
                    }
                }
                if( possibleEscales.get(possibleEscales.size() - 1).getArrival_city() == destinationCity ){
                    possibleRoutes.add(possibleEscales);
                }
            }
        }

        request.setAttribute("possibleRoutes", possibleRoutes);


        for(ArrayList<Routes> possibleRoute: possibleRoutes){
            response.getWriter().println("possible route : ");
            for(Routes possibleEscale: possibleRoute){
//                response.getWriter().println("A : " + possibleEscale.getStart_city() + " B : " + possibleEscale.getArrival_city());
            }
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/flights.jsp");
        dispatcher.forward(request, response);



//        response.getWriter().println("<h1>departureCity : " + departureCity + "</h1>");
//        response.getWriter().println("<h1>destinationCity : " + destinationCity + "</h1>");
//        response.getWriter().println("<h1>roundTrip : " + roundTrip + "</h1>");
//        response.getWriter().println("<h1>persons : " + persons + "</h1>");
//        response.getWriter().println("<h1>departureDate : " + departureDate + "</h1>");
//        response.getWriter().println("<h1>returnDate : " + returnDate + "</h1>");
    }
}
