package com.project1.visiterManagmentSystem;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "visiter_Table")

public class visiterManagmentSystem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
   @Column(name = "name" ,nullable = false)
   @NotEmpty
   @Size(min = 2,message = "name should have at least 2 characters")
	private String name;
   @NotEmpty
   @Email
	private String email;
//   @NotBlank
//   @Size(min = 10,message ="name should have at least 2 characters")
//   Digits(min=10,max=13,message = "phone no should have at least 10 digit and maximun 13 digit")
//   @Pattern(regexp="(^$|[0-9]{10})")
	private long phone;
   @NotEmpty
	private String address;
   @NotEmpty
	private String gender;
   @NotEmpty
	private String date;
   @NotEmpty
   private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "visiterManagmentSystem id=" + id + "\n name=" + name + "\n email=" + email + "\n phone=" + phone
				+ "\n address=" + address + "\n gender=" + gender + "\n password="+password+"\n date="+date;
	}

}
 