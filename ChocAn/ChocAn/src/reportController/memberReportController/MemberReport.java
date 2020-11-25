package reportController.memberReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import systemUser.Member;

public class MemberReport {
	
	private String memberName;
	private String memberNumber;
	private String memberAddress;
	//parallel arrays for each service
	private String[] serviceDate;
	private String[] providerName;
	private String[] serviceName;
    
	//Fills out all of the attributes 
	public MemberReport(ArrayList<ServiceProvided> servicesForWeek) {
		Member temp = servicesForWeek.get(0).getMember();
		memberName = temp.getName();
		memberNumber = temp.getMemberNumber();
		memberAddress = temp.getStreetAddress();
		
		int size = servicesForWeek.size();
		serviceDate = new String[size];
		providerName = new String[size];
		serviceName = new String[size];
		
		ServiceProvided current;
		for(int i = 0; i < size; i++) {
			current = servicesForWeek.get(i);
			serviceDate[i] = current.getDate();
			providerName[i] = current.getProvider().getName();
			serviceName[i] = current.getServiceName();
		}	
	}
	
	
	
    private void writeMemberNameAndNumber() {

    }

    private void writeMemberAddressInfo() {

    }

    private void writeServiceDate() {

    }

    private void writeProviderName() {

    }

    private void writeServiceName() {

    }
}
