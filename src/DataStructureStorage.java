import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;
import java.lang.Math;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class DataStructureStorage {
    Runtime runtime = Runtime.getRuntime();
    public PhoneContact[] phoneArray;
    public LinkedList<PhoneContact>
            phoneContactLinkedList = new LinkedList<>();
    public RBTreeMap<String, PhoneContact>
            phoneContactRBTreeMap = new RBTreeMap<>();
    public Hashtable<String, PhoneContact>
            phoneContactHashtable = new Hashtable<>();
    public HeapAdaptablePriorityQueue<String,
            PhoneContact> phoneContactHeap
            = new HeapAdaptablePriorityQueue<>();

    public int capacity = 0;
    public int mb = 1024 * 1024;

    public void createPhoneArray(String fileSizeChoice) {
        switch (fileSizeChoice) {
            case "data/tiny.csv" -> capacity = 21;
            case "data/small.csv" -> capacity = 50001;
            case "data/medium.csv" -> capacity = 200001;
            case "data/large.csv" -> capacity = 1000001;
        }

        phoneArray = new PhoneContact[capacity];
    }

    public void clearDataStructure() {
            phoneArray = new PhoneContact[capacity];
            phoneContactLinkedList = new LinkedList<>();
            phoneContactRBTreeMap = new RBTreeMap<>();
            phoneContactHashtable = new Hashtable<>();
            phoneContactHeap =
                    new HeapAdaptablePriorityQueue<>();
    }

    public String searchDataStructure(String dataStructureChoice,
                                      String searchKey) {
        switch (dataStructureChoice) {
            case "Array" -> {
                return searchArray(searchKey);
            }
            case "Linked List" -> {
                return searchLinkedList(searchKey);
            }
            case "Red-Black Tree" -> {
                return searchRBTreeMap(searchKey);
            }
            case "Hashtable" -> {
                return searchHashtable(searchKey);
            }
            case "Custom" -> {
                return searchHeap(searchKey);
            }
        }

        return "Error in searchDataStructure";
    }

    public String searchArray(String searchKey) {
        for (int i = 0; i < phoneArray.length - 1; i++) {
            if (phoneArray[i] != null) {
                if (Objects.equals(searchKey,
                        phoneArray[i].SearchKey))
                    return phoneArray[i].toString();
            }
        }

        return "Could not find entry from given search key.";
    }

    public String searchLinkedList(String searchKey) {
            for (int i = 0; i < phoneContactLinkedList
                    .size() - 1; i++) {
                if (Objects.equals(phoneContactLinkedList
                        .get(i).SearchKey, searchKey))
                    return phoneContactLinkedList.get(i).toString();
            }

        return "Could not find entry from given search key.";
    }

    public String searchRBTreeMap(String searchKey) {
        if (phoneContactRBTreeMap.get(searchKey) != null)
            return phoneContactRBTreeMap.get(searchKey).toString();

        return "Could not find entry from given search key.";
    }

    public String searchHashtable(String searchKey) {
        if (phoneContactHashtable.containsKey(searchKey))
            return phoneContactHashtable.get(searchKey).toString();

        return "Could not find entry from given search key.";
    }

    public String searchHeap(String searchKey) {
        HeapAdaptablePriorityQueue<String, PhoneContact>
                tempHeap = phoneContactHeap;

        System.out.println("Starting minimum: " +
                phoneContactHeap.min().getKey());
        for (int i = 0;
             i < phoneContactHeap.size() - 1;
             i++) {

            if (Objects.equals(tempHeap.min().getKey(), searchKey))
                return tempHeap.removeMin().getValue().toString();
            else
                tempHeap.removeMin();
            System.out.println(tempHeap.min().getKey());
        }

        return "Could not find entry from given search key.";
    }

    public void runInsertion(String dataStructureChoice,
                             DataStructureStorage storage,
                             CsvReader reader,
                             OutputPanel outputPanel) {

        reader.read1000Entries(dataStructureChoice,
                storage, outputPanel);

    }

    public void runSearch(String dataStructureChoice,
                          CsvReader reader,
                          OutputPanel outputPanel) {

        DataStructureStorage smallStorage =
                new DataStructureStorage();
        DataStructureStorage mediumStorage =
                new DataStructureStorage();
        DataStructureStorage largeStorage =
                new DataStructureStorage();

        switch (dataStructureChoice) {
            case "Array" -> {
                smallStorage
                        .createPhoneArray("data/small.csv");
                reader.readArray("data/small.csv",
                        smallStorage.phoneArray);

                mediumStorage
                        .createPhoneArray("data/medium.csv");
                reader.readArray("data/medium.csv",
                        mediumStorage.phoneArray);

                largeStorage
                        .createPhoneArray("data/large.csv");
                reader.readArray("data/large.csv",
                        largeStorage.phoneArray);
            }

            case "Linked List" -> {
                reader.readLinkedList("data/small.csv",
                        smallStorage.phoneContactLinkedList);
                reader.readLinkedList("data/medium.csv",
                        mediumStorage.phoneContactLinkedList);
                reader.readLinkedList("data/large.csv",
                        largeStorage.phoneContactLinkedList);
            }

            case "Red-Black Tree" -> {
                reader.readRBTreeMap("data/small.csv",
                        smallStorage.phoneContactRBTreeMap);
                reader.readRBTreeMap("data/medium.csv",
                        mediumStorage.phoneContactRBTreeMap);
                reader.readRBTreeMap("data/large.csv",
                        largeStorage.phoneContactRBTreeMap);
            }

            case "Hashtable" -> {
                reader.readHashtable("data/small.csv",
                        smallStorage.phoneContactHashtable);
                reader.readHashtable("data/medium.csv",
                        mediumStorage.phoneContactHashtable);
                reader.readHashtable("data/large.csv",
                        largeStorage.phoneContactHashtable);
            }

            case "Custom" -> {
                reader.readHeap("data/small.csv",
                        smallStorage.phoneContactHeap);
                reader.readHeap("data/medium.csv",
                        mediumStorage.phoneContactHeap);
                reader.readHeap("data/large.csv",
                        largeStorage.phoneContactHeap);
            }
        }

        runUniversalSearch(dataStructureChoice, reader,
                smallStorage, mediumStorage,
                largeStorage, outputPanel);
    }

    public void runUniversalSearch(String dataStructureChoice,
                                   CsvReader reader,
                                   DataStructureStorage smallStorage,
                                   DataStructureStorage mediumStorage,
                                   DataStructureStorage largeStorage,
                                   OutputPanel outputPanel) {

        PhoneContact[] tempSmallArray = new PhoneContact[50000];
        reader.readArray("data/small.csv", tempSmallArray);
        PhoneContact[] tempMediumArray = new PhoneContact[200000];
        reader.readArray("data/medium.csv", tempMediumArray);
        PhoneContact[] tempLargeArray = new PhoneContact[1000000];
        reader.readArray("data/large.csv", tempLargeArray);

        long startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 50000)
                .distinct().limit(1000).forEach(number -> {
                    System.out.println(tempSmallArray[number]);
                    if (tempSmallArray[number] != null) {
                        String searchKey = tempSmallArray[number].SearchKey;

                        String tempString = smallStorage
                                .searchDataStructure(dataStructureChoice,
                                        searchKey);
                    }
                });
        long endTime = System.currentTimeMillis();
        long smallTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 200000)
                .distinct().limit(1000).forEach(number -> {
                    if (tempMediumArray[number] != null) {
                        String searchKey = tempMediumArray[number].SearchKey;

                        String tempString = mediumStorage
                                .searchDataStructure(dataStructureChoice,
                                        searchKey);
                    }
                });
        endTime = System.currentTimeMillis();
        long mediumTime = endTime - startTime;

        startTime = System.currentTimeMillis();
        ThreadLocalRandom.current()
                .ints(0, 1000000)
                .distinct().limit(1000).forEach(number -> {
                    if (tempLargeArray[number] != null) {
                        String searchKey = tempLargeArray[number].SearchKey;

                        String tempString = largeStorage
                                .searchDataStructure(dataStructureChoice,
                                        searchKey);
                    }
                });
        endTime = System.currentTimeMillis();
        long largeTime = endTime - startTime;

        outputPanel.results.setText("Small Time: " + smallTime + " ms\n" +
                "Medium Time: " + mediumTime + " ms\n" +
                "Large Time: " + largeTime +" ms");
    }

    public void runMeasurement(String dataStructureChoice,
                               DataStructureStorage storage,
                               CsvReader reader,
                               OutputPanel outputPanel,
                               String measurementChoice){

        switch (measurementChoice) {
            case "Insertion" -> runInsertion(dataStructureChoice,
                    storage, reader, outputPanel);
            case "Look-Up" -> runSearch(dataStructureChoice,
                    reader, outputPanel);
            case "Memory" -> findMemoryUsage(dataStructureChoice,
                    storage, reader, outputPanel);
        }
    }

    public void findMemoryUsage(String dataStructureChoice,
                                DataStructureStorage storage,
                                CsvReader reader,
                                OutputPanel outputPanel) {

        long initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice,
                "data/small.csv", storage);
        long afterMemory = runtime.freeMemory();
        long smallMemory =
                Math.abs((initialMemory - afterMemory) / mb);

        initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice,
                "data/medium.csv", storage);
        afterMemory = runtime.freeMemory();
        long mediumMemory =
                Math.abs((initialMemory - afterMemory) / mb);

        initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice,
                "data/large.csv", storage);
        afterMemory = runtime.freeMemory();
        long largeMemory =
                Math.abs((initialMemory - afterMemory) / mb);

        outputPanel.results
                .setText("Small File: " + smallMemory + " mb\n" +
                "Medium File: " + mediumMemory + " mb\n" +
                "Large File: " + largeMemory + " mb");
    }
}
