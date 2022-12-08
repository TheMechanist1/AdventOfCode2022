package daytemplate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DayNumber
{
    public static File inputFile = new File("daytemplate//input.txt");
    public static void main( String[] args )
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException ioException) {
            System.out.println("File does not exist");
        }
    }
}
