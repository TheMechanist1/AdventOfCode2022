package helper;

public class HelperFunctions {
    // Make printing easier
    public static void print(Object o) {
        System.out.println(o);
    }

    // Make printing arrayLists easier
    public static void printArray(Object[] o) {
        for (Object i : o) {
            System.out.println(i);
        }
    }

    public static void printDebug(String s) {
        //Print debug statements
        System.out.println("[Debug] " + s);
    }
}
