package com.chocan.user.systemuser;

public class SystemUser {
	
	private String name;
	private String streetAddress;
	private String city;
	private String state;
	private String zip;
	
	public SystemUser(String name, String streetAddress, String city, String state, String zip) {
		this.name = name;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	// Getters
	public String getName() {
		return name;
	}
	
	public String getStreetAddress() {
		return streetAddress;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	//Setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void setZip(String zip) {
		this.zip = zip;
	}
	
}
