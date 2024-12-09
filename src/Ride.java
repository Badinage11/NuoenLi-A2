import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Comparator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//The Ride class implements the RideInterface interface
public class Ride implements RideInterface {
    //Private variables: amusement facility name, maximum capacity, operator, visitor queue, amusement history, maximum number of riders, number of cycles
    private String rideName;
    private int maxCapacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    //Default constructor
    public Ride() {
        this("", 0, null, 1);
    }

    //Constructor with parameters
    public Ride(String rideName, int maxCapacity, Employee operator, int maxRider) {
        this.rideName = rideName;// Initializes the ride name
        setMaxCapacity(maxCapacity);// Sets the max capacity
        this.operator = operator; // Initializes the operator
        this.visitorQueue = new LinkedList<>();// Initializes the visitor queue
        this.rideHistory = new LinkedList<>(); // Initializes the ride history
        setMaxRider(maxRider);// Sets the max riders
        this.numOfCycles = 0; // Initializes the number of cycles
    }

    // Getter for ride name
    public String getRideName() {
        return rideName;
    }

    // Setter for ride name
    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    // Getter for max capacity
    public int getMaxCapacity() {
        return maxCapacity;
    }

    //Set maximum capacity to ensure at least 1
    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity >= 1){
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Max capacity must be at least 1.");
            //Throw an exception if the maximum capacity is less than 1
        }
    }

    // Getter for operator
    public Employee getOperator() {
        return operator;
    }

    // Setter for operator
    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    // Getter for max riders
    public int getMaxRider() {
        return maxRider;
    }

    //Set the maximum number of riders to ensure at least 1
    public void setMaxRider(int maxRider) {
        if(maxRider >= 1){
            this.maxRider = maxRider;
        } else {
            throw new IllegalArgumentException("Max riders per cycle must be at least 1.");
            //Throw an exception if the maximum number of riders is less than 1
        }
    }

    // Getter for number of cycles
    public int getNumOfCycles() {
        return numOfCycles;
    }

    //Set the number of cycles to ensure it is not negative
    public void setNumOfCycles(int numOfCycles) {
        if(numOfCycles >= 0){
            this.numOfCycles = numOfCycles;
        } else {
            throw new IllegalArgumentException("Number of cycles cannot be negative.");
            //Throw an exception if the number of cycles is negative
        }
    }

    //Add visitors to the queue
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if(visitorQueue.size() < maxCapacity){
            visitorQueue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to the queue.");
        } else {
            System.out.println("Queue is full. Cannot add visitor " + visitor.getName() + ".");
        }
    }

    //Remove visitors from the queue
    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if(removed != null){
            System.out.println("Visitor " + removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

    //Print the current queue
    @Override
    public void printQueue() {
        if(visitorQueue.isEmpty()){
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Current Queue:");
            for(Visitor v : visitorQueue){
                System.out.println("Name: " + v.getName() + ", ID: " + v.getVisitorId() + ", Membership: " + v.getMembershipType());
            }
        }
    }

    //Run one riding cycle
    @Override
    public void runOneCycle() {
        if(operator == null){
            System.out.println("No operator assigned. Cannot run the ride.");
            return;
        }
        if(visitorQueue.isEmpty()){
            System.out.println("Queue is empty. Cannot run the ride.");
            return;
        }
        int riders = Math.min(maxRider, visitorQueue.size());
        System.out.println("Running cycle " + (numOfCycles + 1) + " with " + riders + " riders.");
        for(int i = 0; i < riders; i++){
            Visitor visitor = visitorQueue.poll();
            if(visitor != null){
                addVisitorToHistory(visitor);
            }
        }
        numOfCycles++;
        System.out.println("Ride has run for " + numOfCycles + " cycles.");
    }

    //Add visitors to the amusement history
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    //Check if the visitor is in the amusement history
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (exists ? " is" : " is not") + " in ride history.");
        return exists;
    }

    //Obtain the number of visitors in the history of the amusement park
    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in ride history: " + count);
        return count;
    }

    // Prints the ride history
    @Override
    public void printRideHistory() {
        if(rideHistory.isEmpty()){
            System.out.println("Ride history is empty.");
        } else {
            System.out.println("Ride History:");
            Iterator<Visitor> it = rideHistory.iterator();
            while(it.hasNext()){
                Visitor v = it.next();
                System.out.println("Name: " + v.getName() + ", ID: " + v.getVisitorId() + ", Membership: " + v.getMembershipType());
            }
        }
    }

    //Sort Amusement History
    public void sortRideHistory(Comparator<Visitor> comparator){
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }

    //Export amusement history to a file
    public void exportRideHistory(String filename){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            for(Visitor v : rideHistory){
                String line = String.join(",", v.getName(), String.valueOf(v.getAge()), v.getGender(), v.getVisitorId(), v.getMembershipType());
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Ride history exported to " + filename + ".");
        } catch(IOException e){
            System.err.println("Error exporting ride history: " + e.getMessage());
        }
    }

    //Import amusement history from files
    public void importRideHistory(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            int count = 0;
            while((line = br.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length == 5){
                    String name = parts[0];
                    int age = Integer.parseInt(parts[1]);
                    String gender = parts[2];
                    String visitorId = parts[3];
                    String membershipType = parts[4];
                    Visitor v = new Visitor(name, age, gender, visitorId, membershipType);
                    rideHistory.add(v);
                    count++;
                } else {
                    System.err.println("Invalid record: " + line);
                }
            }
            System.out.println("Imported " + count + " visitors from " + filename + ".");
        } catch(IOException | NumberFormatException e){
            System.err.println("Error importing ride history: " + e.getMessage());
        }
    }
}
