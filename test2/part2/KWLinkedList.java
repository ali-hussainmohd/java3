package test2;


import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class KWLinkedList<E>
{  // Data fields
    private Node<E> head = null;   // points to the head of the list
    private Node<E> tail = null;   //points to the tail of the list
    private int size = 0;    // the number of items in the list

    public void add(int index, E obj)
    {  ListIterator<E> iter = listIterator(index);
        iter.add(obj);
    }

    public void add( E obj)
    {  ListIterator<E> iter = listIterator(size);
        iter.add(obj);
    }
    public void addFirst(E obj) { add(0, obj);  }
    public void addLast(E obj) { add(size, obj);  }

    public E get(int index)
    { ListIterator<E> iter = listIterator(index);
        return iter.next();
    }
    public E getFirst() { return head.data;  }
    public E getLast() { return tail.data;  }

    public int size() {  return size;  }

    public E remove(int index)
    {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
    }

    public Iterator iterator() { return new KWListIter(0);  }
    public ListIterator listIterator() { return new KWListIter(0);  }
    public ListIterator listIterator(int index){return new KWListIter(index);}
    public ListIterator listIterator(ListIterator iter)
    {     return new KWListIter( (KWListIter) iter);  }

    // Inner Classes
    private static class Node<E>
    {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
        private Node(E dataItem,Node next)  //constructor
        {   data = dataItem;
            this.next=next;
        }

    }  // end class Node

    public class KWListIter implements ListIterator<E>
    {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   //

        public KWListIter(int i)  // constructor for KWListIter class
        {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
            lastItemReturned = null;

            if (i == size)     // Special case of last item
            {     index = size;     nextItem = null;      }
            else          // start at the beginning
            {   nextItem = head;
                for (index = 0; index < i; index++)  nextItem = nextItem.next;
            }// end else
        }  // end constructor

        public KWListIter(KWListIter other)
        {   nextItem = other.nextItem;
            index = other.index;    }

        public boolean hasNext() {   return nextItem != null;    }
        public boolean hasPrevious()
        {   return (nextItem == null && size != 0) || nextItem.prev != null;   }
        public int previousIndex() {  return index - 1;    }
        public int nextIndex() {  return index;    }
        public void set(E item)  { lastItemReturned.data = item; }  // not implemented
        public void remove(){
            lastItemReturned.prev.next = lastItemReturned.next;
            lastItemReturned.next.prev = lastItemReturned.prev;}      // not implemented

        public E next()
        {   if (!hasNext()) {  throw new NoSuchElementException();   }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        public E previous()
        {   if (!hasPrevious()) {   throw new NoSuchElementException();   }
            if (nextItem == null) { nextItem = tail;  }
            else {  nextItem = nextItem.prev;  }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }

        public void add(E obj)
        {   if (head == null)     // add to an empty list
        {   head = new Node(obj);
            tail = head;
        }
        else if (nextItem == head)  // insert at head
        {   Node newNode = new Node(obj);    // Create a new node
            newNode.next = nextItem; // link it to the nextItem
            nextItem.prev = newNode;  // link nextItem to the new node
            head = newNode; // The new node is now the head
        }
        else if (nextItem == null) // insert at tail
        {     Node newNode = new Node(obj);// Create a new node
            tail.next = newNode; // Link the tail to the new node
            newNode.prev = tail;      // Link the new node to the tail
            tail = newNode; // The new node is the new tail
        }
        else      // insert into the middle
        {     Node newNode = new Node(obj);
            newNode.prev = nextItem.prev; // Link it to nextItem.prev
            nextItem.prev.next = newNode;  // Link it to the nextItem
            newNode.next = nextItem;
            nextItem.prev = newNode;
        }
            // Increase size and index
            size++;      index++;
        } // end of method add

    }// end of inner class KWListIter
//###################################close inner class KWListIter###################################################
        //EXTRA FROM ME
        // Return reference to the node with the specified index
        private Node<E> getNode(int index)
        {
            Node<E> node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.next;
            }
            return node;
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



        // Method to insert a new node after the node referenced by node
        private void addAfter (Node<E> node, E item)
        {
            Node<E> temp = new Node<E>(item);
            node.next = temp;
            size++;
        }


        // Method to insert a new item at the specified index in the list






    ///////////////////////////////////////////////////////
    //SOLUTIONS
    //METHOD_one

    public boolean replaceTheCorrespondingIndex(KWLinkedList<Character> mylistB, E newitem){
        int i;
        for(i=0;i<mylistB.size();i++)
        {
            if(mylistB.get(i)=='y')
            {
                this.set(i,newitem);
                return true;
            }
        }
//If character not found then returning false
        return false;
    }

    //METHOD_two

    public boolean insertAfterNextIndex(E itemA, E itemB){

        {
            int i;

            for(i=0;i<size();i++)
            {
                if(itemA==get(i))
                {
                    this.add(i+1,itemB);
                    return true;
                }
            }
            return false;
        }
    }
        public boolean isEmpty(){return head == null;}
    //Question 1 [8 + 8 Marks]
    //(A)	[8 Marks] Write a method called insertSorted to
    // be included in class LinkedList that accepts a parameter
    // item of type E. Assume that the list is sorted in ascending order.
    // The method will insert a new
    // node in the list containing item as data in such
    // a way that after insertion also the list remains sorted.
    // Consider all possible cases in your method, including empty list.
    //Do not call any method of class LinkedList in your method.
    //      Example :
    //Before run:
    //                    head
    //   list:     5    10     20    30     35     50
    // item =   25       	After run:
    //                    head
    //   list:     5    10     20    25   30     35     50
    //
    //
    //Method heading:
     public boolean insertSorted(E item){
        Node temp = head;
        if(isEmpty())
            return false;
        while(temp!=null){

            if(   (  (Comparable)temp.data  ).compareTo(item) >0      ){
               // Node itemNode = new Node(item,temp);
                Node itemNode = new Node(item);

                itemNode.next=temp;
                itemNode.prev=temp.prev;

                temp.prev.next=itemNode;
                temp.prev=itemNode;


                size++;
                return true;
            }
            else
            {
                temp=temp.next;
            }
        }
        return  false;
     }

     //(B)	[8 Marks] Write a method called deleteMultipleNodes
    // to be included in the class KWLinkedList (class for doubly linked list).
    // The method has two parameters count of type int and direction of type char.
    // The count is the number of nodes to be deleted in the specified direction.
    // The direction can be either ‘f’ or ‘b’.
    // The method returns false, if the list is empty
    // or the number of nodes in the list is less than count.
    // The method checks the direction, if direction is ‘f’,
    // the method removes count number of nodes in the forward direction,
    // otherwise, the method removes count number of nodes in the backward direction,
    // and returns true.
    //NOTE: You can use ListIterator and its methods.
    //      Example 1:
    //Before run:
    //                    head                                    tail
    //   list:     20    50     70    90     33     89
    // count: 2       direction: ’f’	After run:
    //                    head                  tail
    //   list:     70    90     33     89
    //
    //      Example 2:
    //Before run:
    //                    head                                    tail
    //   list:     20    50     70    90     33     89
    // count: 2       direction: ’b’	After run:
    //                    head                 tail
    //   list:     20    50     70    90
    //
    //
    //Method heading:
    public boolean deleteMultipleNodes(int count, char direction)
    {
        if(isEmpty() || count > size-1)
            return false;

        switch (direction){
            case 'F':
            case 'f':
                for(int i = 0; i <count; i++){
                    head=head.next;
                    head.prev=null;
                    size--;
                }

                return true;
            case 'B':
            case 'b':
                for(int i = 0; i <count; i++){
                    tail=tail.prev;
                    tail.next=null;
                    size--;
                }
                return true;
                default:
                    System.out.println("the letter be enter undefined");
        }
        return false;
    }
    public void question()
    {

        if (size%2== 0 || size < 3)
            return;
        Node<E> h = head;
        for(int i = 0; i <= size/2; i++)
            h=h.next;
        System.out.println("center = "+size/2);
        System.out.println("h.data = "+h.data);
        Node<E> p = head;
        while (h!= null)
    {
        System.out.printf("! p.data.equals(h.data) %b p.data = %d h.data = %d\n"
                ,(!p.data.equals(h.data)),p.data,h.data);
        if (! p.data.equals(h.data))
            return;
        {
            p = p.next;
            h = h.next;
        }
    }

        System.out.println("tail.prev = "+tail.prev.data);
        Node<E> t = tail.prev;
        t.next = null;
        tail = t;
        System.out.println("tail ="+ tail.data);
        size--;
    }

    public E function()
    {
        tail.prev.next = null;
        Node<E> temp = tail;
        tail = temp.prev;
        size--;
        return temp.data;
    }

    public void question (E item, E item1)
    {
        ListIterator<E> iter = listIterator();
        while(iter.hasNext())
    {
        if (iter.next().equals (item))
        {
            iter.remove();
            iter.add(item1);
        }
    }//while
    }

}// end of class KWLinnkedList

