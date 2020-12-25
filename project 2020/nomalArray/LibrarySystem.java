package FinalProject;

import java.util.LinkedList;

public class LibrarySystem  {
    //booksList:		list of books – LinkedList object,
    // each element is of type Book,
    private LinkedList<Book> booksList;
    //membersList:	list of members – LinkedList object,
    // each element is of type LibMember,

    private LinkedList<LibMember>  membersList;
    //booksListSize:	actual number of objects of type Book in booksList,
    //membersListSize:	actual number of objects of type LibMember in membersList.
    private int booksListSize,membersListSize;
    //(i)	Constructor without any parameters.
    // Create booksList and membersList as
    // empty linked lists and
    // initialize booksListSize and membersListSize to 0.

    public LibrarySystem() {
        this.booksList = new LinkedList();
        this.membersList = new LinkedList();
        this.booksListSize = 0;
        this.membersListSize = 0;
    }

    //(viii)	isEmptyBooksList: returns true if the booksList is empty,
    // else returns false.
    public boolean isEmptyBooksList(){return booksListSize==0;}
    //(ix)	isEmptyMembersList: returns true if the membersList is empty,
    // else returns false.
    public boolean isEmptyMembersList(){return membersListSize==0;}

    //(x)	sizeBooksList: returns instance variable booksListSize.

    public int sizeBooksList() { return booksListSize; }

    //(xi)	sizeMembersList: returns instance variable membersListSize.
    public int sizeMembersList() { return membersListSize; }

    //(vi)	searchBook: searches the booksList by accessionNum,
    // passed as parameter. If the object is found,
    // it returns its location in the booksList, else returns -1.
    public int searchBook(long accessionNum){
        //Book b1 =(Book)booksList.get(0);

        for(int i=0; i < booksListSize; i++){
            if(booksList.get(i).getAccessionNum()==accessionNum)
                return i;}

        return -1;
    }
    //(vii)	searchMember: searches the membersList by cprNum,
    // passed as parameter. If the object is found,
    // it returns its location in the membersList, else returns -1.

    public int searchMember(long cpr){
        //Book b1 =(Book)booksList.get(0);

        for(int i=0; i < membersListSize; i++)
            if(membersList.get(i).getCprNum()==cpr)
                return i;

        return -1;
    }
    //(ii)	addBook: 	inserts a new Bookobject at the end of the booksList.
    // Object of type Book is passed as parameter.
    // If the object already exists in the list,
    // then do not add the object and return false,
    // else return true after successfully adding the Book.
    public boolean addBook(Book b1){
        for(int i=0; i < booksListSize; i++){
            if(booksList.get(i).equals(b1))
                return false;}

        booksList.add(b1);
        booksListSize++;
        return true;
    }
    //(iii)	deleteBook: 	deletes a Book object from booksList.
    // Accession number of the Book is passed as parameter.
    // If the Book is issued to a member or the object
    // is not found in the booksList,
    // then the Book cannot be deleted and the method returns false,
    // else the method returns true,
    // after successfully deleting the object.
    public boolean deleteBook (long accessionNum){
        int index = searchBook(accessionNum);

        if(index == -1)
            return false;
        if(booksList.get(index).getIssuedTo()== null){
        booksList.remove(index);
        booksListSize--;
        return true;
        }
        return false;
    }
    //(iv)	addMember:	inserts a new LibMember object
    // at the end of the membersList.
    // Object of type LibMember is passed as parameter.
    // If the object already exists in the list,
    // then do not add the object and return false,
    // else return true after successfully adding the member.
    public boolean addMember(LibMember m1){
        for(int i=0; i < membersListSize; i++){
            if(membersList.get(i).equals(m1))
                return false;}

        membersList.add(m1);
        membersListSize++;
        return true;
    }
   //(v)	deleteMember:   deletes a LibMember object from membersList.
    // CPR number of the LibMember is passed as parameter.
    // If any Book is issued to the member or the object
    // is not found in the membersList,
    // then the member cannot be deleted and the method returns false,
    // else the method returns true, after successfully deleting the object.
   public boolean deleteMember (long cpr){
       int index = searchMember(cpr);

       if(index == -1)
           return false;
       if(membersList.get(index).getNumBooksIssued()== 0){
           membersList.remove(index);
           membersListSize--;
           return true;
       }
       return false;
   }

   //(xii)	issueBook: accepts accession number of
    // a Book as the first parameter and the CPR number
    // of the member as the second parameter.
   // The Book can be issued to a member only if:
   // object reference to the member and return true.
   // If the Book cannot be issued then return false.
   //Note that there will be cross referencing between the book and the member.
     public boolean issueBook(long accessionNum,long cpr){
          int bookIndex= searchBook(accessionNum),
              memberIndex=searchMember(cpr);

          //(a)	The Book exists in the booksList,
         // (b)The member exists in the membersList,
          if(bookIndex == -1 || bookIndex==-1)

              return false;


          Book book = booksList.get(bookIndex);
          LibMember member = membersList.get(memberIndex);
          //(c)	The Book is not issued to any member,
         // (d)	The member has less than 10 books issued to him/her.

          if(book.getIssuedTo() != null|| member.getNumBooksIssued() >= 10)

          return false;
          //If the book can be issued to a member,
         // then add the Book object in the booksIssued array for the member,
         // increment numBooksIssuedby 1 for the member and
         Book ArrayBook[]= member.getBooksIssued();
         ArrayBook[member.getNumBooksIssued()]=book;
         member.setBooksIssued(ArrayBook);
         //arraylist
          //member.getBooksIssued().add(book);
          member.setNumBooksIssued(member.getNumBooksIssued()+1);
         // also make issuedTo instance variable of the Book
         book.setIssuedTo(member);
           return true;
      }
      //(xiii)	returnBook: accepts accession number of
    // a Book as the parameter. The Book can be returned only if:
    public boolean returnBook(long accessionNum){
        int bookIndex= searchBook(accessionNum);
        //(a)	The Book exists in the Books list,
        if(bookIndex == -1 )
            return false;
        Book book = booksList.get(bookIndex);
        // 	(b) The Book is issued to a member.
        if(book.getIssuedTo() != null)
        {
            // then delete it from booksIssued array for the member,
            // decrement numBooksIssued by one for the member and also
            // make issuedTo instance variable of the Book object to null
            LibMember member = book.getIssuedTo();
            book.setIssuedTo(null);
            //member.getBooksIssued().remove(book);
            Book ArrayBook[]= member.getBooksIssued();
            for(int i= 0; i < member.getNumBooksIssued();i++){
                if(ArrayBook[i].equals(book)){
                    for(int j= i+1; j < member.getNumBooksIssued();j++){
                      ArrayBook[j-1]=ArrayBook[j];
                    }//for j
                }//if
            }//for i

            member.setBooksIssued(ArrayBook);
            member.setNumBooksIssued(member.getNumBooksIssued()-1);
            return true;

        }

        return false;
    }

    //(xiv)	printBooksIssued: accepts CPR number of a member
    // as a parameter and
    // prints details of all the books issued to the member.
    public void printBooksIssued(long cpr){
        int index = searchMember(cpr);
        if(index ==-1)
            System.out.printf("the cpr %d not found ",cpr);
        LibMember member =membersList.get(index);
        Book ArrayBook[]=member.getBooksIssued();
        for(int i=0;i < member.getNumBooksIssued();i++)
            System.out.println(ArrayBook[i].toString());
    }
    //(xv)	isBookIssued: accepts accession number of the Book as parameter.
    // It returns true if the Book object exists in the bookList
    // and is issued to a member, else returns false.
    public boolean isBookIssued(long accessionNum){
        int index = searchBook(accessionNum);
        if(index == -1)
            return false;

        return booksList.get(index).getIssuedTo()!=null;
    }




}
