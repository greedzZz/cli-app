package Utility;

import java.util.HashSet;
import java.util.TreeMap;
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
        System.out.println("Космодесантник " + sm.getName() + " добавлен в коллекцию!");
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
                throw new Exception("К сожалению, коллекция переполнена. \n" +
                        "Чтобы доабвить в нее новй элемент, необходимо удалить один из добавленных ранее.");
            } else {
                return otherCount;
            }
        } else {
            throw new Exception("К сожалению, коллекция переполнена. \n" +
                    "Чтобы доабвить в нее новй элемент, необходимо удалить один из добавленных ранее.");
        }
    }
}
