package com.codecool.filepartreader;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FilePartReader {

    private String filePath;
    private int fromLine;
    private int toLine;

    public FilePartReader() {
        setup("aaa", 2, 9);
    }

    public void setup(String filePath, int fromLine, int toLine) {
        if(toLine < fromLine || fromLine < 1) {
            throw new IllegalArgumentException("Invalid argument");
        }
        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\n");
            }
        scanner.close();
        return stringBuilder.toString();
    }

    public String readLines() throws IOException{
        String[] lines = read().replaceAll("\\p{Punct}+", "").split("\n");
        StringBuilder stringBuilder = new StringBuilder();
        int calculatedToLine = Math.min(toLine, lines.length);
        for (int i = fromLine; i <= calculatedToLine; i++) {
            stringBuilder.append(lines[i - 1]).append("\n");
        }
        return stringBuilder.toString();
    }
}
