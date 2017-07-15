package org.it.discovery.training.hibernate.model;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Person who can write books, for example
 * @author admin
 *
 */

@Entity
@Table(name = "PERSON")
public class Person extends BaseEntity {
	private String name;
	
	/**
	 * Books that person has written
	 */
	private List<Book> books;
	
	
	private Person boss;

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

	@OneToOne(fetch = FetchType.EAGER)
	public Person getBoss() {
		return boss;
	}

	public void setBoss(Person boss) {
		this.boss = boss;
	}

	@Override
	public String toString() {
		return "Person [name=" + name;
	}
	
	

}
