package service.serviceOffered.serviceOffered;

/**
 * Encompasses the attributes of a service offered
 * @author Ben Peinhardt
 */
public class ServiceOffered {

    // Private attributes
    protected String serviceName;
    protected String serviceCode;
    protected double serviceFee;

    /**
     * Gets the Service Name 
     * @return String serviceName
     */
    public String getServiceName() {
    	return serviceName;
    }

    /**
     * Gets the service code
     * @return String serviceCode
     */
    public String getServiceCode() {
    	return serviceCode;
    }

    /**
     * gets the service fee
     * @return double serviceFee
     */
    public double getServiceFee() {
    	return serviceFee;
    }

    /**
     * Sets service name
     * @param serviceName
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Set service code
     * @param serviceCode
     */
    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * Sets the service fee
     * @param serviceFee
     */
    public void setServiceFee(double serviceFee) {
        this.serviceFee = serviceFee;
    }
    
}
