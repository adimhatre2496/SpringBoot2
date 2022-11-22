package com.example.springBootEmployee.controller;

import com.example.springBootEmployee.entity.EmployeeEntity;
import com.example.springBootEmployee.model.Employee;
import com.example.springBootEmployee.model.EmployeeRespone;
import com.example.springBootEmployee.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeEntity> getEmployee(@PathVariable Long employeeId) {
        EmployeeEntity employeeEntity = employeeService.getEmployee(employeeId);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }
    @GetMapping(path = "/employees", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeEntity> getAllEmployees(@RequestParam String firstName, @RequestParam String lastName ) {
        EmployeeEntity employeeEntity = employeeService.getAllEmployees(firstName,lastName);
        return new ResponseEntity<>(employeeEntity, HttpStatus.OK);
    }

    @PostMapping(path ="/employees", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<EmployeeRespone> createEmployee(@RequestBody Employee employee) {
        EmployeeRespone empRs = employeeService.createEmployee(employee);
        return new ResponseEntity<>(empRs, HttpStatus.OK);
    }

    @PutMapping(path = "/employees/{employeeId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeId, @RequestBody Employee employee) {
        Employee empUpdate = employeeService.updateEmployee(employeeId, employee);
        return new ResponseEntity<>(empUpdate, HttpStatus.OK);
    }



    @DeleteMapping(path = "/employees/{employeeId}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Void> deleteEmployee(@PathVariable Long employeeId) {
         employeeService.deleteEmployee(employeeId);
        return  ResponseEntity.noContent().build();
    }

}


