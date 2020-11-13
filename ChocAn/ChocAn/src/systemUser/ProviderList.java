package systemUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Encompasses operations on the list of providers
 * @author Ben Peinhardt, Griffin Mack
 */
public class ProviderList {

    // Private attributes
    private ArrayList<Provider> providerList = new ArrayList<Provider>();
    private String path = "providers.csv";

    /**
     * Constructor for provider list, fills the list from providers.csv
     */
    public ProviderList() {
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
			    String[] values = line.split(",");
			    Provider newProvider = new Provider();
                newProvider.setName(values[0]);
                newProvider.setStreetAddress(values[1]);
                newProvider.setCity(values[2]);
                newProvider.setState(values[3]);
                newProvider.setZIP(values[4]);
	            newProvider.setProviderNumber(values[5]);
                this.providerList.add(newProvider);			
			}
            br.close();

    	} catch (Exception e) {
           System.out.println("Unable to read provider from provider file");
    	}
    }

    /**
     * Returns the entire provider list
     * @return ArrayList<Provider> providerList
     */
    public ArrayList<Provider> getProviderList() {
        return providerList;
    }

    /**
     * Searches the list of providers and returns provider object
     */
    public Provider getProvider(String providerNumber) {
    	for (int i = 0; i < this.providerList.size(); i++) {
            if (this.providerList.get(i).getProviderNumber().equals(providerNumber)) {
                return this.providerList.get(i);
            }
        }

        // Provider not found
        Provider nullProvider = new Provider();
        return nullProvider;
    }

    /**
     * Adds a provider to the list
     * @param name
     * @param streetAddress
     * @param city
     * @param state
     * @param ZIP
     */
    public void createProvider(String name, String streetAddress, String city, String state, String ZIP, String providerNumber) {
       
        Provider newProvider = new Provider();
        newProvider.setName(name);
        newProvider.setStreetAddress(streetAddress);
        newProvider.setCity(city);
        newProvider.setState(state);
        newProvider.setZIP(ZIP);
	    newProvider.setProviderNumber(providerNumber);
        this.providerList.add(newProvider);
        
        // Update JSON
        persist();
    }

    /**
     * Finds provider in list and deletes
     * @param providerNumber
     */
    public void deleteProvider(String providerNumber) {
        for (int i = 0; i < this.providerList.size(); i++) {
            if (this.providerList.get(i).getProviderNumber().equals(providerNumber)) {
                this.providerList.remove(i);
            }
        }
        
        // Updates JSON
        persist();
    }

    /**
     * Persists the entire provider list to the providers.csv. Called whenever provider is added, deleted, or updated
     */
    private void persist() {
        try {
            File file = new File(this.path);
	        FileWriter fw = new FileWriter(file);
	        PrintWriter pw = new PrintWriter(fw);

	        for (int i = 0; i < this.providerList.size(); i++) {
	            pw.print(this.providerList.get(i).writeProviderToCSV());
	            if (i != this.providerList.size() - 1) {
	                pw.println(" ");
	            }
	        }
	        pw.close();
        } catch(Exception e) {
            System.out.println("Unable to persist provider information!");
        }
    }
}
