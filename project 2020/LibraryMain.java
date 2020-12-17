package FinalProject;

public class LibraryMain {
    public static void main(String[] args) {
        //public Book(String title, String author1,
        //                String author2, String publisher,
        //                String isbn, int yearPublication,
        //                long accessionNum) {
        LibrarySystem l1= new LibrarySystem();
        /*Book b1 = new Book("java","bob"
                ,"jon","uob",
                "isbn2222aabb1",2010,1002);

        System.out.println(l1.addBook(b1));

        Book b2 = new Book("java2","bob"
                ,"jon","uob",
                "isbn2232aabb1",2010,1003);
        System.out.println(l1.addBook(b2));
        System.out.println(l1.deleteBook(1003));*/
        //public LibMember(String firstName, String lastName, String teleNum,
        //                     char gender, long cprNum) {
        LibMember m1 = new LibMember("ali","hussain"
                ,"3336",'m',2222);

        System.out.println(l1.addMember(m1));
        System.out.println(l1.deleteMember(2222));
        System.out.println(l1.deleteMember(2222));
        



    }//main
}//class
