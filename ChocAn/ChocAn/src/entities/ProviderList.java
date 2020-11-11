package entities;

import java.util.ArrayList;

public class ProviderList {

    private ArrayList<Provider> providerList;

    public Provider getProvider(String providerNumber) {
    	return providerList.get(0);
    }

    public void createProvider(String name, String streetAddress, String city, String state, String ZIP) {

    }

    public void deleteProvider(String providerNumber) {

    }

    public ArrayList<Provider> getProviderList() {
        return providerList;
    }
}
