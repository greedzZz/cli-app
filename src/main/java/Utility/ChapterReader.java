package Utility;

import java.util.Scanner;

public class ChapterReader {
    public String[] readChapter() {
        String[] chapter = new String[2];
        Scanner sc = new Scanner(System.in);
        boolean isCorrect = false;
        String argument = "";
        while (!isCorrect) {
            System.out.println("Please, enter a chapter name.");
            argument = sc.nextLine().trim();
            if (argument.equals("")) {
                System.out.println("Chapter name cannot be empty word.");
            } else {
                isCorrect = true;
            }
        }
        chapter[0] = argument;

        isCorrect = false;
        while (!isCorrect) {
            System.out.println("Please, enter a chapter world.");
            argument = sc.nextLine().trim();
            if (argument.equals("")) {
                System.out.println("Chapter world cannot be empty word.");
            } else {
                isCorrect = true;
            }
        }
        chapter[1] = argument;
        return chapter;
    }
}
