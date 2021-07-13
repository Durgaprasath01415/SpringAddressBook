package com.bridgelabz.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbook.dto.PersonDTO;
import com.bridgelabz.addressbook.dto.ResponseDTO;
import com.bridgelabz.addressbook.exception.InvalidContactDetailsException;
import com.bridgelabz.addressbook.model.Person;
import com.bridgelabz.addressbook.service.IPersonService;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	@Autowired(required=true)
	private IPersonService personService;
	
	@GetMapping(value={"/get"})
	public ResponseEntity<ResponseDTO> getAllContacts() {
		List<Person> contactList = personService.getAllContacts();
		ResponseDTO respDTO = new ResponseDTO("List of all Contacts : ", contactList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/getbyId/{id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id) throws InvalidContactDetailsException{
		Person person = personService.getContactById(id);
		ResponseDTO respDTO = new ResponseDTO("Contact id : " + id, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<ResponseDTO>getContactByName(@PathVariable String name) throws InvalidContactDetailsException{
		Person person=personService.getContactByName(name);
		ResponseDTO respDTO = new ResponseDTO("Contact name : " + name, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
		
	}
	@GetMapping("/getbyaddress/{address}")
	public ResponseEntity<ResponseDTO>getContactByAddress(@PathVariable  String address) throws InvalidContactDetailsException {
		Person person=personService.getContactByAddress(address);
		ResponseDTO respDTO = new ResponseDTO("Contact address : " + address, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/getbycity/{city}")
	public ResponseEntity<ResponseDTO> getContactByCity(@PathVariable String city) throws InvalidContactDetailsException{
		Person person=personService.getContactByCity(city);
		ResponseDTO respDTO = new ResponseDTO("Contact city : " + city, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getbystate/{state}")
	public ResponseEntity<ResponseDTO> getContactByState(@PathVariable String state) throws InvalidContactDetailsException{
		Person person=personService.getContactByState(state);
		ResponseDTO respDTO = new ResponseDTO("Contact state : " + state, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getbyzipcode/{zipcode}")
	public ResponseEntity<ResponseDTO> getContactByZIPCode( @PathVariable String zipcode) throws InvalidContactDetailsException{
		Person person=personService.getContactByZIPCode(zipcode);
		ResponseDTO respDTO = new ResponseDTO("Contact zipcode : " + zipcode, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/getbyphonenumber/{phoneNumber}")
	public ResponseEntity<ResponseDTO> getContactByphoneNumber(@PathVariable String phoneNumber) throws InvalidContactDetailsException{
		Person person=personService.getContactByphoneNumber(phoneNumber);
		ResponseDTO respDTO = new ResponseDTO("Contact zipcode : " + phoneNumber, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PostMapping("/addcontact")
	public ResponseEntity<ResponseDTO> addContact( @RequestBody PersonDTO personDTO) throws InvalidContactDetailsException{
		Person person = personService.addPerson(personDTO);
		ResponseDTO respDTO = new ResponseDTO("Contact added with id : " + person.getId(), person);
		
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable int id, @Valid @RequestBody PersonDTO personDTO) throws InvalidContactDetailsException{
		Person person = personService.updatePersonById(id, personDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Contact with id : " + id, person);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteContactById(@PathVariable int id) throws InvalidContactDetailsException{
		personService.deletePersonById(id);
		ResponseDTO respDTO = new ResponseDTO("Deleted Contact with id : ", id);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
