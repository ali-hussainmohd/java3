package test2;

public class QueueEx {
    // Write a method called mergeQueues to be included
    // in class QueueEx that merges two queues
    // q1 and q2 of type ArrayQueue into a third queue q3
    // as follows.  Queue q3 is obtained by adding an
    // element from q1 followed by adding an element from q2.
    // If no more elements are available in one of the queues,
    // then the remaining elements of the other queue are added into q3.
    // Queues q1 and q2 should remain unchanged at the end of the method.
    //      Example:
    //	q1:	10	30	 5         20       40
    //	q2:	7	15	25
    //	q3:	10	7	30       15       5       25      20      40
    public void mergeQueues(ArrayQueue<Integer> q1, ArrayQueue<Integer> q2,
                            ArrayQueue<Integer>q3) {
        ArrayQueue<Integer> qq11 = new ArrayQueue(q1);
        ArrayQueue<Integer> qq22 = new ArrayQueue(q2);

        while(!qq11.isEmpty()|| !qq22.isEmpty()){
            if(!qq11.isEmpty())
            q3.offer(qq11.poll());
            if(!qq22.isEmpty())
                q3.offer(qq22.poll());
        }//while

    }
}//class
