package com.chocan.user.member;

import com.chocan.user.systemuser.SystemUser;

public class Member extends SystemUser {
	private int memberNumber;
	private boolean memberStatus;

	public Member(int memberNumber, boolean memberStatus, String name, String streetAddress, String city, String state, String zip) {
		super(name, streetAddress, city, state, zip);
		this.memberNumber = memberNumber;
		this.memberStatus = memberStatus; // True is a valid member
	}

	// Getters
	public int getMemberNumber() {
		return memberNumber;
	}
	
	public boolean getMemberStatus() {
		return memberStatus;
	}
	
	// Setters	
	public void setMemberStatus(boolean memberStatus) {
		this.memberStatus = memberStatus;
	}

	public void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}
}
