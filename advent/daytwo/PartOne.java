package daytwo;

public class PartOne {
    private final String puzzleInput;
    public PartOne(String puzzleInput) {
        this.puzzleInput = puzzleInput;
    }
    public int parsePuzzleInput() {
        String puzzleInputLower = puzzleInput.toLowerCase();
        String[] splitInput = puzzleInputLower.split("\n");
        int total = 0;
        for(String row : splitInput) {
            char opponentTurn = row.charAt(0);
            char myTurn = row.charAt(2);
            //a x Rock
            //b y Paper
            //c z Sizzor
            if(opponentTurn == 'a') { //Rock
                if (myTurn == 'x') { //Rock vs Rock
                    total += 1;
                    total += 3;
                } else if (myTurn == 'y') { // Rock vs Paper
                    total += 2;
                    total += 6;
                } else if (myTurn == 'z') { // Rock vs Scissor
                    total += 3;
                }
            } else if (opponentTurn == 'b') {
                if (myTurn == 'x') { //Paper vs Rock
                    total += 1;
                } else if (myTurn == 'y') { //Paper vs Paper
                    total += 2;
                    total += 3;
                } else if (myTurn == 'z') { //Paper vs Scissor
                    total += 3;
                    total += 6;
                }
            } else if (opponentTurn == 'c') {
                if (myTurn == 'x') { //Scissor vs Rock
                    total += 1;
                    total += 6;
                } else if (myTurn == 'y') { //Scissor vs Paper
                    total += 2;
                } else if (myTurn == 'z') { //Scissor vs Scissor
                    total += 3;
                    total += 3;
                }
            }
        }
        return total;
    }
}
