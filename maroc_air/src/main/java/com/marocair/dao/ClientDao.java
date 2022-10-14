package com.marocair.dao;

import com.sun.security.ntlm.Client;

import java.util.List;
import java.util.Optional;

public class ClientDao implements DAO<Client>{
    @Override
    public Optional<Client> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public long save(Client client) {
        return 0;
    }

    @Override
    public void update(Client client, String[] params) {

    }

    @Override
    public void delete(long id) {

    }
}
