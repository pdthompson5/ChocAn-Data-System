package systemUser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Entity to control editing list of members and also accessing members
 * @author Ben Peinhardt
 */
public class MemberList {

    // Private attributes
    private ArrayList<Member> memberList = new ArrayList<Member>();
    private String path = "members.csv";

    /**
     * Constructor for member list, fills the list from members.csv
     */
    public MemberList() {
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null) {
			    String[] values = line.split(",");
			    Member newMember = new Member();
                newMember.setName(values[0]);
                newMember.setStreetAddress(values[1]);
                newMember.setCity(values[2]);
                newMember.setState(values[3]);
                newMember.setZIP(values[4]);
	            newMember.setMemberNumber(values[5]);
	            newMember.setMemberStatus(Boolean.parseBoolean(values[6]));
                this.memberList.add(newMember);		
			}
        br.close();

    	} catch (Exception e) {
           System.out.println("Unable to read members from member file");
    	}
    }
    
    /**
     * Searches the member list and returns the entire member using member number
     * @param memberNumber
     * @return Member member
     */
    public Member getMember(String memberNumber) {
        for (int i = 0; i < this.memberList.size(); i++) {
        	if (this.memberList.get(i).getMemberNumber().equals(memberNumber)) {
                return this.memberList.get(i);
            }
        }

        // Member not found
        Member nullMember = new Member();
        return nullMember;
    }

    /**
     * Searches the member list and returns the member's status using member number
     * @param memberNumber
     * @return boolean memberStatus
     */
    public boolean getMemberStatus(String memberNumber) {
        for (int i = 0; i < this.memberList.size(); i++) {
        	if (this.memberList.get(i).getMemberNumber().equals(memberNumber)) {
                return this.memberList.get(i).getMemberStatus();
            }
        }

        // Member Not Found
        return false;
    }

    /**
     * Adds a member to the member list
     * @param name
     * @param streetAddress
     * @param city
     * @param state
     * @param ZIP
     */
    public void createMember(String name, String streetAddress, String city, String state, String ZIP, String memberNumber, boolean memberStatus) {
        // Duplicate checking and memberNumber creation happens in controller

        Member newMember = new Member();
        newMember.setName(name);
        newMember.setStreetAddress(streetAddress);
        newMember.setCity(city);
        newMember.setState(state);
        newMember.setZIP(ZIP);
	    newMember.setMemberNumber(memberNumber);
	    newMember.setMemberStatus(memberStatus);
        this.memberList.add(newMember);

        // Update JSON
        persist();
    }

    /**
     * Searches member list and deletes member using memberNumber
     * @param memberNumber
     */
    public void deleteMember(String memberNumber) {
        for (int i = 0; i < this.memberList.size(); i++) {
            if (this.memberList.get(i).getMemberNumber().equals(memberNumber)) {
                this.memberList.remove(i);
            }
        }

        // Updates JSON
        persist();
    }

    /**
     * Returns the entire member list
     * @return ArrayList<Member> memberList
     */
    public ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    /**
     * Persists the entire member list to the members.json. Called whenever member is added, deleted, or updated
     */
    private void persist() {
        try {
            File file = new File(this.path);
	        FileWriter fw = new FileWriter(file);
	        PrintWriter pw = new PrintWriter(fw);

	        for (int i = 0; i < this.memberList.size(); i++) {
	            pw.print(this.memberList.get(i).writeMemberToCSV());
	            if (i != this.memberList.size() - 1) {
	                pw.println(" ");
	            }
	        }
	        pw.close();
        } catch(Exception e) {
            System.out.println("Unable to persist member information");
        }
    }
}
