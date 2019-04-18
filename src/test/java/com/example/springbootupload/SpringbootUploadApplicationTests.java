package com.example.springbootupload;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootUploadApplicationTests {

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("name",System.currentTimeMillis());
        map.put("name2",System.currentTimeMillis());
        map.put("name3",System.currentTimeMillis());
        map.put("name4",System.currentTimeMillis());
        map.put("name5",System.currentTimeMillis());
        map.put("name6",System.currentTimeMillis());
        map.put("name7",System.currentTimeMillis());
        for ( Map.Entry<String,Object> entry :  map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }

    }

}
