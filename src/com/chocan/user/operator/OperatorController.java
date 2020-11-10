package com.chocan.user.operator;

import com.chocan.user.member.MemberDataController;
import com.chocan.user.provider.ProviderDataController;

public class OperatorController {
	private int uniqueMemberNumber = 0;  // TODO This value needs to be persistent
	private int uniqueProviderNumber = 0;  // TODO This value needs to be persistent
	private static MemberDataController memberDataController = new MemberDataController();
	private static ProviderDataController providerDataController = new ProviderDataController();
	
	public void addNewMember(String memberName, String memberStreetAddress, String memberCity, String memberState,
			String memberZip) {
		//generate a unique member number
		int memberNumber = createUniqueMemberNumber();
		
		memberDataController.addNewMember(memberNumber, memberName, memberStreetAddress, memberCity, memberState, memberZip);
		
	}

	public void addNewProvider(String providerName, String providerStreetAddress, String providerCity,
			String providerState, String providerZip) {
		//generate a unique member number
		int providerNumber = createUniqueProviderNumber();

		providerDataController.addNewMember(providerNumber, providerName, providerStreetAddress, providerCity, providerState, providerZip);
		
	}

	private int createUniqueMemberNumber() {
		return uniqueMemberNumber++;
	}

	private int createUniqueProviderNumber() {
		return uniqueProviderNumber++;
	}

}
