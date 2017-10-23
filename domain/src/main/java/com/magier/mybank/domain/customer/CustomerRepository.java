package com.magier.mybank.domain.customer;

import java.util.List;

public interface CustomerRepository {

    void createCustomer(Customer customer);
    List<Customer> findAll();
    Customer findByEMail(String email);
    void deleteAllCustomers();
}
