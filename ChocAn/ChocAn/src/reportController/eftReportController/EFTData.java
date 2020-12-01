package reportController.eftReportController;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;

/**
 * Produces the EFT data file for a provider for the week
 * @author thomp
 *
 */

public class EFTData {
	private String providerName;
	private String providerNumber;
	private double fee;

	public EFTData(ArrayList<ServiceProvided> servicesForWeek) {
		providerName = servicesForWeek.get(0).getProvider().getName();
		providerNumber = servicesForWeek.get(0).getProvider().getProviderNumber();
		fee = 0.0;
		for(int i = 0; i < servicesForWeek.size(); i++) {
			fee += servicesForWeek.get(i).getServiceFee();
		}
	}
	
	
	
	
	public void writeToTxtFile(String path) {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(providerName);
			pw.println(providerNumber);
			pw.println(fee);

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to print summary report to file.");
		}
	}

	
}
