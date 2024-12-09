//The RideInterface interface defines the basic operations of amusement facilities
public interface RideInterface {
    //Add visitors to the queue
    void addVisitorToQueue(Visitor visitor);
    //Remove visitors from the queue
    void removeVisitorFromQueue();
    //Print visitor information in the current queue
    void printQueue();
    //Run one riding cycle
    void runOneCycle();
    //Add visitors to the amusement history
    void addVisitorToHistory(Visitor visitor);
    //Check if the visitor is in the amusement history record
    boolean checkVisitorFromHistory(Visitor visitor);
    //Retrieve the number of visitors from the amusement history records
    int numberOfVisitors();
    //Print visitor information from amusement history records
    void printRideHistory();
}