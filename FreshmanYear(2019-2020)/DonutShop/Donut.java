/****************************************************************************
 * Donut
 ****************************************************************************
 * A program that keeps track of the customers and their donut purchases of a donut shop
 *_____________________________________________________
 * Cyaira Hughes
 * April 8, 2020
 * 255-901
 ****************************************************************************/
public class Donut {

    //Instance variable (size)
    private Size size;

    //Getter Method (size)
    public Size getSize() {
        return size;
    }

    //Setter Method (size)
    public void setSize(Size size1) { this.size = size1; }

    //Instance variable (flavor)
    private Flavor flavor;

    //Getter Method (flavor)
    public Flavor getFlavor() { return flavor; }

    //Setter Method (flavor)
    public void setFlavor(Flavor flavor1) { this.flavor = flavor1; }

    //Instance variable (icing)
    private Icing icing;

    //Getter Method (icing)
    public Icing getIcing() { return icing; }

    //Setter Method (icing)
    public void setIcing(Icing icing1) { this.icing = icing1; }

    //Instance variable (topping)
    private Topping topping;

    //Getter Method (topping)
    public Topping getTopping() { return topping; }

    //Setter Method (topping)
    public void setTopping(Topping topping1) { this.topping = topping1; }

    //Default Constructor
    public Donut() {
        this.size = Size.REGULAR;
        this.flavor = Flavor.OLD_FASHIONED;
        this.icing = Icing.NONE;
        this.topping = Topping.NONE;
    }
    //Parameterized Constructor
    public Donut(Size size)  {
        this.setSize(size);
        this.setFlavor(Flavor.OLD_FASHIONED);
       this.setIcing(Icing.NONE);
       this.setTopping(Topping.NONE);
    }
    //Method returns order string
    public String toString() {
        return "\n\t" + size + "\n" + "\t" + flavor + "\n"+ "\t" + icing + "\n" +"\t" + topping + "\n";
    }
}


