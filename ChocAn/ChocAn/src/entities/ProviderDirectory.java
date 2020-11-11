package entities;

import java.util.ArrayList;

/**
 * Encompasses Provider Directory, which is actually a list of Services Offered
 * @author Ben Peinhardt
 */
public class ProviderDirectory {
    
    // Private attributes
    private ArrayList<ServiceOffered> providerDirectory;

    /**
     * Gets the entire provider directory
     * @return ArrayList<ServiceOffered> providerDirectory
     */
    public ArrayList<ServiceOffered> getProviderDirectory() {
    	return this.providerDirectory;
    }

    /**
     * Returns an entire Service Offered structure based on service name
     * @param serviceName
     * @return ServiceOffered service
     */
    public ServiceOffered getServiceByName(String serviceName) {
    	for (int i = 0; i < this.providerDirectory.size(); i++) {
            if (this.providerDirectory.get(i).getServiceName() == serviceName) {
                return this.providerDirectory.get(i);
            }
        }

        // Service Not found
        ServiceOffered temp = new ServiceOffered();
        return temp;
    }

    /**
     * Gets service from list by service code
     * @param serviceCode
     * @return
     */
    public ServiceOffered getServiceByCode(String serviceCode) {
    	for (int i = 0; i < this.providerDirectory.size(); i++) {
            if (this.providerDirectory.get(i).getServiceCode() == serviceCode) {
                return this.providerDirectory.get(i);
            }
        }

        // Service not found
        ServiceOffered temp = new ServiceOffered();
        return temp;
    }
}
