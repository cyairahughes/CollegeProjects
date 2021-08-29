package Horoscope;

public class Horoscope {
    /**
     * Create instance variables
     *
     */
    private int month, day;
    private String sign;

    /**
     * Create default constructor to initialize variables
     *
     */
    public Horoscope() {
        this.month = 0; // initialize month
        this.day = 0; //initialize day
        this.sign = " "; // Initialize sign
    }

    /**
     * Create parameterized constructor containing a valid month, day, and sign
     *
     */
    public Horoscope(int month, int day, String sign) {
        this.month = month; // Initialize month
        this.day = day; //initialize day
        this.sign = sign; // initialize sign
    }


    /***
     * Create a method that determines the String result for the given month and day.
     * @return an String value
     */
    public String determineSign() {
        String positiveTraits, negativeTraits;
        if ((month == 12 && day >= 22 && day <= 31) || (month == 1 && day >= 1 && day <= 19)) {
            sign = "Capricorn ♑";
            positiveTraits = "Positive Traits: Loyal, Hardworking, Team player, Ambitious and Classy";
           negativeTraits = "Negative Traits: Overly Serious, Critical, Melancholy, Unforgiving and Suspicious";
        } else if ((month == 1 && day >= 20 && day <= 31) || (month == 2 && day >= 1 && day <= 17)) {
            sign = "Aquarius ♒";
            positiveTraits = "Positive Traits: Open-Minded, Humanitarian, Creative, Free Spirited and Intellectual";
           negativeTraits = "Negative Traits: Impulsive, Unpredictable, Inconsistent, Extremist and Stubborn ";
        } else if ((month == 2 && day >= 18 && day <= 29) || (month == 3 && day >= 1 && day <= 19)) {
            sign = "Pisces V";

           positiveTraits = "Positive Traits: Empathetic, Artistic, Emotional, Selfless and Natural Healers ";
            negativeTraits = "Negative Traits: Moody, Negative, Lazy, Idealistic and Escapists";
        } else if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 19)) {
            sign = "Aries ♈";

            positiveTraits = "Positive Traits: Strong leadership, amazing self-confidence, positive energy, bravery, creativity";
            negativeTraits = "Negative Traits: Selfishness, attention-seeking, outbursts of anger, lack Of patience, impulsive behavior";
        } else if ((month == 4 && day >= 20 && day <= 30) || (month == 5 && day >= 1 && day <= 20)) {
            sign = "Taurus ♉";

            positiveTraits = "Positive Traits: Logical, generous and trustworthy, determined, understanding, kind, organized, patient ";
            negativeTraits = "Negative Traits: Jealous, lazy, stubborn, dependant, imbalanced materialistic, possessive";
        } else if ((month == 5 && day >= 21 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
            sign = "Gemini ♊";

           positiveTraits = "Positive Traits: Flexible, outgoing, funny, enthusiastic, smart, versatile";
            negativeTraits = "Negative Traits: Superficial, backstabber, lack of direction, bad decision-making skills, anxious ";
        } else if ((month == 6 && day >= 21 && day <= 30) || (month == 7 && day >= 1 && day <= 22)) {
            sign = "Cancer ♋";

            positiveTraits = "Positive Traits: Creative, emotive, faithful, loving and charming, intuitive ";
            negativeTraits = "Negative Traits: Moody, negative, clingy, unpredictable, suspicious ";
        } else if ((month == 7 && day >= 23 && day <= 31) || (month == 8 && day >= 1 && day <= 22)) {
            sign = "Leo ♌";
            positiveTraits = "Positive Traits: Caring and lives a good life, optimistic, natural leader, kind and protective, loyal, honest, vivacious and attention seeking ";
            negativeTraits = "Negative Traits: Arrogance, inflexibility, laziness, dogmatic and prideful, domineering, jealous and competitive ";
        } else if ((month == 8 && day >= 23 && day <= 31) || (month == 9 && day >= 1 && day <= 22)) {
            sign = "Virgo ♍";

          positiveTraits = "Positive Traits: Intelligence, analytical, honesty, reliable and perfectionist ";
         negativeTraits = "Negative Traits: Critical, judgemental, old school, fussy and slow ";
        } else if ((month == 9 && day >= 23 && day <= 30) || (month == 10 && day >= 1 && day <= 22)) {
            sign = "Libra ♎";

            positiveTraits = "Positive Traits: Romantic, charming, great listener, fair, idealist and understanding ";
            negativeTraits = "Negative Traits: Lazy, indecisive, unreliable, superficial and manipulative ";
        } else if ((month == 10 && day >= 23 && day <= 31) || (month == 11 && day >= 1 && day <= 21)) {
            sign = "Scorpio ♏";

            positiveTraits = "Positive Traits: Focused, Brave, Loyal, Faithful and Ambitious ";
            negativeTraits = "Negative Traits: Jealous, Possessive, Secretive, Dominating, Resentful";
        } else if ((month == 11 && day >= 22 && day <= 30) || (month == 12 && day >= 1 && day <= 21)) {
            sign = "Sagittarius ♐";

            positiveTraits = "Positive Traits:Smart, Caring, Deep, Honest and Wild ";
           negativeTraits = "Negative Traits:Impatient, Careless, Boastful, Attention seeking and Brutal";
        } else {
            sign = "Invalid Birthday";
            positiveTraits = " ";
            negativeTraits = " ";
        }
        return sign + " \n" + positiveTraits + "\n" + negativeTraits;
    }
    /***
     *  Create a setter method
     * month, day, sign
     */
    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    /***
     *  Create a getter method
     *  month, day, sign
     */
    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return day;
    }

    public String getSign() {
        return sign;
    }
}

