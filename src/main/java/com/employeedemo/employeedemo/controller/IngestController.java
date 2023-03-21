package com.employeedemo.employeedemo.controller;

import com.employeedemo.employeedemo.dto.ApiResponse;
import com.employeedemo.employeedemo.model.Employee;
import com.employeedemo.employeedemo.repository.EmployeeRepository;
import com.employeedemo.employeedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class IngestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/add")
    public String addEmployee() throws FileNotFoundException {
          employeeService.saveEmployeeDetails();
          return "update in progress";
    }
    @GetMapping("/allEmployees/{offset}/{pagesize}")
    public ApiResponse<Page<Employee>> getEmployees(@PathVariable int offset,@PathVariable int pagesize)
    {
        Page<Employee> employees = employeeService.getEmployees(offset, pagesize);
      return new ApiResponse<>(employees,pagesize);
    }
    @GetMapping("/allEmployees/sorted/{offset}/{pagesize}")
    public ApiResponse<Page<Employee>> getEmployeesSorted(@PathVariable int offset,@PathVariable int pagesize)
    {
        Page<Employee> employees = employeeService.getEmployeesSorted(offset, pagesize);
        return new ApiResponse<>(employees,pagesize);
    }
}
