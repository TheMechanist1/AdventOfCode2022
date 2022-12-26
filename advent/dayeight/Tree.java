package dayeight;

public class Tree {
    private int height;
    private int scenicScore;
    private boolean isVisible;

    public Tree(int height, boolean isVisible) {
        this.height = height;
        this.isVisible = isVisible;
        this.scenicScore = 0;
    }

    public int getHeight() {
        return height;
    }

    public int getScenicScore() {
        return scenicScore;
    }

    public boolean getIsVisible() {
        return isVisible;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public void setIsVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public void setScenicScore(int scenicScore) {
        this.scenicScore = scenicScore;
    }

    public String toString() {
        return "Height: " + height + " Is Visible: " + isVisible;
    }
}
