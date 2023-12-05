package com.seed.customapi;

import com.seed.customapi.utils.SecretUtil;
import com.seed.customapi.utils.ResourceDataUtil;
import com.seed.customapi.project.request.CreateProjectRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashMap;

@SpringBootTest
class CustomApiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void projectSecretTest() {
        CreateProjectRequest request = CreateProjectRequest.builder()
                .name("test")
                .prefix("test")
                .userId(1L)
                .build();
        System.out.println(SecretUtil.generateSecret(request));
    }


    @Test
    void createResourceTest() {
        LinkedHashMap<String, String> data = new LinkedHashMap<>();
        data.put("boolean", "Boolean");
        data.put("number", "Number");
        data.put("string", "String");
        data.put("date", "Date");
        data.put("array", "Array");
        data.put("object", "Object");

        var result = ResourceDataUtil.generateData(1, 10, data);
        for (var item : result) {
            System.out.println(item);
        }
    }


    @Test
    void redisTest() {

    }
}
