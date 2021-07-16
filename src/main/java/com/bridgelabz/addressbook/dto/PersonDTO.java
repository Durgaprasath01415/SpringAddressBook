package com.bridgelabz.addressbook.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;
@Data
public class PersonDTO {
	
	@NotNull
	@Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$" , message = "First name should contain atleast 3 characters with first character upper case")
	private String firstName;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-z]{2,}$" , message = "Last name should contain atleast 3 characters with first character upper case")
	private String lastName;
	@NotNull
	private String address;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	@Pattern(regexp = "[0-9]{6}", message = "Invalid Zip Code")
	private String zipCode;
	@NotNull
	@Pattern(regexp = "^[1-9]{1}[0-9]{9}$", message = "Invalid Phone Number")
	private String phoneNumber;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
