package daytemplate;

public class DayNumber
{
    public static String puzzleInput = "";
    public static PartOne partOne = new PartOne(puzzleInput);
    public static PartTwo partTwo = new PartTwo(puzzleInput);

    public static void main( String[] args )
    {
        System.out.println("""
                ┌─────────────────────────────────────────────────────────────────────────────┐
                │                                Part 1 Output                                │
                └─────────────────────────────────────────────────────────────────────────────┘
                """);
        System.out.println(partOne.parsePuzzleInput());
        System.out.println("""
                ┌─────────────────────────────────────────────────────────────────────────────┐
                │                                Part 2 Output                                │
                └─────────────────────────────────────────────────────────────────────────────┘
                """);
        System.out.println(partTwo.parsePuzzleInput());
    }
}
