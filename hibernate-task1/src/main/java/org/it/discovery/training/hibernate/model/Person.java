package org.it.discovery.training.hibernate.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Person who can write books, for example
 * @author admin
 *
 */

@Entity
@Table(name = "PERSON")
@DiscriminatorValue("pe")
public class Person extends BaseEntity {
	private String name;
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}
