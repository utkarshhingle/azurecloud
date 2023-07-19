package com.utk.azurecloud.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.utk.azurecloud.dto.EmployeeTest;

public interface EmployeeRepository extends JpaRepository<EmployeeTest,Integer> {
}
