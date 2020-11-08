package com.chocan.user.provider;

import com.chocan.user.systemuser.SystemUser;

public class Provider extends SystemUser {
	private String providerNumber;

	public Provider(String providerNumber, String name, String streetAddress, String city, String state, String zip) {
		super(name, streetAddress, city, state, zip);
		this.providerNumber = providerNumber;
	}

	// Getters
	public String getProviderNumber() {
		return providerNumber;
	}
	
	// Setters
	public void setProviderNumber(String providerNumber) {
		this.providerNumber = providerNumber;
	}
}
