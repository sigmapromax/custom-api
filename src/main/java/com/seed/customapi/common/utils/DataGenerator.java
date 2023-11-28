package com.seed.customapi.common.utils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    public static String generateString(String keyName, Integer id) {
        return keyName + " " + id.toString();
    }

    public static Long generateDateTimestamp() {
        long currentTimestamp = Instant.now().getEpochSecond();
        long threeDaysAgo = currentTimestamp - (3 * 24 * 60 * 60);
        return ThreadLocalRandom.current().nextLong(threeDaysAgo, currentTimestamp);
    }

    public static Boolean generateBoolean() {
        return Math.random() < 0.5;
    }

    public static Integer generateNumber() {
        return (int) (Math.random() * 100);
    }

    public static List generateArray() {
        return new ArrayList<>();
    }

    public static Object generateObject() {
        return new Object();
    }
}
