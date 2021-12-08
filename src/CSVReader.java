import java.awt.*;
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
    public static long elapsedTime;

    public static void main(String[] args) throws Exception{
//        String csvFile = "C:\\Users\\Oppos\\IdeaProjects\\DSFinalProject\\src\\tiny.csv";
        String csvTinyFile = "C:\\Users\\Brownao\\IdeaProjects\\DSFinalProject\\src\\tiny.csv";
        String csvSmallFile = "C:\\Users\\Brownao\\IdeaProjects\\DSFinalProject\\src\\small.csv";
        String csvMediumFile = "C:\\Users\\Brownao\\IdeaProjects\\DSFinalProject\\src\\medium.csv";
        String csvLargeFile = "C:\\Users\\Brownao\\IdeaProjects\\DSFinalProject\\src\\large.csv";

//        Object[] phoneArray = new Object[1000000];
//        CSVReader.readArray(csvLargeFile, phoneArray);
//
//        for(Object phoneContact : phoneArray) {
//            System.out.println(phoneContact);
//        }

        LinkedList<Object> phoneLinkedList = new LinkedList<>();
        readLinkedList(csvTinyFile, phoneLinkedList);

        for(Object phoneContact : phoneLinkedList) {
            System.out.println(phoneContact);
        }

        System.out.println();
        System.out.println("Total time is " + elapsedTime + " milliseconds");
    }

    public static void readArray(String csvFile, Object[] phoneArray) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            long startTime = System.currentTimeMillis();
            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5], Integer.parseInt(tempArr[6]), tempArr[7],
                            tempArr[8]
                    );
                    phoneArray[contactOne.Number - 1] = contactOne;
                }
            }
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readLinkedList(String csvFile, LinkedList<Object> phoneLinkedList) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            long startTime = System.currentTimeMillis();
            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]), tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5], Integer.parseInt(tempArr[6]), tempArr[7],
                            tempArr[8]
                    );
                    phoneLinkedList.add(contactOne);
                }
            }
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }


}
