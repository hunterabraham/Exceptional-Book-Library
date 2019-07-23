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

import java.text.ParseException;

/**
 * Testing methods for ExceptionalLibrary.java and supporting classes
 *
 * @author Hunter Abraham
 */
public class ExceptionalBookLibraryTests {

    /**
     * Checks to see if libraryParseCardBarCode() works correctly. This means that it handles
     * ParseExceptions correctly and returns the correct bar code.
     *
     * @return boolean true if the ParseException is handled correctly, false otherwise
     */
    public static boolean testLibraryParseCardBarCode() {
        ExceptionalLibrary library = new ExceptionalLibrary("madison", "april", "abc");
        String testStr1 = "2019000027"; // Create test strings
        String testStr2 = "lalsdkfjae";
        String testStr3 = "8298383838";
        int errorVal = 0; // Value that is used to track the flow of data through the method
        boolean flag = false;
        // Try to go through the various methods, some hit the catch block and some don't.
        // errorVal is used to track how the data flows through the program. If the data doesn't
        // follow the correct path, false is returned.
        int barCode1 = -1;
        // This value should not throw an exception; return false if an exception is thrown
        try {
            barCode1 = library.parseCardBarCode(testStr1, 1);
        } catch (ParseException e) {
            return false;
        }
        // This value should throw an exception. If an
        try {
            library.parseCardBarCode(testStr2, 1);
        } catch (ParseException e) {
            flag = true;
            errorVal += e.getErrorOffset();
        }
        try {
            library.parseCardBarCode(testStr3, 1);
        } catch (ParseException e) {
            flag = true;
            errorVal += e.getErrorOffset();
        }
        if (errorVal != 2 || barCode1 != 2019000027) {
            return false;
        }
        return flag;
    }

    /**
     * Tests the parseRunLibrarianCheckoutBookCommand() method. Ensures that incorrect values
     * cause a ParseException and correct values do not.
     *
     * @return boolean true if all the tests pass, false if any fail
     */
    public static boolean testLibraryParseRunLibrarianCheckoutBookCommand() {
        ExceptionalLibrary library = new ExceptionalLibrary("Madison", "april", "abc");
        Book book = new Book("Title", "Author");
        int errorVal = 0;
        // Try to go through the various methods, some hit the catch block and some don't.
        // errorVal is used to track how the data flows through the program. If the data doesn't
        // follow the correct path, false is returned.

        try {
            Subscriber subscriber = new Subscriber("Hunter", 1234, "Madison", "16172828");
        } catch (InstantiationException e) {
            System.out.println("Error: Instantiation Exception");
            return false;
        }

        String[] commandsFail1 = {"3", "2019000001", "asldkfdks"};
        try {
            library.parseRunLibrarianCheckoutBookCommand(commandsFail1);
        } catch (ParseException e) {
            errorVal += 1;
        }

        String[] commandsFail2 = {"3", "sdljdsfljk", "1"};
        try {
            library.parseRunLibrarianCheckoutBookCommand(commandsFail2);
        } catch (ParseException e) {
            errorVal += 1;
        }

        String[] commandsPass = {"3", "2019000001", "1"};
        try {
            library.parseRunLibrarianCheckoutBookCommand(commandsPass);
            if (!book.isAvailable()) {
                return false;
            }
        } catch (ParseException e) {
            System.out.println("here");
            return false;
        }
        if (errorVal != 2) {
            return false;
        }
        return true;
    }

    /**
     * Tests the parseRunSubscriberReturnBookCommand() method. Ensures that incorrect values
     * cause a ParseException and correct values do not.
     *
     * @return boolean true if all the tests pass, false if any fail
     */
    public static boolean testLibraryParseRunSubscriberReturnBookCommand() {
        // Try to go through the various methods, some hit the catch block and some don't.
        // errorVal is used to track how the data flows through the program. If the data doesn't
        // follow the correct path, false is returned.

        ExceptionalLibrary library = new ExceptionalLibrary("Madison", "april", "abc");
        Book book = new Book("Title", "Author");
        int errorVal = 0;
        // These tests should hit the catch block
        try {
            Subscriber subscriber = new Subscriber("Hunter", 1234, "Madison", "3838382929");
            String[] commandsPass = {"1", "1"};
            library.parseRunSubscriberCheckoutBookCommand(commandsPass, subscriber);
        } catch (InstantiationException e) {
            System.out.println("Error: Instantiation exception");
            return false;
        } catch (ParseException e) {
            System.out.println("Test 1 should have passed but didn't");
            return false;
        }
        // These tests should not hit the catch block
        try {
            Subscriber subscriber = new Subscriber("Hunter", 1234, "Madison", "3838382929");
            String[] commandsFail1 = {"1", "kldsfjsddfj"};
            library.parseRunSubscriberCheckoutBookCommand(commandsFail1, subscriber);
        } catch (InstantiationException e) {
            System.out.println("Error: Instantiation exception");
            return false;
        } catch (ParseException e) {
            errorVal += 1;
        }

        if (errorVal != 1) {
            return false;
        }
        return true;
    }

    /**
     * Tests the parseRunLibrarianRemoveBookCommand() method. Ensures that incorrect values
     * cause a ParseException and correct values do not.
     *
     * @return boolean true if all the tests pass, false if any fail
     */
    public static boolean testParseRunLibrarianRemoveBookCommand() {
        // Try to go through the various methods, some hit the catch block and some don't.
        // errorVal is used to track how the data flows through the program. If the data doesn't
        // follow the correct path, false is returned.

        ExceptionalLibrary library = new ExceptionalLibrary("Madison", "april", "abc");
        String[] commandsPassAdd = {"1", "The", "Author"};
        String[] commandsPassRemove = {"8", "3"};
        // If either of the methods hit an exception, return false. If the book isn't added
        // correctly, return false
        try {
            library.parseRunLibrarianAddBookCommand(commandsPassAdd);
        } catch (ParseException e) {
            return false;
        }
        try {
            library.parseRunLibrarianRemoveBookCommand(commandsPassRemove);
        } catch (ParseException e) {
            return false;
        }
        if (library.getBooks().size() != 0) {
            return false;
        }
        return true;
    }

    /**
     * Tests the parseRunLibrarianCheckoutBookCommand() method. Ensures that incorrect values
     * cause a ParseException and correct values do not.
     *
     * @return boolean true if all the tests pass, false if any fail
     */
    public static boolean testParseRunLibrarianCheckoutBookCommand() {
        // Try to go through the various methods, some hit the catch block and some don't.
        // errorVal is used to track how the data flows through the program. If the data doesn't
        // follow the correct path, false is returned.

        ExceptionalLibrary library = new ExceptionalLibrary("Madison", "april", "abc");
        library.addBook("title", "author");
        int errorVal = 0;
        try {
            library.addSubscriber("Person", 1234, "Madison", "8499584939");
            String[] commandsPass = {"3", "2019000004", "4"};
            library.parseRunLibrarianCheckoutBookCommand(commandsPass);
            if (library.getBooks().get(0).isAvailable()) {
                return false;
            }
        } catch (InstantiationException | ParseException e) {
            return false;
        }
        try {
            Subscriber subscriber = new Subscriber("Person", 1234, "Madison", "3839402039");
            String[] commandsFail = {"3", "ajlskfd", ";adjkls"};
            library.parseRunLibrarianCheckoutBookCommand(commandsFail);
        } catch (InstantiationException | ParseException e) {
            errorVal += 1;
        }
        if (errorVal != 1) {
            return false;
        }
        return true;
    }

    /**
     * Driving method for ExceptionalBookLibraryTests.java. Runs all the tests and prints the
     * results.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        System.out.println("testLibraryParseCardBarCode(): " + testLibraryParseCardBarCode());
        System.out.println("testLibraryParseRunLibrarianCheckoutBookCommand(): "
            + testLibraryParseRunLibrarianCheckoutBookCommand());
        System.out.println("testLibraryParseRunSubcriberReturnBookCommand(): "
            + testLibraryParseRunSubscriberReturnBookCommand());
        System.out.println("testParseRunLibrarianRemoveBookCommand(): "
            + testParseRunLibrarianRemoveBookCommand());
        System.out.println("testLibraryParseRunLibrarianCheckoutBookCommand(): "
            + testParseRunLibrarianCheckoutBookCommand());
    }
}
