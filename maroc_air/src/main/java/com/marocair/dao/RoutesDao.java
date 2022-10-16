package com.marocair.dao;

import com.marocair.models.Routes;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoutesDao implements DAO<Routes>{
    Database db;
    public RoutesDao() {
        db = new Database();
    }
    @Override
    public Optional<Routes> get(long id) {
        return Optional.empty();
    }
    @Override
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
            routes.add(route);
        }
        return routes;
    }

    @Override
    public Boolean save(Routes route) {
//        INSERT INTO public.routes (id, start_city, arrival_city, price, duration) VALUES (DEFAULT, 1::integer, 2::integer, 5463.00::numeric(7,2), 300::integer)
        String rqt = "INSERT INTO routes (id, start_city, arrival_city, price, duration) VALUES(DEFAULT,"+ route.getStart_city() +","+ route.getArrival_city() +","+ route.getPrice() +","+ route.getDuration() +");";
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

