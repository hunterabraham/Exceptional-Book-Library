//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           ExceptionalBookLibrary
// Files:           Book.java, Librarian.java, Subscriber.java, ExceptionalLibrary.java
// Course:          CS 300, 2019, Semester 2
//
// Author:          Hunter Abraham
// Email:           hjabraham@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    (name of your pair programming partner)
// Partner Email:   (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here.  Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * This class models a librarian who works at a book library. A Librarian is responsible for
 * managing the books in the library and helping the library subscribers to checkout and return
 * books
 */
public class Librarian {
    // instance fields
    private String username; // librarian's username
    private String password; // librarian password to have access to this application

    /**
     * Creates a new Librarian with a given name and a given password
     *
     * @param username username of this librarian
     * @param password password of this librarian to have access to this application
     */
    public Librarian(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Returns the name of this librarian
     *
     * @return the name of this librarian
     */
    public String getUsername() {
        return username;
    }

    /**
     * Checks if a given password equals the password of this librarian
     *
     * @param password a given password
     * @return true if a given password equals the password of this librarian, false otherwise
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

}
