import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class CrateListObject {
    private char[][] crates;

    public CrateListObject() {}

    public void initCrates(String fileString) {
        try {
            FileReader inputFile = new FileReader(fileString);
            BufferedReader bufferedReader = new BufferedReader(inputFile);
            char[][] crateStacksOriginal = new char[8][9];
            
            String line;
            for(int i = 0; i < 8; i++) {
                if((line = bufferedReader.readLine()) != null) {
                    int characterNumber = 0;
                    for (int j = 1; j < line.length(); j+=4) {
                        crateStacksOriginal[i][characterNumber] = line.charAt(j);
                        characterNumber += 1;
                    }
                }
            }

            Collections.reverse(Arrays.asList(crateStacksOriginal));

            char[][] crateStacksTransposed = new char[9][72];
            for (int i = 0; i < crateStacksTransposed.length; i++) {
                for (int j = 0; j < crateStacksTransposed[i].length; j++) {
                    crateStacksTransposed[i][j] = ' ';
                }
            }

            for (int i = 0; i < crateStacksOriginal.length; i++) {
                for (int j = 0; j < crateStacksOriginal[i].length; j++) {
                    crateStacksTransposed[j][i] = crateStacksOriginal[i][j];
                }
            }

            // Print the flipped array
            for (char[] row : crateStacksTransposed) {
                System.out.println(Arrays.toString(row));
            }
            
            bufferedReader.close();
            this.crates = crateStacksTransposed;
        } catch (IOException ioException) {
            System.out.println("File does not exist");
        }   
    }

    public int getIndexOfFirstEmptySlot(int stackNumber) {
        int topCrateIndex = 0;
        char[] cs = crates[stackNumber];
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] == ' ') {
                topCrateIndex = i;
                return topCrateIndex;
            }
        }
        return topCrateIndex;
    }

    public char[] getCrateTopToBottom(int stackNumber, int amount) {
        char[] movingCrates = new char[amount];
        int topIndex = getIndexOfFirstEmptySlot(stackNumber);
        for (int i = 0; i < amount; i++) {
            movingCrates[i] = crates[stackNumber][topIndex-i-1];
        }
        return movingCrates;
    }

    public char[] getCrateTopToBottomReversed(int stackNumber, int amount) {
        char[] movingCrates = new char[amount];
        int topIndex = getIndexOfFirstEmptySlot(stackNumber);
        for (int i = 0; i < amount; i++) {
            movingCrates[i] = crates[stackNumber][topIndex-i-1];
        }
        return reverseCrates(movingCrates);
    }

    public void removeCrates(int stackNumber, char[] newCrates) {
        int topIndex = getIndexOfFirstEmptySlot(stackNumber);
        for (int i = 0; i < newCrates.length; i++) {
            crates[stackNumber][topIndex-i-1] = ' ';
        }
    }

    public void setCrates(int stackNumber, char[] newCrates) {
        int topIndex = getIndexOfFirstEmptySlot(stackNumber);
        for (int i = 0; i < newCrates.length; i++) {
            crates[stackNumber][topIndex+i] = newCrates[i];
        }
    }

    public char[] getAllCratesInStack(int stackNumber) {
        return crates[stackNumber];
    }

    public char[] getAllCratesToLargest(int stackNumber) {
        char[] allCrates = getAllCratesInStack(stackNumber);
        char[] largestCrates = new char[getLargestStack()];
        for (int i = 0; i < largestCrates.length; i++) {
            largestCrates[i] = allCrates[i];
        }
        return largestCrates;
    }

    public char[] getAllFilledCrates(int stackNumber) {
        char[] allCrates = getAllCratesInStack(stackNumber);
        char[] filledCrates = new char[getLargestStack()];
        for (int i = 0; i < allCrates.length; i++) {
            if (allCrates[i] != ' ' ) {
                filledCrates[i] = allCrates[i];
            }
        }
        return filledCrates;
    }

    public char[] reverseCrates(char[] crates) {
        char[] reversedCrates = new char[crates.length];
        for (int i = 0; i < crates.length; i++) {
            reversedCrates[i] = crates[crates.length-i-1];
        }
        return reversedCrates;
    }

    public int getLargestStack() {
        int largestStack = 0;
        for (int i = 0; i < 8; i++) {
            if (getIndexOfFirstEmptySlot(i) > largestStack) {
                largestStack = getIndexOfFirstEmptySlot(i);
            }
        }
        return largestStack;
    }

    public int getNumberOfFilledCrates() {
        int numberOfFilledCrates = 0;
        for (int i = 0; i < 9; i++) {
            numberOfFilledCrates += getIndexOfFirstEmptySlot(i)-1;
        }
        return numberOfFilledCrates;
    }

    public void printTopCreate() {
        for (int i = 0; i < 9; i++) {
            System.out.print(crates[i][getIndexOfFirstEmptySlot(i)-1]);
        }
        System.out.println();
    }

    public void printCrates() {
        for (char[] row : crates) {
            for (char crate : row) {
                System.out.print(crate);
            }
            System.out.println();
        }
    }
}
