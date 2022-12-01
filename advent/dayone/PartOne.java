package dayone;

import java.util.ArrayList;

public class PartOne {
    private final String puzzleInput;
    public PartOne(String puzzleInput) {
        this.puzzleInput = puzzleInput;
    }

    public ArrayList<Integer> parseIntList() {
        ArrayList<Integer> ElfCalorieUnsorted = new ArrayList<Integer>();

        String[] s = puzzleInput.split("\n\n");

        for (String elfCalorieString: s) {
            String[] foodItems = elfCalorieString.split("\n");
            int totalCalories = 0;
            for(String number: foodItems) {
                totalCalories += Integer.parseInt(number);
            }
            ElfCalorieUnsorted.add(totalCalories);
        }
        return ElfCalorieUnsorted;
    }

    //Parse input into a 2d array and then add and sort accordingly
    public ArrayList<Integer> elvesCaloriesSorter() {
        ArrayList<Integer> unsorted = parseIntList();
        unsorted.sort(Integer::compareTo);
        return unsorted;
    }
}
