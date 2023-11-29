package com.seed.customapi.file;

import java.util.UUID;

public class FileUtil {

    // write a method to generate a random file name which is a string and 16 characters long
    private static String getRandomFileName() {
        return UUID.randomUUID().toString();
    }

    public static String generateFilePath(Long userId, Long projId) {
//        String BASIC_PATH = "/home/zlf/data/custom-api";
        String BASIC_PATH = "/Users/zhanglinfeng/Downloads";
        String POST_SUFFIX = ".json";

        return  BASIC_PATH +
                "/" +
                userId +
                "/" +
                projId +
                "/" +
                getRandomFileName() +
                POST_SUFFIX;
    }
}
