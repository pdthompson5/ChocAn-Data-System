package service.serviceProvidedPackage.serviceProvided;

import java.util.Date;

import service.serviceOffered.serviceOffered.ServiceOffered;
import systemUser.Member;
import systemUser.Provider;

/**
 * Encompasses a service provided to a customer
 * @author Ben Peinhardt
 * @author Topher Fryzel
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
    public ServiceProvided(ServiceOffered service, Provider provider, Member member, String comments, String serviceDate, String serviceTime, String serviceProvidedID) {
        this.service = service;
        this.comments = comments;
        this.member = member;
        this.provider = provider;
        this.date = serviceDate;
        this.timeProvided = serviceTime;
        this.serviceProvidedID = serviceProvidedID;
    }

    /**
     * Gets the service provided ID
     * @return String ID
     */
    public String getServiceProvidedID() {
        return this.serviceProvidedID;
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

    /**
     * Gets the member the service was provided to
     * @return Member member
     */
    public Member getMember() {
        return this.member;
    }

    /**
     * Gets the provider who provided the service
     * @return Provider provider
     */
    public Provider getProvider() {
        return this.provider;
    }

    /**
     * Helper function for persistance, writes ServiceProvided information to line of comma separated strings
     * @return String serviceProvidedAsCSV
     */
    public String writeServiceProvidedToCSV() {
        String serviceProvidedAsCSV = String.format("%s,%s,%s,%s,%s,%s,%s", this.serviceProvidedID, this.timeProvided, this.date, this.provider.getProviderNumber(), this.member.getMemberNumber(), this.service.getServiceCode(), this.comments); 
        
        return serviceProvidedAsCSV;
    }
}
