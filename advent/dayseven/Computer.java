package dayseven;

/*
Each Directory can have exactly 1 parent directory, 
Each Directory can have multiple subdirectories.
Each Directory can have multiple files.

Each File can have exactly 1 parent directory.
Each File can have a size.

Files might have the same name but it shouldnt matter.
 */

public class Computer {
    Directory rootDirectory;
    Directory currentDirectory;

    public Computer(Directory rootDirectory) {
        this.rootDirectory = rootDirectory;
        this.currentDirectory = rootDirectory;
    }

    public Computer() {
        this.rootDirectory = new Directory("/");
        this.currentDirectory = rootDirectory;
    }

    public Directory getRootDirectory() {
        return rootDirectory;
    }

    public void setRootDirectory(Directory rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public Directory getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectoryOutmost() {
        currentDirectory = rootDirectory;
    }

    public void upOneDirectory() {
        currentDirectory = currentDirectory.getParentDirectory();
    }

    public void downOneDirectory(String directoryName) {
        for (Directory directory : currentDirectory.getSubDirectories()) {
            if (directory.getDirectoryName().equals(directoryName)) {
                currentDirectory = directory;
            }
        }
    }

    public void addDirectory(Directory directory) {
        directory.setParentDirectory(currentDirectory);
        currentDirectory.getSubDirectories().add(directory);
    }
}
