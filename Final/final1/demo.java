package test2;

import java.util.ListIterator;

public class demo {
    public static void main(String[] args) {

        //elem:     35
        // Iist (before method call):   15   75    20   35   40   60   45
        KWLinkedList list = new KWLinkedList();

        list.add(15);
        list.add(75);
        list.add(20);

        list.add(35);

        list.add(40);
        list.add(60);
        list.add(45);

        System.out.println("list.isproper(35)="+list.isproper(35));
        ArrayStack stackList = new ArrayStack();
        //stack (Before method call):     5,  20,  10,  50,  15,  30
        //                                        item:    7
        //                                                     top
        //stack (After method call):      7,  20,  10,  50,  15,  30
        //                           Method will return 5.
        stackList.push(30);//
        stackList.push(15);//
        stackList.push(50);//
        stackList.push(10);//
        stackList.push(20);//
        stackList.push(5);//  top
        ArrayStack temp = new ArrayStack(stackList);
        //print the elemet of stack
        System.out.println(" before call the method");
        while(!temp.isEmpty()){

            System.out.println("temp.pop() = "+temp.pop());
        }//while
        System.out.println("stackList.replaceTop(7)="+stackList.replaceTop(7));
        ArrayStack temp2 = new ArrayStack(stackList);
        System.out.println(" After call the method");
        while(!temp2.isEmpty()){

            System.out.println("temp.pop() = "+temp2.pop());
        }//while
        //Example1:
        //           top                                                                    top
        //st1:     4    5    3   7   8			st2:       5    9    4   7   1
        //If the pos is 3, then both stacks contain 7 in position 3.
        // The method returns true.
        //If the pos is 1, then st1 contains 5 and st2 contains 9 in position 1.
        // The method returns false.
        ArrayStack st1 = new ArrayStack();
        st1.push(8);
        st1.push(7);
        st1.push(3);
        st1.push(5);
        st1.push(4);//top
        ArrayStack st2 = new ArrayStack();
        st2.push(1);
        st2.push(7);
        st2.push(4);
        st2.push(9);
        st2.push(5);//top
        StackExt obj = new StackExt();
        System.out.println("obj.sameposition(st1,st2,3)= "
                +obj.sameposition(st1,st2,3));
        System.out.println("obj.sameposition(st1,st2,1)= "
                +obj.sameposition(st1,st2,1));

    }//main
}//class
