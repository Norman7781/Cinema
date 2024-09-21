package com.cinema.test;

import com.cinema.dao.CustomerDao;
import com.cinema.model.Customer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public class CinemaTest {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static CustomerDao customerDao = new CustomerDao();
    public static void customerAction(){
            System.out.println("Choose an action:");
            System.out.println("1: Find Customer by ID");
            System.out.println("2: Get All Customers");
            System.out.println("3: Create a New Customer");
            System.out.println("4: Delete Customer");
            System.out.println("5: Exit");
    }
	public static void main(String[] args) throws SQLException, IOException {

        boolean exit = false;
        while(!exit){
        int choice = Integer.parseInt(br.readLine());

        switch(choice){
                case 1:
                    findCustomer();
                    break;
                case 2:
                    getAllCusomter();
                    break;
                case 3:
                    registerCustomer();
                    break;
                case 4:
                    destroyCustomer();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the application...");
                    break;
                    }
        }

        CustomerDao customerDao =  new CustomerDao();
        Customer customer = customerDao.findbyId(1);
        System.out.println(customer);

        System.out.println("*****get all customers*****");
        List<Customer> customers = customerDao.getALl();
        for(Customer c: customers) {
            System.out.println(c);
        }

        System.out.println("******create customer*****");
        Customer newCustomer = new Customer();
        newCustomer.setName("U HLA");
        customerDao.create(newCustomer);

        System.out.println("*****get all customers*****");
        customers = customerDao.getALl();
        for(Customer c: customers) {
            System.out.println(c);
        }

        Customer deleteCustomer = new Customer();
        deleteCustomer.setId(11);
        customerDao.delete(deleteCustomer);
    }

    private static void destroyCustomer() throws IOException, SQLException {
        System.out.println("Enter Customer Id : ");
        int id = Integer.parseInt(br.readLine());
        Customer customer = new Customer();
        customer.setId(id);
        customerDao.delete(customer);
    }

    private static void registerCustomer() throws SQLException, IOException {
        System.out.println("Enter customer name: ");
        String name = br.readLine();
        Customer customer = new Customer();
        customer.setName(name);
        customerDao.create(customer);
    }

    private static void getAllCusomter() throws SQLException {
        System.out.println("*** All Customers ***");
        List<Customer> customers = customerDao.getALl();
        for (Customer c: customers) {
            System.out.println(c);
        }
    }

    private static void findCustomer() throws IOException, SQLException {
        System.out.println("Enter Customer Id: ");
        int id = Integer.parseInt(br.readLine());
        Customer customer = customerDao.findbyId(id);
    }
}
