package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 1 - Inheritance
 * The Student class extends the Person class and prints out the contents of the person class as well as their Student Level
 * August 21, 2020
 *
 ****************************************************************************/

public class Student extends Person {

    //Instance Variable
    private String level;

    //Default Constructor
    public Student(){
    //Calls default constructor in Person class
        super();
        level = "Freshman";
    }

    //Accessor and Mutator Method
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    //Parameterized Constructor
    public Student(String first, String middle, String last, Address homeAddress, String phoneNumber, String email, String level){
    //Calls parameterized constructor in Person class
        super(first, middle, last, homeAddress, phoneNumber, email);
    //If isValidLevel method returns false, illegal argument exception is thrown
        if(!isValidLevel(level))
            throw new IllegalArgumentException();
        this.setLevel(level);
    }

    //Determines if Level input is valid
    private boolean isValidLevel(String level){
        switch (level) {
            case "Freshman":
            case "Graduate":
            case "Senior":
            case "Junior":
            case "Sophomore":
                return true;
            default:
                return false;
        }
    }

    //String Method
    public String toString(){
    //Calls toString method in Person class
            return "Student: " + "\n" +
                    super.toString() + "Student Level: " + level + "\n";

    }
}
