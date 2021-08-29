/****************************************************************************
 * StateAnalysis
 ****************************************************************************
 * A program that reads and input file and writes and output file
 *_____________________________________________________
 * Cyaira Hughes
 * April 27, 2020
 * 255-901
 ****************************************************************************/
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException;


public class StateAnalysis {

    public static void main(String[] args) throws FileNotFoundException {
        //Scanner and PrinterWriter objects
        File inputFile = new File("StateFile.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("StateFileOutput.txt");
        String[] data = new String[50];

        //Tests if there is a problem with input file
        try {
            data = readFile(inputFile);
            System.out.print("\n" + "Input file correct");
        } catch (FileNotFoundException e) {
            System.out.print("Incorrect input filename");
        }
        //Main method calls methods
        ArrayList<State> states = parseData(data);
        double lengthAverage = calcLengthAverage(states);

    }

    //Method reads a file anr returns array
    public static String[] readFile(File inputFile) throws FileNotFoundException {
        Scanner in = new Scanner(inputFile);
        ArrayList<String> temp = new ArrayList<>();
        String[] tokens = new String[50];
        while (in.hasNextLine()) {
            String line = in.nextLine();

            temp.add(line);
        }

        in.close();
        tokens = temp.toArray(new String[50]);
        if (tokens.length > 50) {
            temp.remove(52);
            temp.remove(51);
            temp.remove(50);
            String[] result = temp.toArray(new String[50]);
            System.out.print(Arrays.toString(result));
            return result;
        } else {
            System.out.print(Arrays.toString(tokens));
            return tokens;
        }
    }

    //Method converts array to Arraylist of type State
    public static ArrayList<State> parseData(String[] data) {
        ArrayList<State> list = new ArrayList<>();
        String name = " ";
        String capital = " ";
        int rank = 0;
        int length = 0;
        int width = 0;
        int i = 0;
        int x = 0;
        int y = 1;
        int z = 2;
        int a = 3;
        int b = 4;

        String[] tokens = new String[50];
        String line = Arrays.toString(data);
        tokens = line.replace("]", "").replace("[", "").replace(" ", "").split(",");
        while (i < data.length) {
            name = tokens[x];
            capital = tokens[y];
            try {
                rank = Integer.parseInt(tokens[z]);
                if (rank < 0) {
                    rank = 0;
                }
            } catch (NumberFormatException e) {
                rank = 0;
            }
            try {
                length = Integer.parseInt(tokens[a]);
                if (length < 0) {
                    length = 0;
                }
            } catch (NumberFormatException e) {
                length = 0;
            }
            try {
                width = Integer.parseInt(tokens[b]);
                if (width < 0) {
                    width = 0;
                }
            } catch (NumberFormatException e) {
                width = 0;
            }
            System.out.print(width + " ");
            list.add(new State(name, capital, rank, length, width));
            i++;
            x += 5;
            y += 5;
            z += 5;
            a += 5;
            b += 5;
        }
        return list;
    }

    //Method calculates the average length of the states
    public static double calcLengthAverage(ArrayList<State> states) {
        StringBuilder out = new StringBuilder();
        for (State o : states) {
            out.append(o.toString());
            out.append("\t");
        }
        String line = out.toString();
        String[] token = line.replace("\t", " ").split(" ");
        double length = 0;
       double result = 0;
        int i = 0;
        int a = 3;

        while (i < token.length && a < 250){
            length = Double.parseDouble(token[a]);
            result += length;
            i++;
            a +=5;
        }
        result /= 50;
        System.out.print(result);
       return result;
    }
    //Method calculates the average width of the states
    public static double calcWidthAverage(ArrayList<State> states){
        StringBuilder out = new StringBuilder();
        for (State o : states) {
            out.append(o.toString());
            out.append("\t");
        }
        String line = out.toString();
        String[] token = line.replace("\t", " ").split(" ");
        double width = 0;
        double result = 0;
        int i = 0;
        int a = 4;

        while (i < token.length && a < 250){
            width = Double.parseDouble(token[a]);
            result += width;
            i++;
            a +=5;
        }
        result /= 50;
        return result;
    }
    //Method returns a string array of states above the average length
    public static String[] calcLengthAboveAverage(ArrayList<State> states, double avg){
        StringBuilder out = new StringBuilder();
        for (State o : states) {
            out.append(o.toString());
            out.append("\t");
        }
        String line = out.toString();

        String[] token = line.replace("\t", " ").split(" ");
        double length = 0;
        double result = 0;
        int i = 0;
        int a = 3;
        String bb = " ";
        String l = "";
        String[] above = new String[]{l};
        while (i < token.length && a < 250) {
            length = Double.parseDouble(token[a]);
            if (length > avg) {
                l = token[a - 3];

            }
                i++;
                a += 5;
            }
        return above;
    }
    public static String[] calcWidthAboveAverage(ArrayList<State> states, double avg){
        String[] a = new String[0];
        return a;
    }
    public static String[] calcFirstCapitals(ArrayList<State> states, int value){
        String[] a = new String[0];
        return a;
    }
    public static boolean findState(ArrayList<State> states, State state){
        boolean x = false;
        return x;
    }
    public static void writeOutData (String[] data, File ouputFile) throws FileNotFoundException{

    }
}

    


