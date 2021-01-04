package test2;

public class StackExt {
    //Write a method called samePosition in a class called StackExt
    // that receives two parameters st1 and st2 of type ArrayStack
    // and a third parameter pos of type int.
    //  The method returns true, if stack st1 and st2 contains
    // the same value in position pos.
    // Otherwise, the method returns false.
    // Assume that both stacks st1 and st2 contains same number of elements.
    //Assume that the position of the top element is 0 and increases by
    // 1 for each subsequent element.
    // The elements of both stacks st1 and st2 must
    // remain in the original relative positions
    // in the stacks at the end of the method.
    //Use common stack operations only such as push,
    // pop, peek, isEmpty, constructor and copy constructor.
    // You can create local objects of type ArrayStack in your method.
    public boolean sameposition(ArrayStack<Integer> st1,
                                ArrayStack<Integer> st2, int pos){
        if(st1.isEmpty() || st2.isEmpty())
            return false;
        ArrayStack<Integer> temp = new ArrayStack<Integer>(st1),
                            temp2 = new ArrayStack<Integer>(st2);

        for(int i=0; i < pos;i++){
            temp.pop();
            temp2.pop();
        }//for
        return temp.peek()== temp2.peek();
    }

}//class
