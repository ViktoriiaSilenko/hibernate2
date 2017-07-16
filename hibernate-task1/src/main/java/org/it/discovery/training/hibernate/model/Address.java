package org.it.discovery.training.hibernate.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	
	private String street;
	
	private String zipCode;
	
	private String apt;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", zipCode=" + zipCode + ", apt=" + apt + "]";
	}
	

	

}
