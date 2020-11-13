package service.serviceOffered.providerDirectory;

import java.util.ArrayList;

import service.serviceOffered.serviceOffered.ServiceOffered;

import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Encompasses Provider Directory, which is actually a list of Services Offered
 * @author Ben Peinhardt
 */
public class ProviderDirectory {
    
    // Private attributes
    private ArrayList<ServiceOffered> providerDirectory = new ArrayList<ServiceOffered>();
    private String path = "providerDirectory.csv";

    /**
     * Constructor, builds Provider Directory from CSV of services
     */
    public ProviderDirectory() {
        try {
			BufferedReader br = new BufferedReader(new FileReader(this.path));
			String line;
			while ((line = br.readLine()) != null) {
			    String[] values = line.split(",");
                ServiceOffered tempService = buildServiceOfferedFromCSV(values);
                this.providerDirectory.add(tempService);	
			}
        br.close();

    	} catch (Exception e) {
           System.out.println("Unable to read services provided from services provided file");
    	}
    }

    /**
     * Helper for constructor, makes ServiceOffered object from array of values
     * @param values
     * @return ServiceOffered myServiceOffered
     */
    private ServiceOffered buildServiceOfferedFromCSV(String[] values) {
        ServiceOffered myServiceOffered = new ServiceOffered();
        myServiceOffered.setServiceName(values[0]);
        myServiceOffered.setServiceCode(values[1]);
        myServiceOffered.setServiceFee(Double.parseDouble(values[2]));
        return myServiceOffered;
    }

    /**
     * Gets the entire provider directory
     * @return ArrayList<ServiceOffered> providerDirectory
     */
    public ArrayList<ServiceOffered> getProviderDirectory() {
    	return this.providerDirectory;
    }

    /**
     * Returns an entire Service Offered structure based on service name
     * @param serviceName
     * @return ServiceOffered service
     */
    public ServiceOffered getServiceByName(String serviceName) {
    	for (int i = 0; i < this.providerDirectory.size(); i++) {
            if (this.providerDirectory.get(i).getServiceName().equals(serviceName)) {
                return this.providerDirectory.get(i);
            }
        }

        // Service Not found
        ServiceOffered temp = new ServiceOffered();
        return temp;
    }

    /**
     * Gets service from list by service code
     * @param serviceCode
     * @return
     */
    public ServiceOffered getServiceByCode(String serviceCode) {
        for (int i = 0; i < this.providerDirectory.size(); i++) {
            if (this.providerDirectory.get(i).getServiceCode().equals(serviceCode)) {
                return this.providerDirectory.get(i);
            }
        }

        // Service not found
        ServiceOffered temp = new ServiceOffered();
        return temp;
    }
}
