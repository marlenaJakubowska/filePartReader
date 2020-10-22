package com.codecool.filepartreader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FileWordAnalyserTest {

    private FileWordAnalyser fileWordAnalyser;

    @Mock
    static private FilePartReader filePartReader;

    @BeforeEach
    void setUp() throws IOException {
        filePartReader = mock(FilePartReader.class);
        when(filePartReader.readLines()).thenReturn("testing file bob");
        fileWordAnalyser = new FileWordAnalyser(filePartReader);
    }

    @Test
    void check_if_words_ordered_alphabetically() {
        List<String> correct = new ArrayList<>(Arrays.asList("bob", "file", "testing"));
        assertEquals(correct, fileWordAnalyser.getWordsOrderedAlphabetically());
    }

    @Test
    void check_if_finds_words_containing_substring() {
        List<String> correct = new ArrayList<>(Collections.singletonList("testing"));
        assertEquals(correct, fileWordAnalyser.getWordsContainingSubstring("test"));
    }

    @Test
    void check_if_finds_palindrome() {
        List<String> correct = new ArrayList<>(Collections.singletonList("bob"));
        assertEquals(correct, fileWordAnalyser.getStringsWhichPalindromes());
    }
}