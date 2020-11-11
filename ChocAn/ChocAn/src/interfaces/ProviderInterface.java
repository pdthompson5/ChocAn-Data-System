package interfaces;

import entities.ProviderDirectory;
import entities.ServiceOffered;

public class ProviderInterface {
    public boolean verifyMember(String memberNumber) {
        return false;
    } 

    public ProviderDirectory getProviderDirectory() {
        ProviderDirectory temp = new ProviderDirectory();
        return temp;
    }

    public void billChocAn() {

    }
    
    public ServiceOffered lookUpServiceCode(String serviceCode) {
        ServiceOffered temp = new ServiceOffered();
        return temp;
    }

    public boolean verifyService(ServiceOffered service) {
        return false;
    }

    public String addCommments() {
        return "Not implemented";
    } 

    public String promptForServiceCode() {
        return "not implemented";
    }

    public boolean tryAgainPrompt() {
        return false;
    }
}
