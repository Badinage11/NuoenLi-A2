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

public class Ride implements RideInterface {
    private String rideName;
    private int maxCapacity;
    private Employee operator;
    private Queue<Visitor> visitorQueue;
    private LinkedList<Visitor> rideHistory;
    private int maxRider;
    private int numOfCycles;

    public Ride() {
        this("", 0, null, 1);
    }

    public Ride(String rideName, int maxCapacity, Employee operator, int maxRider) {
        this.rideName = rideName;
        setMaxCapacity(maxCapacity);
        this.operator = operator;
        this.visitorQueue = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        setMaxRider(maxRider);
        this.numOfCycles = 0;
    }

    public String getRideName() {
        return rideName;
    }

    public void setRideName(String rideName) {
        this.rideName = rideName;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity >= 1){
            this.maxCapacity = maxCapacity;
        } else {
            throw new IllegalArgumentException("Max capacity must be at least 1.");
        }
    }

    public Employee getOperator() {
        return operator;
    }

    public void setOperator(Employee operator) {
        this.operator = operator;
    }

    public int getMaxRider() {
        return maxRider;
    }

    public void setMaxRider(int maxRider) {
        if(maxRider >= 1){
            this.maxRider = maxRider;
        } else {
            throw new IllegalArgumentException("Max riders per cycle must be at least 1.");
        }
    }

    public int getNumOfCycles() {
        return numOfCycles;
    }

    public void setNumOfCycles(int numOfCycles) {
        if(numOfCycles >= 0){
            this.numOfCycles = numOfCycles;
        } else {
            throw new IllegalArgumentException("Number of cycles cannot be negative.");
        }
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if(visitorQueue.size() < maxCapacity){
            visitorQueue.add(visitor);
            System.out.println("Visitor " + visitor.getName() + " added to the queue.");
        } else {
            System.out.println("Queue is full. Cannot add visitor " + visitor.getName() + ".");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        Visitor removed = visitorQueue.poll();
        if(removed != null){
            System.out.println("Visitor " + removed.getName() + " removed from the queue.");
        } else {
            System.out.println("Queue is empty. No visitor to remove.");
        }
    }

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

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println("Visitor " + visitor.getName() + " added to ride history.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        boolean exists = rideHistory.contains(visitor);
        System.out.println("Visitor " + visitor.getName() + (exists ? " is" : " is not") + " in ride history.");
        return exists;
    }

    @Override
    public int numberOfVisitors() {
        int count = rideHistory.size();
        System.out.println("Number of visitors in ride history: " + count);
        return count;
    }

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

    public void sortRideHistory(Comparator<Visitor> comparator){
        Collections.sort(rideHistory, comparator);
        System.out.println("Ride history sorted.");
    }

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
