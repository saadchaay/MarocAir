package com.marocair.dao;

import com.marocair.models.Cities;
import com.marocair.util.Database;

import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitiesDao implements DAO<Cities> {

    private final String table = "Cities";
    Database db = new Database();
    @Override
    public Optional<Cities> get(long id) {
        try{
            Database db = new Database();
            String query = "select * from " + table + " where id = " + id;
            ResultSet resultSet = db.resultSet(query);
            Cities city = new Cities();
            while(resultSet.next()){
                city.setId(resultSet.getInt("id"));
                city.setName(resultSet.getString("name"));
            }
            return Optional.of(city);
        }catch(Exception exception){

            return Optional.empty();
        }
    }

    @Override
  /*    public List<Cities> getAll() {
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
    */

    public List<Cities> getAll() throws SQLException {
        List<Cities> cites = new ArrayList<>();
        String rq = "SELECT * FROM cities";
        ResultSet res = db.resultSet(rq);
        while (res.next()){
            Cities city = new Cities();
            city.setId(res.getInt("id"));
            city.setName(res.getString("name"));
            cites.add(city);
        }
        return cites;
    }

    @Override
    public Boolean save(Cities cities) {
        return false;
    }

    @Override
    public void update(Cities cities, String[] params) {
    }

    @Override
    public void delete(long id) {

    }
}
