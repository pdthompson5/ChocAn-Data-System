package entities;

public class SystemUser {

    // Private attributes
    private String name;
    private String streetAddress;
    private String city;
    private String state;
    private String ZIP;
    
    public String getName() {
        return this.name;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getCity() {
        return this.city;
    }

    public String getZIP() {
        return this.ZIP;
    }

    public String getState() {
        return this.state;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setStreetAddress(String str) {
        this.streetAddress = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setZIP(String str) {
        this.ZIP = str;
    }

    public void setState(String str) {
        this.state = str;
    }
}
