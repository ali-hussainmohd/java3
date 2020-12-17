package assignment3;

public class PalindromeChecker {
    public boolean palindrome(String str){
        int count=0,centerLength=(str.length())/2;
        ArrayStack<Character> stack = new ArrayStack();
        ArrayQueue<Character> queue =new ArrayQueue<>();

            str= str.toLowerCase();

        for(int i=0;i <str.length() ;i++){

            stack.push(str.charAt(i));
            queue.offer(str.charAt(i));

        }//for

        for(int i=0; i< centerLength   ; i++)
        {
            System.out.println("at index "+i+" letter peek ="+stack.peek());
            System.out.println("peek = "+queue.peek()+"\n-----------------------");

            if(stack.pop() == queue.poll()){
                count++;
            }//if

        }//for
        System.out.println("count = "+count);
        System.out.println("length = "+centerLength);

        //centerLength+=1;
        return centerLength == count;
    }

    public static void main(String[] args) {
        PalindromeChecker p = new PalindromeChecker();
        System.out.println("tattarrattat ############"+p.palindrome("tattarrattat"));
        System.out.println("***************************************");
        System.out.println("marram ############"+p.palindrome("marram"));
        System.out.println("***************************************");
        System.out.println("izram ############ "+p.palindrome("izram"));
        System.out.println("***************************************");
        System.out.println("izrham ############ "+p.palindrome("izrham"));
    }
}//class
