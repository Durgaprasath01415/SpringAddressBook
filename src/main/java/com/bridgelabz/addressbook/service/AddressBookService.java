package com.bridgelabz.addressbook.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbook.dto.PersonDTO;
import com.bridgelabz.addressbook.exception.InvalidContactDetailsException;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.repository.IPersonRepository;
@Service
public class AddressBookService implements IPersonService {
	@Autowired(required=true)
	private IPersonRepository personRepository;
	
	@Autowired
	private ModelMapper modelmapper;
	

	@Override
	public List<Person> getAllContacts() {
		return personRepository.findAll();
	}

	@Override
	public Person getContactById(int id) throws InvalidContactDetailsException {
		return personRepository.findById(id).orElseThrow(() -> new InvalidContactDetailsException("Contact not found"));
	}

	@Override
	public void deletePersonById(int id) throws InvalidContactDetailsException {
		personRepository.findById(id)
				.orElseThrow(() -> new InvalidContactDetailsException("Contact to be Delete Not found"));
		personRepository.deleteById(id);

	}

	@Override
	public Person updatePersonById(int id, PersonDTO personDTO) throws InvalidContactDetailsException {
		Person person = personRepository.findById(id)
				.orElseThrow(() -> new InvalidContactDetailsException("Contact to be Updated Not found"));
		person = new Person(id, personDTO);
		personRepository.save(person);
		return this.getContactById(id);
	}

	@Override
	public Person addPerson(PersonDTO personDTO) throws InvalidContactDetailsException {

		Person person = new Person();
		person.getFirstName();
		Person per = modelmapper.map(personDTO, Person.class);
		System.out.println(person);
		return personRepository.save(per);

	}

	@Override
	public Person getContactByName(String name) throws InvalidContactDetailsException {
		return personRepository.getContactByName(name);

	}

	@Override
	public Person getContactByAddress(String address) throws InvalidContactDetailsException {

		return personRepository.getContactByAddress(address);
	}

	@Override
	public Person getContactByCity(String city) throws InvalidContactDetailsException {
		
		return personRepository.getContactByCity(city);
	}

	@Override
	public Person getContactByState(String state) throws InvalidContactDetailsException {
		return personRepository.getContactByState(state);
	}

	@Override
	public Person getContactByZIPCode(String zipcode) throws InvalidContactDetailsException {
		return personRepository.getContactByZIPCode(zipcode);
	}

	@Override
	public Person getContactByphoneNumber(String phoneNumber) throws InvalidContactDetailsException {
		return personRepository.getContactByphoneNumber(phoneNumber);
	}
	
	
}
