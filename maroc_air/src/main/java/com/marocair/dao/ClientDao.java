package com.marocair.dao;

import com.marocair.models.Clients;
import java.util.List;
import java.util.Optional;

public class ClientDao implements DAO<Clients>{
    @Override
    public Optional<Clients> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Clients> getAll() {
        return null;
    }

    @Override
    public Boolean save(Clients client) {
        return false;
    }

    @Override
    public void update(Clients client, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
