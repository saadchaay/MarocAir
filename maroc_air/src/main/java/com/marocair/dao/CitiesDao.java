package com.marocair.dao;

import com.marocair.models.Cities;

import java.util.List;
import java.util.Optional;

public class CitiesDao implements DAO<Cities> {
    @Override
    public Optional<Cities> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Cities> getAll() {
        return null;
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
