
/****************************************************************************
 * SpaceInfo
 ****************************************************************************
 *  Gives the surface area and distance from Earth of any of the 8
 *  planets in our solar system
 *_____________________________________________________
 * Cyaira Hughes
 * March 03, 2020
 * 255-901
 ****************************************************************************/
import java.util.Scanner; // Import Scanner

public class SpaceInfo { // Program names stored as "SpaceInfo"
    public static void main(String[] args){ // Declares main Method

        processInput(); // Calls processInput Method
    }

    public static void processInput(){ // Declares processInput Method

        String userResponse = "yes"; // userResponse stored as "yes"
        final String QUIT = "quit"; // Constant variable QUIT stored as "quit"

        Scanner input = new Scanner(System.in); // Scanner variable stored as input

        while (!(userResponse.equals(QUIT))){ // Loops program when userResponse does not equal "quit"

            System.out.println("Enter the planet: "); // Tells the user to enter a planet
            String planet = input.next(); // User input stored in planet variable

            verifyPlanet(planet); // Calls verifyPlanet Method

            if (verifyPlanet(planet) == true){ // Option 1, if verifyPlanet Method returns true

                double diameter = getDiameter(planet); // Calls getDiameter Method and stores value in diameter variable
                double surfaceArea = calcSurfaceArea(diameter); // Calls calcSurfaceArea Method and stores value in surfaceArea variable
                long distance = getDistance(planet); // Calls getDistance Method and stores value in distance variable
                System.out.println("Enter the scale you want displayed: "); // Tells user to enter scale
                String scale = input.next(); // User input stored in scale variable
                double convertedDistance = convertDistance(distance, scale); // Calls convertDistance method and stores value in convertedDistance variable

                System.out.printf(planet + " has a surface area of: " + "%,.2f", surfaceArea); // Prints out the surface area of the planet
                System.out.println();
                System.out.printf(planet + " is " + "%,.2f", convertedDistance); // Prints out the distance of the planet
                System.out.printf(" " + scale + " from Earth");
                System.out.println();

                System.out.println ("Would you like to enter another planet? Enter quit to exit."); // Asks user if they'd like to enter another planet
                userResponse = input.nextLine().trim().toLowerCase(); // Stores user input in userResponse variable
                userResponse = input.nextLine().trim().toLowerCase();

            }else{ // Option 2, if verifyPlanet Method does not return true

                System.out.println("Please enter a valid planet name"); // Tells user to enter a valid planet name
                System.out.println ("Would you like to enter another planet? Enter quit to exit."); // Asks the user if they'd like to enter another planet
                userResponse = input.nextLine().trim().toLowerCase(); // Stores user input in userResponse variable
                userResponse = input.nextLine().trim().toLowerCase();
            }
        }
    }

    public static boolean verifyPlanet(String planet){ // Declares verifyPlanet Method

        if (planet.equalsIgnoreCase("Mercury")){ // If planet entered is "mercury" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Venus")){ // If planet entered is "venus" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Earth")){ // If planet entered is "earth" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Mars")){ // If planet entered is "mars" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Jupiter")){ // If planet entered is "jupiter" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Saturn")){ // If planet entered is "saturn" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Uranus")){ // If planet entered is "uranus" the method returns true
            return true;

        }else if (planet.equalsIgnoreCase("Neptune")){ // If planet entered is "neptune" the method returns true
            return true;

        }else{	// Otherwise, method returns false
            return false;
        }

    }

    public static double getDiameter(String planet){ // Declares getDiameter Method

        double [] diameter = {3031.9, 7520.8, 7917.5, 4212.3, 86881, 72367, 31518, 30599}; // Stores planet diameters in array

        if (planet.equalsIgnoreCase("Mercury")){ // If planet entered is "mercury" the method returns 3031.9
            return diameter[0];

        }else if (planet.equalsIgnoreCase("Venus")){ // If planet entered is "venus" the method returns 7502.8
            return diameter[1];

        }else if (planet.equalsIgnoreCase("Earth")){ // If planet entered is "earth" the method returns 7917.5
            return diameter[2];

        }else if (planet.equalsIgnoreCase("Mars")){ // If planet entered is "mars" the method returns 4212.3
            return diameter[3];

        }else if (planet.equalsIgnoreCase("Jupiter")){ // If planet entered is "jupiter" the method returns 86881
            return diameter[4];

        }else if (planet.equalsIgnoreCase("Saturn")){ // If planet entered is "saturn" the method returns 72367
            return diameter[5];

        }else if (planet.equalsIgnoreCase("Uranus")){ // If planet entered is "uranus" the method returns 31518
            return diameter[6];

        }else if (planet.equalsIgnoreCase("Neptune")){ // Otherwise, method returns 30599
            return diameter[7];
        }else{
            return -1.0;
        }
    }
    public static double calcSurfaceArea(double diameter){ // Declares calcSurfaceArea Method

        double surfaceArea = 4 * Math.PI * Math.pow((diameter / 2 ), 2); // Calculates surface area
        return surfaceArea; // Returns value of surface area
    }

    public static long getDistance(String planet){ // Declares getDistance Method

        long [] distance = {56974146, 25724767, 0, 78340000, 628730000, 1275000000, 2723950000L, 4351400000L}; // Stores planet distances in array

        if (planet.equalsIgnoreCase("Mercury")){ // If planet entered is "mercury" the method returns 56974146
            return distance[0];

        }else if (planet.equalsIgnoreCase("Venus")){ // If planet entered is "venus" the method returns 25724767
            return distance[1];

        }else if (planet.equalsIgnoreCase("Earth")){ // If planet entered is "earth" the method returns 0
            return distance[2];

        }else if (planet.equalsIgnoreCase("Mars")){ // If planet entered is "mars" the method returns 78340000
            return distance[3];

        }else if (planet.equalsIgnoreCase("Jupiter")){ // If planet entered is "jupiter" the method returns 628730000
            return distance[4];

        }else if (planet.equalsIgnoreCase("Saturn")){ // If planet entered is "saturn" the method returns 1275000000
            return distance[5];

        }else if (planet.equalsIgnoreCase("Uranus")){ // If planet entered is "uranus" the method returns 2723950000
            return distance[6];

        }else if (planet.equalsIgnoreCase("Neptune")){ // Otherwise, method returns 4351400000
            return distance[7];

        }else{
            return -1;
        }
    }


    public static double convertDistance(long distance, String scale){ // Declares convertDistance Method

        double k = distance;

        if (scale.equalsIgnoreCase("Miles")){ // If scale entered is "miles" the method returns the converted scale
            return k;

        }else if (scale.equalsIgnoreCase("Kilometers")){ // If scale entered is "Kilometers" the method returns the converted scale
            k *= 1.60934;
            return k;

        }else if (scale.equalsIgnoreCase("Meters")){ // If scale entered is "meters" the method returns the converted scale
            k *= 1609.34;
            return k;

        }else if (scale.equalsIgnoreCase("Yards")){ // If scale entered is "yards" the method returns the converted scale
            k *= 1760;
            return k;

        }else{ // Otherwise, the method returns 0.0
            k = 0.0;
            return k;
        }
    }
}
