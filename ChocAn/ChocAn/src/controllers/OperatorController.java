package controllers;

import java.io.IOException;

import entities.MemberList;
import entities.ProviderList;

/**
 * Controller for operators to manage member and provider data
 * @author Griffin Mack
 */
public class OperatorController {

    // Private attributes
	MemberList memberList = new MemberList();
	ProviderList providerList = new ProviderList();

	public void addNewMember(String memberName, String memberStreetAddress, String memberCity, String memberState,
			String memberZip) {
		String memberNumber = null;  //TODO create a unique memberNumber
		boolean memberStatus = true; // Members are valid when added to the system
		memberList.createMember(memberName, memberStreetAddress, memberCity, memberState, memberZip, memberNumber, memberStatus);
	}

	public void addNewProvider(String providerName, String providerStreetAddress, String providerCity,
			String providerState, String providerZip) {
		String providerNumber = null;  //TODO create a unique providerNumber
		providerList.createProvider(providerName, providerStreetAddress, providerCity, providerState, providerZip, providerNumber);
	}
    
}
