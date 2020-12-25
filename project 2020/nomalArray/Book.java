package FinalProject;

public class Book {
    //title (String), author1 (String),
    // author2(String), publisher (String), yearPublication (int),
    //isbn (String), accessionNum (long), issuedTo (LibMember).
    private String title,author1,author2,publisher,isbn;
    private int yearPublication;
    private  long accessionNum;
    private static long accessionNamGlobe =1001;
    private LibMember issuedTo;
    //Default constructor (without any parameters),

    public Book() {
        this.title = "title";
        this.author1 = "author1";
        this.author2 = "author2";
        this.publisher = "publisher";
        this.isbn = "isbn";
        this.yearPublication = 0000;
        this.accessionNum=1001;
        this.issuedTo = null;
        accessionNamGlobe++;
    }

    // constructor with 6 parameters
    // (except for issuedTo – initialize issuedTo to null),
    public Book(String title, String author1,
                String author2, String publisher,
                String isbn, int yearPublication,
                long accessionNum) {
        if(isbn.length()==13)
            this.isbn = isbn;
        else{
        System.out.println("ISBN not 13 light");
        return;
        }
        this.title = title;
        this.author1 = author1;
        this.author2 = author2;
        this.publisher = publisher;


        this.yearPublication = yearPublication;
        if(accessionNum > accessionNamGlobe )
        this.accessionNum = accessionNum;
        this.issuedTo = null;
        accessionNamGlobe++;
    }
    // set and get methods for all attributes,

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor1() {
        return author1;
    }

    public void setAuthor1(String author1) {
        this.author1 = author1;
    }

    public String getAuthor2() {
        return author2;
    }

    public void setAuthor2(String author2) {
        this.author2 = author2;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if(isbn.length()==13)
            this.isbn = isbn;
        else{
            System.out.println("ISBN not 13 light");
            return;
        }
    }

    public int getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(int yearPublication) {
        this.yearPublication = yearPublication;
    }

    public long getAccessionNum() {
        return accessionNum;
    }

    public void setAccessionNum(long accessionNum) {
        if(accessionNum > accessionNamGlobe )
        this.accessionNum = accessionNum;
    }

    public LibMember getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(LibMember issuedTo) {
        this.issuedTo = issuedTo;
    }

    // equals
    //



    public boolean equals(Book b1) {
        if (this == b1) return true;

        return //yearPublication == b1.yearPublication &&
                accessionNum == b1.accessionNum &&
                title.equals( b1.title) &&
                /*author1.equals( b1.author1) &&
                author2.equals( b1.author2) &&
                publisher.equals( b1.publisher) &&*/
                isbn.equals( b1.isbn);
                /*&&
                issuedTo.equals( b1.issuedTo);*/
    }



    // and toString.


    @Override
    public String toString() {
        return "\nBook{" +
                "title='" + title + '\'' +
                ", author1='" + author1 + '\'' +
                ", author2='" + author2 + '\'' +
                ",\npublisher='" + publisher + '\'' +
                ", isbn='" + isbn + '\'' +
                ", yearPublication=" + yearPublication +
                ", accessionNum=" + accessionNum +
                //", issuedTo=" + issuedTo +
                '}';
    }

    //NOTE: The ISBN is a unique 13-digit number assigned by the publisher.
    // It is like barcode.

    //As there can be multiple copies of a book in a library,
    //the libraries assign a unique number,
    //called accession number,
    // to every book in the library to keep track of the books in the library.
    // Assume that accession number starts from 1001.
}
