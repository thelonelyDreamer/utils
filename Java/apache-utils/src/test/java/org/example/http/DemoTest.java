package org.example.http;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class DemoTest {

    @Test
    public void test() throws IOException {
        for (int i = 0; i < 15; i++) {
            new Thread(()->{
                while (true){
                    HttpClient httpClient = Demo.getHttpClient();
                    System.out.println(httpClient);
                    try {
                        httpClient.execute(new HttpGet("http://www.baidu.com"));
                        if(httpClient instanceof CloseableHttpClient) {
                            CloseableHttpClient client = (CloseableHttpClient) httpClient;
                            client.close();
                        }
                        Thread.sleep(10000);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        new Scanner(System.in).next();
    }
}