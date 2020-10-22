package com.codecool.filepartreader;

import java.io.IOException;
import java.util.List;

public class App 
{
    public static void main( String[] args ) {

        FilePartReader filePartReader = new FilePartReader();

        filePartReader.setup("src/main/resources/somethingWritten.txt", 1, 9);
        FileWordAnalyser fileWordAnalyser = new FileWordAnalyser(filePartReader);

        List<String> sortedWords = fileWordAnalyser.getWordsOrderedAlphabetically();
        System.out.println(sortedWords);

        List<String> wordsWithSubstring = fileWordAnalyser.getWordsContainingSubstring("po");
        System.out.println(wordsWithSubstring);

        List<String> palindromes = fileWordAnalyser.getStringsWhichPalindromes();
        System.out.println(palindromes);
    }
}
