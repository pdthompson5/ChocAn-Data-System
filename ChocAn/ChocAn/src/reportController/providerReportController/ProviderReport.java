package reportController.providerReportController;

import java.util.ArrayList;
import java.util.Date;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import systemUser.Provider;

/**
 * Produces and complies the data required for a member report
 * 
 * @author Philip Thompson
 * @author Ben Peinhardt
 */
public class ProviderReport {

	private String providerName;
	private String providerNumber;
	private String address;
	private String city;
	private String state;
	private String ZIPCode;
	// parallel arrays for each service provided
	private String[] dateOfService;
	private String[] dateAndTimeRecieved;
	private String[] memberName;
	private String[] memberNumber;
	private String[] serviceCode;
	private double[] fee;
	// totals
	private int totalConsultations;
	private double feeForWeek;

	// Used by interface for saving options (Are you sure you want to save an empty
	// report etc.)
	public boolean containsServices = false;

	/**
	 * Constructor: sets attributes of the class
	 * 
	 * @param servicesForWeek for a provider
	 */
	public ProviderReport(ArrayList<ServiceProvided> servicesForWeek, Provider provider) {
		// Set provider information
		this.providerName = provider.getName();
		this.providerNumber = provider.getProviderNumber();
		this.address = provider.getStreetAddress();
		this.city = provider.getCity();
		this.state = provider.getState();
		this.ZIPCode = provider.getZIP();

		// Empty case
		if (servicesForWeek.size() == 0) {
			return;
		} else {
			this.containsServices = true;
		}

		this.totalConsultations = servicesForWeek.size();
		this.dateOfService = new String[totalConsultations];
		this.dateAndTimeRecieved = new String[totalConsultations];
		this.memberName = new String[totalConsultations];
		this.memberNumber = new String[totalConsultations];
		this.serviceCode = new String[totalConsultations];
		this.fee = new double[totalConsultations];

		feeForWeek = 0;
		ServiceProvided current;
		for (int i = 0; i < totalConsultations; i++) {
			current = servicesForWeek.get(0);
			this.dateOfService[i] = current.getDate();
			this.dateAndTimeRecieved[i] = current.getTimeProvided(); // This is a misleading name but we need to change
																		// it everywhere at once. Its the dynamically
																		// generated time and date when the service
																		// record goes into the computer system.
			this.memberName[i] = current.getMember().getName();
			this.memberNumber[i] = current.getMemberNumber();
			this.serviceCode[i] = current.getServiceCode();
			this.fee[i] = current.getServiceFee();
			this.feeForWeek += fee[i];
		}

	}

	/**
	 * It.. writes the report to a txt file... no seriosuly
	 * 
	 * @param path
	 */
	public void writeToTxtFile(String path) {
		try {
			String finalPath = path + providerName + " " + generateDate() + ".txt";

			// Make a file pointer, why is this three statements Java?
			File file = new File(finalPath);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);

			pw.println("Provider Name: " + this.providerName);
			pw.println("Provider Number: " + this.providerNumber);
			pw.println("Provider Street Address: " + this.address);
			pw.println("Provider City: " + this.city);
			pw.println("Provider State: " + this.state);
			pw.println("Provider ZIP: " + this.ZIPCode);
			pw.println("");

			for (int i = 0; i < this.totalConsultations; i++) {
				pw.println("Service " + (i+1));
				pw.println("     Date of Service: " + this.dateOfService[i]);
				pw.println("     Date and Time Recieved: " + this.dateAndTimeRecieved[i]);
				pw.println("     Member Name: " + this.memberName[i]);
				pw.println("     Member Number: " + this.memberNumber[i]);
				pw.println("     Service Code: " + this.serviceCode[i]);
				pw.println("     Service Fee: " + this.fee[i]);
				pw.println("");
			}

			pw.println("Total Consultations: " + this.totalConsultations);
			pw.println("Fee for Week: " + this.feeForWeek);

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to print provider report to file.");
		}
	}

	/**
	 * Uses the Date object to generate a string with the current date
	 * 
	 * @return String serviceDate
	 */
	private String generateDate() {
		Date todaysDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
		return formatter.format(todaysDate);
	}

}
