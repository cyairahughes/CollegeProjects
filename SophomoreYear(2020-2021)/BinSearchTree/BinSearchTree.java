package cmsc256;
/****************************************************************************
 * Cyaira Hughes
 ****************************************************************************
 * 256-901
 * Programming Project 5
 * A Visualized BST Using Bridges
 * October 31, 2020
 ****************************************************************************/
import bridges.base.BinTreeElement;
import bridges.connect.Bridges;

public class BinSearchTree<E extends Comparable<E>> implements BinTreeInterface<E> {
    //instance variables
    private int size;
    private BinTreeElement<E> root;

    //constructor
    public BinSearchTree(){clear();}

    //method that returns the root of BST
     @Override
    public BinTreeElement<E> getRoot() {
        return root;
    }

    //private helper method that adds an element to BST
    private BinTreeElement<E> addHelp(BinTreeElement<E> root, E element){
        //if root is null, root is set to element
        if(root == null) return new BinTreeElement<>(element);
        //if the value of element is less than or equal to the root, set left and compare again
        if (root.getValue().compareTo(element) >= 0)
            root.setLeft(addHelp(root.getLeft(), element));
        else
            //else, set right and compare again
            root.setRight(addHelp(root.getRight(), element));
        return root;
    }

    //adds element to BST and increases size of BST
    @Override
    public boolean add(E element) {
        root = addHelp(root, element);
        size++;
        return true;
    }

    //helper method that removes largest element in BST
    private BinTreeElement<E> deleteMax(BinTreeElement<E> root){
        if (root.getRight() == null) return root.getLeft();
        root.setRight(deleteMax(root.getRight()));
        return root;
    }

    //helper method that returns largest element in BST
    private BinTreeElement<E> getMax(BinTreeElement<E> root){
        if (root.getRight() == null) return root;
        return getMax(root.getRight());
    }

    //helper method that removes specified element from BST
    private BinTreeElement<E> removeHelp(BinTreeElement<E> root, E element){
        if (root == null) return null;
        if (root.getValue().compareTo(element) > 0)
            root.setLeft(removeHelp(root.getLeft(), element));
        else if (root.getValue().compareTo(element) < 0)
            root.setRight(removeHelp(root.getRight(), element));
        else {
            if (root.getLeft() == null) return root.getRight();
            else if (root.getRight() == null) return root.getLeft();
            else {
                BinTreeElement<E> temp = getMax(root.getLeft());
                root.setValue(temp.getValue());
                root.setLeft(deleteMax(root.getLeft()));
            }
        }
        return root;
    }

    //searches and removes element form BST and decreases size of BST
    @Override
    public boolean remove(E element) {
        E temp = searchHelp(root, element);
        if (temp != null){
            root = removeHelp(root, element);
            size--;
        }
        return temp != null;
    }

    //returns size of BST
    @Override
    public int size() {
        return size;
    }

    //determines if size is 0
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //clears BST
    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    //helper method that searches BST for target element
    private E searchHelp(BinTreeElement<E> root, E target){
        if(root == null) return null;
        if (root.getValue().compareTo(target) > 0)
            return searchHelp(root.getLeft(), target);
        else if (root.getValue().compareTo(target) == 0)
            return root.getValue();
        else return searchHelp(root.getRight(), target);
    }

    //searches BST for target element and returns false if target is not found
    public boolean search(E target) {
        return searchHelp(root, target) != null;
    }

    //helper method that returns a string of BST in inorder traversal
    private String inorderHelp(BinTreeElement<E> root){
        if (root == null) return "";
        return (inorderHelp(root.getLeft()) + root.getValue() + "  " + inorderHelp(root.getRight()));
    }

    //returns BST string inorder
    @Override
    public String inorder() {
        return inorderHelp(root);
    }

    //helper method that returns a string of BST in postorder traversal
    private String postorderHelp(BinTreeElement<E> root){
        if (root == null) return "";
        return postorderHelp(root.getLeft()) + postorderHelp(root.getRight()) + root.getValue() + "  ";
    }

    //returns BST string postorder
    @Override
    public String postorder() {
        return postorderHelp(root);
    }

    //helper method that returns a string of BST in preorder traversal
    private String preorderHelp(BinTreeElement<E> root){
        if (root == null) return "";
        return root.getValue() + "  " + preorderHelp(root.getLeft()) + preorderHelp(root.getRight());
    }

    //returns BST string preorder
    @Override
    public String preorder() {
        return preorderHelp(root);
    }

    //helper method that returns height of BST
    private int maxDepth(BinTreeElement<E> root){
        if (root == null) return -1;
        if(root.getLeft() == null && root.getRight() == null)
            return 0;
        else {
            int dLeft = maxDepth(root.getLeft());
            int dRight = maxDepth(root.getRight());
            if (dLeft > dRight)
                return (dLeft + 1);
            else
                return (dRight + 1);
        }
    }
    //returns height
    public int height(){
        return maxDepth(root);
    }

    //helper method that determines if BST is full
    private boolean isFull(BinTreeElement<E> root){
        if (root == null) return true;
        if (root.getLeft() == null && root.getRight() == null) return true;
        if ((root.getLeft() != null) && (root.getRight() != null))
            return (isFull(root.getLeft()) && isFull(root.getRight()));
        return false;
    }

    //determines if BST if full
    public boolean isFullBST(){
        if (root == null) return false;
        return isFull(root);
    }

    //helper method that returns the number of leaves in BST
    private int getNumLeaves(BinTreeElement<E> root){
        if (root == null) return 0;
        if ((root.getLeft() == null) && (root.getRight() == null))
            return 1 + getNumLeaves(root.getLeft()) + getNumLeaves(root.getRight());
        return getNumLeaves(root.getLeft()) + getNumLeaves(root.getRight());
    }

    //returns number of leaves
    public int getNumberOfLeaves() {
       return getNumLeaves(root);

    }

    //helper method that returns number of non-leaves in BST
    private int getNumNonLeaves(BinTreeElement<E> root){
        if (isEmpty()) return 0;
        if (root == null) return 0;
        if ((root.getLeft() != null) || (root.getRight() != null))
            return 1 + getNumNonLeaves(root.getLeft()) + getNumNonLeaves(root.getRight());
        return getNumNonLeaves(root.getLeft()) + getNumNonLeaves(root.getRight());
    }

    //returns number of non-leaves
    public int getNumberOfNonLeaves(){
        return getNumNonLeaves(root);
    }

    public static void main(String[] args) {
        Bridges bridges = new Bridges(4, "CyairaHughes",
                "910423764620");
        BinSearchTree <String> names = new BinSearchTree<>();

        names.add("Frodo");

        names.add("Dori");

        names.add("Bilbo");

        names.add("Kili");

        names.add("Gandalf");

        names.add("Fili");

        names.add("Thorin");

        names.add("Nori");

        System.out.print(names.postorder());

        bridges.setTitle("Project 5 - Binary Search Tree Implementation");
        bridges.setDescription("By Cyaira Hughes");

           names.root.setLabel(names.root.getValue());
           names.root.getRight().setLabel(names.root.getRight().getValue());
           names.root.getRight().getRight().setLabel(names.root.getRight().getRight().getValue());
           names.root.getRight().getRight().getLeft().setLabel(names.root.getRight().getRight().getLeft().getValue());
           names.root.getRight().getLeft().setLabel(names.root.getRight().getLeft().getValue());
           names.root.getLeft().setLabel(names.root.getLeft().getValue());
           names.root.getLeft().getRight().setLabel(names.root.getLeft().getRight().getValue());
           names.root.getLeft().getLeft().setLabel(names.root.getLeft().getLeft().getValue());


        bridges.setDataStructure(names.root);
        try {
            bridges.visualize();
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
    }
}
