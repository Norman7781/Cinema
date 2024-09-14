package com.cinema.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<Ticket> tickets = new ArrayList<Ticket>();
}
