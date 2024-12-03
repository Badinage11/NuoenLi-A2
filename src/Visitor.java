class Visitor {
    private String name;
    private int age;
    private String phoneNumber;
    private String ticketId;
    private String visitDate;

    public Visitor(String name, int age, String phoneNumber, String ticketId, String visitDate) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.ticketId = ticketId;
        this.visitDate = visitDate;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return "Visitor{name='" + name + "', age=" + age + "}";
    }
}
