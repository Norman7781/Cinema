package com.cinema.dao;

import java.sql.SQLException;

public abstract class AbstractDao<T>{

    public abstract T findbyId(int id) throws SQLException;
}
