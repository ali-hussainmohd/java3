package test2;

public class demoQeueu {

    public static void main(String[] args) {
        //	q1:	10	30	 5         20       40
        //	q2:	7	15	25
        //	q3:	10	7	30       15       5       25      20      40

        QueueEx obj = new QueueEx();
        ArrayQueue q1 = new ArrayQueue();
        q1.offer(10);
        q1.offer(30);
        q1.offer(5);
        q1.offer(20);
        q1.offer(40);
        ArrayQueue q2 = new ArrayQueue();
        q2.offer(7);
        q2.offer(15);
        q2.offer(25);
        ArrayQueue q3 = new ArrayQueue();
        obj.mergeQueues(q1,q2,q3);

        while(!q3.isEmpty()){
            System.out.print(q3.poll()+" ");
        }
    }//main
}//class
