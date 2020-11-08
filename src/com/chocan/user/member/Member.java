package com.chocan.user.member;

import com.chocan.user.systemuser.SystemUser;

public class Member extends SystemUser {
	private String memberNumber;
	private boolean memberStatus;

	public Member(String memberNumber, boolean memberStatus, String name, String streetAddress, String city, String state, String zip) {
		super(name, streetAddress, city, state, zip);
		this.memberNumber = memberNumber;
		this.memberStatus = memberStatus; // True is a valid member
	}

	// Getters
	public String getMemberNumber() {
		return memberNumber;
	}
	
	public boolean getMemberStatus() {
		return memberStatus;
	}
	
	// Setters	
	public void setMemberStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	public void setMemberNumber(String memberNumber) {
		this.memberNumber = memberNumber;
	}
}
