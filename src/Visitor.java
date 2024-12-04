//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Visitor extends Person {
    private String visitorId;
    private String membershipType;

    public Visitor() {
    }

    public Visitor(String name, int age, String gender, String visitorId, String membershipType) {
        super(name, age, gender);
        this.visitorId = visitorId;
        this.membershipType = membershipType;
    }

    public String getVisitorId() {
        return this.visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getMembershipType() {
        return this.membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Visitor)) {
            return false;
        } else {
            Visitor other = (Visitor)obj;
            return this.visitorId != null && this.visitorId.equals(other.visitorId);
        }
    }

    public int hashCode() {
        return this.visitorId != null ? this.visitorId.hashCode() : 0;
    }
}
