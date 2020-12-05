package solveDouble;
import java.util.LinkedList;
import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;


class KWLinkedList<E> extends AbstractSequentialList<E> {
    // Data Fields

    public Node<E> head = null;
    /** A reference to the end of the list. */
    public Node<E> tail = null;
    /** The size of the list. */
    public int size = 0;

    /**
     * Insert an object at the beginning of the list.
     * @param item - the item to be added
     */
    public void addFirst(E item) {
        Node obj = new Node(item);
        if(head != null)
        {
            obj.next = head;
            head.prev = obj;
            head = obj;
        } else {
            head = obj;
            tail = obj;
        }
        size++;
    }

    /**
     * Insert an object at the end of the list.
     * @param  - the item to be added
     */
    public void addLast(E i) {
        Node item = new Node(i);
        if(tail != null) {
            item.prev = tail;
            tail.next = item;
            tail = item;
        } else {
            head = item;
            tail = item;
        }
        size++;
    }

    /**
     * Get the first element in the list.
     * @return The first element in the list.
     */
    public E getFirst() {
        return head.data;
    }

    /**
     * Get the last element in the list.
     * @return The last element in the list.
     */
    public E getLast() {
        return tail.data;
    }
    /*</exercise>*/

    /*<exercise chapter="2" section="8" type="programming" number="3">*/
    /**
     * Return an Iterator to the list
     * @return an Itertor to the list
     */
    public Iterator<E> iterator() {
        KWListIter iterator = new KWListIter(0);
        return iterator;
    }

    /**
     * Return a ListIterator to the list
     * @return a ListItertor to the list
     */
    public ListIterator<E> listIterator() {
        KWListIter iterator = new KWListIter(0);
        return iterator;
    }

    /** Return a ListIterator that begins at index
     * @param index - The position the iteration is to begin
     * @return a ListIterator that begins at index
     */
    public ListIterator<E> listIterator(int index) {
        KWListIter iterator = new KWListIter(index);
        return iterator;
    }

    /**
     * Return a ListIterator that begins at the same
     * place as an existing ListIterator
     * @param iter - The other ListIterator
     * @return a ListIterator that is a copy of iter
     */
    public ListIterator <E> listIterator(ListIterator <E> iter) {
        KWListIter iterator = new KWListIter((KWListIter)iter);
        return iterator;
    }
    /*</exercise>*/
    /**
     * Add an item at the specified index.
     * @param index The index at which the object is to be
     *        inserted
     * @param obj The object to be inserted
     * @throws IndexOutOfBoundsException if the index is out
     *         of range (i < 0 || i > size())
     */
    @Override
    public void add(int index, E obj) {
        listIterator(index).add(obj);
    }

    /**
     * Get the element at position index.
     * @param index Position of item to be retrieved
     * @return The item at index
     */
    @Override
    public E get(int index) {
        return listIterator(index).next();
    }

    /**
     * Return the size of the list
     * @return the size of the list
     */
    @Override
    public int size() {
        return size;
    }

    // Inner Classes
    /**
     * A Node is the building block for a double-linked list.
     */
    private static class Node<E> {

        /** The data value. */
        public E data;
        /** The link to the next node. */
        public Node<E> next = null;
        /** The link to the previous node. */
        public Node<E> prev = null;

        /**
         * Construct a node with the given data value.
         * @param dataItem The data value
         */
        private Node(E dataItem) {
            data = dataItem;
        }

        public String getData() {
            if(data == null)
                return "null";
            else
                return (String)data;
        }
    } //end class Node

    /** Inner class to implement the ListIterator interface. */
    private class KWListIter implements ListIterator<E> {

        /** A reference to the next item. */
        private Node<E> nextItem;
        /** A reference to the last item returned. */
        private Node<E> lastItemReturned;
        /** The index of the current item. */
        private int index = 0;

        /**
         * Construct a KWListIter that will reference the ith item.
         * @param i The index of the item to be referenced
         */
        public KWListIter(int i) {
            // Validate i parameter.
            if (i < 0 || i > size) {
                throw new IndexOutOfBoundsException(
                        "Invalid index " + i);
            }
            lastItemReturned = null; // No item returned yet.
            // Special case of last item.
            if (i == size) {
                index = size;
                nextItem = null;
            } else { // Start at the beginning
                nextItem = head;
                for (index = 0; index < i; index++) {
                    nextItem = nextItem.next;
                }
            }
        }

        /**
         * Construct a KWListIter that is a copy of another KWListIter
         * @param other The other KWListIter
         */
        public KWListIter(KWListIter other) {
            KWListIter itr = new KWListIter(0);
            itr.index = other.index;
            itr.lastItemReturned = other.lastItemReturned;
            itr.nextItem = other.nextItem;
        }

        /**
         * Indicate whether movement forward is defined.
         * @return true if call to next will not throw an exception
         */
        @Override
        public boolean hasNext() {
            return nextItem != null;
        }

        /** Move the iterator forward and return the next item.
         @return The next item in the list
         @throws NoSuchElementException if there is no such object
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        /**
         * Indicate whether movement backward is defined.
         * @return true if call to previous will not throw an exception
         */
        @Override
        public boolean hasPrevious() {
            return (nextItem == null && size != 0)
                    || nextItem.prev != null;
        }

        /**
         * Return the index of the next item to be returned by next
         * @return the index of the next item to be returned by next
         */
        @Override
        public int nextIndex() {
            return index;
        }

        /**
         * Return the index of the next item to be returned by previous
         * @return the index of the next item to be returned by previous
         */
        @Override
        public int previousIndex() {
            return index - 1;
        }

        /**
         * Move the iterator backward and return the previous item.
         * @return The previous item in the list
         * @throws NoSuchElementException if there is no such object
         */
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            if (nextItem == null) { // Iterator past the last element
                nextItem = tail;
            } else {
                nextItem = nextItem.prev;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        /**
         * Add a new item between the item that will be returned
         * by next and the item that will be returned by previous.
         * If previous is called after add, the element added is
         * returned.
         * @param obj The item to be inserted
         */
        @Override
        public void add(E obj) {
            if (head == null) { // Add to an empty list.
                head = new Node<E>(obj);
                tail = head;

            } else if (nextItem == head) { // Insert at head.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 1
                // Link nextItem to the new node.
                nextItem.prev = newNode; // Step 2
                // The new node is now the head.
                head = newNode; // Step 3

            } else if (nextItem == null) { // Insert at tail.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link the tail to the new node.
                tail.next = newNode; // Step 1
                // Link the new node to the tail.
                newNode.prev = tail; // Step 2
                // The new node is the new tail.
                tail = newNode; // Step 3

            } else { // Insert into the middle.
                // Create a new node.
                Node<E> newNode = new Node<E>(obj);
                // Link it to nextItem.prev.
                newNode.prev = nextItem.prev; // Step 1
                nextItem.prev.next = newNode; // Step 2
                // Link it to the nextItem.
                newNode.next = nextItem; // Step 3
                nextItem.prev = newNode; // Step 4

            }
            // Increase size and index and set lastItemReturned.
            size++;
            index++;
            lastItemReturned = null;
        } // End of method add.

        /*<exercise chapter="2" section="8" type="programming" number="1">*/
        /** Remove the last item returned. This can only be
         *  done once per call to next or previous.
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        @Override
        public void remove() {

            lastItemReturned.prev.next = lastItemReturned.next;
            lastItemReturned.next.prev = lastItemReturned.prev;
        }
        /*</exercise>*/

        /*<exercise chapter="2" section="8" type="programming" number="2">*/
        /** Replace the last item returned with a new value
         *  @param item The new value
         *  @throws IllegalStateException if next or previous
         *  was not called prior to calling this method
         */
        @Override
        public void set(E item) {
            lastItemReturned.data = item;
        }
        /*</exercise>*/
    } //end class KWListIter

    /*<exercise chapter="2" section="7" type="programming" number="1">*/
    /**
     * Method to find the index of the first occurence of an item in the list
     * @param target The item being sought
     * @return The index of the first occurence of the tartet item
     *         or -1 if the item is not found.
     */
    @Override
    public int indexOf(Object target) {
        return -1;
    }
    /*</exercise>*/

    /*<exercise chapter="2" section="7" type="programming" number="2">*/
    /**
     * Method to find the index of the last occurence of an item in the list
     * @param target The item being sought
     * @return The index of the last occurence of the tartet item
     *         or -1 if the item is not found.
     */
    @Override
    public int lastIndexOf(Object target) {
        return -1;
    }
    /*</exercise>*/

    /*<exercise chapter="2" section="7" type="programming" number="3">*/
    /**
     * Method to return the index of the minimum item in the list
     * It is assumed that each item in the list implements Comparable
     * @return Index of the minimum item in the list
     *         or -1 if the list is empty
     * @throws  if the list elements do not implement Comparable
     */
    public int indexOfMin() {
        return 0;
    }
    public String toString ()
    {
        String str = "";
        Node nodeRef = head;
        for (int i = 0; i < size&& nodeRef!= null; i++) {
            str = str + nodeRef.data + "\t";
            nodeRef = nodeRef.next;}
        return str;
    }
    //Question 2 Write a method called removeWithCondition to be included in the class KWLinkedList that accepts two parameters item and pItem of type E. The method deletes the node having its data as item, if preceded by a node having its data as pItem, and returns true. If not found then it returns false.
    //The method heading is
    //
   public boolean removeWithCondition(E item, E pitem){
        Node temp= head;
        while(temp!= null){
            Node pre= temp.prev;
            if(temp.data.equals(item)&& pre.data.equals(pitem)){
                //remove(item);
                Node preNode =temp.prev;
                Node nextNode=temp.next;
                nextNode.prev=temp.prev;
                preNode.next=temp.next;
                size--;

                return true;
            }
            else
            {
                temp=temp.next;

            }
        }
        return false;
   }

   //Question1 Write a method called findAll to be included in
   // class KWLinkedList that finds all nodes in
   // “this” list with their data values less than item,
   // passed as the first parameter and inserts these values in a new linked list,
   // called list2 passed as the second parameter to the method.
    //If “this” list is empty or no values less than item exists in the list
   // , then the method returns false, otherwise it returns true.
   // Assume that list2 is initially empty.
    //Method method:
    public  boolean findAll(E  item, KWLinkedList<E>  list2){
        Node temp = head;
        int countLess=0;
        while(temp !=null){

            int result= ((Comparable)temp.data).compareTo(item);

           if(result < 0){

                //list2.add((E)temp.data);
               Node newNode = new Node(temp.data);
               if(list2.head == null){
                   list2.head=newNode;
                   list2.tail=newNode;
               }
               else {
                   newNode.prev=list2.tail;
                   list2.tail.next=newNode;
                   list2.tail=newNode;

               }
               list2.size++;
                countLess++;
            }//if

            temp=temp.next;
        }
     return countLess!=0 ;
    }

    //Question 4 Write a method called isPalindrome to be included
    // in class KWLinkedList to determine whether
    // the data field of nodes forms a palindrome.
    // If it is palindrome, the method should return true,
    // else return false. Write one solution using listIterator
    // and write another solution without using any iterator.
    //
    //Examples: M A D A M,                     R   A   C   E   C   A   R
    public boolean isPalindromelistIterator(){
        ListIterator fordwardIter = this.listIterator();
        ListIterator backwardIter = this.listIterator(size);
        int center =size/2, count=0;


        while(fordwardIter.hasNext()&&fordwardIter.nextIndex() < center ){
            if(fordwardIter.next() == backwardIter.previous()
                    ){
                count++;
            }//if
        }
        System.out.println("count = "+count);
        return count == center;
    }

    public boolean isPalindrome(){
        Node fordWard = head;
        Node backWard = tail;
        int count=0;
        for(int i =0 ; i < size/2 && fordWard !=null && backWard!= null; i++){
            if(fordWard.data.equals(backWard.data))
                count++;
            /////////////update//////////

            fordWard =fordWard.next;
            backWard =backWard.prev;
        }

        System.out.println(count);
        return  count == size/2;
    }

    //Question 3 Write a method called reverseNodes to be included in class
    // KWLinkedList which reverses the nodes of a doubly linked list.
    // Do not allocate any new memory space (node),
    // use the nodes of the existing list.
    // Write the method by swapping the data field of the nodes.
    // Write one solution using listIterator and
    // write another solution without using any iterator.
    //Solution 1 (using ListIterator)     25   20    15    5    10
    // 10   5    15    20    25
     public void reverseNodesIter(){
        ListIterator forwardIter = this.listIterator();
         ListIterator backwardIter = this.listIterator(size);
     E itemForward=null,itemBackward=null;
     for(int i=0; i < size/2 && forwardIter.hasNext() ; i++){
         itemForward = (E)forwardIter.next();
         itemBackward = (E)backwardIter.previous();
         forwardIter.set(itemBackward);
         backwardIter.set(itemForward);
     }


     }

    public void reverseNodes(){
        E itemForward=null,itemBackward=null;
        Node<E> forward = head,reverse = tail;

        for(int i=0; i < size/2 ; i++){
            itemForward = forward.data;
            itemBackward = reverse.data;

            forward.data = itemBackward;
            reverse.data = itemForward;

            forward= forward.next;
            reverse=reverse.prev;


        }//for




    }
}
/*</listing>*/