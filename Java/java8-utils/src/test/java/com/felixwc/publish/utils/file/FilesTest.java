package com.felixwc.publish.utils.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FilesTest {

    @Test
    public void test() throws IOException {
        File file1 = new File("1.txt");
        File file2 = new File("2.txt");
        File file = new File("total.txt");
        Files.mergeMultiFiles(file,file1,file2);
    }

}