package com.marocair.controllers;

import com.marocair.dao.CitiesDao;
import com.marocair.dao.ClientDao;
import com.marocair.dao.ReservationsDao;
import com.marocair.dao.RoutesDao;
import com.marocair.helpers.SendMail;
import com.marocair.models.Clients;
import com.marocair.models.Reservations;
import com.marocair.models.Routes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;

@WebServlet(name = "BookingController", value = "/reservation")
public class BookingController extends HttpServlet {
    private final RoutesDao routesDao;
    private final CitiesDao citiesDao;
    private final Reservations res;
    private final Clients client;
    private final ClientDao clientDao;
    private final ReservationsDao resDao;

    public BookingController() {
        routesDao = new RoutesDao();
        resDao = new ReservationsDao();
        citiesDao = new CitiesDao();
        clientDao = new ClientDao();
        res = new Reservations();
        client = new Clients();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        if(Objects.equals(request.getParameter("action"),"booking")){
            long routeId = Long.parseLong(request.getParameter("routeId"));
            try {
                Routes route = routesDao.get(routeId).isPresent() ? routesDao.get(routeId).get() : null;
                assert route != null;
                request.setAttribute("cities", citiesDao.getAll());
                request.setAttribute("route", route);
                request.getRequestDispatcher("/views/reservation.jsp").forward(request, response);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            request.getRequestDispatcher("/views/reservation.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        long routeId = Long.parseLong(request.getParameter("routeId"));
        Routes route = null;
        try {
            route = routesDao.get(routeId).isPresent() ? routesDao.get(routeId).get() : null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        assert route != null;
        System.out.println(route.getStart_city());
        client.setFullName(request.getParameter("first_name")+" "+request.getParameter("last_name"));
        client.setEmail(request.getParameter("email"));
        client.setPhone(request.getParameter("phone"));
        if(clientDao.save(client)){
            try {
                int idClient = clientDao.getClientId();
                int random_ref = (int)Math.floor(Math.random()*(999999-99999+1)+99999);
                res.setClient_id(idClient);
                res.setReference(String.valueOf(random_ref));
                res.setDepartDate(LocalDate.now().plusDays(10).toString());
                if(resDao.save(res)){
                    String confirmMsg = "Reference number: "+res.getReference()+"\nYour Trip: \n\tStart city >> "+route.getStart_city()+"\t\t Start time: " + route.getStart_time() +
                            "\n\tArrival city >> "+route.getArrival_city()+ "\n\t\t\t Price:  "+ route.getPrice();
                    SendMail.sendMessage(client.getEmail(),"Confirmation reservation", confirmMsg);
                    request.setAttribute("refBooking", res.getReference());
                    request.setAttribute("successMsg", "Reservation has been booked successfully");
                    request.getRequestDispatcher("/views/reservation.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
