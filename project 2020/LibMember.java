package FinalProject;

import java.util.ArrayList;
import java.util.Arrays;


public class LibMember {
    //firstName (String), lastName (String),
    // gender (char), cprNum (long), teleNum (String),
    // booksIssued (array of type Book, size = 10) and
    // numBooksIssued (int).
    private String firstName,lastName,teleNum;
    private char gender;
    private long cprNum;
    private int numBooksIssued;
    private ArrayList<Book> booksIssued;

    //Default constructor (without any parameters),

    public LibMember() {
        this.firstName = "firstName";
        this.lastName = "lastName";
        this.teleNum = "teleNum";
        this.gender = 'n';
        this.cprNum = 0000;
        this.numBooksIssued = 0;
        this.booksIssued = new ArrayList<Book>(10);
    }

    // constructor with 5 parameters
    // (except for booksIssued and numBooksIssued
    // – initialize nubBooksIssued to 0),
    public LibMember(String firstName, String lastName, String teleNum,
                     char gender, long cprNum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.teleNum = teleNum;
        this.gender = gender;
        this.cprNum = cprNum;
        this.numBooksIssued = 0;
        this.booksIssued = new ArrayList<Book>(10);
    }
    // set and get methods for all attributes,

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTeleNum() {
        return teleNum;
    }

    public void setTeleNum(String teleNum) {
        this.teleNum = teleNum;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public long getCprNum() {
        return cprNum;
    }

    public void setCprNum(long cprNum) {
        this.cprNum = cprNum;
    }

    public int getNumBooksIssued() {
        return numBooksIssued;
    }

    public void setNumBooksIssued(int numBooksIssued) {
        if(numBooksIssued >= 0)
        this.numBooksIssued = numBooksIssued;
    }

    public ArrayList getBooksIssued() {

        return booksIssued;
    }

    public void setBooksIssued(ArrayList booksIssued) {

        this.booksIssued = booksIssued;
    }

    // equals
    //


    public boolean equals(LibMember m1) {
        if (this == m1) return true;


        return gender == m1.gender &&
                cprNum == m1.cprNum &&
                numBooksIssued == m1.numBooksIssued &&
                firstName.equals( m1.firstName) &&
                lastName.equals( m1.lastName) &&
                teleNum.equals( m1.teleNum) &&
                booksIssued.equals(m1.booksIssued);
    }




    // and toString.


    @Override
    public String toString() {
        return "LibMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", teleNum='" + teleNum + '\'' +
                ", gender=" + gender +
                ", cprNum=" + cprNum +
                ", numBooksIssued=" + numBooksIssued +
                ", booksIssued=" + booksIssued.toString() +
                '}';
    }

}
