/****************************************************************************
 * Customer
 ****************************************************************************
 * A program that keeps track of the customers and their donut purchases of a donut shop
 *_____________________________________________________
 * Cyaira Hughes
 * April 8, 2020
 * 255-901
 ****************************************************************************/
import java.util.ArrayList;

public class Customer {

    //Instance variables
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private ArrayList<Donut> donuts = new ArrayList<Donut>();

    //Accessor/Mutator Methods
    public String getFirstName(){ return firstName;}
    public void setFirstName(String firstName1){this.firstName = firstName1;}
    public String getLastName(){ return lastName;}
    public void setLastName(String lastName1){this.lastName = lastName1;}
    public String getPhone(){return phone;}
    public void setPhone(String phone1){this.phone = phone1;}
    public String getEmail(){return email;}
    public void setEmail(String email1){this.email = email1;}
    public ArrayList<Donut> getDonut(){return donuts;}

    //Default Constructor
    public Customer(){

        firstName = null;
        lastName = null;
        phone = null;
        email = null;
        donuts = new ArrayList<Donut>();
    }

    //Parameterized Constructor
    public Customer (String lastName, String firstName, String phone, String email){
        super();
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPhone(phone);
        this.setEmail(email);
        donuts = new ArrayList<Donut>();
    }

    //Order Donut Method
    public void orderDonut(Donut donut){
        if (donuts.size() < 5) {
            donuts.add(donut);

        } else {
            System.out.println("Donut order is empty");
        }
    }

    //Get Donut Method
    public int getNumDonut(){
        int i = 0;
        while (i < donuts.size()) {
            i++;
        }
        return i;
    }



    //toString Method
    public String toString(){
        StringBuffer sb = new StringBuffer();

        for (Donut s : donuts) {
            sb.append(s);

        }
        String str = sb.toString();

        return firstName + " " + lastName + "\n" + phone + "\n" + email + "\n" + "Donut Order:"+ "\n" + str;
    }
}
