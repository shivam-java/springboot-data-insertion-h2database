package com.employeedemo.employeedemo.service;

import com.employeedemo.employeedemo.model.Employee;
import com.employeedemo.employeedemo.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

   public void saveEmployeeDetails() throws FileNotFoundException {
       FileReader fileReader=new FileReader("src/main/resources/employee.json");
       AtomicReference<List<Employee>> employees1=null;
       ObjectMapper mapper=new ObjectMapper();
       CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()-> {
           try {
               List<Employee> employees = mapper.readValue(fileReader, new TypeReference<List<Employee>>(){});
               employees1.set(employeeRepository.saveAll(employees));
           } catch (IOException e) {
               e.printStackTrace();
           }
       });
       if(employees1!=null){
       System.out.println(employees1.get().size());
       }

   }
}
