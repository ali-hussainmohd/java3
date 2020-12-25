package FinalProject.protectedArray;

import java.util.Scanner;

public class LibraryMain {
    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
            int chooseNumber=0;

        LibrarySystem libaray=new LibrarySystem();
        do{
            System.out.println(
                    "\n\t------------------------------------------------" +
                    "\n\t\t\t\tLibaray Management System\n" +
                    "\t-------------------------------------------------");

            //(ii)	addBook: (iii)	deleteBook: (iv)	addMember:
            // (v)	deleteMember: (vi)	searchBook: (viii)	isEmptyBooksList: (ix)
            // isEmptyMembersList: (x)	sizeBooksList: (xi)	sizeMembersList:
            //(xii)	issueBook: (xiii)	returnBook:
            //(xiv)	printBooksIssued: (xv)	isBookIssued:  ,memberDetails ,exit
            System.out.println(
            "=================================================\n"+
             "1- Books.\n2- Member.\n3- IssueBook. \n4- Return Book.\n0- Exit!\n"+
            "================================================="
            );
            System.out.println("Enter number from 0-4:");
            chooseNumber=read.nextInt();

            long accessionNum=0,cpr=0;
            Book book;
            LibMember member;
            String title=" ",author1=" ",author2=" ",publisher=" ",isbn=" ",
            firstName=" ",lastName=" ",teleNum=" ",answer=" ";
            int yearPublication=0;
            char gender;


            switch (chooseNumber){
///////////////////////////////////////////////////////////////////////////////////
                case 1:
                    do {
                        System.out.println(
                                "=================================================\n" +
                                        "1- Add Book.\n2- Delete Book.\n3- Search Book." +
                                        "\n4- Number of Books in List." +
                                        "\n5- Is Books List Empty?"+
                                        "\n6- Is this book issued?"+
                                        "\n7- Return to main menu." +
                                        "\n0- Exit!\n" +
                                        "================================================="
                        );
                        System.out.println("Enter number from 0-7:");
                        chooseNumber = read.nextInt();
                        switch (chooseNumber) {
                            case 1://Add Book
                                do{
                                //public Book(String title, String author1,
                                //                String author2, String publisher,
                                //                String isbn, int yearPublication,
                                //                long accessionNum) {
                                System.out.println("Enter title, first author" +
                                        ", second author, publisher, ISBN,\n year Publication," +
                                        "accession number:");
                                title = read.next();
                                author1 = read.next();
                                author2 = read.next();
                                publisher = read.next();
                                isbn = read.next();
                                yearPublication = read.nextInt();
                                accessionNum = read.nextLong();
                                book = new Book(
                                        title, author1, author2, publisher,
                                        isbn, yearPublication, accessionNum);
                                if (libaray.addBook(book)) {
                                    System.out.println("The book successfully added.");
                                } else
                                    System.out.println("The book can't be added.");
                                System.out.println("\nEnter \"Y\" to Delete  a Book or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 2://Delete Book
                                do{
                                System.out.println("Enter long Accession Number for book.");
                                accessionNum = read.nextLong();
                                if (libaray.deleteBook(accessionNum))
                                    System.out.println("The book successfully deleted.");

                                else
                                    System.out.println("The book can't be delete.");
                                System.out.println("\nEnter \"Y\" to Delete  a Book or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                            }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 3://Search Book
                                do{
                                System.out.println("Enter long Accession Number for book.");
                                accessionNum = read.nextLong();

                                if (libaray.searchBook(accessionNum)!=-1)
                                    System.out.println("The book available in list.");

                                else
                                    System.out.println("The book can't be found.");
                                System.out.println("\nEnter \"Y\" to Search Book or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 4://Number of Books in List
                                do{
                                System.out.printf("%d available book in list.\n",
                                        libaray.sizeBooksList() );
                                System.out.println("\nEnter \"Y\" to check Number of Books in List or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 5://Is Books List Empty?
                                do{
                                if(libaray.isEmptyBooksList())
                                    System.out.println("No book available in books list.");

                                else
                                    System.out.println("The list not empty.");
                                System.out.println("\nEnter \"Y\" to check Is Books List Empty? or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 6://Is this book issued?
                                do{
                                System.out.println("Enter long Accession Number for book.");
                            accessionNum = read.nextLong();
                            if (libaray.isBookIssued(accessionNum))
                                System.out.println("The book is issued!!");

                            else
                                System.out.println("The book is not issued!!");
                                System.out.println("\nEnter \"Y\" to check Is this book issued? or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                            break;
                            case 0:
                                System.exit(1);
                                break;
                        }//switch

                    }while(chooseNumber !=7);
//////////////////////////////////////////////end of book menu/////////////////////////////////////////
                    break;
////////////////////////////////////////////////member menu//////////////////////////////////////
                case 2:
                    do {
                        System.out.println(
                                "=================================================\n" +
                                        "1- Add Member.\n2- Delete Member." +
                                        "\n3- Search Member." +
                                        "\n4- Number of Member in List." +
                                        "\n5- Is Member List Empty?" +
                                        "\n6- Print Books Issued for member"+
                                        "\n7- Return to main menu." +
                                        "\n0- Exit!\n" +
                                        "================================================="
                        );
                        System.out.println("Enter number from 0-7:");
                        chooseNumber = read.nextInt();
                        switch(chooseNumber){
                            case 1:
                                do{
                                //public LibMember(
                                // String firstName, String lastName, String teleNum,
                                //                     char gender, long cprNum) {

                                System.out.println("Enter firstName, lastName," +
                                        "telephone number, gender and cpr:");
                                firstName=read.next();
                                lastName=read.next();
                                teleNum=read.next();
                                gender=read.next().charAt(0);
                                cpr=read.nextLong();
                                member=new LibMember(
                                        firstName,lastName
                                        ,teleNum,gender,cpr);
                                if (libaray.addMember(member)) {
                                    System.out.println("The member successfully added.");
                                } else
                                    System.out.println("The member can't be added.");
                                System.out.println("\nEnter \"Y\" to add Member or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 2://Delete Member
                                do{
                                System.out.println("Enter member cpr Number:");
                                cpr = read.nextLong();
                                if (libaray.deleteMember(cpr))
                                    System.out.printf("The member cpr %d successfully deleted.\n",cpr);

                                else
                                    System.out.printf("The member cpr %d can't be delete.\n",cpr);
                                System.out.println("\nEnter \"Y\" to Delete Member or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 3://Search Member.
                                do{
                                System.out.println("Enter member cpr Number:");
                                cpr = read.nextLong();
                                if (libaray.searchMember(cpr)!=-1)
                                    System.out.printf("The member cpr %d available in list.\n",cpr);

                                else
                                    System.out.printf("The member cpr %d not available in list.\n",cpr);
                                System.out.println("\nEnter \"Y\" to search for Member or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;
                            case 4:// Member List size
                                do{
                                System.out.printf("%d available member in list.\n",
                                        libaray.sizeMembersList() );
                                System.out.println("\nEnter \"Y\" to recheck Member List number or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                        }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 5://Is Member List Empty?
                                do{
                                if(libaray.isEmptyMembersList())
                                    System.out.println("No member available in list.");

                                else
                                    System.out.println("The list not member empty.");
                                System.out.println("\nEnter \"Y\" to recheck member list empty or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));
                                break;

                            case 6:
                                do{
                                System.out.println("Enter member cpr Number:");
                                cpr = read.nextLong();
                                libaray.printBooksIssued(cpr);
                                System.out.println("\nEnter \"Y\" to reprint member book details or " +
                                        "\"N\" to stop...... ");
                                answer = read.next();
                                }while(!answer.equalsIgnoreCase("N"));

                                break;

                            case 0:
                                System.exit(1);
                                break;

                        }//switch
                    }while (chooseNumber != 7);
                    break;
///////////////////////////////////////////////end of member meun//////////////////////////////////
                case 3:
                    System.out.println("Enter long Accession Number for book.");
                    accessionNum=read.nextLong();
                    System.out.println("Enter CPR Number of the member.");
                    cpr=read.nextLong();
                    if((libaray.issueBook(accessionNum,cpr))){
                        System.out.println("The book successfully issued.");
                    }
                    else
                        System.out.printf(
                                "\n\"The book Accession Number %d & CPR %d not issued\"\n"
                                ,accessionNum,cpr);
                    System.out.println("\nEnter any thing to continue & press enter...... ");
                    read.next();
                    break;
                case 4:
                    System.out.println("Enter long Accession Number for book.");
                    accessionNum=read.nextLong();

                    if(libaray.returnBook(accessionNum)){
                        System.out.println("The book successfully returned.");
                    }
                    else
                        System.out.printf(
                                "\n\"The book Accession Number %d can't be return\"\n"
                                ,accessionNum);
                    System.out.println("\nEnter any thing to continue & press enter...... ");
                    read.next();
                    break;
                case 0:
                    System.exit(1);
                default:
                    System.out.println("invited number please, try again!");
            }
            /*
            "1- Add Book.\n2- Delete Book.\n3- Search Book.\n4- sizeBooksList" +
            "5- Is Empty Books List?\n6- Add Member.\n7- Delete Member\n" +
            "8- Size Members List.\n 9- Is Empty Members List.\n10- Issue Book\n" +
                    "11- Return Book.\n 12-printBooksIssued. 0- Exit!"
             */
        }while(true);




    }//main
}//class
