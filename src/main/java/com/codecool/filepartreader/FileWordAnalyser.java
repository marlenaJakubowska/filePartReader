package com.codecool.filepartreader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordAnalyser {
    private FilePartReader filePartReader;
    private List<String> words;

    public FileWordAnalyser(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
        getAllWords(filePartReader);
    }


    private void getAllWords(FilePartReader filePartReader) {
        try {
            words = Arrays.asList(filePartReader.readLines().toLowerCase().split("\\s+"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getWordsOrderedAlphabetically() {
        return words.stream().sorted().collect(Collectors.toList());
    }

    public List<String> getWordsContainingSubstring(String subString) {
        return words.stream().filter(s -> s.contains(subString)).collect(Collectors.toList());
    }

    public List<String> getStringsWhichPalindromes() {
        return words.stream().filter(this::isPalindrome).collect(Collectors.toList());
    }

    public Boolean isPalindrome(String string) {
        if (string.length() == 1) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(string).reverse();
        return string.equalsIgnoreCase(sb.toString());
    }
}
