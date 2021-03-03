package Utility;

import java.util.Scanner;

public class CommandManager {
    CollectionManager collectionManager;
    Scanner scanner;

    public CommandManager(CollectionManager collectionManager) {
        this.collectionManager = collectionManager;
    }

    public void readInput() {
        scanner = new Scanner(System.in);
        System.out.println("Please, enter a command. (Enter \"help\" to get information about available commands)");
        String command = "";
        while (!command.equals("exit")) {
            String[] input = scanner.nextLine().trim().split(" ");
            command = input[0];
            try {
                switch (command) {
                    case "help":
                        collectionManager.help();
                        break;
                    case "info":
                        collectionManager.info();
                        break;
                    case "show":
                        collectionManager.show();
                        break;
                    case "insert":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.insert();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "update":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.update();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "remove_key":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.removeKey();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "clear":
                        collectionManager.clear();
                        break;
                    case "save":
                        collectionManager.save();
                        break;
                    case "execute_script":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.executeScript();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "exit":
                        scanner.close();
                        collectionManager.exit();
                        break;
                    case "remove_greater":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.removeGreater();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "replace_if_greater":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.replaceIfGreater();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "remove_greater_key":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.removeGreaterKey();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "group_counting_by_coordinates":
                        collectionManager.groupCountingByCoordinates();
                        break;
                    case "filter_by_chapter":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.filterByChapter();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    case "filter_starts_with_name":
                        try {
                            collectionManager.setCurrentArgument(input[1]);
                            collectionManager.filterStartsWithName();
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("To execute this command, you must enter the required argument.");
                        }
                        break;
                    default:
                        throw new Exception("Incorrect command input. Enter \"help\" to get information about available commands.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
