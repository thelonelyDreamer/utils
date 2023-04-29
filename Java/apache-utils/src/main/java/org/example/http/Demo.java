package org.example.http;

import lombok.extern.slf4j.Slf4j;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 23167
 * @description Java is the best language
 * @date 2023/4/25--@9:52
 */
@Slf4j
public class Demo {


    private static final PoolingHttpClientConnectionManager poolManager;

    static {
        poolManager = new PoolingHttpClientConnectionManager();
        poolManager.setMaxTotal(10);
        poolManager.setDefaultMaxPerRoute(5);
    }

    /**
     * @throws IOException
     */
    public void get() throws IOException {




        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpGet请求
        StringBuilder builder = new StringBuilder("https://www.baidu.com");
        String url = builder.append("?name=").append("张三").toString();
        String encode = URLEncoder.encode(url);
        System.out.println(encode);
        HttpGet httpGet = new HttpGet(url);
        // 响应对象
        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发起请求
            response = httpClient.execute(httpGet);
            // 判断响应状态码是否为200
            if (response.getCode() == 200) {
                // 获取返回数据
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "UTF-8");
                // 打印数据长度
                log.info("content:{}", content.length());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            // 释放连接
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
    }

    public void post() throws IOException {

        // 创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 创建HttpPost对象，设置url访问地址
        HttpPost httpPost = new HttpPost("https://fanyi.baidu.com/langdetect");

        // 声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        // 实际请求地址：https://fanyi.baidu.com/langdetect?query=Java
        params.add(new BasicNameValuePair("query", "Java"));

        // 创建表单的Entity对象,第一个参数是封装好的表单数据，第二个参数是编码
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, StandardCharsets.UTF_8);
        //设置表单的Entity对象到Post请求中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 使用HttpClient发起请求，获取response
            response = httpClient.execute(httpPost);
            // 解析响应
            if (response.getCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                log.info("content={}", content);
            }
        }catch (ParseException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭资源
            response.close();
            httpClient.close();
        }
    }

    public static HttpClient getHttpClient(){
        return HttpClients.custom().setConnectionManager(poolManager).build();
    }

    public void draft(){
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        poolingHttpClientConnectionManager.setMaxTotal(100);
        // 设置每个主机的最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(10);
        // 从连接池中获取HttpClient对象
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(poolingHttpClientConnectionManager).build();

    }
}
