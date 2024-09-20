package com.cinema.test;

import com.cinema.dao.CustomerDao;
import com.cinema.model.Customer;
import java.sql.SQLException;

public class CinemaTest {
	public static void main(String[] args) throws SQLException {
        CustomerDao customerDao =  new CustomerDao();
        Customer customer = customerDao.findbyId(1);
        System.out.println(customer);
    }
}
