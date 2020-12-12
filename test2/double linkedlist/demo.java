package test2;

import java.util.ListIterator;

public class demo {
    public static void main(String[] args) {
//Before run:
        //                    head
        //   list:     5    10     20    30     35     50
        // item =   25       	After run:
        //                    head
        //   list:     5    10     20    25   30     35     50
        KWLinkedList list = new KWLinkedList();
        //System.out.println("list.insertSorted(25) = "+list.insertSorted(25));
        list.add(5);
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(35);
        list.add(50);
        /*ListIterator iter = list.listIterator();
        while (iter.hasNext())
            System.out.print(iter.next()+" ");
        System.out.println();
        System.out.println("list.insertSorted(25) = "+list.insertSorted(25));

         iter = list.listIterator();
        while (iter.hasNext())
            System.out.print(iter.next()+" ");*/
        //Before run:
        //                    head                                    tail
        //   list:     20    50     70    90     33     89
        // count: 2       direction: ’f’	After run:
        //                    head                  tail
        //   list:     70    90     33     89
        //
        //      Example 2:
        //Before run:
        //                    head                                    tail
        //   list:     20    50     70    90     33     89
        // count: 2       direction: ’b’	After run:
        //                    head                 tail
        //   list:     20    50     70    90
        //
        //
        //Method heading:
        KWLinkedList list2 = new KWLinkedList();
        /*System.out.println("list2.deleteMultipleNodes(2,'b')) = "
                +list2.deleteMultipleNodes(2,'b'));*/
        list2.add(20);list2.add(50);list2.add(70);list2.add(90);list2.add(33);
        list2.add(89);

        ListIterator iter2 = list2.listIterator();
        while (iter2.hasNext())
            System.out.print(iter2.next()+" ");
        System.out.println();
        /*System.out.println("list2.deleteMultipleNodes(2,'f')) = "
                +list2.deleteMultipleNodes(2,'f'));*/
        System.out.println("list2.deleteMultipleNodes(2,'b')) = "
                +list2.deleteMultipleNodes(2,'b'));

        iter2 = list2.listIterator();
        while (iter2.hasNext())
            System.out.print(iter2.next()+" ");
    }//main
}//class
