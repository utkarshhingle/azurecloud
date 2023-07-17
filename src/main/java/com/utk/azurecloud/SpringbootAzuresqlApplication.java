package com.utk.azurecloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class SpringbootAzuresqlApplication {

    @Autowired
    private EmployeeRepository repository;

//    @PostMapping("/employee")
//    public String addEmployee(@RequestBody Employee employee) {
//        return repository.save(employee);
//    }

//    @GetMapping("/employees")
//    public List<Employee> getEmployees() {
//        return repository.findAll();
//    }

	@GetMapping("/message")
	public String message() {
		return "Congratulation your app deployed successfully on Azure ";
	}
	
	
    public static void main(String[] args) {
        SpringApplication.run(SpringbootAzuresqlApplication.class, args);
    }

	@PostMapping("/employee")
	public EmployeeTest addEmployee(@RequestBody EmployeeTest employee) {
	    return repository.save(employee);
	}
	
	@GetMapping("/employees")
	public List<EmployeeTest> getEmployees() {
	    return repository.findAll();
	}
	

}
