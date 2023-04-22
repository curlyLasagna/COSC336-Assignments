import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class solution {
    static class Inputs {
        private int size;
        private List<Integer> inputVal;

        Inputs(int size, List<Integer> inputVal) {
            this.size = size;
            this.inputVal = inputVal;
        }

        Inputs(Inputs o) {
            this(o.getSize(), o.getInputVal());
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public List<Integer> getInputVal() {
            return inputVal;
        }

        public void setInputVal(List<Integer> inputVal) {
            this.inputVal = inputVal;
        }
    }

    class Node {
        int item;
        int size;
        Node left, right;

        public Node(int item) {
            this.item = item;
            this.size = 1;
            left = right = null;
        }

        int select(Node root, int k) {

            // Input validation
            if (k > root.size)
                return -1;

            // Prevents NullPointerExceptions by setting null pointer size to 0
            int leftSize = root.left != null ? root.left.size : 0;
            
            if (k == leftSize + 1)
                return root.item;
             else if (k <= leftSize)
                return select(root.left, k);
            return select(root.right, k - leftSize - 1);

        }
    }

    // Root of BST
    Node root;

    // Constructor
    solution() {
        root = null;
    }

    solution(int item) {
        root = new Node(item);
    }

    void insert(int item) {
        root = insertRec(root, item);
    }

    // A recursive function to insert a new key in BST recursively
    Node insertRec(Node root, int item) {

        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(item);
            return root;
        }

        // Otherwise, recur down the tree
        else if (item <= root.item) {
            root.left = insertRec(root.left, item);
            root.size++;
        } else if (item > root.item) {
            root.right = insertRec(root.right, item);
            root.size++;
        }
        /* return the (unchanged) node pointer */
        return root;
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to recursively
    // do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("Node " + root.item + " has size: " + root.size);
            inorderRec(root.right);
        }
    }

    /**
     * Reads a text file of integers where the first line is the size of the input
     * to be evaluated Returns an Inputs object with attributes size and inputVal
     *
     * @param file A string containing the name of the text file to be read
     * @return Inputs object
     */
    static Inputs readInput(String file) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(file));
        int inputSize = Integer.parseInt(inputFile.readLine().trim());
        List<Integer> input = Stream.of(inputFile.readLine().split("\\s+")).map(Integer::parseInt).toList();
        inputFile.close();
        return new Inputs(inputSize, input);
    }

    public static void main(String[] args) throws IOException {
        List<Integer> data1 = new ArrayList<Integer>(Arrays.asList(7, 10, 3, 13, 13));
        solution tree1 = new solution();
        data1.forEach(x -> tree1.insert(x));
        
        Inputs in61 = new Inputs(readInput("./input-6.1.txt"));
        Inputs in62 = new Inputs(readInput("./input-6.2.txt"));

        solution tree2 = new solution();
        solution tree3 = new solution();

        in61.inputVal.forEach(x -> tree2.insert(x));
        in62.inputVal.forEach(x -> tree3.insert(x));
        
        System.out.println(tree1.root.select(tree1.root, (tree1.root.size / 2) + 1));
        System.out.println(tree2.root.select(tree2.root, (tree2.root.size / 2) + 1));
        System.out.println(tree3.root.select(tree3.root, (tree3.root.size / 2) + 1));
    }

}
