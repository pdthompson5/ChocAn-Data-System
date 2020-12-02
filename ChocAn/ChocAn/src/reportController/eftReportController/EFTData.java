package reportController.eftReportController;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import systemUser.Provider;
import service.serviceProvidedPackage.serviceProvidedList.ServiceProvidedList;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;

/**
 * Produces the EFT data file for all of the weekly providers
 * @author Philip Thompson
 *
 */

public class EFTData {
	private String[] providerNames;
	private String[] providerNums;
	private double[] fees;
	int numProviders;

	/**
	 * 
	 * @param servicesForWeek 
	 */
	public EFTData(ServiceProvidedList servicesForWeek, ArrayList<Provider> providersForWeek) {
		numProviders = providersForWeek.size();
		providerNames = new String[numProviders];
		providerNums = new String[numProviders];
		fees = new double[numProviders];
		
		Provider current;
		ArrayList<ServiceProvided> currentServices;
		//for each provider 
		for(int i = 0; i < numProviders; i++) {
			//update current provider 
			current = providersForWeek.get(i);
			//get services for current provider
			currentServices = servicesForWeek.getServiceByProvider(current.getProviderNumber());
			
			providerNames[i] = current.getName();
			providerNums[i] = current.getProviderNumber();
			fees[i] = 0.0;
			//for each service current provided
			for(int j = 0; j < currentServices.size(); j++) {
				fees[i] += currentServices.get(j).getServiceFee();
			}
		}
	}	
	
	
	
	
	public void writeToTxtFile(String path) {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			for(int i = 0; i < numProviders; i++) {
				pw.println(providerNames[i]);
				pw.println(providerNums[i]);
				pw.println(fees[i]);
				pw.println();
			}

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to print summary report to file.");
		}
	}

	
}
