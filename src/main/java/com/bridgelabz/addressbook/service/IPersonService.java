package com.bridgelabz.addressbook.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.PersonDTO;
import com.bridgelabz.addressbook.exception.InvalidContactDetailsException;
import com.bridgelabz.addressbook.model.Person;
@Service
public interface IPersonService {
	public List<Person> getAllContacts();
	public Person addPerson(PersonDTO personDTO) throws InvalidContactDetailsException;
	public Person getContactById(int id) throws InvalidContactDetailsException;
	public Person getContactByName(String name) throws InvalidContactDetailsException;
	public Person getContactByAddress(String address) throws InvalidContactDetailsException;
	public Person getContactByCity(String city) throws InvalidContactDetailsException;
	public Person getContactByState(String state) throws InvalidContactDetailsException;
	public Person getContactByZIPCode(String zipcode) throws InvalidContactDetailsException;
	public Person getContactByphoneNumber(String phoneNumber) throws InvalidContactDetailsException;
	public  void deletePersonById(int id) throws InvalidContactDetailsException;
    public  Person updatePersonById(int id, PersonDTO personDTO) throws InvalidContactDetailsException;
    


}
