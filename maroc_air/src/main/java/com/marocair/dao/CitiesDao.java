package com.marocair.dao;

import com.marocair.models.Cities;
import com.marocair.util.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CitiesDao implements DAO<Cities> {
    Database db = new Database();
    @Override
    public Optional<Cities> get(long id) {
        return Optional.empty();
    }

    @Override
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
