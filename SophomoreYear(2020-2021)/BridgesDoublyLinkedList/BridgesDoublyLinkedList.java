package cmsc256;

import bridges.base.DLelement;
import bridges.connect.Bridges;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 4
 * A Visualized Doubly Linked List Using Bridges
 * October 14, 2020
 ****************************************************************************/

public class BridgesDoublyLinkedList<E> implements List<E> {
    //instance variables
    private DLelement<E> head;
    private DLelement<E> tail;
    private DLelement<E> curr;
    private int listSize;

    //Constructor
     public BridgesDoublyLinkedList(){
        clear();
     }

    public static void main(String[] args) {

        //connect to bridges
        Bridges bridges = new Bridges(4, "CyairaHughes",
                "910423764620");

        //create instance of BridgesDoublyLinkedList class
        BridgesDoublyLinkedList<String> adventureTime = new BridgesDoublyLinkedList<String>();

        BridgesDoublyLinkedList<String> test = new BridgesDoublyLinkedList<String>();
        test.append("a");
        test.append("b");
        test.append("c");
        test.append("d");
        test.append("3");
        test.clear();
        System.out.println(test.currPos());
        //sets title when visualized
        bridges.setTitle("Characters in Adventure Time");

        //sets description when visualized
        bridges.setDescription("My 20 favorites in no particular order");

        //adding 20 strings to DLList
            adventureTime.append("Finn");
            adventureTime.append("Jake");
            adventureTime.append("Marceline");
            adventureTime.append("Princess_Bubblegum");
            adventureTime.append("Ice_King");
            adventureTime.append("BMO");
            adventureTime.append("LSP");
            adventureTime.append("Flame_Princess");
            adventureTime.append("Lady_Rainicorn");
            adventureTime.append("Hunson_Abadeer");
            adventureTime.append("Cinnamon_Bun");
            adventureTime.append("Peppermint_Butler");
            adventureTime.append("Gunter");
            adventureTime.append("Tree_Trunks");
            adventureTime.append("Prismo");
            adventureTime.append("Martin_Mertens");
            adventureTime.append("Earl_of_Lemongrab");
            adventureTime.append("Susan_Strong");
            adventureTime.append("Magic_Man");
            adventureTime.append("N.E.P.T.R");

        //sets label and color for nodes
        System.out.println(adventureTime.toString());
        for (int i = 0; i < adventureTime.length(); i++) {
            adventureTime.moveToPos(i);
          adventureTime.curr.setLabel(adventureTime.getValue());
          adventureTime.curr.setColor("pink");

        }
        adventureTime.head.setColor("pink");
        adventureTime.tail.setColor("pink");

        //sets the DLList to visualize
        bridges.setDataStructure(adventureTime.head);
        try {
            bridges.visualize();
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
     }
    @Override
    //clears the list by setting the instance variables to null and size to 0
    public void clear() {
         head = new DLelement<E>((DLelement<E>) null,null);
         curr = tail = new DLelement<E>(null, head);
         listSize = 0;
    }

    @Override
    //inserts an element into the list
    public boolean insert(E it) {

             curr = new DLelement<>(it, curr, curr.getPrev());
             curr.getPrev().setNext(curr);
             curr.getNext().setPrev(curr);
             listSize++;
             return true;
    }

    @Override
    //inserts an element at the end of the list
    public boolean append(E it) {
            tail.setPrev(new DLelement<>(it, tail, tail.getPrev()));
            tail.getPrev().getPrev().setNext(tail.getPrev());
            if (curr == tail) curr = tail.getPrev();
            listSize++;
            return true;
        }

    @Override
    //removes an element from the list
    public E remove() {
        E it = curr.getValue();
        if (isEmpty()) return null;
        if(curr.equals(tail.getPrev())) {
            curr.getPrev().setNext(tail);
            curr.getNext().setPrev(curr.getNext());
            curr = curr.getPrev();
            it = curr.getPrev().getValue();
        }else {
            curr.getPrev().setNext(curr.getNext());
            curr.getNext().setPrev(curr.getPrev());
            curr = curr.getNext();
        }
        listSize--;
        return it;
    }
    //determines if the list is empty
    public boolean isEmpty(){
         if (listSize == 0)
             return true;
        return false;
    }

    //moves curr to the starting position of the list
    public void moveToStart() {
        curr = head.getNext();
    }

    //moves curr to end position of list
    public void moveToEnd() {
        curr = tail.getPrev();
    }

    @Override
    //moves curr to previous position of list
    public void prev() {
        if (curr.getPrev() != head)
            curr = curr.getPrev();
    }

    @Override
    //moves curr to next position of list
    public void next() {
        if (curr.getNext() != tail)
            curr = curr.getNext();
    }

    @Override
    //returns the size of the list
    public int length() {
        return listSize;
    }

    @Override
    //returns the current position of the list
    public int currPos() {
        DLelement<E> temp = head.getNext();
        int i = 0;
         if (isEmpty()){
             return 0;
         }else {
             for (i = 0; curr != temp; i++)
                 temp = temp.getNext();
         }
         if (i == 1){
             return 0;
         }
        return i+1;
    }

    @Override
    //moves the current position of the list to an integer stated
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > listSize)) return false;
        curr = head.getNext();
        for(int i=0; i<pos; i++) curr = curr.getNext();
        return true;
    }

    @Override
    //determines id curr is at the end of the list
    public boolean isAtEnd() {
         if (isEmpty()) return true;
        return curr == tail.getPrev();
    }

    @Override
    //returns the value of the node in the current position
    public E getValue(){
       if ((curr == tail) || isEmpty())
           return null;
       return curr.getValue();
    }

    //returns a string of all elements in the DLList seperated by spaces
    public String toString(){
         StringBuilder str = new StringBuilder("");
         curr = head.getNext();
        for (int i = 0; i < listSize ; i++) {
            str.append(curr.getValue());
            curr = curr.getNext();
            if(curr != null){
                str.append(" ");
            }

        }
        return str.toString();
    }
}

