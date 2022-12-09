package dayseven;

public class File {
    String fileName;
    Directory parentDirectory;
    int size;

    public File(String fileName, Directory parentDirectory, int size) {
        this.fileName = fileName;
        this.parentDirectory = parentDirectory;
        this.size = size;
    }

    public File(String fileName, Directory parentDirectory) {
        this.fileName = fileName;
        this.parentDirectory = parentDirectory;
    }

    public File(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "- " + fileName + " (file, size=" + size + ")";
    }
}
