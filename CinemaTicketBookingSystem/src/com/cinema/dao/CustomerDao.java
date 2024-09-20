package com.cinema.dao;

import com.cinema.database.PgSqlConnectionFactory;
import com.cinema.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao extends AbstractDao<Customer>{

    private PgSqlConnectionFactory connectionFactory;

    public CustomerDao(){
        this.connectionFactory = new PgSqlConnectionFactory();
    }
    @Override
    public Customer findbyId(int id) throws SQLException {
        String query = "select * from customers where id = ?";
        try(Connection connection = this.connectionFactory.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()){
                    Customer customer = new Customer();
                    customer.setId (resultSet.getInt("id"));
                    customer.setName(resultSet.getString("name"));
                    return customer;
                }
            }
        }
        return null;
    }
}
