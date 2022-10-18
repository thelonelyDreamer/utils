package com.felixwc.publish.utils.file;

import java.io.*;

/**
 * in order to learn java!
 * created at 2022/10/11 12:57
 *
 * @author felixwc
 */
public class Files {

    public static boolean mergeMultiFiles(File target,File... source) throws IOException {
        boolean result=false;
        BufferedOutputStream outputStream=null;
        try {
            outputStream= new BufferedOutputStream(new FileOutputStream(target));
            byte[] bytes = new byte[1024];
            for (File file : source) {
                try(BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file));){
                    int len;
                    while ((len = inputStream.read(bytes))!=-1){
                        outputStream.write(bytes,0,len);
                        outputStream.flush();
                    }
                }
            }
            result =true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(outputStream!=null){
                outputStream.close();
            }
        }
        return result;
    }
}
