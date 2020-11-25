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
		this.name = temp.getName();
		this.providerNumber = temp.getProviderNumber();
		this.address = temp.getStreetAddress();
		this.city = temp.getCity();
		this.state = temp.getState();
		this.ZIPCode = temp.getZIP();
		
		
		
		this.totalConsultations = servicesForWeek.size();
		this.dateOfService = new String[totalConsultations];
		this.dateAndTimeRecieved = new String[totalConsultations];
		this.memberName = new String[totalConsultations];
		this.memberNumber = new String[totalConsultations];
		this.serviceCode = new String[totalConsultations];
		this.fee = new double[totalConsultations];
		
		feeForWeek = 0;
		ServiceProvided current;
		for(int i = 0; i < totalConsultations; i++) {
			current = servicesForWeek.get(0);
			this.dateOfService[i] = current.getDate();
			//FIXME: There is currently no dateAndTimeRecieved attribute in ServiceProvided
			this.dateAndTimeRecieved[i] = "";
			this.memberName[i] = current.getMember().getName();
			this.memberNumber[i] = current.getMemberNumber();
			this.serviceCode[i] = current.getServiceCode();
			this.fee[i] = current.getServiceFee();
			this.feeForWeek += fee[i];
		}
		
	}
	
	
	
	
	
	
}
