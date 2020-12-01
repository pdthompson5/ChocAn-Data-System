package reportController.memberReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;
import systemUser.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Produces and complies the data required for a member report
 * 
 * @author Philip Thompson
 * @author Ben Peinhardt
 */
public class MemberReport {

	// Member attributes
	private String memberName;
	private String memberNumber;
	private String memberStreetAddress;
	private String memberCity;
	private String memberState;
	private String memberZip;

	// Services provided attributes as parallel arrays
	private ArrayList<String> datesOfService = new ArrayList<String>();
	private ArrayList<String> providerNames = new ArrayList<String>();
	private ArrayList<String> serviceNames = new ArrayList<String>();
	public boolean containsServices = false; // default, set to true by constructor

	/**
	 * Constructor: sets attributes of the class
	 * 
	 * @param servicesForWeek for member
	 * @param member to whom services were provided
	 */
	public MemberReport(ArrayList<ServiceProvided> servicesForWeek, Member member) {

		// Set member attributes
		this.memberName = member.getName();
		this.memberNumber = member.getMemberNumber();
		this.memberStreetAddress = member.getStreetAddress();
		this.memberCity = member.getCity();
		this.memberState = member.getState();
		this.memberZip = member.getZIP();

		if (servicesForWeek.size() == 0) {
			return;
		} else {
			this.containsServices = true;
		}

		// Set service provided attributes
		for (int i = 0; i < servicesForWeek.size(); i++) {
			datesOfService.add(servicesForWeek.get(i).getDate());
			providerNames.add(servicesForWeek.get(i).getProvider().getName());
			serviceNames.add(servicesForWeek.get(i).getServiceName());
		}
	}

	/**
	 * Compiles all of the necessary information into a .txt file named "fileName"
	 * 
	 * @param path
	 */
	public void writeToTxtFile(String path) {
		try {
			// Make a file pointer, why is this three statements Java?
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);

			// Print attributes of the member to the file
			pw.println(this.memberName);
			pw.println(this.memberNumber);
			pw.println(this.memberStreetAddress);
			pw.println(this.memberCity);
			pw.println(this.memberState);
			pw.println(this.memberZip);

			// print the services to a file
			for (int i = 0; i < this.datesOfService.size(); i++) {
				pw.println(); // Separates services from member info and each other
				pw.println(this.datesOfService.get(i));
				pw.println(this.providerNames.get(i));
				pw.println(this.serviceNames.get(i));
			}

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to write member report to file.");
		}
	}

}
