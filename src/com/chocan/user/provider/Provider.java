package com.chocan.user.provider;

import com.chocan.user.systemuser.SystemUser;

public class Provider extends SystemUser {

	private String name;
	private String streetAddress;

	public Provider(String name, String streetAddress, String city, String state, String zip) {
		super(name, streetAddress, city, state, zip);
		
	}

}
