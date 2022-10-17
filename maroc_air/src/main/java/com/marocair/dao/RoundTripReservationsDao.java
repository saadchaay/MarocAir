package com.marocair.dao;

import com.marocair.models.RoundTripReservations;

import java.util.List;
import java.util.Optional;

public class RoundTripReservationsDao implements DAO<RoundTripReservations>{
    @Override
    public Optional<RoundTripReservations> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<RoundTripReservations> getAll() {
        return null;
    }

    @Override
    public Boolean save(RoundTripReservations roundTripReservations) { return false; }

    @Override
    public void update(RoundTripReservations roundTripReservations, String[] params) {

    }

    @Override
    public Boolean delete(long id) {
        return false;
    }
}
