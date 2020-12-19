package test2;

public class StackExt {
    //Write a method called rearrangeStack in a class
    // called StackExt that receives two parameters st of type ArrayStack
    // and item of type int.


    // The method rearranges the elements of the stack st
    // in such a way that all the elements of the stack st which
    // are below item are moved to the top portion of the stack and all
    // remaining items are moved to the bottom portion of the array.

    //Use common stack operations only such as push, pop,
    // peek,isEmpty, constructor and copy constructor.
    // You can create local objects of type ArrayStack in your method.
    //Example:
    //Before method call:   item = 10
    //           top
    //            0    1     2*     3     4*    5*    6
    //   st:    20    15    5     25    3    7    12	After method call:
    //        top
    //        0    1     2      3      4     5      6
    //st:    5     3     7     20     15    25     12
    public void rearrangeStack(ArrayStack<Integer> st, int item) {
        ArrayStack <Integer>listGreater =new ArrayStack();
        ArrayStack <Integer>listSmaller =new ArrayStack();
        ArrayStack<Integer> reverse = new ArrayStack<Integer>();
        while(!st.isEmpty()){
            if(st.peek() < item)
                listSmaller.push(st.pop());
            else
                listGreater.push(st.pop());

        }//while

        System.out.println();
        while(!listSmaller.isEmpty()){
            reverse.push(listSmaller.pop());
        }
        while(!listGreater.isEmpty()){
            reverse.push(listGreater.pop());

        }
        System.out.println("top revers ="+reverse.peek());
        while(!reverse.isEmpty()){
            st.push(reverse.pop());
        }

        //st=listGreater;

    }
    }//class
