package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 1 - Inheritance
 * The Staff class extends the employee class and prints out the contents of the employee class as well as the employee's title
 * August 21, 2020
 *
 ****************************************************************************/
public class Staff extends Employee {

    //Instance Variable
    private String title;

    //Default Constructor
    public Staff(){
    //Calls default constructor in Employee class
        super();
        title = "None given";
    }

    //Parameterized Constructor
    public Staff(String first, String middle, String last, Address homeAddress, String phoneNumber, String email,
                 String office, int salary, int month, int day, int year, String title){
    //Calls parameterized constructor in Employee class
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
        this.title = title;
    }

    //Accessor and Mutator Method
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //String Method
    public String toString(){
    //Calls toString method in Employee class and replaces "Employee: " with empty space
            return "Staff: " +
                    super.toString().replace("Employee: ", "") +
                    "Title: " + title;
    }
}
