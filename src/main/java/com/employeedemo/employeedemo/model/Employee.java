package com.employeedemo.employeedemo.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    int empid;
    String empname;
    int salary;
    String address;
}


