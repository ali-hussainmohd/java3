package Final;

import java.util.Random;

public class Binarytree <E> {


    /**
     * Inner class to encapsulate a tree node.
     *
     * @param <E> The element type
     */
    protected static class Node<E> {
        public E data;            // The information stored in this node.
        public Node<E> left;     //Reference to the left child
        public Node<E> right;    //Reference to the right child.

        // Constructors

        /**
         * Construct a node with given data and no child nodes.
         *
         * @param data The data to store in this node
         */
        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }

        /**
         * Returns a string representation of the node.
         *
         * @return A string representation of the data fields
         */
        @Override
        public String toString() {
            return data.toString();
        }
    } // end class Node

    // data field
    protected Node<E> root;    //The root of the binary tree

    /**
     * Construct an empty Binarytree
     */
    public Binarytree() {
        root = null;
    }

    /**
     * Construct a Binarytree with a specified root. Should only be used
     * by other methods of this class and subclasses.
     *
     * @param root The node that is the root of the tree.
     */
    protected Binarytree(Node<E> root) {
        this.root = root;
    }

    /**
     * Constructs a new binary tree with data in its root, leftTree as its
     * left subtree and rightTree as its right subtree.
     * Can be used to create a binary tree from two given binary trees.
     *
     * @param data      The data item to store in the root
     * @param leftTree  the left sub-tree
     * @param rightTree the right-subtree
     */
    public Binarytree(E data, Binarytree<E> leftTree,
                      Binarytree<E> rightTree) {
        root = new Node(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Return the left subtree of the given tree.
     *
     * @return The left subtree or null if either the root or the left
     * subtree is null
     */
    public Binarytree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new Binarytree<E>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Return the right sub-tree
     *
     * @return the right sub-tree or null if either the root or the right
     * subtree is null.
     */
    public Binarytree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new Binarytree<E>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Return the data field of the root
     *
     * @return the data field of the root or null if the root is null
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Determine whether this tree (or sub tree) is a leaf.
     *
     * @return true if the root has no child node
     */
    public boolean isLeaf() {
        return (root != null && (root.left == null && root.right == null));
    }

    /**
     * Starter method for preorder traversal: public method to call
     * the private recursive method preOrder
     */
    public void preOrderTraverse() {
        preOrder(root);
    }

    /**
     * Performs a recursive pre-order traversal of the tree,
     * whose root is at node. Can be called only within the class.
     *
     * @param node The local root
     */
    private void preOrder(Node<E> node) {
        if (node == null) {
            return;
        } else {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * Starter method for post-order traversal: public method to call
     * the private recursive method postOrder
     */
    public void postOrderTraverse() {
        postOrder(root);
    }

    /**
     * Performs a recursive post-order traversal of the tree,
     * whose root is at node. Can be called only within the class.
     *
     * @param node The local root
     */
    private void postOrder(Node<E> node) {
        if (node == null) {
            return;
        } else {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    /**
     * Starter method for in-order traversal: public method to call
     * the private recursive method inOrder.
     */
    public void inOrderTraverse() {
        inOrder(root);
    }

    /**
     * Performs a recursive in-order traversal of the tree,
     * whose root is at node. Can be called only within the class.
     *
     * @param node The local root
     */
    private void inOrder(Node<E> node) {
        if (node == null) {
            return;
        } else {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    /**
     * Starter method for height of the binary tree.
     */
    public int treeHeight() {
        return height(root);
    }

    /**
     * Finds the height of a binary tree recursively,
     * whose root is at node
     *
     * @param node The local root
     * @return Returns the height of the binary tree
     **/
    private int height(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            return (1 + max(height(node.left), height(node.right)));
        }
    }

    /**
     * Private method to compare two integers, called from method
     * height
     *
     * @param x First integer to compare
     * @param y Second integer to compare
     * @return Returns the maximum of x and y
     **/
    private int max(int x, int y) {
        if (x >= y) return x;
        else return y;
    }

    /**
     * Starter method for nodeCount of the binary tree.
     */
    public int treeNodeCount() {
        return nodeCount(root);
    }

    /**
     * Finds the number of nodes in a binary tree recursively,
     * whose root is at node
     *
     * @param node The local root
     * @return Returns the number of nodes in the binary tree
     */
    private int nodeCount(Node<E> node) {
        if (node == null)
            return 0;
        else {
            return (1 + nodeCount(node.left) + nodeCount(node.right));
        }
    }

    /**
     * Inserts a new node as a leaf node in a binary tree. Can be used
     * to create a binary tree.
     * The new node is inserted randomly anywhere in a binary tree
     * @param item The data item of the node to be inserted.
     * */

    public void insertNode(E item)  {
        Node<E> node = new Node<E>(item); // create a new node
        Node<E> parent=null, current;
        int randNum=0;
        Random rand = new Random(); //random number generator
        if (root == null)
            root = node;
        else {
            current = root;
            while (current != null) {
                parent = current;
                randNum = rand.nextInt(2); //generate a random number
                // having value 0 or 1
                if (randNum == 0)
                    current = current.left;
                else
                    current = current.right;
            }
            // link new node here as a leaf node
            if (randNum == 0)
                parent.left = node;
            else
                parent.right = node;
        } //end insert
    }



}