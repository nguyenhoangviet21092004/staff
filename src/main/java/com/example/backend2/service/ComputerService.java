package com.example.backend2.service;


import com.example.backend2.model.Computer;
import com.example.backend2.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository iComputerRepository;


    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }


    @Override
    public Optional<Computer> findById(int id) {
        return iComputerRepository.findById(id);
    }


    @Override
    public Computer save(Computer computer) {
        return iComputerRepository.save(computer);
    }


    @Override
    public void remove(int id) {
        iComputerRepository.deleteById(id);
    }
}