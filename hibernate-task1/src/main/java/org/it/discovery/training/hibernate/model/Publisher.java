package org.it.discovery.training.hibernate.model;

import java.util.List;


import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Book publisher
 * @author morenets
 *
 */

@Entity
@Table(name = "PUBLISHER")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Publisher extends BaseEntity{
	private String name; 
	
	private List<Book> books;
	
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "publisher")
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Embedded
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Publisher [name=" + name + "]";
	}
	
	
	

}
