package reportController.providerReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import systemUser.Provider;


/**
 * Produces and complies the data required for a member report
 * @author Philip Thompson
 */
public class ProviderReport {
	
	private String name;
	private String providerNumber;
	private String address;
	private String city;
	private String state;
	private String ZIPCode;
	//parallel arrays for each service provided
	private String[] dateOfService;
	private String[] dateAndTimeRecieved;
	private String[] memberName;
	private String[] memberNumber;
	private String[] serviceCode;
	private double[] fee;
	//totals
	private int totalConsultations;
	private double feeForWeek;
	
	
    
	/**
	 * Constructor: sets attributes of the class
	 * @param servicesForWeek for a provider 
	 */
	public ProviderReport(ArrayList<ServiceProvided> servicesForWeek) {
		Provider temp = servicesForWeek.get(0).getProvider();
		name = temp.getName();
		providerNumber = temp.getProviderNumber();
		address = temp.getStreetAddress();
		city = temp.getCity();
		state = temp.getState();
		ZIPCode = temp.getZIP();
		
		
		
		totalConsultations = servicesForWeek.size();
		dateOfService = new String[totalConsultations];
		dateAndTimeRecieved = new String[totalConsultations];
		memberName = new String[totalConsultations];
		memberNumber = new String[totalConsultations];
		serviceCode = new String[totalConsultations];
		fee = new double[totalConsultations];
		
		feeForWeek = 0;
		ServiceProvided current;
		for(int i = 0; i < totalConsultations; i++) {
			current = servicesForWeek.get(0);
			dateOfService[i] = current.getDate();
			//FIXME: There is currently no dateAndTimeRecieved attribute in ServiceProvided
			dateAndTimeRecieved[i] = "";
			memberName[i] = current.getMember().getName();
			memberNumber[i] = current.getMemberNumber();
			serviceCode[i] = current.getServiceCode();
			fee[i] = current.getServiceFee();
			feeForWeek += fee[i];
		}
		
	}
	
	private void writeMemberNameAndNumber() {
		
	}
	private void writeMemberAddressInfo() {
		
	}
	private void writeServiceDateAndTime() {
		
	}
	private void writeMemberInfo() {
		
	}
	private void writeServiceCode(){
		
	}
	private void writeFeeForService() {
		
	}
	private void writeTotalConsultations() {
		
	}
	private void writeTotalFee() {
		
	}
}
