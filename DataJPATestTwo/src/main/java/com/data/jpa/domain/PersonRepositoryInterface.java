package com.data.jpa.domain;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepositoryInterface extends CrudRepository<Person, Long> {

	public Person findById(long id);

	Iterable<Person> findByLastName(String lastName);

}
