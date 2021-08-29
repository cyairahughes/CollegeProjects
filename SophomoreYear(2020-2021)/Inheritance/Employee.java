package cmsc256;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 1 - Inheritance
 * The Employee class extends the Person class and prints out the contents of the person class as well as their office, salary and hire date
 * August 21, 2020
 *
 ****************************************************************************/
public class Employee extends Person {

    //Instance Variables
    private String office;
    private int salary;
    private LocalDate hireDate;

    //Default Constructor
    public Employee() {
    //Calls default constructor in Person class
        super();
        office = "Unassigned";
        salary = 0;
        hireDate = null;
    }

    //Parameterized Constructor
    public Employee(String first, String middle, String last, Address homeAddress, String phoneNumber, String email,
                    String office, int salary, int month, int day, int year) {
    //Calls parameterized constructor in Person class
        super(first, middle, last, homeAddress, phoneNumber, email);
        this.office = office;
    //If salary is a negative number, illegal argument exception is thrown
        if (salary < 0)
            throw new IllegalArgumentException();
        this.salary = salary;
    //Hire date is set to (yyy-MM-dd) format
        hireDate = LocalDate.of(year, month, day);
    }

    //Accessor/Mutator Methods
    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    //String Method
    public String toString() {
        String str = "Employee: ";
    //If hire date is null, the reference does not need to be reformatted
        if (hireDate == null) {
    //Calls toString method in Person class
            return str + "\n" + super.toString() +
                    "Office: " + office + "\n" +
                    "Salary: " + salary + "\n" +
                    "Date Hired: " + hireDate + "\n";
    //If hire date is not null, reference is reformatted to (d/M/yyyy)
        } else {
    //Calls toString method in Person class
            return str + "\n" + super.toString() +
                    "Office: " + office + "\n" +
                    "Salary: $" + salary + "\n" +
                    "Date Hired: " + hireDate.format(DateTimeFormatter.ofPattern("d/M/yyyy")) + "\n";
        }

    }
}

