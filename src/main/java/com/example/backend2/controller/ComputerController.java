package com.example.backend2.controller;

import com.example.backend2.model.Computer;
import com.example.backend2.repository.IComputerRepository;
import com.example.backend2.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/computers")
public class ComputerController {


    @Autowired
    private IComputerService iComputerService;
    @Autowired
    private IComputerRepository iComputerRepository;


    @GetMapping
    public ResponseEntity<Iterable<Computer>> findAllCustomer() {
        List<Computer> customers = (List<Computer>) iComputerService.findAll();
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Computer> findCustomerById(@PathVariable int id) {
        Optional<Computer> customerOptional = iComputerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Computer> saveCustomer(@RequestBody Computer computer) {
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateCustomer(@PathVariable int id, @RequestBody Computer computer) {
        Optional<Computer> customerOptional = iComputerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        computer.setId(customerOptional.get().getId());
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteCustomer(@PathVariable int id) {
        Optional<Computer> customerOptional = iComputerService.findById(id);
        if (!customerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iComputerService.remove(id);
        return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/searchByName")
    public ResponseEntity searchByName(@RequestParam String keyword) {
        List<Computer> customers = iComputerRepository.findAllByName(keyword);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }
}

