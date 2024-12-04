public class AssignmentTwo {

    public static void partThree() {
        Ride ride = new Ride("Roller Coaster", 20, null, 5);
        Visitor v1 = new Visitor("Alice", 25, "111-111-1111", "T001", "2023-12-01");
        Visitor v2 = new Visitor("Bob", 28, "222-222-2222", "T002", "2023-12-01");
        Visitor v3 = new Visitor("Charlie", 22, "333-333-3333", "T003", "2023-12-01");
        Visitor v4 = new Visitor("David", 30, "444-444-4444", "T004", "2023-12-01");
        Visitor v5 = new Visitor("Eve", 27, "555-555-5555", "T005", "2023-12-01");

        ride.addVisitorToQueue(v1);
        ride.addVisitorToQueue(v2);
        ride.addVisitorToQueue(v3);
        ride.addVisitorToQueue(v4);
        ride.addVisitorToQueue(v5);

        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public static void main(String[] args) {
        partThree();
    }
}