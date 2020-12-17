package assignment3;

public class PalindromeFinder {
    public boolean palindrome(String str){
        int count=0,centerLength=(str.length())/2;
        ArrayStack<Character> stuck = new ArrayStack();


        for(int i=0; i <str.length() ;i++){
            stuck.push(str.charAt(i));
        }//for

        for(int i=0; i< centerLength  ; i++)
        {

            System.out.println("peek = "+stuck.peek());
            System.out.println("str at "+i + " char = "+str.charAt(i));
            if(str.charAt(i) == stuck.pop()){
                count++;
            }//if

        }//for
        System.out.println("count = "+count);
        System.out.println("length = "+centerLength);


        return centerLength == count;
    }


    public static void main(String[] args) {
        PalindromeFinder p = new PalindromeFinder();
        System.out.println("maram ##########"+p.palindrome("maram"));
        System.out.println("***********************************");
        System.out.println("second test.="+p.palindrome("tattarrattat"));
        System.out.println("***********************************");
        System.out.println("second test.="+p.palindrome("marram"));
        System.out.println("***********************************");
        System.out.println("three test.="+p.palindrome("Afdre"));
        System.out.println("***********************************");
        System.out.println("forth test.="+p.palindrome("Afdr"));
    }//main
}//class
