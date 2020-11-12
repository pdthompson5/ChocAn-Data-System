package controllers;

import java.io.IOException;

import entities.MemberList;

public class OperatorController {

	public void addNewMember(String memberName, String memberStreetAddress, String memberCity, String memberState,
			String memberZip) {
		
		MemberList memberList = new MemberList();
		memberList.createMember(memberName, memberStreetAddress, memberCity, memberState, memberZip);
		
	}

	public void addNewProvider(String providerName, String providerStreetAddress, String providerCity,
			String providerState, String providerZip) {
		// TODO Auto-generated method stub
		
	}
    
}
