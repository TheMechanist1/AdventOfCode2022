package dayseven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import helper.HelperFunctions;

public class DaySeven
{
    public static java.io.File inputFile = new java.io.File("advent//dayseven//input.txt");
    public static void main( String[] args )
    {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line = "";
            ArrayList<Directory> allDirectories = new ArrayList<Directory>();
            Computer computer = new Computer();
            //Read lines until the end of the file, and add them to the computer
            while((line = bufferedReader.readLine()) != null) {
                //If $ ls is found, add the next few lines to the computer aswell
                if (line.contains("$ cd")) {
                    String[] CdsplitLine = line.split("\\s+");
                    if(CdsplitLine[2].equals("..")) {
                        computer.upOneDirectory();
                    } else if (CdsplitLine[2].equals("/")) {
                        computer.setCurrentDirectoryOutmost();
                    } else {
                        ArrayList<dayseven.Directory> directories = new ArrayList<Directory>();
                        ArrayList<dayseven.File> files = new ArrayList<File>();
                        String directoryName = CdsplitLine[2];
                        bufferedReader.mark(1000);

                        while((line = bufferedReader.readLine()) != null) {
                            //If the line starts with dir its a Directory
                            if (line.contains("$ cd")) {
                                bufferedReader.reset();
                                break;
                            }
                            if (line.startsWith("dir")) {
                                String[] splitLine = line.split("\\s+");
                                Directory directory = new Directory(splitLine[1], computer.getCurrentDirectory());
                                directories.add(directory);
                            }
                            //If the line starts with a number its a file
                            if (line.matches("[0-9]+.*")) {
                                String[] splitLine = line.split("\\s+");
                                File file = new File(splitLine[1], computer.getCurrentDirectory(), Integer.parseInt(splitLine[0]));
                                files.add(file);
                            }
                        }
                        
                        Directory directory = new Directory(directoryName, computer.getCurrentDirectory(), directories, files);
                        allDirectories.add(directory);
                        computer.getCurrentDirectory().addSubDirectory(directory);
                        computer.downOneDirectory(directoryName);
                    }
                }
            }
            
            //Find all of the directories with a total size of at most 100000. What is the sum of the total sizes of those directories?
            //Iterate through all of the directories
            int totalSize = 0;
            for (Directory directory : allDirectories) {
                //If the directory is less than 100000, add it to the total size
                if (directory.getTotalSize() <= 100000) {
                    totalSize += directory.getTotalSize();
                    HelperFunctions.print(directory.getDirectoryName() + " " + directory.getTotalSize());
                }
            }
            HelperFunctions.print(totalSize);
            computer.setCurrentDirectoryOutmost();
            int toBeFreed = 30000000 - (70000000 - computer.getCurrentDirectory().getTotalSize());

            //Find the smallest directory that can be deleted to free up at least 30000000 bytes of space
            //Iterate through all of the directories
            int smallestDirectory = 1000000000;
            for (Directory directory : allDirectories) {
                //If the directory is less than 100000, add it to the total size
                if (directory.getTotalSize() >= toBeFreed) {
                    if (directory.getTotalSize() < smallestDirectory) {
                        smallestDirectory = directory.getTotalSize();
                    }
                }
            }
            HelperFunctions.print(smallestDirectory);
            bufferedReader.close();
        } catch (IOException ioException) {
            System.out.println("File does not exist");
        }
    }
}
