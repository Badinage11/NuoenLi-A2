public class Visitor extends Person {
    private String ticketNumber;
    private String visitDate;

    public Visitor() {
        // Default constructor
    }

    public Visitor(String name, int age, String contactNumber, String ticketNumber, String visitDate) {
        super(name, age, contactNumber);
        this.ticketNumber = ticketNumber;
        this.visitDate = visitDate;
    }

    // Getters and Setters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }
}