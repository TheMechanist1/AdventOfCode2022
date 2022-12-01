package dayone;

import java.util.ArrayList;

public class PartTwo {
    private final ArrayList<Integer> puzzleInput = DayOne.partOne.elvesCaloriesSorter();
    public PartTwo() {
    }

    //Get the top three elves and adds them
    public int topThreeElves() {
        int topThreeElves = 0;
        System.out.println(puzzleInput.get(puzzleInput.size() - 1));
        for (int i = 1; i < 4; i++) {
            System.out.println(puzzleInput.get(puzzleInput.size() - i));
            topThreeElves += puzzleInput.get(puzzleInput.size() - i);
        }
        return topThreeElves;
    }
}
