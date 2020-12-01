package operator;

import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

/**
 * Controller for operators to manage member and provider data
 * 
 * @author Griffin Mack
 * @author Ben Peinhardt
 */
public class OperatorController {

	// Private attributes
	protected MemberList memberList = new MemberList();
	private ProviderList providerList = new ProviderList();

	public void addNewMember(String memberName, String memberStreetAddress, String memberCity, String memberState,
			String memberZip) {
		String memberNumber = createUniqueMemberNumber();
		boolean memberStatus = true; // Members are valid when added to the system
		this.memberList.createMember(memberName, memberStreetAddress, memberCity, memberState, memberZip, memberNumber,
				memberStatus);
	}

	public void addNewProvider(String providerName, String providerStreetAddress, String providerCity,
			String providerState, String providerZip) {
		String providerNumber = createUniqueProviderNumber();
		this.providerList.createProvider(providerName, providerStreetAddress, providerCity, providerState, providerZip,
				providerNumber);
	}

	/**
	 * Returns a Member object from the member list by ID
	 * 
	 * @param memberNumber
	 * @return Member member
	 */
	public Member getMember(String memberNumber) {
		Member tempMember = memberList.getMember(memberNumber);
		return tempMember;
	}

	/**
	 * Returns a provider object from the provider list by ID
	 * 
	 * @param providerNumber
	 * @return
	 */
	public Provider getProvider(String providerNumber) {
		Provider tempProvider = providerList.getProvider(providerNumber);
		return tempProvider;
	}

	/**
	 * Creates a unique member ID by adding one to the previous member ID
	 * 
	 * @return String memberID
	 */
	public String createUniqueMemberNumber() {
		if (this.memberList.getMemberList().size() == 0) {
			return "100000000";
		} else {
			String number = this.memberList.getMemberList().get(this.memberList.getMemberList().size() - 1)
					.getMemberNumber();
			Integer num = Integer.parseInt(number);
			num++;
			return Integer.toString(num);
		}
	}

	/**
	 * Creates unique provider ID by adding one to the previous provider ID
	 * 
	 * @return String providerID
	 */
	public String createUniqueProviderNumber() {
		if (this.providerList.getProviderList().size() == 0) {
			return "100000000";
		} else {
			String number = this.providerList.getProviderList().get(this.providerList.getProviderList().size() - 1)
					.getProviderNumber();
			Integer num = Integer.parseInt(number);
			num++;
			return Integer.toString(num);
		}
	}

	/**
	 * Removes a member from the member list by memberNumber
	 */
	public void deleteMember(String memberNumber) {
		this.memberList.deleteMember(memberNumber);
	}

	/**
	 * Removes a provider from providerList by providerNumber
	 * 
	 * @param providerNumber
	 */
	public void deleteProvider(String providerNumber) {
		this.providerList.deleteProvider(providerNumber);
	}

	/**
	 * Updates a member in member list by member number
	 */
	public void updateMember(String memberNumber, String memberName, String memberStreetAddress, String memberCity,
			String memberState, String memberZip) {
		Member memberToUpdate = this.memberList.getMember(memberNumber);

		memberToUpdate.setName(memberName);
		memberToUpdate.setStreetAddress(memberStreetAddress);
		memberToUpdate.setCity(memberCity);
		memberToUpdate.setState(memberState);
		memberToUpdate.setZIP(memberZip);

		this.memberList.persist();
	}

	// /**
	// * Updates a members status using member number
	// * @param memberNumber
	// * @param status
	// */
	// public void updateMemberStatus(String memberNumber, boolean status) {
	// Member memberToUpdate = this.memberList.getMember(memberNumber);
	// memberToUpdate.setMemberStatus(status);
	// }

	/**
	 * Updates a provider in provider list by providerNumber
	 */
	public void updateProvider(String providerNumber, String providerName, String providerStreetAddress,
			String providerCity, String providerState, String providerZip) {
		Provider providerToUpdate = this.providerList.getProvider(providerNumber);

		providerToUpdate.setName(providerName);
		providerToUpdate.setStreetAddress(providerStreetAddress);
		providerToUpdate.setCity(providerCity);
		providerToUpdate.setState(providerState);
		providerToUpdate.setZIP(providerZip);

		this.providerList.persist();
	}

}
