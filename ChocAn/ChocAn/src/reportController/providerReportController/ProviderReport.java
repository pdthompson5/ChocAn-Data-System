package reportController.providerReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import systemUser.Provider;

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
	
	
    
	
	public ProviderReport(ArrayList<ServiceProvided> servicesForWeek) {
		
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
