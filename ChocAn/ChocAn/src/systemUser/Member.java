package systemUser;

/**
 * Encompasses extra information relevent to Member (memberNumber, memberStatus)
 * @author Ben Peinhardt
 */
public class Member extends SystemUser {
    
    // Private Attributes
    private String memberNumber;
    private boolean memberStatus;

    /**
     * Gets member number
     * @return String memberNumber
     */
    public String getMemberNumber() {
        return this.memberNumber;
    }

    /**
     * Gets member status
     * @return boolean memberStatus
     */
    public boolean getMemberStatus() {
        return this.memberStatus;
    }

    /**
     * Sets member number 
     * @param memberNumber
     */
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    /**
     * Sets member status
     * @param memberStatus
     */
    public void setMemberStatus(boolean memberStatus) {
        this.memberStatus = memberStatus;
    }

    /**
     * Returns the appropriate string to be written to the CSV file for persiting data
     * @return String memberAsCSV
     */
    public String writeMemberToCSV() {
        String memberAsCSV = String.format("%s,%s,%s,%s,%s,%s,%s", this.getName(), this.getStreetAddress(), this.getCity(), this.getState(), this.getZIP(), this.getMemberNumber(), this.getMemberStatus()); 
        
        return memberAsCSV;
    }
}
