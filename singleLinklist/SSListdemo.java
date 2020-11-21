public class SSListdemo {
    public static void main(String[] args) {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(5);
        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(35);
        list1.add(50);
        list1.insertSorted(25);
        System.out.println(list1.toString());
    }//main
}//class
