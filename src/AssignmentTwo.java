public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        System.out.println("===== Starting AssignmentTwo =====\n");
        assignment.partThree();
        System.out.println("\n-----------------------------------\n");
        assignment.partFourA();
        System.out.println("\n-----------------------------------\n");
        assignment.partFourB();
        System.out.println("\n-----------------------------------\n");
        assignment.partFive();
        System.out.println("\n-----------------------------------\n");
        assignment.partSix();
        System.out.println("\n-----------------------------------\n");
        assignment.partSeven();
        System.out.println("\n===== AssignmentTwo Completed =====");
    }

    public void partThree(){
        System.out.println("---- Part 3: Queue Interface ----");
        Ride ride = new Ride("Roller Coaster", 20, null, 5);
        Visitor[] visitors = {
                new Visitor("Alice", 25, "Female", "V001", "Standard"),
                new Visitor("Bob", 30, "Male", "V002", "VIP"),
                new Visitor("Charlie", 22, "Male", "V003", "Standard"),
                new Visitor("Diana", 28, "Female", "V004", "VIP"),
                new Visitor("Ethan", 35, "Male", "V005", "Standard")
        };
        for(Visitor v : visitors){
            ride.addVisitorToQueue(v);
        }
        ride.removeVisitorFromQueue();
        ride.printQueue();
    }

    public void partFourA(){
        System.out.println("---- Part 4A: Collection Class (LinkedList) ----");
        Ride ride = new Ride("Water Slide", 15, null, 3);
        Visitor[] visitors = {
                new Visitor("Frank", 27, "Male", "V006", "Standard"),
                new Visitor("Grace", 32, "Female", "V007", "VIP"),
                new Visitor("Hank", 24, "Male", "V008", "Standard"),
                new Visitor("Ivy", 29, "Female", "V009", "VIP"),
                new Visitor("Jack", 36, "Male", "V010", "Standard")
        };
        for(Visitor v : visitors){
            ride.addVisitorToHistory(v);
        }
        ride.checkVisitorFromHistory(visitors[2]);
        ride.numberOfVisitors();
        ride.printRideHistory();
    }

    public void partFourB(){
        System.out.println("---- Part 4B: Sorting the Collection ----");
        Ride ride = new Ride("Ferris Wheel", 20, null, 5);
        Visitor[] visitors = {
                new Visitor("Karen", 26, "Female", "V011", "Standard"),
                new Visitor("Leo", 31, "Male", "V012", "VIP"),
                new Visitor("Mona", 23, "Female", "V013", "Standard"),
                new Visitor("Nate", 28, "Male", "V014", "VIP"),
                new Visitor("Olivia", 34, "Female", "V015", "Standard")
        };
        for(Visitor v : visitors){
            ride.addVisitorToHistory(v);
        }
        System.out.println("Unsorted Ride History:");
        ride.printRideHistory();
        VisitorComparator comparator = new VisitorComparator();
        ride.sortRideHistory(comparator);
        System.out.println("Sorted Ride History:");
        ride.printRideHistory();
    }

    public void partFive(){
        System.out.println("---- Part 5: Run a Ride Cycle ----");
        Employee operator = new Employee("Paul", 40, "Male", "E001", "Ride Operator");
        Ride ride = new Ride("Bumper Cars", 25, operator, 5);
        for(int i = 1; i <= 10; i++){
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Male", "V01" + i, "Standard"));
        }
        ride.printQueue();
        ride.runOneCycle();
        ride.printQueue();
        ride.printRideHistory();
    }

    public void partSix(){
        System.out.println("---- Part 6: Writing to a File ----");
        Ride ride = new Ride("Haunted House", 15, null, 3);
        Visitor[] visitors = {
                new Visitor("Quincy", 29, "Male", "V016", "Standard"),
                new Visitor("Rachel", 34, "Female", "V017", "VIP"),
                new Visitor("Sam", 21, "Male", "V018", "Standard"),
                new Visitor("Tina", 27, "Female", "V019", "VIP"),
                new Visitor("Uma", 33, "Female", "V020", "Standard")
        };
        for(Visitor v : visitors){
            ride.addVisitorToHistory(v);
        }
        ride.exportRideHistory("ride_history.csv");
    }

    public void partSeven(){
        System.out.println("---- Part 7: Reading from a File ----");
        Ride ride = new Ride("Merry-Go-Round", 10, null, 2);
        ride.importRideHistory("ride_history.csv");
        ride.printRideHistory();
    }
}
