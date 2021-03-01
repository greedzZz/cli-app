package Utility;

import java.io.BufferedInputStream;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ScannerXML {
    private final File file;
    private BufferedInputStream bufferedIS;

    public ScannerXML(File file) {
        this.file = file;
    }

    public void scan() {
        try (Scanner scanner = new Scanner(file)) {
            ArrayList<Byte> fileBytes = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                byte[] strBytes = str.getBytes();
                for (byte i : strBytes) {
                    fileBytes.add(i);
                }
            }
            byte[] buffer = new byte[fileBytes.size()];
            for (int i = 0; i < fileBytes.size(); i++) {
                buffer[i] = fileBytes.get(i);
            }
            ByteArrayInputStream byteArrayIS = new ByteArrayInputStream(buffer);
            this.bufferedIS = new BufferedInputStream(byteArrayIS);
        } catch (FileNotFoundException e) {
            System.out.println("К сожалению, данный файл не был найден.\n" +
                    "Заполните коллекцию вручную или перезапустите программу с корректным именем файла.");
        }
    }

    public BufferedInputStream getBufferedIS() {
        return bufferedIS;
    }
}
