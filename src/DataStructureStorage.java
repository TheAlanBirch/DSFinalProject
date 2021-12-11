import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;

public class DataStructureStorage {
    public PhoneContact[] phoneArray;
    public LinkedList<PhoneContact> phoneContactLinkedList = new LinkedList<>();
    public RBTreeMap<String, PhoneContact> phoneContactRBTreeMap = new RBTreeMap<>();
    public Hashtable<String, PhoneContact> phoneContactHashtable = new Hashtable<>();
    public HeapAdaptablePriorityQueue<String, PhoneContact> phoneContactHeapAdaptablePriorityQueue
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
}
