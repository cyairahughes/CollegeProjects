import java.util.Scanner; // import scanner
/****************************************************************************
* DonutSign
****************************************************************************
*  Determines the cost of a custom-made sign that is in the shape of a logene 
*  consisting of two half circles attached to a parallelogram
*_____________________________________________________
* Cyaira Hughes
* Febuary 20, 2020
* 255-901
****************************************************************************/

public class DonutSign {
  public static void main(String[] args) {
    String userResponse = "yes"; // userResponse stored as "yes"
    final String QUIT = "quit"; // constant variable QUIT stored as "quit"
	  Scanner input = new Scanner(System.in); // import scanner 
	  while (!(userResponse.equals(QUIT))){  // program loops when user does not enter "quit"
	
	  System.out.println("Enter the radius of the circles: ");
    int radius = input.nextInt(); // user inputs radius
	
    System.out.println("Enter the first side of the parallelogram: ");
    int side1 = input.nextInt(); // user inputs side1

    System.out.println("Enter the second side of the parallelogram: ");
    int side2 = input.nextInt(); // user inputs side2

    System.out.println("Enter the angle of the parallelogram: ");
    int angle = input.nextInt(); // user inputs angle	

    System.out.println("Enter the string you would like on your sign: "); 

    String message = input.nextLine();
    message = input.nextLine(); // user inputs message

    double area = (Math.PI * radius * radius) + (Math.sin(angle) * side1 * side2); // calculate area

    double cost = (message.replace(" ", "").length() * 1.65) + (2.85 * area); // calculate cost (does not incorporate spaces in message length) 

    System.out.printf("$%4.2f", cost); // prints out cost with two decimal places

    System.out.println();

    System.out.println ("Would you like to create another sign? Enter quit to exit.");

    userResponse = input.nextLine().trim().toLowerCase(); // user enters "quit" if they want to exit, otherwise the program wil loop
    }

    }
  } 
