package entities;

import java.util.ArrayList;

/**
 * Encompasses operations on the list of providers
 * @author Ben Peinhardt
 */
public class ProviderList {

    // Private attributes
    private ArrayList<Provider> providerList;

    /**
     * Searches the list of providers and returns the whole provider
     */
    public Provider getProvider(String providerNumber) {
    	for (int i = 0; i < this.providerList.size(); i++) {
            if (this.providerList.get(i).getProviderNumber() == providerNumber) {
                return this.providerList.get(i);
            }
        }

        // Provider not found
        Provider nullProvider = new Provider();
        return nullProvider;
    }

    /**
     * Adds a provider to the list
     * @param name
     * @param streetAddress
     * @param city
     * @param state
     * @param ZIP
     */
    public void createProvider(String name, String streetAddress, String city, String state, String ZIP) {
        Provider newProvider = new Provider();
        newProvider.setName(name);
        newProvider.setStreetAddress(streetAddress);
        newProvider.setCity(city);
        newProvider.setState(state);
        newProvider.setZIP(ZIP);
        this.providerList.add(newProvider);
    }

    /**
     * Finds provider in list and deletes
     * @param providerNumber
     */
    public void deleteProvider(String providerNumber) {
        for (int i = 0; i < this.providerList.size(); i++) {
            if (this.providerList.get(i).getProviderNumber() == providerNumber) {
                this.providerList.remove(i);
            }
        }
    }

    /**
     * Returns the entire provider list
     * @return ArrayList<Provider> providerList
     */
    public ArrayList<Provider> getProviderList() {
        return providerList;
    }
}
