package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 1 - Inheritance
 * The Faculty class extends the Employee class and prints out the contents of the Employee class as well as their rank
 * August 21, 2020
 *
 ****************************************************************************/
public class Faculty extends Employee {

    //Instance Variable
    private String rank;

    //Default Constructor
    public Faculty(){
    //Calls default constructor in Employee class
        super();
        rank = "Instructor";
    }

    //Parameterized Constructor
    public Faculty(String first, String middle, String last, Address homeAddress, String phoneNumber, String email,
                   String office, int salary, int month, int day, int year, String rank){
    //Calls parameterized constructor in Employee class
        super(first, middle, last, homeAddress, phoneNumber, email, office, salary, month, day, year);
    //If isValidRank returns false, illegal argument exception is thrown
        if(!isValidRank(rank))
            throw new IllegalArgumentException();
        this.rank = rank;
    }

    //Accessor and Mutator Methods
    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    //Determines if rank input is valid
    private boolean isValidRank(String rank){

            switch (rank) {

                case "Adjunct":
                    return true;
                case "Instructor":
                    return true;
                case "Assistant Professor":
                    return true;
                case "Associate Professor":
                    return true;
                case "Professor":
                    return true;
                default:
                    return false;
            }
    }

    //String Method
    public String toString(){
    //Calls toString method in Employee class and replaces "Employee: " empty space
            return "Faculty: " +
                    super.toString().replace("Employee: ", "") + "Rank: " + rank + "\n";

    }
}
