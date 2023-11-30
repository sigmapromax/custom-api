package com.seed.customapi.common;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

@Service
public class RedisService {
    // I tried to use RedisTemplate<String, LinkedHashMap<String, String>> but it didn't work
    RedisTemplate<String, String> redisTemplate;

    public RedisService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void saveKeyValue(Long key, LinkedHashMap<String, String> value) {
        redisTemplate.opsForValue().set(key.toString(), value.toString());
    }

    public LinkedHashMap<String, String> getValueByKey(Long key) {
        String dataStructureString = redisTemplate.opsForValue().get(key.toString());
        return dataStructureString == null ? null : convertStringToLinkedHashMap(dataStructureString);
    }

    private LinkedHashMap<String, String> convertStringToLinkedHashMap(String dataStructureString) {
        LinkedHashMap<String, String> dataStructure = new LinkedHashMap<>();
        dataStructureString = dataStructureString.substring(1, dataStructureString.length() - 1);
        String[] pairs = dataStructureString.split(",");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            dataStructure.put(keyValue[0].trim(), keyValue[1].trim());
        }
        return dataStructure;
    }
}
