package dayeight;

import helper.HelperFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DayEight
{
    public static File inputFile = new File("advent//dayeight//input.txt");
//    public static File inputFile = new File("advent//dayeight//testInput.txt");
    public static void main( String[] args )
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            List<List<Tree>> tree2d = new ArrayList<>();
            int treeCount = 0;
            while((line = bufferedReader.readLine()) != null) {
                Tree tree;
                List<Tree> trees = new ArrayList<>();
                for (int i = 0; i < line.length(); i++) {
                    tree = new Tree(Integer.parseInt(String.valueOf(line.charAt(i))), false);
                    trees.add(tree);
                }
                tree2d.add(trees);
            }

            TreeMap treeMap = new TreeMap(tree2d);
            StringBuilder treeStringNorm = new StringBuilder();

            for(int x = 0; x < treeMap.getWidth(); x++) {
                for (int y = 0; y < treeMap.getHeight(); y++) {
                    Tree tree = treeMap.get(x, y);
                    Tree treeFlip = treeMap.get(y, x);

                    if(x == 0 || x == treeMap.getWidth()-1 || y == 0 || y == treeMap.getHeight()-1) {
                        tree.setIsVisible(true);
                    } else {
                        boolean isATallerTreeR = false;
                        boolean isATallerTreeL = false;
                        boolean isATallerTreeU = false;
                        boolean isATallerTreeD = false;
                        int scoreUp = 0;
                        int scoreDown = 0;
                        int scoreLeft = 0;
                        int scoreRight = 0;

                        int deltaTreePos = 0;

                        //Check if there is a tree to the right
                        for (int z = x+1; z < treeMap.getWidth(); z++) {
                            Tree treeToComp = treeMap.get(z, y);
                            deltaTreePos = z - x;
                            //Check if any taller trees
                            if(treeToComp.getHeight() >= tree.getHeight()) {
                                isATallerTreeR = true;
                                break;
                            }
                        }
                        scoreRight = deltaTreePos;
                        deltaTreePos = 0;

                        //Check if there is a tree to the left
                        for (int z = x-1; z >= 0; z--) {
                            Tree treeToComp = treeMap.get(z, y);
                            deltaTreePos = x - z;
                            //Ignore the tree itself
                            //Check if any taller trees
                            if(treeToComp.getHeight() >= tree.getHeight()) {
                                isATallerTreeL = true;
                                break;
                            }
                        }
                        scoreLeft = deltaTreePos;
                        deltaTreePos = 0;

                        //Check if there is a tree above
                        for (int z = y+1; z < treeMap.getHeight(); z++) {
                            Tree treeToComp = treeMap.get(x, z);
                            deltaTreePos = z - y;
                            //Check if any taller trees
                            if(treeToComp.getHeight() >= tree.getHeight()) {
                                isATallerTreeD = true;
                                break;
                            }
                        }
                        scoreDown = deltaTreePos;
                        deltaTreePos = 0;

                        //Check if there is a tree below
                        for (int z = y-1; z >= 0; z--) {
                            Tree treeToComp = treeMap.get(x, z);
                            deltaTreePos = y - z;
                            //Check if any taller trees
                            if(treeToComp.getHeight() >= tree.getHeight()) {
                                isATallerTreeU = true;
                                break;
                            }
                        }
                        scoreUp = deltaTreePos;

                        if(!isATallerTreeR || !isATallerTreeL || !isATallerTreeU || !isATallerTreeD) {
                            tree.setIsVisible(true);
                        }
                        tree.setScenicScore(scoreUp * scoreDown * scoreLeft * scoreRight);
                        HelperFunctions.printDebug("Tree at " + x + ", " + y + " has a score of " + scoreUp + " * " + scoreLeft + " * " + scoreDown + " * " + scoreRight + " = " + tree.getScenicScore());
                    }
                    //Build tree string with T and F
                    if(tree.getIsVisible()) {
                        treeCount++;
                        treeStringNorm.append("T");
                    } else {
                        treeStringNorm.append("F");
                    }
                }
                treeStringNorm.append("\n");
            }
            HelperFunctions.print(treeMap.getWidth() + " " + treeMap.getHeight() + " " + treeCount);
            HelperFunctions.print(treeStringNorm.toString());
            HelperFunctions.print(treeMap.getHighestScenicScore());
            bufferedReader.close();
        } catch (IOException ioException) {
            System.out.println("File does not exist");
        }
    }

}
