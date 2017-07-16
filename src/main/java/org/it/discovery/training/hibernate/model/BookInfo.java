package org.it.discovery.training.hibernate.model;

public class BookInfo {
	
	private int id;
	private String name;
	
	
	
	public BookInfo(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Tuple [id=" + id + ", name=" + name + "]";
	}
	
	
}
