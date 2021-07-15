public class SingleLinkedList<E>
{


    /** private inner class */
    private static class Node<E>
    {
        private E data;
        private Node<E> next;
        /** Creates a new node with a null next field
         @param dataItem  The data stored
         */
        private Node(E dataItem)
        {
            data = dataItem;
            next = null;
        }
        private Node(E dataItem,Node next)
        {
            data = dataItem;
            this.next =next ;
        }

    } //end class Node


    private Node<E> head;
    private int size;

    // constructor – SingleLinkedList
    public SingleLinkedList()
    {
        // initially empty list
        head = null;
        size = 0;
    }


    // Method to insert a new node at front of the list
    private void addFirst (E item)
    {
        Node<E> temp = new Node<E>(item); // create a new node
        // and link to the first node
        head = temp;
        size++;
    }

    // Method to insert a new node after the node referenced by node
    private void addAfter (Node<E> node, E item)
    {
        Node<E> temp = new Node<E>(item,node.next);
        node.next = temp;
        size++;
    }

    // Return reference to the node with the specified index
    private Node<E> getNode(int index)
    {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    // Method to insert a new item at the specified index in the list
    public void add (int index, E item)
    {
        if (index < 0 || index > size) {
            throw new
                    IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0)
            addFirst(item);
        else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    // Method to insert a new item (node) at the end of the list
    public boolean add (E item)
    {
        add(size, item); // calling public method add
        return true;
    }


    // Method to delete the node after the node referenced by node
    private E removeAfter (Node<E> node)
    {   //node is the previous node
        Node<E> temp = node.next;
        if (temp != null) {
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else
            return null;
    }

    // Method to delete the first node
    private E removeFirst ()
    {
        Node<E> temp = head;
        if (head != null) {
            head = head.next;
            size--;
            return temp.data;
        }
        else
            return null;
    }

    // Remove the node at the given index and return its data
    public E remove (int index)
    {  E item;
        if (index < 0 || index >= size) {
            throw new
                    IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0)
            item = removeFirst( );
        else {
            Node<E> node = getNode(index - 1);
             item = removeAfter(node);
        }
        return item; // return the deleted value
    }

    // Method to search an item in the list. If found, return its location,
    // else return -1. It is assumed that the class of item implements
    // equals method. The method finds the first occurrence of item in
    // the list.
    public int indexOf(E item) {
        int index = 0;
        Node<E> node = head;
        while (node != null) {
            if (item.equals(node.data))
                return index;
            else {
                node = node.next;
                index++;
            }
        }
            return -1; // item not found
        }


        // Method to remove the first occurrence of the item from the list,
        // if present and return true, else return false
        public boolean remove (E item)
        {
            int index = indexOf(item);
            if (index != -1) {
                remove(index);  // remove node at the index
                return true;        // item found
            } else
                return false;  // item not found
        }

        // Return String representation of the list
        public String toString ()
        {
            String str = "";
            Node nodeRef = head;
            for (int i = 0; i < size&& nodeRef!= null; i++) {
                str = str + nodeRef.data + "\n";
                nodeRef = nodeRef.next;}
                return str;
            }

            // Method to check whether the list is empty
            public boolean isEmpty()
            {
                return head == null;
            }

            // Return actual number of elements (nodes) in the list
            public int size ()
            {
                return size;
            }

            // Return the object at the specified index
            public E get ( int index)
            {
                if (index < 0 || index >= size) {
                    throw new
                            IndexOutOfBoundsException(Integer.toString(index));
                }
                Node<E> node = getNode(index);
                return node.data;
            }

            // Replace the element at the specified index by the new value
            // anEntry and return the old value
            public E set ( int index, E anEntry)
            {
                if (index < 0 || index >= size)
                    throw new IndexOutOfBoundsException(Integer.toString(index));

                Node<E> node = getNode(index); // calling private method
                E result = node.data;
                node.data = anEntry;
                return result;
            }


            // Method to check whether an object is in the list. If found, return
            // true, else return false.
            public boolean contains (E item)
            {
                int index = indexOf(item);
                if (index != -1)
                    return true;    // item found
                else
                    return false;  // item not found
            }

            // Method to delete all nodes from the list and make it empty
            public void clear ()
            {

                while (head != null) {
                    head.data = null;
                    head = head.next;
                }
                size = 0;
            }

            public boolean insertSorted(E item){
        if(isEmpty())
            return false;
                Node node = head;
                int index=0;
                while(node != null){
                    if(((Comparable)(node.data)).compareTo(item)>0 ){
                        Node dataNode = new Node(item);
                        Node temp = head;
                        for(int i=0;i < index-1 && temp != null;i++)
                            temp=temp.next;
                        temp.next=dataNode;
                        dataNode.next=node;
                        size++;
                        return true;
                    }
                    node = node.next;
                    index++;
            }//while
                return false;
            }//insertSorted




        } // end SingleListList class








