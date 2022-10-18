package com.marocair.dao;

import com.marocair.models.Cities;
import com.marocair.models.Routes;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoutesDao implements DAO<Routes>{

    private final String table = "routes";


    Database db;
    public RoutesDao() {
        db = new Database();
    }
    @Override
    public Optional<Routes> get(long id) throws SQLException {
        String rqt = "SELECT * FROM routes WHERE id = "+ id +";";
        ResultSet res = db.resultSet(rqt);
        while (res.next()){
            Routes route = new Routes();
            route.setId(res.getInt("id"));
            route.setStart_city(res.getInt("start_city"));
            route.setArrival_city(res.getInt("arrival_city"));
            route.setPrice(res.getDouble("price"));
            route.setDuration(res.getInt("duration"));
            route.setStart_time(String.valueOf(res.getTime("start_time")));
            return Optional.of(route);
        }
        return Optional.empty();
    }
    @Override
   /* public List<Routes> getAll() {
        try{
            Database db = new Database();
            String query = "select * from " + table ;
            ResultSet resultSet = db.resultSet(query);
            ArrayList<Routes> routes = new ArrayList<>();
            while(resultSet.next()){
                Routes route = new Routes();
                route.setId(resultSet.getInt("id"));
                route.setStart_city(resultSet.getInt("start_city"));
                route.setArrival_city(resultSet.getInt("arrival_city"));
                route.setPrice(resultSet.getDouble("price"));
                route.setDuration(resultSet.getInt("duration"));
                routes.add(route);
            }
            return routes;
        }catch(Exception exception){

            return null;
        }
        }*/
    public List<Routes> getAll() throws SQLException {
        List<Routes> routes = new ArrayList<>();
        String rq = "SELECT * FROM routes";
        ResultSet res = db.resultSet(rq);
        while (res.next()){
            Routes route = new Routes();
            route.setId(res.getInt("id"));
            route.setStart_city(res.getInt("start_city"));
            route.setArrival_city(res.getInt("arrival_city"));
            route.setPrice(res.getDouble("price"));
            route.setDuration(res.getInt("duration"));
            route.setStart_time(String.valueOf(res.getTime("start_time")));
            routes.add(route);
        }
        return routes;
    }

    @Override
    public Boolean save(Routes route) {
//        INSERT INTO public.routes (id, start_city, arrival_city, price, duration) VALUES (DEFAULT, 1::integer, 2::integer, 5463.00::numeric(7,2), 300::integer)
        String rqt = "INSERT INTO routes (id, start_city, arrival_city, price, duration, start_time) VALUES(DEFAULT,"+
                route.getStart_city() +","+ route.getArrival_city() +","+ route.getPrice() +","+ route.getDuration() +", '"+ route.getStart_time() +"');";
        return db.execute(rqt);
    }

    @Override
    public void update(Routes routesDao, String[] params) {
    }

    @Override
    public Boolean delete(long id) {
        String rqt = "DELETE FROM routes WHERE id = "+ id +";";
        return db.execute(rqt);
    }
}

