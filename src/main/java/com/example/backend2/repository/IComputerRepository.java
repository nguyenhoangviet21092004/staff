package com.example.backend2.repository;


import com.example.backend2.model.Computer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IComputerRepository extends PagingAndSortingRepository<Computer, Integer> {
    List<Computer> findAllByName(String keyword);
}