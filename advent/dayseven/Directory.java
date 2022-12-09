package dayseven;

import java.util.ArrayList;

public class Directory {
    String directoryName;
    Directory parentDirectory;
    ArrayList<Directory> subDirectories;
    ArrayList<File> files;
    int size;

    public Directory(String directoryName, Directory parentDirectory, ArrayList<Directory> subDirectories, ArrayList<File> files) {
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
        if (subDirectories == null) {
            this.subDirectories = new ArrayList<Directory>();
        } else {
            this.subDirectories = subDirectories;
        }

        if (files == null) {
            this.files = new ArrayList<File>();
        } else {
            this.files = files;
        }
    }

    public Directory(String directoryName, Directory parentDirectory, ArrayList<Directory> subDirectories) {
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
        this.subDirectories = subDirectories;
    }

    public Directory(String directoryName, Directory parentDirectory) {
        this.directoryName = directoryName;
        this.parentDirectory = parentDirectory;
    }

    public Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public ArrayList<Directory> getSubDirectories() {
        return subDirectories;
    }

    public void setSubDirectories(ArrayList<Directory> subDirectories) {
        this.subDirectories = subDirectories;
    }

    public void addSubDirectory(Directory directory) {
        if (subDirectories == null) {
            subDirectories = new ArrayList<Directory>();
        }
        subDirectories.add(directory);
        directory.setParentDirectory(this);
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<File> files) {
        this.files = files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        if (files == null) {
            files = new ArrayList<File>();
        }
        if (subDirectories == null) {
            subDirectories = new ArrayList<Directory>();
        }
        for (File file : files) {
            totalSize += file.getSize();
        }
        for (Directory directory : subDirectories) {
            totalSize += directory.getTotalSize();
        }
        return totalSize;
    }

    /*
     * - / (dir)
        - a (dir)
            - e (dir)
            - i (file, size=584)
            - f (file, size=29116)
            - g (file, size=2557)
            - h.lst (file, size=62596)
        - b.txt (file, size=14848514)
        - c.dat (file, size=8504156)
        - d (dir)
            - j (file, size=4060174)
            - d.log (file, size=8033020)
            - d.ext (file, size=5626152)
            - k (file, size=7214296)
     */
    @Override
    public String toString() {
        String output = "- " + directoryName + " (dir)";
        if (files == null) {
            files = new ArrayList<File>();
        }
        if (subDirectories == null) {
            subDirectories = new ArrayList<Directory>();
        }

        for (File file : files) {
            output += " " + file.toString();
        }

        for (Directory directory : subDirectories) {
            output += " " + directory.toString();
        }
        return output;
    }
    
}
