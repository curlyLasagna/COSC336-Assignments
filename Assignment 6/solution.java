import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class solution {
    // Java program to demonstrate
    // insert operation in binary
    // search tree
    class BinarySearchTree {

        int select(Node x, int k) {
            // if (x.key == )

            return 0;
        }

        // Class containing left and right child of current node and key value
        class Node {
            int key, size;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        // Root of BST
        Node root;

        // Constructor
        BinarySearchTree() {
            root = null;
        }

        BinarySearchTree(int value) {
            root = new Node(value);
        }

        void insert(int key) {
            root = insertRec(root, key);
        }

        // A recursive function to insert a new key in BST
        Node insertRec(Node root, int key) {

            // If the tree is empty, return a new node
            if (root == null) {
                root = new Node(key);
                return root;
            }

            /* Otherwise, recur down the tree */
            else if (key < root.key)
                root.left = insertRec(root.left, key);
            else if (key > root.key)
                root.right = insertRec(root.right, key);

            /* return the (unchanged) node pointer */
            return root;
        }

        // This method mainly calls InorderRec()
        void inorder() {
            inorderRec(root);
        }

        // A utility function to
        // do inorder traversal of BST
        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                System.out.println(root.key);
                inorderRec(root.right);
            }
        }

    }

    public static void main(String[] args) {
        List<Integer> data1 = new ArrayList<Integer>(Arrays.asList(7, 10, 3, 13, 13));
    }
}
