import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DayFive
{
    // public static PartOne partOne = new PartOne(parsePuzzleInput());
    // public static PartTwo partTwo = new PartTwo(parsePuzzleInput());

    // 72 x 9 array of ArrayLists
    
    public static ArrayList<Integer> instructionsParser() {
        try {
            FileReader inputFile = new FileReader("dayfive//input.txt");
            BufferedReader bufferedReader = new BufferedReader(inputFile);
            String line;
            ArrayList<Integer> instructions = new ArrayList<Integer>();
            while((line = bufferedReader.readLine()) != null) {
                if(!line.startsWith("[") && !line.startsWith(" ") && line != "") {
                    String replaced = line.replace("move ", "").replace("from ", "").replace(" to ", " ");
                    String[] splitLine = replaced.split(" ");
                    for(String s : splitLine) {
                        System.out.println(s);
                        instructions.add(Integer.parseInt(s));
                    }
                }
            }
            bufferedReader.close();
            return instructions;
        } catch (IOException ioException) {
            System.out.println("File does not exist");
            return new ArrayList<Integer>();
        } 
    }

    public static void main( String[] args )
    {
        //partOne = new PartOne(null);
        //partTwo = new PartTwo(null);
        CrateListObject crates = new CrateListObject();
        crates.initCrates("dayfive//input.txt");
        //System.out.println(crates.getCrateTopToBottom(2, 1));
        ArrayList<Integer> ints = instructionsParser();
        int iterationNumber = 0;
        for(int i = 0; i < ints.size(); i+=3) {
            int numOfBoxes = ints.get(i);
            int fromStackNumber = ints.get(i+1) - 1;
            int toStackNumber = ints.get(i+2) - 1;
            System.out.println("Instruction " + iterationNumber + ": " + numOfBoxes + " from " + fromStackNumber + " to " + toStackNumber);
            System.out.println("Number of creates: " + crates.getNumberOfFilledCrates());
            char[] crateTemp = crates.getCrateTopToBottom(fromStackNumber, numOfBoxes);
            crates.removeCrates(fromStackNumber, crateTemp);
            crates.setCrates(toStackNumber, crateTemp);
            System.out.println("Number of creates: " + crates.getNumberOfFilledCrates());
            System.out.println();
            iterationNumber += 1;
        }
        crates.printTopCreate();


    }
}
