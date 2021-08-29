package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 1 - Inheritance
 * The Person class is the super class of the student, employee, faculty and staff classes and prints out
 * a persons name, home address, phone number, email address and ID
 * August 21, 2020
 *
 ****************************************************************************/
public class Person {
    //Instance Variables
    private int id;
    private Name name;
    private Address homeAddress;
    private String phoneNumber;
    private String email;
    private static int recordNumber = 0;

    //Default Constructor
    public Person() {
    //Sets name to default name found in Name class
        this.name = new Name();
    //Sets home address to default address found in Address class
        this.homeAddress = new Address();
        this.phoneNumber = "None given";
        this.email = "None given";
        this.id = recordNumber;
    }

    //Parameterized Constructor
    public Person(String first, String middle, String last, Address homeAddress, String phoneNumber, String email) {
    //Calls parameterized constructor and sets name
        this.name = new Name(first, middle, last);
        this.homeAddress = homeAddress;
        this.phoneNumber = phoneNumber;
        this.email = email;
    //Increments record number and then sets ID to record number value
        recordNumber++;
        this.id = recordNumber;

    }

    //Accessor/Mutator Methods
    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name.toString();
    }

    public void setName(Name name) {
        this.name = name;
    }

    //String Method
    public String toString() {
        return
                "---------------------------------------" + "\n" +
                        name + "\n" +
                        "---------------------------------------" + "\n" +
                        "Home Address: " + homeAddress + "\n" +
                        "Phone Number: " + phoneNumber + "\n" +
                        "Email Address: " + email + "\n" +
                        "ID: " + id + "\n";
    }
}
