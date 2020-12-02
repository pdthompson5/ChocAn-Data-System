package systemUser;

/**
 * Base class for a system user (provider or member)
 * Details basic information with getters and setters (name, streetAddress, city, state, ZIP)
 * @author Ben Peinhardt
 */
public class SystemUser {

    // Private attributes
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String ZIP;
    
    /**
     * Returns the name of the SystemUser
     * @return String name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns the street address of the SystemUser
     * @return String streetAddress
     */
    public String getStreetAddress() {
        return this.streetAddress;
    }

    /**
     * Returns the city of the SystemUser
     * @return String city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Returns the ZIP code of the SystemUser
     * @return String ZIP
     */
    public String getZIP() {
        return this.ZIP;
    }

    /**
     * Returns the state of the SystemUser
     * @return String state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the name of the SystemUser
     * @param str
     */
    public void setName(String str) {
        this.name = str;
    }

    /**
     * Sets address of SystemUser
     * @param str
     */
    public void setStreetAddress(String str) {
        this.streetAddress = str;
    }

    /**
     * Sets city of SystemUser
     * @param str
     */
    public void setCity(String str) {
        this.city = str;
    }

    /**
     * Sets ZIP of SystemUser
     */
    public void setZIP(String str) {
        this.ZIP = str;
    }

    /**
     * Sets state of SystemUser
     * @param str
     */
    public void setState(String str) {
        this.state = str;
    }
}
