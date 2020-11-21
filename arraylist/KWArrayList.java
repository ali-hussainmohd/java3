import java.util.Arrays;

/** This class implements some methods of the Java ArrayList class */
public class KWArrayList<E>
{
    private static final int INITIAL_CAPACITY = 10; // The default initial capacity
    private E[] theData; // array
    private int size; // actual number of elements in the array
    private int capacity; // array capacity

    //default constructor
    @SuppressWarnings("unchecked")
    public KWArrayList()
    {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity]; // memory allocation
        size = 0; // initially empty
    }

    // constructor with capacity
    @SuppressWarnings("unchecked")
    public KWArrayList(int cap)
    {
        capacity = cap;
        theData = (E[]) new Object[capacity]; // memory allocation
        size = 0; // initially empty
    }

    // Return actual number of elements in the list
    public int size( )
    {
        return size;
    }

    // Check whether list is empty or not
    public boolean isEmpty( )
    {
        return (size == 0);
    }

    // Create a new array that is twice the capacity of the current array and
    // then copy the contents of the new array
    private void reallocate ()
    {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }

    // Method to insert a new element at the end of the list
    public boolean add (E anEntry)
    {
        if (size >= capacity)  // Make sure there is space to add new item
            reallocate();
        theData[size] = anEntry; // insert item
        size++;
        return true;
    }

    // Method to insert a new element at the specified index in the list
    public void add (int index, E anEntry)
    {
        // check validity of index
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size >= capacity) // Make sure there is space to add new item
            reallocate();
        // shift data in the array to make space for the new item
        for (int i = size; i > index; i--) {
            theData[i] = theData[i-1];
        }
        theData[index] = anEntry; // insert item
        size++;
    }

    // Return the object at the specified index
    public E get (int index)
    {
// check validity of index
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    // Replace the element at the specified index by the newValue and return
    // the old value
    public E set (int index, E newValue)
    {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    // Remove the element at the given index and return it
    public E remove (int index)
    {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        // shift data in the array to delete element
        for (int i = index + 1; i < size; i++) {
            theData[i-1] = theData[i];
        }
        size--;
        return returnValue;
    }

    // Method to search an object in the list. If found, return its location,
    // else return -1. It is assumed that the class of obj implements equals
    // method. The method finds the first occurrence of obj in the list.
    public int indexOf(E obj)
    {
        int index = -1;
        for(int i = 0; i < size; i++)
            if ( obj.equals(theData[i]) ){
                index = i;
                break;
            }
        return index;
    }

    // Method to remove the first occurrence of the object from the list,
    // if present and return true, else return false
    public boolean remove (E obj)
    {
        int index = indexOf(obj);
        if (index != -1) {
            remove(index);  // remove element at the index
            return true;        // obj found
        }
        else
            return false;  // obj not found
    }

    // Method to check whether an object is in the list. If found, return true,
    // else return false. It is assumed that the class of obj implements equals
    // method
    public boolean contains(E obj)
    {
        for(int i = 0; i < size; i++) {
            if ( obj.equals(theData[i]) )
                return true;
        }
        return false;
    }

    // Method to delete all objects from the list and bring it to empty state
    public void clear( ) {
        for (int i = 0; i < size; i++) {
            theData[i] = null;

        }
        size = 0;
    }

        // Return String representation of the list
        public String toString( )
        {
            String str = "";
            for(int i = 0; i < size; i++)
                str = str + theData[i] + "\t";
            return str;
        }
    public boolean removeAll(E obj){
        boolean check=false;
        for(int i = 0; i < size; i++){ //go through elements
            if(theData[i].equals(obj)){ // check smailer data
               // remove(obj); // remove the data
                //////////////////////////////////////////////
                if (i < 0 || i >= size) {
                    throw new ArrayIndexOutOfBoundsException(i);
                }
                // shift data in the array to delete element
                for (int j = i + 1; j < size; j++) {
                    theData[j-1] = theData[j];
                }
                size--;
                //////////////////////////////////////////////
                check=true; // update stauts
                i--; // return back one step
            }//if

        }//loop

        return check;
    }//removeAll
                                       //obj of class
    public boolean equals (KWArrayList recevedlist){

        int count =0;
        boolean check = false;
        for(int i=0; i< size; i++){
            check = false;
               //call obj             //parameter obj
           if(this.theData[i].equals(recevedlist.theData[i])){

                count++;
                check=true;
            }//if

        }//loop
        /*if(count == size )
            return true
            else
            return false
         */
        System.out.println("count == size "+ (count == size&& check));
        return  count == size&& check;
    } //equals

    //Question 4 Write a method CompareSum to be included in the
    // class KWArrayList of Question 1. The method compares the sum
    // of the elements  of the first half of the list
    // with the sum of the elements of the second half and
    // returns true If they are equal, otherwise  it returns false.
    //  Assume that the list contains integers.
    // You are not allowed to call any other method of the class.
    //Method heading:  public boolean CompareSum();
    public  boolean CompareSum(){
        int center=size/2,firstHalf=0,secondHalf=0;
        Integer num =0;

        ////////////////////even size //////////////
        if(size %2 == 0){

            for (int i=0; i < size ; i++){
                if(i < center){
                    firstHalf +=(Integer) theData[i];
                }else
                    secondHalf += (Integer) theData[i];
            }//for i



        }/////////////////////the end of even size///////////////////
        else { ///////////////////////odd size /////////////////////
            firstHalf+= (Integer) theData[center] / 2;
            secondHalf+= (Integer) theData[center] / 2;
            for (int i=0; i < size ; i++){
                if(i < center){
                    firstHalf +=(Integer) theData[i];
                    // don't want to count the center
                }else if( i > center)
                    secondHalf += (Integer) theData[i];
            }//for i
        }// else
        return firstHalf == secondHalf;
    }//CompareSum


    //Question 6 (A) Write a method called listChange to be included
    // in the KWArrayList class of Question 1
    // that accepts a parameter list1 of type KWArrayList class.
    // The method checks, whether list1 is in ascending order.
    // If so, it will delete the first and last elements of "this" list,
    // otherwise, it will copy
    // the first element from list1 and add it to
    // be the last element in "this" list. The method return false, if list1
    // or "this" list has less than two elements, otherwise it will return true.
    //Method heading:   public  boolean listChange(KWArrayList list1);

    public  boolean listChange(KWArrayList list1){
        if(list1.isEmpty() && list1.size < 2)
            return false;
        int count =0;
        boolean check = false;
        for(int i = 0 ; i < size-1; i++)
        {   //1 if the first bigger than second
            // 0 if first and second are equals
            // -1 if the first smaller than the second
            if(((Comparable)this.theData[i]).compareTo(list1.theData[i+1])<0)
                count++;
            System.out.println(((Comparable)this.theData[i]).compareTo(list1.theData[i+1])<0);
        }//loop


        //ascending order
        if(count == size-1){
           remove(0);
            remove(size-1);
        }
        else
        add(theData[0]);

        return true;
    }
}  //end class KWArrayList


