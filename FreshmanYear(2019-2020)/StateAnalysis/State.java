
/****************************************************************************
 * State
 ****************************************************************************
 * State Object
 *_____________________________________________________
 * Cyaira Hughes
 * April 27, 2020
 * 255-901
 ****************************************************************************/

public class State {
    //Instance Variables
    private String name, capital;
    private int rank, length, width;

    //Default and Parameterized Constructor
    public State(){
        this.name = "";
        this.capital = "";
        this.rank = 0;
        this.length = 0;
        this.width = 0;
    }
    public State(String name, String capital, int rank, int length, int width){
        this.setName(name);
        this.setCapital(capital);
        this.setRank(rank);
        this.setLength(length);
        this.setWidth(width);
    }

    //Accessor/Mutator Methods
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }
    public int getRank() {
        return rank;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    //ToString Method
    public String toString(){
        return name + " " + capital + " " + rank + " " + length + " " + width;
    }

    //Equals Method
    public boolean equals(Object obj) {
        if (obj instanceof State) {
            State state = (State) obj;
            return this.name == state.name && this.capital == state.capital && this.rank == state.rank && this.length == state.length && this.width == state.width;
        }
        return false;
    }
}
