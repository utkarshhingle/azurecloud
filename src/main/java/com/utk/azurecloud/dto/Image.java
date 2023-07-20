package com.utk.azurecloud.dto;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate birth;
    
    private LocalDate death;
    
    
    private int age;

    private String name;

    @Column(length = 2000)
    private String description;

    @Lob
    private byte[] imageBytes;

    public Image() {
    }
    
    

	public Image(LocalDate birth, LocalDate death, int age, String name, String description,
			byte[] imageBytes) {
		this.birth = birth;
		this.death = death;
		this.age = age;
		this.name = name;
		this.description = description;
		this.imageBytes = imageBytes;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDate getDeath() {
		return death;
	}

	public void setDeath(LocalDate death) {
		this.death = death;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImageBytes() {
		return imageBytes;
	}

	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}

 
    
    
    // Getters and setters
}
