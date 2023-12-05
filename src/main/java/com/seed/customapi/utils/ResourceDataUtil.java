package com.seed.customapi.utils;

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
                        metadata.put(key, MetadataGeneratorUtil.generateString(key, id));
                    }
                    case "Date" -> {
                        metadata.put(key, MetadataGeneratorUtil.generateDateTimestamp());
                    }
                    case "Boolean" -> {
                        metadata.put(key, MetadataGeneratorUtil.generateBoolean());
                    }
                    case "Number" -> {
                        metadata.put(key, MetadataGeneratorUtil.generateNumber());
                    }
                    case "Array" -> {
                        metadata.put(key, MetadataGeneratorUtil.generateArray());
                    }
                    case "Object" -> {
                        metadata.put(key, MetadataGeneratorUtil.generateObject());
                    }
                }
            }
            id += 1;

            result.add(metadata);
        }
        return result;
    }
}
