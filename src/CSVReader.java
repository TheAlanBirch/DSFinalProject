import java.util.*;
import java.io.*;

// Got this code from this website.
//www.tutorialspoint.com/
// how-to-read-the-data-from-a-csv-file-in-java#
// :~:text=Java%20Object%20Oriented%20Programming
// %20Programming%20A%20CSV%20stands,
// using%20the%20readLine%20%28%29%20method%20of
// %20BufferedReader%20class.

public class CSVReader {
    public static void readArray(String csvFile, Object[] phoneArray) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
//                    PhoneContact contactOne = new PhoneContact(
//                            tempArr[0], tempArr[1], tempArr[2],
//
//                    );
                }
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        String csvFile = "C:\\Users\\Oppos\\IdeaProjects\\DSFinalProject\\src\\tiny.csv";
//        readArray(csvFile);
    }
}
