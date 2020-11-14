package provider;


import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;
import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

public class ProviderController {

	private MemberList memberList = new MemberList();
	
	/**
	 * @param memberNumber
	 * sees if member is in the file
	 * @return boolean verifyMemberExists
	 */
	public boolean verifyMemberExists(String memberNumber) {
		Member member = this.memberList.getMember(memberNumber);
		if(!(member.getName().equals("notMember"))){
			return true;
		}
		else {
			return false;
		}
	}

	
	/**
	 * @param memberNumber
	 * sees if member is valid
	 * @return boolean verifyMemberStatus
	 */
	public boolean verifyMemberStatus(String memberNumber) {
		Member member = this.memberList.getMember(memberNumber);
		if(member.getMemberStatus() == (true)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String lookupServiceByCode(String serviceCode) {
		// TODO Auto-generated method stub
		return "test_service";
	}

	/**
	 * Creates a service provided object and adds it to the ServiceProvidedList
	 * @param providerNumber
	 * @param memberNumber
	 * @param serviceDate
	 * @param serviceCode
	 * @param serviceComments
	 */
	public void billChocan(String providerNumber, String memberNumber, String serviceDate, String serviceCode,
			String serviceComments) {

		ServiceOffered myService = new ServiceOffered();
		Member myMember = new Member();
		Provider myProvider = new Provider();
		
		// Find Service
		ProviderDirectory myDirectory = new ProviderDirectory();
		myService = myDirectory.getServiceByCode(serviceCode);

		// Find Member
		MemberList myMemberList = new MemberList();
		myMember = myMemberList.getMember(memberNumber);

		// Find Provider
		ProviderList myProviderList = new ProviderList();
		myProvider = myProviderList.getProvider(providerNumber);

		// Add Service Provided
		ServiceProvidedList myServiceProvidedList = new ServiceProvidedList();
		myServiceProvidedList.addServiceProvided(myService, myProvider, myMember, serviceComments);
		
	}
    
}
