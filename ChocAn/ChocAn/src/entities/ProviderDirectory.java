package entities;

import java.util.ArrayList;

public class ProviderDirectory {
    
    private ArrayList<ServiceOffered> providerDirectory;

    public ArrayList<ServiceOffered> getProviderDirectory() {
    	ArrayList<ServiceOffered> list = new ArrayList<ServiceOffered>();
    	return list;
    }

    public ServiceOffered getServiceByName(String serviceName) {
    	ServiceOffered service = new ServiceOffered();
    	return service;
    }

    public ServiceOffered getServiceByCode(String serviceCode) {
    	ServiceOffered service = new ServiceOffered();
    	return service;
    }
}
