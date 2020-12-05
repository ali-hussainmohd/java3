package solveDouble;

public class test {
    public static void main(String[] args) {
        KWLinkedList obj = new KWLinkedList();
        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.add(40);
        obj.add(50);
        System.out.println(obj.toString());
        System.out.println(obj.removeWithCondition(30,20));
        System.out.println(obj.toString());
        KWLinkedList list = new KWLinkedList();
        //10   5   25   12   18   7   40   50   11
        list.add(10);
        list.add(5);
        list.add(25);

        list.add(12);
        list.add(18);
        list.add(7);
        list.add(40);
        list.add(50);
        list.add(11);
        KWLinkedList list2 = new KWLinkedList();

        //System.out.println("list = "+list.toString());
        //System.out.println("fineAll = "+list.findAll(15,list2));
        //System.out.println("list2 = "+list2.toString());


    }
}//class
