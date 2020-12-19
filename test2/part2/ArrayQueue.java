package test2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue <E> {
    private E[] theData; // Array to hold the data.
    private int front;       // Index of the front of the queue.
    private int rear;        // Index of the rear of the queue.
    private int size;         // Current size (actual number of elements)
    // of the queue.
    private int capacity; // Current capacity of the queue.
    private static final int DEFAULT_CAPACITY = 10;
    public ArrayQueue()
    {
        this(DEFAULT_CAPACITY);
    }
    public ArrayQueue(int initCapacity)
    {
        capacity = initCapacity;
        theData = (E[]) new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }
    public  ArrayQueue(ArrayQueue<E> other)
    {
        capacity = other.capacity;
        size = other.size;
        front = other.front;
        rear = other.rear;
        theData = (E[]) new Object[capacity];
        int index = front;
        for (int i = 0; i < size; i++) {
            theData[index]= other.theData[index];
            index = (index + 1) % capacity;
        }
    }
    public boolean isEmpty()
    {
        return (size == 0);
    }
    public boolean offer(E item)
    {
        if (size == capacity) {
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        theData[rear] = item;
        return true;
    }
    public E peek()
    {
        if (size == 0) {
            return null;
        }
        else {
            return theData[front];
        }
    }
    public E poll()
    {
        if (size == 0) {
            return null;
        }
        E result = theData[front];
        front = (front + 1) % capacity;
        size--;
        return result;
    }
    public Iterator<E> iterator()
    {
        return new Iter();
    }
    private void reallocate()
    {
        int newCapacity = 2 * capacity;
        E[] newData = (E[]) new Object[newCapacity];
        int j = front;
        for (int i = 0; i < size; i++) {
            newData[i] = theData[j];
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theData = newData;
    }
    private class Iter implements Iterator<E>
    {
        // Data Fields
        private int index; // Index of next element
        private int count; // Count of elements accessed so far

        // Methods
        // Constructor
        /**
         * Initializes the Iter object to reference the first queue element.
         */
        public Iter()
        {
            index = front;
            count = 0;
        }

        /**
         * @return true, if there are more elements in the queue to access.
         */
        @Override
        public boolean hasNext()
        {
            return (count < size);
        }

        /**
         * Returns the next element in the queue.
         * @pre index references the next element to access.
         * @post index and count are incremented.
         * @return The element with subscript index
         */
        @Override
        public E next()
        {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E returnValue = theData[index];
            index = (index + 1) % capacity;
            count++;
            return returnValue;
        }

        /**
         * Remove the item accessed by the Iter object -- not implemented.
         * @throws UnsupportedOperationException when called
         */
        @Override
        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    } // end inner class Iter

}
