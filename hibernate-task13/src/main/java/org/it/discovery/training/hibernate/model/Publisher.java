package org.it.discovery.training.hibernate.model;

import java.util.List;

/**
 * Book publisher
 * @author morenets
 *
 */
public class Publisher extends BaseEntity{
	private String name;
	
	private List<Book> books;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}
