/**
 * The Main class is used as the program's point of entry <br>
 * To compile: `javac *.java` in a directory containing both SortedLinkedList.java and Main.java <br>
 * To run:     `java Main` in a directory the .class files live <br>
 * To generate javadocs: `javadoc -d doc *.java` in a directory containing both SortedLinkedList.java and Main.java
 * The index.html page will live in the "doc" subdirectory
 */
public class Main {
    /**
     * Main driver to test SortedLinkedList by using getIntListFromUser() to construct an array
     *
     * @param args Command line args for main (not used)
     */
    public static void main(String[] args) {
        SortedLinkedList sll = SortedLinkedList.getIntsFromUser();

        System.out.println("Sorted Linked list is " + sll);
    }
}