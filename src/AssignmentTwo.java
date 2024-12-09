public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();
        System.out.println("===== Starting AssignmentTwo =====\n");
        assignment.partThree();// Part 3: Demonstrates queue operations
        System.out.println("\n-----------------------------------\n");
        assignment.partFourA();// Part 4A: Demonstrates LinkedList operations
        System.out.println("\n-----------------------------------\n");
        assignment.partFourB();// Part 4B: Demonstrates sorting of LinkedList
        System.out.println("\n-----------------------------------\n");
        assignment.partFive();// Part 5: Runs a ride cycle
        System.out.println("\n-----------------------------------\n");
        assignment.partSix();// Part 6: Writes ride history to a file
        System.out.println("\n-----------------------------------\n");
        assignment.partSeven();// Part 7: Reads ride history from a file
        System.out.println("\n===== AssignmentTwo Completed =====");
    }

    // Part 3: Queue Interface
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
            ride.addVisitorToQueue(v);//Add tourists to the queue
        }
        ride.removeVisitorFromQueue();//Remove a tourist from the queue
        ride.printQueue();//Print the current queue
    }

    // Part 4A: Collection Class (LinkedList)
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
            ride.addVisitorToHistory(v);// Add visitors to history
        }
        ride.checkVisitorFromHistory(visitors[2]);// Check if a specific visitor is in history
        ride.numberOfVisitors(); // Output number of visitors in history
        ride.printRideHistory(); // Print ride history
    }

    // Part 4B: Sorting the Collection
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
            ride.addVisitorToHistory(v);//Add tourists to history
        }
        System.out.println("Unsorted Ride History:");
        ride.printRideHistory();//Print unsorted history
        VisitorComparator comparator = new VisitorComparator();
        ride.sortRideHistory(comparator);//Sort history using a comparator
        System.out.println("Sorted Ride History:");
        ride.printRideHistory();//Print sorted history
    }

    //Part 5: Run the amusement ride cycle once
    public void partFive(){
        System.out.println("---- Part 5: Run a Ride Cycle ----");
        Employee operator = new Employee("Paul", 40, "Male", "E001", "Ride Operator");
        Ride ride = new Ride("Bumper Cars", 25, operator, 5);
        for(int i = 1; i <= 12; i++){
            ride.addVisitorToQueue(new Visitor("Visitor" + i, 20 + i, "Male", "V01" + i, "Standard"));
        }
        ride.printQueue();//Print initial queue
        ride.runOneCycle();//Run a cycle of amusement facilities once
        ride.printQueue();//Print the queue after the loop
        ride.printRideHistory();//Print the history after the cycle
    }

    //Part 6: Writing Data to a File
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
            ride.addVisitorToHistory(v);//Add tourists to history
        }
        ride.exportRideHistory("ride_history.csv");//Export historical records to a file
    }

    //Part 7: Reading Data from Files
    public void partSeven(){
        System.out.println("---- Part 7: Reading from a File ----");
        Ride ride = new Ride("Merry-Go-Round", 10, null, 2);
        ride.importRideHistory("ride_history.csv");//Import history from file
        ride.printRideHistory();//Print the import history
    }
}
