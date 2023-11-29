package com.seed.customapi.file;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;

@Component
public class FileClient {
    RestTemplate restTemplate;

    public FileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String IP_ADDRESS = "10.199.44.41";
    private final String PORT = "3000";

    public SaveResourceJsonFileResponse saveResourceJsonFile(Long userId, Long projId, List<LinkedHashMap<String, Object>> data) {
        HttpEntity<SaveResourceJsonFileRequest> request = new HttpEntity<>(
                SaveResourceJsonFileRequest.builder()
                .filePath(FileUtil.generateFilePath(userId, projId))
                .data(data)
                .build()
        );

//        String url = "http://" + IP_ADDRESS + ":" + PORT + "/save";
        String url = "http://localhost:3000/save";
        return restTemplate.postForObject(url, request, SaveResourceJsonFileResponse.class);
    }

    public LoadResourceJsonFileResponse loadResourceJsonFile(LoadResourceJsonFileRequest request) {
        return null;
    }
}

