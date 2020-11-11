package entities;

import java.util.ArrayList;
/**
 * Entity to control editing list of members and also accessing members
 * @author Ben Peinhardt
 */
public class MemberList {

    // Private attributes
    private ArrayList<Member> memberList = new ArrayList<Member>();
    
    /**
     * Searches the member list and returns the entire member using member number
     * @param memberNumber
     * @return Member member
     */
    public Member getMember(String memberNumber) {
        for (int i = 0; i < this.memberList.size(); i++) {
            if (this.memberList.get(i).getMemberNumber() == memberNumber) {
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
            if (this.memberList.get(i).getMemberNumber() == memberNumber) {
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
    public void createMember(String name, String streetAddress, String city, String state, String ZIP) {
        // Duplicate checking and memberNumber creation happens in controller

        Member newMember = new Member();
        newMember.setName(name);
        newMember.setStreetAddress(streetAddress);
        newMember.setCity(city);
        newMember.setState(state);
        newMember.setZIP(ZIP);
        this.memberList.add(newMember);
    }

    /**
     * Searches member list and deletes member using memberNumber
     * @param memberNumber
     */
    public void deleteMember(String memberNumber) {
        for (int i = 0; i < this.memberList.size(); i++) {
            if (this.memberList.get(i).getMemberNumber() == memberNumber) {
                this.memberList.remove(i);
            }
        }
    }

    /**
     * Returns the entire member list
     * @return ArrayList<Member> memberList
     */
    public ArrayList<Member> getMemberList() {
        return this.memberList;
    }
}
