//The Visitor class inherits from the Person class and represents visitors to the amusement park
public class Visitor extends Person {
    //Private variables: Visitor ID and Member Type
    private String visitorId;
    private String membershipType;

    //Default constructor, call parent class constructor
    public Visitor() {
        super();
    }

    //Constructor with parameters, initialize visitor information
    public Visitor(String name, int age, String gender, String visitorId, String membershipType) {
        super(name, age, gender);//Call the constructor of the parent class
        this.visitorId = visitorId;//Initialize visitor ID
        this.membershipType = membershipType;//Initialize member type
    }

    // Getter for visitor ID
    public String getVisitorId() {
        return visitorId;
    }

    // Setter for visitor ID
    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    // Getter for membership type
    public String getMembershipType() {
        return membershipType;
    }

    // Setter for membership type
    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    //Rewrite the equals method and compare based on visitorId
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;//If it is the same object, return true
        if(!(obj instanceof Visitor)) return false;//If it is not of Visitor type, return false
        Visitor other = (Visitor) obj;
        return visitorId != null && visitorId.equals(other.visitorId);//Compare VisitorId
    }

    //Rewrite the hashCode method to generate hash values based on visitorId
    @Override
    public int hashCode() {
        return visitorId != null ? visitorId.hashCode() : 0;//Generate hash value for visitorId
    }
}
