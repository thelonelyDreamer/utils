package org.example;

import junit.framework.TestCase;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.junit.Test;

import java.io.IOException;

public class MainTest extends TestCase {

    @Test
    public void test(){
        try {
            HttpGet httpGet = new HttpGet("http://www.baidu.com");
            CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(httpGet);
            response.getEntity().writeTo(System.out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}