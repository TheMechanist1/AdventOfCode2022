package daytwo;

public class PartTwo {
    private final String puzzleInput;
    public PartTwo(String puzzleInput) {
        this.puzzleInput = puzzleInput;
    }
    public int parsePuzzleInput() {
        String puzzleInputLower = puzzleInput.toLowerCase();
        String[] splitInput = puzzleInputLower.split("\n");
        int total = 0;
        for(String row : splitInput) {
            char opponentTurn = row.charAt(0);
            char myTurn = row.charAt(2);
            //a Rock
            //b Paper
            //c Sizzor

            //x LOSE
            //y DRAW
            //z WIN
            if(opponentTurn == 'a') { //Rock
                switch (myTurn) {
                    case 'z' -> {
                        //Win, must be Paper
                        total += 6;
                        total += 2;
                    }
                    case 'x' -> {
                        //Lose, must be Scissor
                        total += 0;
                        total += 3;
                    }
                    case 'y' -> {
                        //Draw, must be Rock
                        total += 3;
                        total += 1;
                    }
                }
            } else if (opponentTurn == 'b') { //Paper
                switch (myTurn) {
                    case 'z' -> {
                        //Win, must be Scissor
                        total += 6;
                        total += 3;
                    }
                    case 'x' -> {
                        //Lose, must be Rock
                        total += 0;
                        total += 1;
                    }
                    case 'y' -> {
                        //Draw, must be Paper
                        total += 3;
                        total += 2;
                    }
                }
            } else if (opponentTurn == 'c') { //Scissor
                switch (myTurn) {
                    case 'z' -> {
                        //Win, must be Rock
                        total += 6;
                        total += 1;
                    }
                    case 'x' -> {
                        //Lose, must be Paper
                        total += 0;
                        total += 2;
                    }
                    case 'y' -> {
                        //Draw, must be Scissor
                        total += 3;
                        total += 3;
                    }
                }
            }
        }
        return total;
    }
}
