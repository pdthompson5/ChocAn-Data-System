package entities;

/**
 * Encompasses extra functionality of Provider (providerNumber, listOfServices, numberOfConsultations, totalFee)
 */
public class Provider extends SystemUser {
    
    // Private attributes
    private String providerNumber;
    private ServiceOffered[] listOfServices;
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
     * @return ServiceOffered[] listOfServices
     */
    public ServiceOffered[] getListOfServices() {
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
    public void setListOfServices(ServiceOffered[] listOfServicesOffered) {
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
}
