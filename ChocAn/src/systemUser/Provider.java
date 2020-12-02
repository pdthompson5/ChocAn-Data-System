package systemUser;

import java.util.ArrayList;

import service.serviceOffered.serviceOffered.ServiceOffered;

/**
 * Encompasses extra functionality of Provider (providerNumber, listOfServices, numberOfConsultations, totalFee)
 * @author Ben Peinhardt
 */
public class Provider extends SystemUser {
    
    // Private attributes
    private String providerNumber;
    
    // TODO None of these variables seem useful
    private ArrayList<ServiceOffered> listOfServices;
    private int numberOfConsultations;
    private double totalFee;
    
    /**
     * Gets provider number
     * @return String providerNumber
     */
    public String getProviderNumber() {
        return this.providerNumber;
    }

    /**
     * Gets list of services
     * @return ArrayList<ServiceOffered> listOfServices
     */
    public ArrayList<ServiceOffered> getListOfServices() {
        return this.listOfServices;
    }

    /**
     * Gets number of consultations
     * @return int numConsultations
     */
    public int getNumberOfConsultations() {
        return this.numberOfConsultations;
    }

    /**
     * Gets the total fee
     * @return double totalFee
     */
    public double getTotalFee() {
        return this.totalFee;
    }

    /**
     * Sets provider number
     * @param providerNumber
     */
    public void setProviderNumber(String providerNumber) {
        this.providerNumber = providerNumber;
    }

    /**
     * Sets list of services offered
     * @param listOfServicesOffered
     */
    public void setListOfServices(ArrayList<ServiceOffered> listOfServicesOffered) {
        this.listOfServices = listOfServicesOffered;
    }

    /**
     * Sets number of consultations
     * @param numberOfConsultations
     */
    public void setNumberOfConsultations(int numberOfConsultations) {
        this.numberOfConsultations = numberOfConsultations;
    }

    /**
     * Sets total fee
     * @param totalFee
     */
    public void setTotalFee(double totalFee) {
        this.totalFee = totalFee;
    }
    
    /**
     * Returns the appropriate string to be written to the CSV file for persiting data
     * @return String providerAsCSV
     */
    public String writeProviderToCSV() {
        String providerAsCSV = String.format("%s,%s,%s,%s,%s,%s", this.getName(), this.getStreetAddress(), this.getCity(), this.getState(), this.getZIP(), this.getProviderNumber()); 
        
        return providerAsCSV;
    }
}
