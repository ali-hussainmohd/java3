package solveDouble;

import java.util.LinkedList;
import java.util.ListIterator;

public class demoIterator {
    public static void main(String[] args) {
        KWLinkedList list = new KWLinkedList();
        list.add("m");
        list.add("a");
        list.add("d");
        list.add("d");
        list.add("a");
        list.add("m");
/*
        ListIterator listIter = list.listIterator(3);


            System.out.println(listIter.nextIndex()+"\t"+listIter.next());
        listIter.remove();


        listIter = list.listIterator(0);
        System.out.println();
        while(listIter.hasNext()){
            System.out.println(listIter.nextIndex()+"\t"+listIter.next());

        }*/

        //System.out.println(list.isPalindrome());
        //Solution 1 (using ListIterator)     25   20    15    5    10
        KWLinkedList list2 = new KWLinkedList();
        list2.add(25);
        list2.add(20);
        list2.add(15);
        list2.add(5);
        list2.add(10);

        list2.reverseNodes();

        ListIterator forwardIter = list2.listIterator();
        while(forwardIter.hasNext()){
            System.out.println(forwardIter.next());
        }

    }//main
}//class
