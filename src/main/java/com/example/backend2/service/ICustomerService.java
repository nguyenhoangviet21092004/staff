package com.example.backend2.service;

import com.example.backend2.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    public void save(Customer customer);

    public Optional<Customer> findById(long id);

    public List<Customer> findAll();

    public void update(Customer customer);

    public void delete(Customer customer);
}
