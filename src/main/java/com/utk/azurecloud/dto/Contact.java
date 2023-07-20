package com.utk.azurecloud.dto;
import jakarta.persistence.*;

@Entity
public class Contact {
    public Contact(String name, String email, String message) {
		super();
		this.name = name;
		this.email = email;
		this.message = message;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String message;

    
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    
    
    // Constructors, getters, and setters
    // ...
}
