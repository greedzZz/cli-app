import java.io.*;

import Utility.*;

//C:\\Users\\1642586\\Desktop\\Программирование\\lab5\\SpaceMarines.xml

public class Main {
    public static void main(String[] args) {
        CollectionManager collectionManager = new CollectionManager();
        FileManager fileManager = new FileManager(new File(args[0]));
        fileManager.manageXML(collectionManager);
        CommandManager commandManager = new CommandManager(collectionManager);
        commandManager.readInput();
    }
}
