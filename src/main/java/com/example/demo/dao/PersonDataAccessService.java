package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Person;

@Repository("sqldb")
public class PersonDataAccessService implements PersonDao {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public PersonDataAccessService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int insertPerson(UUID id, Person person) {
		return 1;
	}
	
	@Override
	public List<Person> selectAllPeople() {
		String sqlStatement = "SELECT id, name FROM person";
		return jdbcTemplate.query(sqlStatement, (resultSet, i) -> {
			UUID id = UUID.fromString(resultSet.getString("id"));
			String name = resultSet.getString("name");
			return new Person(id, name);
		});
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		String sqlStatement = "SELECT id, name FROM person WHERE id = ?";
		Person person = jdbcTemplate.queryForObject(
				sqlStatement,
				new Object[] {id},
				(resultSet, i) -> {
					final UUID personId = UUID.fromString(resultSet.getString("id"));
					final String name = resultSet.getString("name");
					return new Person(personId, name);
				});
		return Optional.ofNullable(person);
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
