package com.bridgelabz.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbook.model.Person;

@Repository
public interface IPersonRepository extends JpaRepository<Person, Integer> {

	@Query(value="select * from addressbook where first_name=?1",nativeQuery=true)
	 Person getContactByName(String name);

	@Query(value="select * from addressbook where address=?1",nativeQuery=true)
	Person getContactByAddress(String address);
	
	@Query(value="select * from addressbook where city=?1",nativeQuery=true)
	Person getContactByCity(String city);

	@Query(value="select * from addressbook where state=?1",nativeQuery=true)
	Person getContactByState(String state);

	@Query(value="select * from addressbook where zip_code=?1",nativeQuery=true)
	Person getContactByZIPCode(String zipcode);

	@Query(value="select * from addressbook where phone_number=?1",nativeQuery=true)
	Person getContactByphoneNumber(String phoneNumber);
	
}