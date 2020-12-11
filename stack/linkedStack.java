package stack;

import java.util.NoSuchElementException;

public class linkedStack<E> {

    /** Node: inner class to create nodes for linked list based stack. */
    private static class Node<E>
    {
        // Data Fields
        private E data;
        private Node<E> next;  // The reference to the next node.

        // Constructors
        /**
         * Creates a new node with a null next field.
         * @param dataItem The data to be stored in the node
         */
        private Node(E dataItem)
        {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data to be stored in the node
         * @param nodeRef  The node referenced by new node
         */
        private Node(E dataItem, Node<E> nodeRef)
        {
            data = dataItem;
            next = nodeRef;
        }
    } //End of class Node

    // Data Field: The reference to the first node of the stack.
    private Node<E> topOfStack;
    private int size;

    public linkedStack(){
        topOfStack=null;
        size=0;
    }

    public E push(E obj){
        topOfStack=new Node(obj,topOfStack);
        size++;
        return obj;
    }
    public E pop(){
        if (isEmpty())
            throw new NoSuchElementException();
        E result = topOfStack.data;
        topOfStack= topOfStack.next;
        size--;
        return result;

        }

        public E peek(){
            if (isEmpty())
                throw new NoSuchElementException();
            return topOfStack.data;

        }

    public boolean isEmpty(){ return topOfStack == null;}
    public int getSize(){return size;}


}
