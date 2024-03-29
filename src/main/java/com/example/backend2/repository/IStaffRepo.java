package com.example.backend2.repository;

import com.example.backend2.model.Computer;
import com.example.backend2.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStaffRepo extends JpaRepository<Staff,Integer> {
    List<Computer> findAllByName(String keyword);
}
