package stack;

import java.util.NoSuchElementException;

public class ArrayStack<E> {

    private E[ ] theData; // array to store stack elements
    /** Index of top of the stack. */
    private int topOfStack; // index of stack top.
    private static final int INITIAL_CAPACITY = 10;

    public ArrayStack(){
        theData= (E[])new Object[INITIAL_CAPACITY];
        topOfStack=-1;
    }
    public ArrayStack(int cap){
        theData= (E[])new Object[cap];
        topOfStack=-1;
    }

    public ArrayStack(ArrayStack other){
        theData= (E[])new Object[other.theData.length];
        for(int i = 0 ; i < theData.length ; i++){
            this.theData[i]=(E)other.theData[i];
        }
        this.topOfStack =other.topOfStack;
    }

    public E push(E obj){
        if(topOfStack == theData.length-1)
            reallocate();

        theData[++topOfStack]=obj;
        return obj;
    }

    public E pop (){
        if(isEmpty())
            throw new NoSuchElementException();
        E result = theData[topOfStack];
        theData[topOfStack--]=null;
        return result;
    }

    public E peek(){
       if(isEmpty())
            throw new NoSuchElementException();
       return theData[topOfStack];
    }
    public boolean isEmpty(){return topOfStack == -1;}

    private void reallocate(){
        E[] temp = (E[]) new Object[2*theData.length];
        // theData = source (original) array
        // first 0 = starting location in the source array
        // temp = destination (new array in which to copy the elements)
        // second 0 = starting location in the destination array to copy
        // theData.length = number of array elements to copy
        System.arraycopy(theData,0,temp,0,theData.length);
        theData=temp;
    }

    public int size(){return topOfStack+1;}


}//class
