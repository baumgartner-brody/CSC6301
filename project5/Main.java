/**
 * The Main class is used as the program's point of entry <br>
 * To compile: `javac *.java` in a directory containing both SortedStack.java and Main.java <br>
 * To run:     `java Main` in a directory the .class files live <br>
 * To generate javadocs: `javadoc -d doc *.java` in a directory containing both SortedStack.java and Main.java
 * The index.html page will live in the "doc" subdirectory
 * 
 * After running the source code through meld, it can be seen that only 20 / 113 SLoC (or 17.6%) of the codebase
 * was modified. Of those changes, 11 lines were comments and 9 were actual code
 */
public class Main {
    /**
     * Main driver to test SortedStack by using getIntListFromUser() to construct an array
     *
     * @param args Command line args for main (not used)
     */
    public static void main(String[] args) {
        SortedStack ss = SortedStack.getIntsFromUser();

        System.out.println("Sorted Stack is " + ss);
    }
}