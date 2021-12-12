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

    public void searchDataStructure(String dataStructureChoice, String searchKey) {
        switch (dataStructureChoice) {
            case "Array" -> searchArray(searchKey);
            case "Linked List" -> searchLinkedList(searchKey);
            case "Red-Black Tree" -> searchRBTreeMap(searchKey);
            case "Hashtable" -> searchHashtable(searchKey);
            case "Custom" -> searchHeap(searchKey);
        }
    }

    public String searchArray(String searchKey) {
            for (int i = 0; i < phoneArray.length - 1; i++) {
                if (Objects.equals(searchKey, phoneArray[i].SearchKey))
                    return phoneArray[i].toString();
            }

            return "Could not find entry from given search key.";
    }

    public void searchLinkedList(String searchKey, String searchResult) {
        try {
            for (int i = 0; i < phoneContactLinkedList.size() - 1; i++) {
                if (phoneContactLinkedList.get(i).SearchKey == searchKey)
                    searchResult = phoneContactLinkedList.get(i).toString();
            }
        } catch(Exception e) {
            searchResult = "Could not find entry from given search key.";
        }
    }

    public void searchRBTreeMap(String searchKey, String searchResult) {
        try {
            if (phoneContactRBTreeMap.get(searchKey) != null)
                searchResult = phoneContactRBTreeMap.get(searchKey).toString();
        } catch(Exception e) {
            searchResult = "Could not find entry from given search key.";
        }
    }

    public void searchHashtable(String searchKey, String searchResult) {
        try {
            if (phoneContactHashtable.containsKey(searchKey))
                searchResult = phoneContactHashtable.get(searchKey).toString();
        } catch(Exception e) {
            searchResult = "Could not find entry from given search key.";
        }
    }

    public void searchHeap(String searchKey, String searchResult) {
        try {
            HeapAdaptablePriorityQueue<String, PhoneContact> tempHeap = phoneContactHeap;

            System.out.println("Starting minimum: " + phoneContactHeap.min());
            for (int i = 0;
                 i < phoneContactHeap.size() - 1;
                 i++) {

                if (tempHeap.min().getKey() == searchKey)
                    searchResult = tempHeap.removeMin().getValue().toString();
                System.out.println(phoneContactHeap.min());
            }

        } catch(Exception e) {
            searchResult = "Could not find entry from given search key.";
        }
    }
}
