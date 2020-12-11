package stack;
import java.util.Stack;
public class demo {
    public static void main(String[] args) {
        ArrayStack s1 = new ArrayStack();
        System.out.println("s1.isEmpty() = "+s1.isEmpty());
        s1.push(10);
        System.out.println("s1.size() = "+s1.size());
        s1.push(50);
        System.out.println("s1.size() = "+s1.size());
        s1.push(60);

        System.out.println("s1.isEmpty() = "+s1.isEmpty());

        System.out.println("s1.size() = "+s1.size());

        ArrayStack s2 = new ArrayStack(s1);
        System.out.println("s2.peek() = "+s2.peek());
        System.out.println("s2.size() = "+s2.size());
        while (!s2.isEmpty())
            System.out.println(s2.pop());
////////////////////////////stack linkedlist /////////////////////////
        linkedStack lisks1= new linkedStack();
        lisks1.push(10);
        lisks1.push(20);
        lisks1.push(30);

        System.out.println("lisks1.peek() = "+lisks1.peek());
        System.out.println("lisks1.getSize()= "+lisks1.getSize());
        while (!lisks1.isEmpty()){
            System.out.println(lisks1.pop());
        }


    }//main
}//class
