package com.marocair.dao;


import com.oracle.wls.shaded.org.apache.xpath.operations.Bool;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    Optional<T> get(long id);

    List<T> getAll() throws SQLException;

    Boolean save(T t);

    void update(T t, String[] params);

    Boolean delete(long id);

}
