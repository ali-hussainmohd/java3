package test2;

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

    public void question(ArrayStack<Integer> s)
    {
        System.out.println("enter method");
        if(topOfStack == -1 || (topOfStack + 1) %2 !=0)
            return;
        Integer a[] =   new Integer[topOfStack + 1];
        for (int i = 0; i <= topOfStack/2; i++)
        {
            a[i]= (Integer) theData[i] + (Integer)theData[topOfStack - i];
        }
        for (int i = topOfStack/2; i >= 0; i--)
            s.push((Integer)a[i]);
        for (int i = topOfStack/2; i >= 0; i--)
            System.out.println(s.pop());
    }
    //Write a method called replaceTop
    // to be included in this class ArrayStack.
    // If stack is not empty, then the method replaces
    // the top element of the stack by
    // parameter item and returns the old value at the top.
    //  If the stack is empty, return null.
    //Do not call any other method of the class ArrayStack in your method.
    public E replaceTop(E item ){
        if( topOfStack != -1 ){
            E oldvalue= theData[topOfStack];
            theData[topOfStack]=item;
            return oldvalue;
        }//if
        return null;
    }


}//class
