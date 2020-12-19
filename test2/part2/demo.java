package test2;

import java.util.ListIterator;

public class demo {
    public static void main(String[] args) {

       /* KWLinkedList list = new KWLinkedList();

        list.add(5);
        list.add(10);
        list.add(20);

        list.add(30);

        list.add(15);
        list.add(12);
        list.add(25);
        ListIterator iter = list.listIterator();
        while (iter.hasNext()){
            System.out.print("element = "+iter.next()+"  ");
        }


        System.out.println("\nafter call method\n");
        list.question(30,999);
        System.out.println("------------------------------");



         iter = list.listIterator();
        while (iter.hasNext()){
            System.out.print("element = "+iter.next()+"  ");
        }*/

       /* KWLinkedList<Integer> list = new KWLinkedList<Integer>();
        list.add(2);
        list.add(-1);
        list.add(0);
        list.add(1);

        list.add(0);
        ListIterator<Integer> iter = list.listIterator();
        while (iter.hasNext()) {
            if (iter.next() == 0)
                iter.remove();
        }
        if (iter.hasPrevious())
            System.out.println("END");

        else


        {


        while(iter.hasNext())
                System.out.print(iter.next()+" ");
        }*/

        KWLinkedList<Integer> list=new KWLinkedList<Integer> (); list.add(77);
        list.add(22);
        list.add(44); list.add(100); list.add(120);
        for(int i=0; i<list.size();i++) System.out.print(list.get(i) + " ");
        System.out.println();
        ListIterator<Integer> iter = list.listIterator(2); while(iter.hasPrevious())
            System.out.print(iter.previous() + " ");

    }//main
}//class
