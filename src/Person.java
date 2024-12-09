// Abstract class Person
public abstract class Person {
    // Private variables: name, age, and gender
    private String name;
    private int age;
    private String gender;

    //Default constructor
    public Person() {}

    //Constructor with parameters
    public Person(String name, int age, String gender) {
        this.name = name;// Initializes the name
        setAge(age);//Set age and use setAge method
        this.gender = gender; // Initializes the gender
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    //Set age to ensure it is not negative
    public void setAge(int age) {
        if(age >= 0){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Age cannot be negative.");
            //Throw an exception if the age is negative
        }
    }

    // Getter for gender
    public String getGender() {
        return gender;
    }

    // Setter for gender
    public void setGender(String gender) {
        this.gender = gender;
    }
}
