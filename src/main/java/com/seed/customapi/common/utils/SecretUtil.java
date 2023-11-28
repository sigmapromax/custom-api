package com.seed.customapi.common.utils;

import com.seed.customapi.project.request.CreateProjectRequest;
import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

@Slf4j
public class SecretUtil {

    // write an algorithm to generate a secret key
    // the secret key should be 24 characters long and hexadecimal
    // the secret key should be unique and related to user id and project name and timestamp
    public static String generateSecret(CreateProjectRequest request) {
        String userId = request.getUserId().toString();
        String projName = request.getName();

        long timestamp = Instant.now().getEpochSecond();
        String data = userId + projName + timestamp;

        String secretKey = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(data.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }

            secretKey = sb.substring(0, 24);
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage());
        }

        return secretKey;
    }
}
