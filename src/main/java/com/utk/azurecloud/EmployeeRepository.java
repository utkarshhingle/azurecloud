package com.utk.azurecloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public String save(Employee employee) {
        String sql = "INSERT INTO Employee (id,name,dept,salary) VALUES (?,?,?,?)";
        jdbcTemplate.update(sql, employee.getId(),employee.getName(),employee.getDept(),employee.getSalary());
        return "Succesfully Inserted";
    }
}
