package com.marocair.dao;

import com.marocair.models.UpdatedTrips;
import com.marocair.util.Database;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UpdatedTripsDao implements DAO<UpdatedTrips>{

    Database db;

    public UpdatedTripsDao() { db = new Database(); }

    @Override
    public Optional<UpdatedTrips> get(long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public List<UpdatedTrips> getAll() throws SQLException {
        return null;
    }

    @Override
    public Boolean save(UpdatedTrips updatedTrips) {
        String rqt = "INSERT INTO updated_trips(id, route_id, start_period, end_period, new_price) " +
                "VALUES (DEFAULT, "+ updatedTrips.getRoute_id() +", "+ updatedTrips.getStart_period() +", "+
                updatedTrips.getEnd_period() +", "+ updatedTrips.getPrice() +")";
        return db.execute(rqt);
    }

    @Override
    public void update(UpdatedTrips updatedTrips, String[] params) {

    }

    @Override
    public Boolean delete(long id) {
        return null;
    }
}
