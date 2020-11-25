package reportController.summaryReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;


public class SummaryReport {
	//parallel arrays for each provider who provided a service
	private ArrayList<String> providersToBePaid;
	private ArrayList<String> providerNums;
	private ArrayList<Double> feesToBePaid;
	private ArrayList<Integer> numberOfConsultations;
	//other vars
	private int numProviders;
	private int totalConsultations;
	private double totalFee;
	
	
    /**
     * Constructor: sets attributes of the class
     * @param servicesForWeek (sorted by providerNum)
     */
	public SummaryReport(ArrayList<ServiceProvided> servicesForWeek) {
		providersToBePaid = new ArrayList<>();
		providerNums = new ArrayList<>();
		feesToBePaid = new ArrayList<>();
		numberOfConsultations = new ArrayList<>();
	
	}
	private void writeProviderName() {
		
	}
	private void writeProviderConsultations() {
		
	}
	private void writeProviderTotalFee() {
		
	}
	private void writeTotalNumberOfProviders() {
		
	}
	private void writeTotalConsultations() {
		
	}
	private void writeTotalFee() {
		
	}
}
