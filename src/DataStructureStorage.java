import goodrichStructures.HeapAdaptablePriorityQueue;
import goodrichStructures.RBTreeMap;

import java.util.*;

public class DataStructureStorage {
    public Object[] tinyPhoneArray = new PhoneContact[21];
    public Object[] smallPhoneArray = new PhoneContact[50000];
    public Object[] mediumPhoneArray = new PhoneContact[200000];
    public Object[] largePhoneArray = new PhoneContact[1000000];

    public LinkedList<PhoneContact> phoneContactLinkedList = new LinkedList<>();
    public RBTreeMap<String, PhoneContact> phoneContactRBTreeMap = new RBTreeMap<>();
    public Hashtable<String, PhoneContact> phoneContactHashtable = new Hashtable<>();
    public HeapAdaptablePriorityQueue<String, PhoneContact> phoneContactHeapAdaptablePriorityQueue
            = new HeapAdaptablePriorityQueue<>();


}
