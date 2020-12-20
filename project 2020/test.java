package FinalProject;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int choseNumber=0;
        Scanner read =new Scanner(System.in);
        //public Book(String title, String author1,
        //                String author2, String publisher,
        //                String isbn, int yearPublication,
        //                long accessionNum) {
        LibrarySystem l1= new LibrarySystem();
        Book b1 = new Book("java","bob"
                ,"jon","uob",
                "isbn2222aabb1",2010,1002);


        Book b2 = new Book("java2","bob"
                ,"jon","uob",
                "isbn2232aabb1",2010,1003);

        System.out.println(l1.addBook(b1)); System.out.println(l1.addBook(b2));

        //public LibMember(String firstName, String lastName, String teleNum,
        //                     char gender, long cprNum) {
        LibMember m1 = new LibMember("ali","hussain"
                ,"3336",'m',2222);

        System.out.println(l1.addMember(m1));
        //System.out.println("l1.issueBook(1003)"+l1.isBookIssued(1003));

        System.out.println("issueBook = "+l1.issueBook(1002,2222));
       // System.out.println("l1.issueBook(1003)= "+l1.isBookIssued(1003));
       //l1.printBooksIssued(2222);
        //l1.printBooksIssued(2222);
        //System.out.println(l1.returnBook(10053));
        System.out.println("issueBook = "+l1.issueBook(1003,2222));

    }//main
}//class
