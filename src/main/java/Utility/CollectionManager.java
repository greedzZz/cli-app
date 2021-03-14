package Utility;

import Content.*;

import java.io.File;
import java.util.*;

public class CollectionManager {
    private final CollectionPutter collectionPutter;
    private final ElementReader elementReader;
    private final TreeMap<Integer, SpaceMarine> treeMap;
    private final Date date;
    private final HashMap<String, String> commandPool = new HashMap<>();
    private File file;
    private String currentArgument;

    {
        commandPool.put("help", "Displays information on available commands.");
        commandPool.put("info", "Displays information about the collection.");
        commandPool.put("show", "Displays information about elements of the collection.");
        commandPool.put("insert \"key\"", "Adds a new element with the given key.");
        commandPool.put("update \"id\"", "Updates the value of the collection element whose id is equal to the given.");
        commandPool.put("remove_key \"key\"", "Removes a collection element by its key.");
        commandPool.put("clear", "Clears the collection.");
        commandPool.put("save", "Saves collection to the file.");
        commandPool.put("execute_script \"file_name\"", "Reads and executes a script from the specified file.");
        commandPool.put("exit", "Ends the program (without saving to file).");
        commandPool.put("remove_greater", "Removes all items from the collection that are greater than the specified one.");
        commandPool.put("replace_if_greater \"key\"", "Replaces the value by key if the new value is greater than the old one.");
        commandPool.put("remove_greater_key \"key\"", "Removes from the collection all elements whose key exceeds the given one.");
        commandPool.put("group_counting_by_coordinates", "Groups the elements of the collection by the value of the coordinates field, display the number of elements in each group.");
        commandPool.put("filter_by_chapter \"chapter\"", "Displays elements whose chapter field is equal to the given.");
        commandPool.put("filter_starts_with_name \"name\"", "Displays elements whose name field value begins with a given substring.");
    }

    public CollectionManager() {
        this.date = new Date();
        this.treeMap = new TreeMap<>();
        this.collectionPutter = new CollectionPutter(treeMap);
        this.elementReader = new ElementReader();
    }

    public void help() {
        for (String com : commandPool.keySet()) {
            System.out.println(com + ": " + commandPool.get(com));
        }
    }

    public void info() {
        System.out.println("Collection type: " + treeMap.getClass() + "\n" +
                "Collection initialization date: " + date + "\n" +
                "Collection size: " + treeMap.size());
    }

    public void show() {
        try {
            SpaceMarineDescriber smd = new SpaceMarineDescriber();
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty.");
            }
            System.out.println("Elements of the collection:\n");
            for (SpaceMarine spaceMarine : treeMap.values()) {
                smd.describe(spaceMarine);
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insert() {
        try {
            int key = Integer.parseInt(currentArgument);
            if (key < 0) {
                throw new NumberFormatException();
            }
            SpaceMarine sm = elementReader.readElement();
            sm.setID(key);
            collectionPutter.put(sm);
        } catch (NumberFormatException e) {
            System.out.println("Key value must be integer. Greater than 0.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update() {
        try {
            int id = Integer.parseInt(currentArgument);
            if (id < 0) {
                throw new NumberFormatException();
            }
            SpaceMarine sm = elementReader.readElement();
            sm.setID(id);
            collectionPutter.put(sm);
            System.out.println("Value of element with id" + id + "has been updated.");
        } catch (NumberFormatException e) {
            System.out.println("ID value must be integer. Greater than 0.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeKey() {
        try {
            Integer key = Integer.parseInt(currentArgument);
            if (!treeMap.containsKey(key)) {
                throw new Exception("There is no such argument in the collection.");
            } else {
                treeMap.remove(key);
                System.out.println("Element with " + currentArgument + " key has been deleted.");
            }
        } catch (NumberFormatException e) {
            System.out.println("The input argument is not an integer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clear() {
        treeMap.clear();
        System.out.println("The collection has been cleared.");
    }

    public void save() {

    }

    public void executeScript() {

    }

    public void exit() {
        System.out.println("The program is finished.");
        System.exit(0);
    }

    public void removeGreater() {
        try {
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty.");
            } else {
                SpaceMarine sm = elementReader.readElement();
                Iterator<SpaceMarine> iterator = treeMap.values().iterator();
                String name;
                while (iterator.hasNext()) {
                    SpaceMarine next = iterator.next();
                    if (sm.compareTo(next) < 0) {
                        name = next.getName();
                        iterator.remove();
                        System.out.println("Space marine " + name + " has been removed from the collection.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void replaceIfGreater() {
        try {
            Integer key = Integer.parseInt(currentArgument);
            if (!treeMap.containsKey(key)) {
                throw new Exception("There is no such argument in the collection.");
            } else {
                SpaceMarine sm = elementReader.readElement();
                sm.setID(key);
                if (sm.compareTo(treeMap.get(key)) > 0) {
                    treeMap.put(sm.getID(), sm);
                    System.out.println("Element with " + currentArgument + " key has been replaced.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("The input argument is not an integer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void removeGreaterKey() {
        try {
            Integer key = Integer.parseInt(currentArgument);
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty.");
            } else {
                Iterator<SpaceMarine> iterator = treeMap.values().iterator();
                while (iterator.hasNext()) {
                    SpaceMarine next = iterator.next();
                    Integer currentKey = next.getID();
                    if (currentKey > key) {
                        iterator.remove();
                        System.out.println("Element with key " + currentKey + " has been deleted.");
                    }
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("The input argument is not an integer");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void groupCountingByCoordinates() {
        try {
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty.");
            } else {
                int first = 0;
                int second = 0;
                int third = 0;
                int fourth = 0;
                for (SpaceMarine sm : treeMap.values()) {
                    if (sm.getCoordinateX() >= 0) {
                        if (sm.getCoordinateY() >= 0) {
                            first += 1;
                        } else {
                            fourth += 1;
                        }
                    } else {
                        if (sm.getCoordinateY() >= 0) {
                            second += 1;
                        } else {
                            third += 1;
                        }
                    }
                }
                System.out.println("There are " + first + " space marines in the first coordinate quarter, " +
                        "" + second + " in the second one, " + third + " in the third one, " + fourth + " in the fourth one.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterByChapter() {
        try {
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty");
            }
            ChapterReader cr = new ChapterReader();
            String[] arguments = cr.readChapter();
            String chapterName = arguments[0];
            String chapterWorld = arguments[1];
            SpaceMarineDescriber smd = new SpaceMarineDescriber();
            System.out.println("Elements whose chapter value is equal to entered value:");
            System.out.println();
            for (SpaceMarine sm : treeMap.values()) {
                if (sm.getChapterName().equals(chapterName) && sm.getChapterWorld().equals(chapterWorld)) {
                    smd.describe(sm);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void filterStartsWithName() {
        try {
            if (treeMap.isEmpty()) {
                throw new Exception("The collection is empty");
            }
            SpaceMarineDescriber smd = new SpaceMarineDescriber();
            int count = 0;
            System.out.println("Elements whose starts with entered value:");
            System.out.println();
            for (SpaceMarine sm : treeMap.values()) {
                if (sm.getName().startsWith(currentArgument)) {
                    smd.describe(sm);
                    count += 1;
                }
            }
            if (count == 0) {
                System.out.println("There are no elements whose starts with entered value.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TreeMap<Integer, SpaceMarine> getCollection() {
        return treeMap;
    }

    public CollectionPutter getCollectionPutter() {
        return collectionPutter;
    }

    public void setCurrentArgument(String argument) {
        this.currentArgument = argument;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
