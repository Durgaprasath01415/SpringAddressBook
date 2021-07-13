package com.bridgelabz.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.bridgelabz.addressbook.dto.PersonDTO;

import lombok.Data;
@Entity
@Table(name = "addressbook")

public @Data class Person {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String firstName;
		private String lastName;
		private String address;
		private String city;
		private String state;
		private String zipCode;
		private String phoneNumber;
		public Person() {	
		}

		public Person(int id, PersonDTO personDTO){
			this.id = id;
			this.firstName = personDTO.getFirstName();
			this.lastName = personDTO.getLastName();
			this.address = personDTO.getAddress();
			this.city = personDTO.getCity();
			this.state = personDTO.getState();
			this.zipCode = personDTO.getZipCode();
			this.phoneNumber = personDTO.getPhoneNumber();
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
					+ ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", phoneNumber=" + phoneNumber + "]";
		}
	}

