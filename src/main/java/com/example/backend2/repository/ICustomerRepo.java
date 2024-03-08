package com.example.backend2.repository;

import com.example.backend2.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Long> {
}
