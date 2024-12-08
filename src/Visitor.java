public class Visitor extends Person {
    private String visitorId;
    private String membershipType;

    public Visitor() {
        super();
    }

    public Visitor(String name, int age, String gender, String visitorId, String membershipType) {
        super(name, age, gender);
        this.visitorId = visitorId;
        this.membershipType = membershipType;
    }

    public String getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(String visitorId) {
        this.visitorId = visitorId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(!(obj instanceof Visitor)) return false;
        Visitor other = (Visitor) obj;
        return visitorId != null && visitorId.equals(other.visitorId);
    }

    @Override
    public int hashCode() {
        return visitorId != null ? visitorId.hashCode() : 0;
    }
}
