import java.util.*;
import java.io.*;
import Content.*;
import Utility.*;
//C:\\Users\\1642586\\Desktop\\Программирование\\lab5\\SpaceMarines.xml

public class Main {
    public static void main(String[] args) {
        TreeMap<Integer, SpaceMarine> treeMap = new TreeMap<>();
        CollectionPutter collectionPutter = new CollectionPutter(treeMap);
        FileManager fileManager = new FileManager(new File(args[0]));
        fileManager.manageXML(treeMap, collectionPutter);

    }
}
