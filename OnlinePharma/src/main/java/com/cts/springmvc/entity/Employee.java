package com.cts.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

//pojo class can also be called as Entity class
@Entity
@Table(name = "newemployee")//mysql table
public class Employee
{


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty(message = "Please enter username")
	@Column
	private String username;
	

	@NotEmpty(message = "Please enter password")
	@Column
	private String password;
	@Size(max = 20, min = 3, message = "Name length must be between {2} and {1} characters")

	@NotEmpty(message = "Please enter Empname")
	@Column
	private String name;
	

	@NotEmpty(message = "Please enter valid email")
	@Column
	private String email;
	
	@Min(value=21, message="Age Must be equal or greater than 21")  
	@Column
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
