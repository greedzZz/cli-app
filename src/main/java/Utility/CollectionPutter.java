package Utility;

import java.util.*;

import Content.*;

public class CollectionPutter {
    private final TreeMap<Integer, SpaceMarine> treeMap;
    private int count;
    private final HashSet<Integer> idSet;
    private boolean filled;

    public CollectionPutter(TreeMap<Integer, SpaceMarine> treeMap) {
        this.treeMap = treeMap;
        idSet = new HashSet<>();
        count = 0;
    }

    public void put(SpaceMarine sm) throws Exception {
        sm.setId(generateID());
        treeMap.put(sm.getID(), sm);
        System.out.println("Space marine " + sm.getName() + " has been added to the collection!");
        System.out.println(sm.getID());
        idSet.add(sm.getID());
        count += 1;
    }

    public int generateID() throws Exception {
        if (count != Integer.MAX_VALUE) {
            return (count + 1);
        } else if (!filled) {
            int otherCount = 1;
            while (!idSet.contains(otherCount)) {
                otherCount += 1;
            }
            if (otherCount == Integer.MIN_VALUE) {
                filled = true;
                throw new Exception("Unfortunately, the collection is overflowing. \n" +
                        "To add a new element to it, you need to delete one of the previously added ones.");
            } else {
                return otherCount;
            }
        } else {
            throw new Exception("Unfortunately, the collection is overflowing. \n" +
                    "To add a new element to it, you need to delete one of the previously added ones.");
        }
    }
}
