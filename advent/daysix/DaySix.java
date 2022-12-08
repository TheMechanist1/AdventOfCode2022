package daysix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DaySix
{
    public static File inputFile = new File("advent/daysix/input.txt");
    public static void main( String[] args )
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                for (int i = 3; i < line.length(); i++) {
                    char first = line.charAt(i - 3);
                    char second = line.charAt(i - 2);
                    char third = line.charAt(i - 1);
                    char fourth = line.charAt(i);
                    //No characters are repeated
                    System.out.println(first + " " + second + " " + third + " " + fourth);
                    if (first != second && first != third && first != fourth && second != third && second != fourth && third != fourth) {
                        System.out.println("No characters are repeated " + (i+1) + " " + first + " " + second + " " + third + " " + fourth);
                        break;
                    }
                }

                for (int i = 14; i < line.length(); i++) {
                    char[] charList = new char[14];
                    for (int j = 0; j < 14; j++) {
                        charList[j] = line.charAt(i - 14 + j);
                    }

                    boolean repeated = false;
                    for (int j = 0; j < 14; j++) {
                        for (int k = 0; k < 14; k++) {
                            if (j != k && charList[j] == charList[k]) {
                                repeated = true;
                                break;
                            }
                        }
                    }

                    if (!repeated) {
                        System.out.println("No characters are repeated " + i + " " + line.substring(i - 14, i));
                        break;
                    }
                }
            }

            bufferedReader.close();
        } catch (IOException ioException) {
            System.out.println("File does not exist");
        }
    }
}
