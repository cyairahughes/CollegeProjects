package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 2
 * This project is to design a class that implements an interface of method used
 * to manipulate an input string done by using particular methods
 ****************************************************************************/
public class RamString extends MyIndexOutOfBoundsException implements WackyStringInterface  {

    //Instance Variable
    private String wackyString;

    //Default Constructor
    public RamString(){
        this.wackyString = "Go Rams! Go CS@VCU!";
    }

    //Parameterized Constructor
    public RamString(String wackyString){
        if (wackyString == null){
            throw new IllegalArgumentException();
        }
        this.wackyString = wackyString;
    }

    //Setter method for instance variable that makes sure the string input is non null
    public void setWackyString(String wackyString){
        if (wackyString == null){
            throw new IllegalArgumentException();
        }else{
            this.wackyString = wackyString;
        }
    }

    //Getter Method
    public String getWackyString() { return wackyString; }

    //Prints out every third character from the string entered
    public String getEveryThirdCharacter() {
        String everyThirdCharacter = "";
        for (int i = 0; i < wackyString.length(); i++) {
            if ((i + 1) % 3 == 0)
                everyThirdCharacter += wackyString.charAt(i);
        }
        return everyThirdCharacter;
    }

    //Prints out every odd or even character from the string entered. If "Even" or "odd" isn't entered, an
    //illegal argument exception is thrown
    public String getEvenOrOddCharacters(String evenOrOdd) {
        String result = "";
        if(evenOrOdd.compareToIgnoreCase("odd") == 0){
            for (int i = 0; i < wackyString.length(); i++) {
                if (i % 2 == 0)
                    result += wackyString.charAt(i);
            }
            return result;
        }
        else if(evenOrOdd.compareToIgnoreCase("even") == 0){
            for (int i = 0; i < wackyString.length(); i++) {
                if (i % 2 != 0)
                    result += wackyString.charAt(i);
            }
            return result;
        }else{
            throw new IllegalArgumentException("Must enter either \"odd\" or \"even\"");
        }

    }

    // Counts every double digit found in the string, triple or quadruple digits are not counted
    public int countDoubleDigits() {

        String result = wackyString.replaceAll("\\D+", " ");
        int count = 0;
        for (int i = 0; i < result.length()-1; i++) {
            if (result.charAt(i) == result.charAt(i+1) && result.charAt(i+1) != result.charAt(i-1)
                    && result.charAt(i) != result.charAt(i+2) && result.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }

    // Tests to see if the string entered is a valid email address and returns either true or false
    public boolean isValidVCUEmail() {
        if(wackyString.contains("@vcu.edu") || wackyString.contains("@mymail.vcu.edu")) {
            return true;
        }else {
            return false;
        }
    }

    // Returns a phone number in standard form "(123) 456-789" returns a statement if a phone number is not entered
    public String standardizePhoneNumber() {
        String phoneNumber = wackyString.replaceAll("\\D+", "");
        if (phoneNumber.length() == 10) {
            return phoneNumber.replaceFirst("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
        } else
            return "This WackyString is not a phone number.";
    }

    // If the string contains "00", "CS@VCU" replaces the "00" and if the string contains "0", "Go Rams" replaces
    public void ramifyString() {
        if (wackyString.contains("00")){
            wackyString = wackyString.replace("00", "CS@VCU");

        }
        if(wackyString.contains("0")){
            wackyString = wackyString.replace("0", "Go Rams");
        }

    }

    //Converts every digit found in the substring to roman numeral form
    public void convertDigitsToRomanNumeralsInSubstring(int startPosition, int endPosition)
            throws MyIndexOutOfBoundsException, IllegalArgumentException {
        if (startPosition < 1 || endPosition > wackyString.length() || startPosition > wackyString.length() || endPosition < 1) {
            throw new MyIndexOutOfBoundsException("hello");

        }
        if (startPosition > endPosition) {
            throw new IllegalArgumentException();
        }

        if (wackyString.contains("0")) {
            wackyString = wackyString;
        }
        if (wackyString.contains("1")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("1", "I");
        }
        if (wackyString.contains("2")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("2", "II");
        }
        if (wackyString.contains("3")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("3", "III");
        }
        if (wackyString.contains("4")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("4", "IV");
        }
        if (wackyString.contains("5")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("5", "V");
        }
        if (wackyString.contains("6")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("6", "VI");
        }
        if (wackyString.contains("7")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("7", "VII");
        }
        if (wackyString.contains("8")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("8", "VIII");
        }
        if (wackyString.contains("9")) {
            wackyString = wackyString.substring(startPosition-1, endPosition).replace("9", "IX");
        }


    }
}
