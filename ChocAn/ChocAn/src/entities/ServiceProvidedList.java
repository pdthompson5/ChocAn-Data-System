package entities;

import java.util.ArrayList;

public class ServiceProvidedList {

    private ArrayList<ServiceProvided> serviceProvidedList;
    
    public void addServiceProvided(ServiceOffered service, Provider provider, Member member, String comments) {
    	
    }

    public void deleteProvider(String providerNumber) {

    }

    public ArrayList<ServiceProvided> getServiceProvidedList() {
    	return serviceProvidedList;
    }

    public ArrayList<ServiceProvided> getServiceByProvider(String providerNumber) {
    	return serviceProvidedList;
    }

    public ArrayList<ServiceProvided> getServiceByMember(String memberNumber) {
    	return serviceProvidedList;
    }

    public Member[] getWeeklyMembers() {
    	Member[] list = new Member[20];
    	return list;
    }

    public Provider[] getWeeklyProviders() {
    	Provider[] list = new Provider[20];
    	return list;
    }
}
