import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.HeapPriorityQueue;
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

public class CSVReader {
    public static long elapsedTime;

    public static void main(String[] args) throws Exception{
        String csvTinyFile = "data/tiny.csv";
        String csvSmallFile = "data/small.csv";
        String csvMediumFile = "data/medium.csv";
        String csvLargeFile = "data/large.csv";

        // Array creation works
//        Object[] phoneArray = new Object[1000000];
//        CSVReader.readArray(csvLargeFile, phoneArray);
//
//        for(Object phoneContact : phoneArray) {
//            System.out.println(phoneContact);
//        }


        // LinkedList creation works
//        LinkedList<Object> phoneLinkedList = new LinkedList<>();
//        readLinkedList(csvLargeFile, phoneLinkedList);
//
//        for(Object phoneContact : phoneLinkedList) {
//            System.out.println(phoneContact);
//        }


        // RBTreeMap creation works
//        RBTreeMap<String, PhoneContact> phoneRBTreeMap = new RBTreeMap<>();
//        readRBTreeMap(csvLargeFile, phoneRBTreeMap);
//
//        phoneRBTreeMap.entrySet().forEach(System.out::println);

        // Hashtable creation works
//        Hashtable<String, PhoneContact> phoneHashtable = new Hashtable<>();
//        readHashtable(csvLargeFile, phoneHashtable);
//        phoneHashtable.entrySet().forEach(System.out::println);

        HeapAdaptablePriorityQueue<String, PhoneContact> phoneHeap = new HeapAdaptablePriorityQueue<>();
        readHeap(csvTinyFile, phoneHeap);
        for (int i = 0; i < phoneHeap.size(); i++)
            System.out.println(phoneHeap.removeMin().getValue());

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

    public static void readRBTreeMap(String csvFile, RBTreeMap<String, PhoneContact> phoneRBTreeMap) {
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
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readHashtable(String csvFile, Hashtable<String, PhoneContact> phoneHashtable) {
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
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public static void readHeap(String csvFile, HeapAdaptablePriorityQueue<String, PhoneContact> phoneHeap) {
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
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
