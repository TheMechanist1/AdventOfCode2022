package dayeight;

import java.util.List;

public class TreeMap {
    private List<List<Tree>> trees;

    public TreeMap(List<List<Tree>> trees) {
        this.trees = trees;
    }

    public int getWidth() {
        return this.trees.size();
    }

    public int getHeight() {
        return this.trees.get(0).size();
    }


    public List<List<Tree>> getTrees() {
        return this.trees;
    }

    public Tree get(int x, int y) {
        return this.trees.get(x).get(y);
    }

    public int getHighestScenicScore() {
        int highestScenicScore = 0;
        for(int x = 0; x < this.getWidth(); x++) {
            for (int y = 0; y < this.getHeight(); y++) {
                Tree tree = this.get(x, y);
                if(tree.getScenicScore() > highestScenicScore) {
                    highestScenicScore = tree.getScenicScore();
                }
            }
        }
        return highestScenicScore;
    }
}