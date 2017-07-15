package org.it.discovery.training.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

/**
 * Book in a library
 * @author morenets
 *
 */

@Entity
@Table(name = "BOOK")
@NamedQueries({
	@NamedQuery(name = Book.QUERY_FIND_ALL, query = "from Book"),
	@NamedQuery(name = Book.QUERY_FIND_ALL_WITH_NAME, query = "from Book where name=:name")
})
public class Book extends BaseEntity {
	
	public static final String QUERY_FIND_ALL = "Books.findAll";
	
	public static final String QUERY_FIND_ALL_WITH_NAME = "Books.findByName";
	
	private String name;
	
	private Person author;
	
	private Publisher publisher;
	
	/**
	 * Publishing year
	 */
	private int year;
	
	/**
	 * Total number of pages
	 */
	private int pages;
	
	private List<Hit> hits;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	public Person getAuthor() {
		return author;
	}

	public void setAuthor(Person author) {
		this.author = author;
	}

	@ManyToOne
	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "book")
	@BatchSize(size = 20)
	public List<Hit> getHits() {
		return hits;
	}

	public void setHits(List<Hit> hits) {
		this.hits = hits;
	}
	
	public void addHit(Hit hit) {
		if(hits == null) {
			this.hits = new ArrayList<>();
		}
		this.hits.add(hit);
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", publisher=" + publisher + ", year=" + year + ", pages="
				+ pages + "]";
	}
	
	
}
