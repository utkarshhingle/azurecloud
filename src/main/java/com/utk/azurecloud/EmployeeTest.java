package com.utk.azurecloud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTest {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String dept;
    private long salary;
}
