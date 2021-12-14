import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// Got this code from this website.
//www.tutorialspoint.com/
// how-to-read-the-data-from-a-csv-file-in-java#
// :~:text=Java%20Object%20Oriented%20Programming
// %20Programming%20A%20CSV%20stands,
// using%20the%20readLine%20%28%29%20method%20of
// %20BufferedReader%20class.

public class CsvReader {
    public long memoryUsage;
    Runtime runtime = Runtime.getRuntime();

    public void readFile(String dataStructureChoice,
                         String fileSizeChoice,
                         DataStructureStorage dataStructureStorage) {
        switch (dataStructureChoice) {
            case "Array" -> {
                dataStructureStorage.createPhoneArray(fileSizeChoice);
                readArray(fileSizeChoice,
                        dataStructureStorage.phoneArray);
            }
            case "Linked List" -> readLinkedList(fileSizeChoice,
                    dataStructureStorage.phoneContactLinkedList);
            case "Red-Black Tree" -> readRBTreeMap(fileSizeChoice,
                    dataStructureStorage.phoneContactRBTreeMap);
            case "Hashtable" -> readHashtable(fileSizeChoice,
                    dataStructureStorage.phoneContactHashtable);
            case "Custom" -> readHeap(fileSizeChoice,
                    dataStructureStorage.phoneContactHeap);
        }
    }

    public void readArray(String csvFile,
                          PhoneContact[] phoneArray) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]),
                            tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5],
                            Integer.parseInt(tempArr[6]),
                            tempArr[7], tempArr[8]
                    );
                    phoneArray[contactOne.Number - 1] =
                            contactOne;
                }
            }


            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void
    readLinkedList(String csvFile,
                   LinkedList<PhoneContact> phoneLinkedList) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]),
                            tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5],
                            Integer.parseInt(tempArr[6]),
                            tempArr[7], tempArr[8]
                    );
                    phoneLinkedList.add(contactOne);
                }
            }
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void
    readRBTreeMap(String csvFile,
                  RBTreeMap<String,
                          PhoneContact> phoneRBTreeMap) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]),
                            tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5],
                            Integer.parseInt(tempArr[6]),
                            tempArr[7], tempArr[8]
                    );
                    phoneRBTreeMap.put(contactOne.SearchKey,
                            contactOne);
                }
            }
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void
    readHashtable(String csvFile,
                  Hashtable<String,
                          PhoneContact> phoneHashtable) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]),
                            tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5],
                            Integer.parseInt(tempArr[6]),
                            tempArr[7], tempArr[8]
                    );
                    phoneHashtable.put(contactOne.SearchKey,
                            contactOne);
                }
            }
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void readHeap(String csvFile,
                         HeapAdaptablePriorityQueue<String,
                                 PhoneContact> phoneHeap) {
        try {
            File file = new File(csvFile);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;

            while((line = br.readLine()) != null) {
                if (!line.contains("Number")) {
                    tempArr = line.split(",");
                    PhoneContact contactOne = new PhoneContact(
                            Integer.parseInt(tempArr[0]),
                            tempArr[1], tempArr[2], tempArr[3],
                            tempArr[4], tempArr[5],
                            Integer.parseInt(tempArr[6]),
                            tempArr[7], tempArr[8]
                    );
                    phoneHeap.insert(contactOne.SearchKey,
                            contactOne);
                }
            }
            br.close();

            System.out.println(csvFile + " loaded into array");
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void read1000Entries(String dataStructureChoice,
                                DataStructureStorage storage,
                                OutputPanel outputPanel) {
        PhoneContact[] tempSmallArray = new PhoneContact[500001];
        PhoneContact[] tempMediumArray = new PhoneContact[200001];
        PhoneContact[] tempLargeArray = new PhoneContact[1000001];
        readArray("data/small.csv", tempSmallArray);
        readArray("data/medium.csv", tempMediumArray);
        readArray("data/large.csv", tempLargeArray);

        switch (dataStructureChoice) {
            case "Array" -> read1000Array(storage,
                    outputPanel, tempSmallArray,
                    tempMediumArray, tempLargeArray);
            case "Linked List" -> read1000List(storage,
                    outputPanel, tempSmallArray,
                    tempMediumArray, tempLargeArray);
            case "Red-Black Tree" -> read1000Tree(storage,
                    outputPanel, tempSmallArray,
                    tempMediumArray, tempLargeArray);
            case "Hashtable" -> read1000Hashtable(storage,
                    outputPanel, tempSmallArray,
                    tempMediumArray, tempLargeArray);
            case "Custom" -> read1000Heap(storage,
                    outputPanel, tempSmallArray,
                    tempMediumArray, tempLargeArray);
        }

    }

    public void read1000Array(DataStructureStorage storage,
                              OutputPanel outputPanel,
                              PhoneContact[] tempSmallArray,
                              PhoneContact[] tempMediumArray,
                              PhoneContact[] tempLargeArray) {

        AtomicInteger finalCount = new AtomicInteger(0);
        AtomicInteger finalCount1 = new AtomicInteger(0);
        AtomicInteger finalCount2 = new AtomicInteger(0);


        storage.createPhoneArray("data/small.csv");
        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneArray[finalCount.intValue()] =
                            tempSmallArray[number];
                    finalCount.incrementAndGet();
                });

        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        storage.createPhoneArray("data/medium.csv");
        startTime = System.currentTimeMillis();

        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneArray[finalCount1.intValue()] =
                            tempMediumArray[number];
                    finalCount1.incrementAndGet();
                });

        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        storage.createPhoneArray("data/large.csv");
        startTime = System.currentTimeMillis();

        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneArray[finalCount2.intValue()] =
                            tempLargeArray[number];
                    finalCount2.incrementAndGet();
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results
                .setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");
    }

    public void read1000List(DataStructureStorage storage,
                             OutputPanel outputPanel,
                             PhoneContact[] tempSmallArray,
                             PhoneContact[] tempMediumArray,
                             PhoneContact[] tempLargeArray) {


        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneContactLinkedList
                            .add(tempSmallArray[number]);
                });
        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneContactLinkedList
                            .add(tempMediumArray[number]);
                });
        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(25000).forEach(number -> {
                    storage.phoneContactLinkedList
                            .add(tempLargeArray[number]);
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results
                .setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");
    }

    public void read1000Tree(DataStructureStorage storage,
                             OutputPanel outputPanel,
                             PhoneContact[] tempSmallArray,
                             PhoneContact[] tempMediumArray,
                             PhoneContact[] tempLargeArray) {

        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempSmallArray[number] != null) {
                        storage.phoneContactRBTreeMap
                                .put(tempSmallArray[number].SearchKey,
                                        tempSmallArray[number]);
                    }
                });
        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempMediumArray[number] != null) {
                        storage.phoneContactRBTreeMap
                                .put(tempMediumArray[number].SearchKey,
                                        tempMediumArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempLargeArray[number] != null) {
                        storage.phoneContactRBTreeMap
                                .put(tempLargeArray[number].SearchKey,
                                        tempLargeArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results.setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");
    }

    public void read1000Hashtable(DataStructureStorage storage,
                                  OutputPanel outputPanel,
                                  PhoneContact[] tempSmallArray,
                                  PhoneContact[] tempMediumArray,
                                  PhoneContact[] tempLargeArray) {
        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempSmallArray[number] != null) {
                        storage.phoneContactHashtable
                                .put(tempSmallArray[number].SearchKey,
                                        tempSmallArray[number]);
                    }
                });
        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempMediumArray[number] != null) {
                        storage.phoneContactHashtable
                                .put(tempMediumArray[number].SearchKey,
                                        tempMediumArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempLargeArray[number] != null) {
                        storage.phoneContactHashtable
                                .put(tempLargeArray[number].SearchKey,
                                        tempLargeArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results
                .setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");
    }

    public void read1000Heap(DataStructureStorage storage,
                             OutputPanel outputPanel,
                             PhoneContact[] tempSmallArray,
                             PhoneContact[] tempMediumArray,
                             PhoneContact[] tempLargeArray) {

        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempSmallArray[number] != null) {
                        storage.phoneContactHeap
                                .insert(tempSmallArray[number].SearchKey,
                                        tempSmallArray[number]);
                    }
                });
        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempMediumArray[number] != null) {
                        storage.phoneContactHeap
                                .insert(tempMediumArray[number].SearchKey,
                                        tempMediumArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        storage.clearDataStructure();

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(25000).forEach(number -> {
                    if (tempLargeArray[number] != null) {
                        storage.phoneContactHeap
                                .insert(tempLargeArray[number].SearchKey,
                                        tempLargeArray[number]);
                    }
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results
                .setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");

    }
}
