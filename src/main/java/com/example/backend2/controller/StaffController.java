package com.example.backend2.controller;

import com.example.backend2.model.Computer;
import com.example.backend2.model.Staff;
import com.example.backend2.repository.IStaffRepo;
import com.example.backend2.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staffs")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private IStaffRepo iStaffRepo;

    @GetMapping("")
    public ResponseEntity<List<Staff>> findAll() {
        List<Staff> list = staffService.findAll();
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> findByID(@PathVariable int id) {
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);

    }

    @PostMapping("/save")
    public ResponseEntity<Staff> save(@RequestBody Staff staff) {
        staffService.save(staff);
        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> update(@PathVariable int id, @RequestBody Staff staff) {
        Optional<Staff> staff1 = staffService.findById(id);
        if (!staff1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        staff.setId(staff1.get().getId());

        staffService.save(staff);

        return new ResponseEntity<>(staff, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> delete(@PathVariable int id) {
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.delete(staff.get());
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);

    }

    @GetMapping("/searchByName")
    public ResponseEntity searchByName(@RequestParam String keyword) {
        List<Computer> customers = iStaffRepo.findAllByName(keyword);
        if (customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

}
