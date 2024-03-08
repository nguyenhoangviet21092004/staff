package com.example.backend2.service;

import com.example.backend2.model.Customer;
import com.example.backend2.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService  implements ICustomerService{
    
    @Autowired
    private ICustomerRepo iCustomerRepo;
    @Override
    public void save(Customer customer) {
        iCustomerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findById(long id) {
        return iCustomerRepo.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {
        iCustomerRepo.delete(customer);
    }
}
