package entities;

import java.util.Date;

/**
 * Encompasses a service provided to a customer 
 */
public class ServiceProvided extends ServiceOffered {

    // Private attributes
    private String serviceProvidedID;
    private String timeProvided;
    private String date;
    private Provider provider;
    private Member member;
    private ServiceOffered service;
    private String comments; 

    /**
     * Constructor: sets attributes of the class
     * @param service
     * @param providerNumber
     * @param memberNumber
     * @param comments
     */
    public void ServiceProvided(ServiceOffered service, Provider provider, Member member, String comments) {
        this.service = service;
        this.serviceProvidedID = service.getServiceCode();
        this.comments = comments;
        this.member = member;
        this.provider = provider;

        // TODO: Use imported Date object to set serviceProvidedID and timeProvided
    }
    
    /**
     * Gets the time a service was provided
     * @return String timeProvided
     */
    public String getTimeProvided() {
    	return timeProvided;
    } 

    /**
     * Gets the date a service was provided
     * @return String date
     */
    public String getDate() {
    	return date;
    }

    /**
     * Gets the provider number of the provider who provided the service
     * @return String providerNumber
     */
    public String getProviderNumber() {
    	return provider.getProviderNumber();
    }

    /**
     * Gets the member number of the member who recieved the service
     * @return String memberNumber
     */
    public String getMemberNumber() {	
    	return member.getMemberNumber();
    } 

    /**
     * Gets the entire service object for the type of service provided
     * @return String service
     */
    public ServiceOffered getService() {
    	return service;
    }

    /**
     * Gets the comments from the service provided
     * @return String comments
     */
    public String getComments() {
    	return comments;
    }
}
