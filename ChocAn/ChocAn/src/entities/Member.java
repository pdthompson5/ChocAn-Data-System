package entities;

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
}
