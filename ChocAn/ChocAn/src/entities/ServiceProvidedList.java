package entities;

import java.security.Provider.Service;
import java.util.ArrayList;

/**
 * Encompasses the operations on the list of Services Provided
 * @author Ben Peinhardt
 */
public class ServiceProvidedList {

    // Private Attributes
    private ArrayList<ServiceProvided> serviceProvidedList;
    
    /**
     * Adds a service provided to the list
     * @param service
     * @param provider
     * @param member
     * @param comments
     */
    public void addServiceProvided(ServiceOffered service, Provider provider, Member member, String comments) {

        ServiceProvided newService = new ServiceProvided(service, provider, member, comments);
        this.serviceProvidedList.add(newService);
    }

    /**
     * Deletes a provider from the list
     * @param providerNumber
     */
    public void deleteProvider(String providerNumber) {
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            if (this.serviceProvidedList.get(i).getProviderNumber() == providerNumber) {
                this.serviceProvidedList.remove(i);
            }
        }
    }

    /**
     * Gets the entire service provided list
     * @return ArrayList<ServiceProvided> serviceProvidedList
     */
    public ArrayList<ServiceProvided> getServiceProvidedList() {
    	return this.serviceProvidedList;
    }

    /**
     * Returns an ArrayList of all services provided by a certain provider
     * @param providerNumber
     * @return ArrayList<ServiceProvided> services provided by provider
     */
    public ArrayList<ServiceProvided> getServiceByProvider(String providerNumber) {

        ArrayList<ServiceProvided> servicesByProvider = new ArrayList<ServiceProvided>();
    	for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            if (this.serviceProvidedList.get(i).getProviderNumber() == providerNumber) {
                servicesByProvider.add(this.serviceProvidedList.get(i));
            }
        }

        return servicesByProvider;
    }

    /**
     * Returns an ArrayList of services provided to a certain member 
     * @param memberNumber
     * @return ArrayList<ServiceProvided> services provided to member
     */
    public ArrayList<ServiceProvided> getServiceByMember(String memberNumber) {

        ArrayList<ServiceProvided> servicesProvidedToMember = new ArrayList<ServiceProvided>();
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            if (this.serviceProvidedList.get(i).getMemberNumber() == memberNumber) {
                servicesProvidedToMember.add(this.serviceProvidedList.get(i));
            }
        }

        return servicesProvidedToMember;

    }

    /**
     * Returns an array list of members who have recieved a service this week
     * @return ArrayList<Member> membersWhoRecievedServices
     */
    public ArrayList<Member> getWeeklyMembers() {
    	ArrayList<Member> list = new ArrayList<Member>();
        
        // TODO: Use the Date object to compare today with the date of service
        // Also: What does "this week" mean? Last 7 days? Monday - Friday?
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            
        }

        return list;
    }

    /**
     * Returns an array list of providers who provided a service this week
     * @return ArrayList<Provider> providersWhoGaveServices
     */
    public ArrayList<Provider> getWeeklyProviders() {
        ArrayList<Provider> list = new ArrayList<Provider>();
        
        // TODO: Use the Date object to compare today with the date of service
        // Also: What does "this week" mean? Last 7 days? Monday - Friday?
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            
        }

        return list;
    }
}
