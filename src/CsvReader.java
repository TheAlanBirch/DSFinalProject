import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;
import java.io.*;

// Got this code from this website.
//www.tutorialspoint.com/
// how-to-read-the-data-from-a-csv-file-in-java#
// :~:text=Java%20Object%20Oriented%20Programming
// %20Programming%20A%20CSV%20stands,
// using%20the%20readLine%20%28%29%20method%20of
// %20BufferedReader%20class.

public class CsvReader {
    public long elapsedTime;

    public void readFile(String dataStructureChoice, String fileSizeChoice, DataStructureStorage dataStructureStorage) {
        switch (dataStructureChoice) { // {"Array", "Linked List","Red-Black Tree", "Hashtable", "Custom"};
            case "Array" -> {
                dataStructureStorage.createPhoneArray(fileSizeChoice);
                readArray(fileSizeChoice, dataStructureStorage.phoneArray);
            }
            case "Linked List" -> readLinkedList(fileSizeChoice, dataStructureStorage.phoneContactLinkedList);
            case "Red-Black Tree" -> readRBTreeMap(fileSizeChoice, dataStructureStorage.phoneContactRBTreeMap);
            case "Hashtable" -> readHashtable(fileSizeChoice, dataStructureStorage.phoneContactHashtable);
            case "Custom" -> readHeap(fileSizeChoice, dataStructureStorage.phoneContactHeap);
        }
    }

    public void readArray(String csvFile, PhoneContact[] phoneArray) {
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

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readLinkedList(String csvFile, LinkedList<PhoneContact> phoneLinkedList) {
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

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readRBTreeMap(String csvFile, RBTreeMap<String, PhoneContact> phoneRBTreeMap) {
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
                    phoneRBTreeMap.put(contactOne.SearchKey, contactOne);
                }
            }
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readHashtable(String csvFile, Hashtable<String, PhoneContact> phoneHashtable) {
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
                    phoneHashtable.put(contactOne.SearchKey, contactOne);
                }
            }
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readHeap(String csvFile, HeapAdaptablePriorityQueue<String, PhoneContact> phoneHeap) {
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
                    phoneHeap.insert(contactOne.SearchKey, contactOne);
                }
            }
            long endTime = System.currentTimeMillis();
            elapsedTime = endTime - startTime;
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
