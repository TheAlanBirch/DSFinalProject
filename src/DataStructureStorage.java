import goodrichStructures.Entry;
import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;

public class DataStructureStorage {
    public PhoneContact[] phoneArray;
    public LinkedList<PhoneContact> phoneContactLinkedList = new LinkedList<>();
    public RBTreeMap<String, PhoneContact> phoneContactRBTreeMap = new RBTreeMap<>();
    public Hashtable<String, PhoneContact> phoneContactHashtable = new Hashtable<>();
    public HeapAdaptablePriorityQueue<String, PhoneContact> phoneContactHeap
            = new HeapAdaptablePriorityQueue<>();

    public void createPhoneArray(String fileSizeChoice) {
        int capacity = 0;
        switch (fileSizeChoice) {
            case "data/tiny.csv" -> capacity = 21;
            case "data/small.csv" -> capacity = 50001;
            case "data/medium.csv" -> capacity = 200001;
            case "data/large.csv" -> capacity = 1000001;
        }

        phoneArray = new PhoneContact[capacity];
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
                if (Objects.equals(searchKey, phoneArray[i].SearchKey))
                    return phoneArray[i].toString();
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
}
