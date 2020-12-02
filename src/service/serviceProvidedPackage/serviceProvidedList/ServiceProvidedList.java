package service.serviceProvidedPackage.serviceProvidedList;

import java.security.Provider.Service;

import java.util.Date;
import java.util.ArrayList;

import service.serviceOffered.providerDirectory.ProviderDirectory;
import service.serviceOffered.serviceOffered.ServiceOffered;
import service.serviceProvidedPackage.serviceProvided.ServiceProvided;
import systemUser.Member;
import systemUser.MemberList;
import systemUser.Provider;
import systemUser.ProviderList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Encompasses the operations on the list of Services Provided
 * 
 * @author Ben Peinhardt
 * @author Topher Fryzel
 */
public class ServiceProvidedList {

    // Private Attributes
    private ArrayList<ServiceProvided> serviceProvidedList = new ArrayList<ServiceProvided>();
    private String path = "src/userData/service_provided_list.csv";

    /**
     * Constructor, builds ServiceProvidedList from csv file
     */
    public ServiceProvidedList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                ServiceProvided tempService = buildServiceProvidedFromCSV(values);
                this.serviceProvidedList.add(tempService);
            }
            br.close();

        } catch (Exception e) {
            System.out.println("Unable to read services provided from service provided file");
        }
    }

    /**
     * Helper for the Constructor, builds individual ServiceProvided object from
     * array of String values
     * 
     * @param values
     * @return ServiceProvided myServiceProvided
     */
    private ServiceProvided buildServiceProvidedFromCSV(String[] values) {
        MemberList myMemberList = new MemberList();
        Member myMember = new Member();
        ProviderList myProviderList = new ProviderList();
        Provider myProvider = new Provider();
        ServiceOffered myServiceOffered = new ServiceOffered();
        ProviderDirectory myProviderDirectory = new ProviderDirectory();

        // Get the member
        for (int i = 0; i < myMemberList.getMemberList().size(); i++) {
            if (myMemberList.getMemberList().get(i).getMemberNumber().equals(values[4])) {
                myMember = myMemberList.getMemberList().get(i);
            }
        }

        // Get the provider
        for (int i = 0; i < myProviderList.getProviderList().size(); i++) {
            if (myProviderList.getProviderList().get(i).getProviderNumber().equals(values[3])) {
                myProvider = myProviderList.getProviderList().get(i);
            }
        }

        // Get the service
        for (int i = 0; i < myProviderDirectory.getProviderDirectory().size(); i++) {
            if (myProviderDirectory.getProviderDirectory().get(i).getServiceCode().equals(values[5])) {
                myServiceOffered = myProviderDirectory.getProviderDirectory().get(i);
            }
        }

        // Make the service
        ServiceProvided myServiceProvided = new ServiceProvided(myServiceOffered, myProvider, myMember, values[6],
                values[2], values[1], values[0]);

        // Return the serviceProvided
        return myServiceProvided;
    }

    /**
     * Adds a service provided to the list
     * 
     * @param service
     * @param provider
     * @param member
     * @param comments
     */
    public void addServiceProvided(ServiceOffered service, Provider provider, Member member, String comments,
            String serviceDate, String currTime, String serviceProvidedID) {

        ServiceProvided newService = new ServiceProvided(service, provider, member, comments, serviceDate, currTime,
                serviceProvidedID);

        this.serviceProvidedList.add(newService);

        // Persist service provided
        persist();
    }

    /**
     * Gets the entire service provided list
     * 
     * @return serviceProvidedList
     */
    public ArrayList<ServiceProvided> getServiceProvidedList() {
        return this.serviceProvidedList;
    }

    /**
     * Returns an ArrayList of all services provided by a certain provider
     * 
     * @param providerNumber
     * @return servicesByProvider services provided by provider
     */
    public ArrayList<ServiceProvided> getServiceByProvider(String providerNumber) {

        ArrayList<ServiceProvided> servicesByProvider = new ArrayList<ServiceProvided>();
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            if (this.serviceProvidedList.get(i).getProviderNumber().equals(providerNumber)) {
                servicesByProvider.add(this.serviceProvidedList.get(i));
            }
        }

        return servicesByProvider;
    }

    /**
     * Returns an ArrayList of services provided to a certain member
     * 
     * @param memberNumber
     * @return servicesProvidedToMember services provided to member
     */
    public ArrayList<ServiceProvided> getServiceByMember(String memberNumber) {

        ArrayList<ServiceProvided> servicesProvidedToMember = new ArrayList<ServiceProvided>();
        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            if (this.serviceProvidedList.get(i).getMemberNumber().equals(memberNumber)) {
                servicesProvidedToMember.add(this.serviceProvidedList.get(i));
            }
        }

        return servicesProvidedToMember;

    }

    /**
     * Returns an array list of members who have received a service this week
     * 
     * @return list
     */
    public ArrayList<Member> getWeeklyMembers() {
        ArrayList<Member> list = new ArrayList<Member>();
        boolean memberFound = false;

        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            ServiceProvided memberSevice = this.serviceProvidedList.get(i);
            Member member = memberSevice.getMember();
            for (int j = 0; j < list.size() && memberFound == false; j++) {
                if (list.get(j).getMemberNumber().equals(member.getMemberNumber()))
                    memberFound = true;

            }
            if (memberFound == false)
                list.add(member);
            memberFound = false;
        }
        return list;
    }

    /**
     * Returns an array list of providers who provided a service this week
     * 
     * @return list
     */
    public ArrayList<Provider> getWeeklyProviders() {
        ArrayList<Provider> list = new ArrayList<Provider>();
        boolean providerFound = false;

        for (int i = 0; i < this.serviceProvidedList.size(); i++) {
            ServiceProvided providerSevice = this.serviceProvidedList.get(i);
            Provider provider = providerSevice.getProvider();
            for (int j = 0; j < list.size() && providerFound == false; j++) {
                if (list.get(j).getProviderNumber().equals(provider.getProviderNumber()))
                    providerFound = true;

            }
            if (providerFound == false)
                list.add(provider);
            providerFound = false;
        }
        return list;
    }

    /**
     * Persists ServiceProvidedList information to a csv file, called whenever list
     * is updated
     */
    private void persist() {
        try {
            File file = new File(this.path);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < this.serviceProvidedList.size(); i++) {
                pw.print(this.serviceProvidedList.get(i).writeServiceProvidedToCSV());
                if (i != this.serviceProvidedList.size() - 1) {
                    pw.println("");
                }
            }
            pw.close();
        } catch (Exception e) {
            System.out.println("Unable to persist service provided information");
        }
    }
}
