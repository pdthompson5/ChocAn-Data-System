package reportController.memberReportController;

import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;
import systemUser.Member;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


/**
 * Produces and complies the data required for a member report
 * @author Philip Thompson
 * @author Ben Peinhardt
 */
public class MemberReport {
	
	private Member member;
	private ArrayList<ServiceProvided> servicesProvidedToMember;
    
	/**
	 * Constructor: sets attributes of the class
	 * @param servicesForWeek for member 
	 */
	public MemberReport(ArrayList<ServiceProvided> servicesForWeek) {

		if (servicesForWeek.size() == 0) {
			System.out.println("No services provided to this member.");
			return;
		}

		this.member = servicesForWeek.get(0).getMember();
		this.servicesProvidedToMember = servicesForWeek;
	}
	
	/**
	 * Compiles all of the necessary information into a .txt file named "fileName"
	 * @param path
	 */
	public void writeToTxtFile(String path) {
		try {
			// Make a file pointer, why is this three statements Java?
			File file = new File(path);
	    	FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			// Print attributes of the member to the file
			pw.println(this.member.getName());
			pw.println(this.member.getMemberNumber());
			pw.println(this.member.getStreetAddress());
			pw.println(this.member.getCity());
			pw.println(this.member.getState());
			pw.println(this.member.getState());

			// print the services to a file
			for (int i = 0; i < this.servicesProvidedToMember.size(); i++) {
				pw.println(); // Separates services from member info and each other
				pw.println(this.servicesProvidedToMember.get(i).getDate());
				pw.println(this.servicesProvidedToMember.get(i).getProvider().getName());
				pw.println(this.servicesProvidedToMember.get(i).getServiceName());
			}

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to write member report to file.");
		}
	}

}
