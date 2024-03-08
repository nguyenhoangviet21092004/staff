package com.example.backend2.service;

import com.example.backend2.model.Customer;
import com.example.backend2.model.Staff;

import java.util.List;
import java.util.Optional;

public interface IStaffService {
    public void save(Staff staff);

    public Optional<Staff> findById(int id);

    public List<Staff> findAll();


    public void delete(Staff staff);
}
