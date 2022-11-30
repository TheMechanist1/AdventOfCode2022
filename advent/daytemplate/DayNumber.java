package daytemplate;

public class DayNumber
{
    public static String partOnePuzzleInput = "";
    public static String partTwoPuzzleInput = "";
    public static PartOne partOne = new PartOne(partOnePuzzleInput);
    public static PartTwo partTwo = new PartTwo(partTwoPuzzleInput);

    public static void main( String[] args )
    {
        System.out.println("""
                ┌─────────────────────────────────────────────────────────────────────────────┐
                │                                Part 1 Output                                │
                └─────────────────────────────────────────────────────────────────────────────┘
                """);
        System.out.println(partOne.methodNameHere());
        System.out.println("""
                ┌─────────────────────────────────────────────────────────────────────────────┐
                │                                Part 2 Output                                │
                └─────────────────────────────────────────────────────────────────────────────┘
                """);
        System.out.println(partTwo.methodNameHere());
    }
}
