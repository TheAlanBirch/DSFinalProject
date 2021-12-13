import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;

public class DataStructureStorage {
    Runtime runtime = Runtime.getRuntime();
    public PhoneContact[] phoneArray;
    public LinkedList<PhoneContact> phoneContactLinkedList = new LinkedList<>();
    public RBTreeMap<String, PhoneContact> phoneContactRBTreeMap = new RBTreeMap<>();
    public Hashtable<String, PhoneContact> phoneContactHashtable = new Hashtable<>();
    public HeapAdaptablePriorityQueue<String, PhoneContact> phoneContactHeap
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
            phoneContactHeap = new HeapAdaptablePriorityQueue<>();
    }

    public String searchDataStructure(String dataStructureChoice, String searchKey) {
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
                if (Objects.equals(searchKey, phoneArray[i].SearchKey))
                    return phoneArray[i].toString();
            }
        }

        return "Could not find entry from given search key.";
    }

    public String searchLinkedList(String searchKey) {
            for (int i = 0; i < phoneContactLinkedList.size() - 1; i++) {
                if (Objects.equals(phoneContactLinkedList.get(i).SearchKey, searchKey))
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
        HeapAdaptablePriorityQueue<String, PhoneContact> tempHeap = phoneContactHeap;

        System.out.println("Starting minimum: " + phoneContactHeap.min().getKey());
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

    }

    public void runSearch(String dataStructureChoice,
                     DataStructureStorage storage,
                          OutputPanel outputPanel) {

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
                    storage, outputPanel);
            case "Memory" -> findMemoryUsage(dataStructureChoice,
                    storage, reader, outputPanel);
        }
    }

    public void findMemoryUsage(String dataStructureChoice,
                                DataStructureStorage storage,
                                CsvReader reader,
                                OutputPanel outputPanel) {

        long initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice,"data/small.csv", storage);
        long afterMemory = runtime.freeMemory();
        long smallMemory = (initialMemory - afterMemory) / mb;

        initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice, "data/medium.csv", storage);
        afterMemory = runtime.freeMemory();
        long mediumMemory = (initialMemory - afterMemory) / mb;

        initialMemory = runtime.freeMemory();
        reader.readFile(dataStructureChoice, "data/large.csv", storage);
        afterMemory = runtime.freeMemory();
        long largeMemory = (initialMemory - afterMemory) / mb;

        outputPanel.results.setText("Small File: " + smallMemory + " mb\n" +
                "Medium File: " + mediumMemory + " mb\n" +
                "Large File: " + largeMemory + " mb");
    }
}
