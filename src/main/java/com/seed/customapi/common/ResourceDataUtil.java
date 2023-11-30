package com.seed.customapi.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ResourceDataUtil {

    // returning final result which length is equal to size
    public static List<LinkedHashMap<String, Object>> generateData(int startId, int size, LinkedHashMap<String, String> dataStructure) {
        ArrayList<LinkedHashMap<String, Object>> result = new ArrayList<>();
        int id = startId;
        while (id <= size) {
            LinkedHashMap<String, Object> metadata = new LinkedHashMap<>();
            metadata.put("id", id);

            for (var entry : dataStructure.entrySet()) {
                var key = entry.getKey();
                var type = entry.getValue();
                switch (type) {
                    case "String" -> {
                        metadata.put(key, MetadataGenerator.generateString(key, id));
                    }
                    case "Date" -> {
                        metadata.put(key, MetadataGenerator.generateDateTimestamp());
                    }
                    case "Boolean" -> {
                        metadata.put(key, MetadataGenerator.generateBoolean());
                    }
                    case "Number" -> {
                        metadata.put(key, MetadataGenerator.generateNumber());
                    }
                    case "Array" -> {
                        metadata.put(key, MetadataGenerator.generateArray());
                    }
                    case "Object" -> {
                        metadata.put(key, MetadataGenerator.generateObject());
                    }
                }
            }
            id += 1;

            result.add(metadata);
        }
        return result;
    }
}
