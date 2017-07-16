package org.it.discovery.training.hibernate.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HIT")
public class Hit extends BaseEntity{
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;
	
	private Book book;
	
	public Hit() {
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public LocalDateTime getViewed() {
		return viewed;
	}

	public void setViewed(LocalDateTime viewed) {
		this.viewed = viewed;
	}
	
	@ManyToOne
	public Book getBook() {
		return this.book;
		
	}
	
	public void setBook(Book book) {
		this.book = book;
	}


}
