package org.example;

import com.felixwc.publish.utils.autoconfig.eden.EdenInterface;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MainTest {
    @Autowired
    private EdenInterface edenInterface;

    @Test
    public void test(){
        System.out.println(edenInterface);
    }
}