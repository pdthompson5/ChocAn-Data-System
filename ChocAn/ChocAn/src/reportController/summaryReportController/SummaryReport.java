package reportController.summaryReportController;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import systemUser.Provider;

import service.serviceProvidedPackage.serviceProvided.ServiceProvided;


public class SummaryReport {
	//parallel arrays for each provider who provided a service
	private ArrayList<String> providersToBePaid = new ArrayList<String>();
	private ArrayList<String> providerNums = new ArrayList<String>();
	private ArrayList<Double> feesToBePaid = new ArrayList<Double>();
	private ArrayList<Integer> numberOfConsultations = new ArrayList<Integer>();
	//other vars
	private int numProviders;
	private int totalConsultations;
	private double totalFee;
	
	
    /**
     * Constructor: sets attributes of the class
     * @param servicesForWeek (sorted by providerNum)
     */
	public SummaryReport(ArrayList<ServiceProvided> servicesForWeek) {
		ServiceProvided currentService;
		String currentProviderNum = "";
		
		totalFee = 0;
		
		//j = iterator for each provider 
		//i = iterator for each serviceProvided 
		int j = -1;
		for(int i = 0; i < servicesForWeek.size(); i++) {
			currentService = servicesForWeek.get(i);
			//if next provider is different -> iterate provider lists (this is why the list needs to be sorted)
			if(!(currentProviderNum.equals(currentService.getProviderNumber()))) {
				currentProviderNum = currentService.getProviderNumber();
				providersToBePaid.add(currentService.getProvider().getName());
				providerNums.add(currentProviderNum);
				feesToBePaid.add(0.0);
				numberOfConsultations.add(0);
				j++;
			}
			//FIXME: Do these lines work? I'm just trying to add the current service fee and iterate consultations
			feesToBePaid.set(j, feesToBePaid.get(j).doubleValue() + currentService.getServiceFee());
			numberOfConsultations.set(j, numberOfConsultations.get(j).intValue() + 1);
			
			totalFee += currentService.getServiceFee();
			
		}
		
		numProviders = j+1;
		totalConsultations = servicesForWeek.size();
		
	
	}
	
	
	
	public void writeToTxtFile(String path) {
		try {
			File file = new File(path);
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(fw);
			
			for (int i = 0; i < this.providersToBePaid.size(); i++) {
				pw.println(this.providersToBePaid.get(i));
				pw.println(this.providerNums.get(i));
				pw.println("$" + this.feesToBePaid.get(i));
				pw.println(this.numberOfConsultations.get(i));
				pw.println("");
			}
			pw.println(this.numProviders);
			pw.println(this.totalConsultations);
			pw.println("$" + this.totalFee);

			pw.close();

		} catch (Exception e) {
			System.out.println("Unable to print summary report to file.");
		}
	}
	
	
	
	
}
