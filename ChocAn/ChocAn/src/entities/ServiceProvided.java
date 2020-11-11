package entities;

public class ServiceProvided extends ServiceOffered {

    // Private attributes
    private String serviceProvidedID;
    private String timeProvided;
    private String date;
    private Provider provider;
    private Member member;
    private ServiceOffered service;
    private String comments; 
    
    public String getTimeProvided() {
    	return timeProvided;
    } 

    public String getDate() {
    	return date;
    }

    public String getProviderNumber() {
    	return provider.getProviderNumber();
    }

    public String getMemberNumber() {	
    	return member.getMemberNumber();
    } 

    public ServiceOffered getService() {
    	return service;
    }

    public String getComments() {
    	return comments;
    }

    public void ServiceProvided(ServiceOffered service, String providerNumber, String memberNumber, String comments) {

    }
}
