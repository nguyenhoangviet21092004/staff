package com.example.backend2.repository;

import com.example.backend2.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepo extends JpaRepository<Staff,Integer> {
}
