package org.it.discovery.training.hibernate.repository;

import java.util.List;

import org.it.discovery.training.hibernate.model.Person;

public interface PersonRepository {
	
	/**
	 * Returns all the persons that haven't written books
	 * @return
	 */
	List<Person> findPersonWithoutBooks();
	
	/**
	 * Returns author who wrote maximum number of books
	 * @return
	 */
	Person findMostEfficientAuthor();
	
	/**
	 * Returns all the persons which books contain the specified text in
	 * their name
	 * @param name
	 * @return
	 */
	List<Person> findPersonsByBook(String name);
	
	/**
	 * Returns all the persons that have written books prepared by
	 * this publisher
	 * @param number
	 * @return
	 */
	List<Person> findPersonsOfPublisher(int publisherId);
	
	/**
	 * Find persons(limit or less) with maximum number of books 
	 * ordered by number of books)
	 * @param limit
	 * @return
	 */
	List<Person> findTopAuthors(int limit);
	

}
