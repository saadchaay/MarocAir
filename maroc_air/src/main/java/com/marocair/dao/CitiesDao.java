package com.marocair.dao;

import com.marocair.models.Cities;
import com.marocair.util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitiesDao implements DAO<Cities> {

    private final String table = "Cities";

    @Override
    public Optional<Cities> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Cities> getAll() {
        try{
            Database db = new Database();
            String query = "select * from " + table;
            ResultSet resultSet = db.resultSet(query);
            ArrayList<Cities> cities = new ArrayList<>();
            while(resultSet.next()){
                Cities city = new Cities();
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
                cities.add(city);
            }
            return cities;
        }catch(Exception exception){

            return null;
        }


    }

    @Override
    public long save(Cities cities) {
        return 0;
    }

    @Override
    public void update(Cities cities, String[] params) {
    }

    @Override
    public void delete(long id) {
    }
}
