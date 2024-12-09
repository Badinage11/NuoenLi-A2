//The Employee class inherits from the Person class
public class Employee extends Person {
    //Private variables: Employee ID and Position
    private String employeeId;
    private String position;

    //Default constructor
    public Employee() {
        super();
    }//Call the constructor of the parent class

    //Constructor with parameters
    public Employee(String name, int age, String gender, String employeeId, String position) {
        super(name, age, gender);//Call the constructor of the parent class
        this.employeeId = employeeId;//Initialize employee ID
        this.position = position;//Initialize position
    }

    //Obtain employee ID
    public String getEmployeeId() {
        return employeeId;
    }

    //Set employee ID
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    // Getter for position
    public String getPosition() {
        return position;
    }

    // Setter for position
    public void setPosition(String position) {
        this.position = position;
    }
}
