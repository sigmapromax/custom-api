package com.seed.customapi.common.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ResourceDataUtil<T> {

    // returning final result which length is equal to size
    public static List<LinkedHashMap<String, Object>> generateData(int size, LinkedHashMap<String, String> data) {
        ArrayList<LinkedHashMap<String, Object>> result = new ArrayList<>();
        int id = 1;
        while (id < size) {
            LinkedHashMap<String, Object> metadata = new LinkedHashMap<>();
            metadata.put("id", id);

            for (var entry : data.entrySet()) {
                var key = entry.getKey();
                var type = entry.getValue();
                switch (type) {
                    case "String" -> {
                        metadata.put(key, DataGenerator.generateString(key, id));
                    }
                    case "Date" -> {
                        metadata.put(key, DataGenerator.generateDateTimestamp());
                    }
                    case "Boolean" -> {
                        metadata.put(key, DataGenerator.generateBoolean());
                    }
                    case "Number" -> {
                        metadata.put(key, DataGenerator.generateNumber());
                    }
                    case "Array" -> {
                        metadata.put(key, DataGenerator.generateArray());
                    }
                    case "Object" -> {
                        metadata.put(key, DataGenerator.generateObject());
                    }
                }
            }
            id += 1;

            result.add(metadata);
        }
        return result;
    }
}
