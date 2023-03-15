package com.employeedemo.employeedemo.controller;

import com.employeedemo.employeedemo.model.Employee;
import com.employeedemo.employeedemo.repository.EmployeeRepository;
import com.employeedemo.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class IngestController {


    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/add")
    public String addEmployee() throws FileNotFoundException {
          employeeService.saveEmployeeDetails();
          return "update in progress";
    }
}
