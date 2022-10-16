package com.marocair.dao;

import com.marocair.models.Cities;
import com.marocair.models.Routes;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoutesDao implements DAO<Routes>{

    private final String table = "routes";

    @Override
    public Optional<Routes> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Routes> getAll() {
        try{
            Database db = new Database();
            String query = "select * from " + table;
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
    }

    @Override
    public long save(Routes routesDao) {
        return 0;
    }

    @Override
    public void update(Routes routesDao, String[] params) {
    }

    @Override
    public void delete(long id) {
    }
}

