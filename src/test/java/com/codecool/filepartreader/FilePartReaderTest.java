package com.codecool.filepartreader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {

    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
        filePartReader.setup("src/test/java/com/codecool/filepartreader/testFile.txt", 1, 1);
    }

    @Test
    public void check_if_InvalidArgumentException_Thrown() {
        assertThrows(IllegalArgumentException.class, () -> filePartReader.setup("aaa", 2, 1));
    }

    @Test
    void should_read_file() throws IOException {
        assertEquals("testing file bob.\n", filePartReader.read());
    }

    @Test
    void should_delete_punctuation() throws IOException {
        assertEquals("testing file bob\n", filePartReader.readLines());
    }

}