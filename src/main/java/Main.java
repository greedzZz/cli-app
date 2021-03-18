import java.io.*;

import Utility.*;
import Utility.FileUtils.FileManager;

//C:\\Users\\1642586\\Desktop\\Программирование\\lab5\\SpaceMarines.xml

/**
 * The main class of the program.
 * @author Anvar Gazizov
 */
public class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0 || args[0].matches("(/dev/)\\w*")){
                throw new IllegalArgumentException("There is no file pathname in the command argument or entered pathname is incorrect.");
            }
            CollectionManager collectionManager = new CollectionManager();
            FileManager fileManager = new FileManager(new File(args[0]));
            fileManager.manageXML(collectionManager);
            CommandManager commandManager = new CommandManager(collectionManager);
            commandManager.readInput();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
