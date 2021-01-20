package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("sqldb")
public class PersonDataAccessService implements PersonDao {

	@Override
	public int insertPerson(UUID id, Person person) {
		return 1;
	}
	
	@Override
	public List<Person> selectAllPeople() {
		return null;
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		return null;
	}

	@Override
	public int deletePersonById(UUID id) {
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person personToUpdate) {
		return 0;
	}
	
}
