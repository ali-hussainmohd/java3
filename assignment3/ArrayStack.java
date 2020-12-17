package assignment3;

import java.util.NoSuchElementException;

public class ArrayStack<E> {
    private E[ ] theData;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 10;

    public ArrayStack(){
        topOfStack =-1;
        theData = (E[]) new Object[INITIAL_CAPACITY];
    }//default constructor

    public ArrayStack(int cap) {

        topOfStack = -1;
        if (cap <= 0 )
            cap = INITIAL_CAPACITY;
        theData = (E[]) new Object[cap];

    }//constructor with parameter
    public  ArrayStack (ArrayStack<E> other)
    {
        theData = (E[]) new Object[other.topOfStack + 1];
        for (int i = 0; i < other.topOfStack+1 ; i++)
            theData[i]= other.theData[i];
        topOfStack = other.topOfStack;
    }//Copy constructor
    public boolean isEmpty()
    {
        return topOfStack == -1;
    }

    public int size() {
        return topOfStack+1;
    }

    private void reallocate() {
        E[] temp = (E[]) new Object[2 * theData.length];
        System.arraycopy(theData, 0, temp, 0, theData.length);
        theData = temp;
    }

    public E push(E obj)
    {
        if (topOfStack == theData.length - 1) {
            reallocate();
        }
        topOfStack++;
        theData[topOfStack] = obj;
        return obj;
    }

    public E pop()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack--];
    }
    public E peek()
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return theData[topOfStack];
    }
    public boolean contains(E data){
        for(int i = topOfStack ; i>=0; i--)
            if(theData[i].equals(data))
                return true;
        return false;
    }

    public void clear(){
        theData = (E[]) new Object[INITIAL_CAPACITY];
        topOfStack = -1;

    }

}//class
