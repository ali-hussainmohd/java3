package test2;

public class demoStack {
    public static<E> void question(ArrayStack<E> s1, ArrayStack<E> s2)
    {
        System.out.println("enter method");
        if(s1.isEmpty() || !s2.isEmpty())
            return;
        System.out.println("while");
        while(! s1.isEmpty())
    {

        s2.push(s1.pop());
        if (!s1.isEmpty())
            s1.pop();
    }
    }

    public static void main(String[] args) {
        /*ArrayStack <Integer> s1 = new ArrayStack();
        s1.push(10);
        s1.push(20);//1
        s1.push(30);

        s1.push(40);//3
        s1.push(50);
        s1.push(60);//4
        ArrayStack <Integer> s2 = new ArrayStack();


        question(s1,s2);
        while(!s2.isEmpty()){
            System.out.print("element = "+s2.pop()+" ");
        }*/

//Value
//2
//4
//7
//10
//8
//12
       /* ArrayStack <Integer> ss1 = new ArrayStack();
        ss1.push(2);//0
        ss1.push(4);//1
        ss1.push(7);//2
        ss1.push(10);//3
        ss1.push(8);//4
        ss1.push(12);//5
        ss1.question(ss1);*/



            /*ArrayStack<Integer> st = new ArrayStack<Integer>();
            for(int i = 3; i < 10; i += 2)
            st.push( i + 1);
            ArrayStack<Integer> st1 = new ArrayStack<Integer>();
            while(! st.isEmpty())
            st1.push(st.pop() + 2);
            while(! st1.isEmpty())
            System.out.print(st1.pop() + " ");*/

        //           top
        //   st:    20    15    5     25    3    7    12	After method call:
        //        top
        //st:    5     3     7     20     15    25     12
        ArrayStack <Integer> ss11 = new ArrayStack();
        ss11.push(20);
        ss11.push(15);
        ss11.push(5);

        ss11.push(25);
        ss11.push(3);
        ss11.push(7);
        ss11.push(12);
        StackExt obj = new StackExt();
        obj.rearrangeStack(ss11, 10);

        while(! ss11.isEmpty())
            System.out.print(ss11.pop() + " ");


    }//main
}//class
