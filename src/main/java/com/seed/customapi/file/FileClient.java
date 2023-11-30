package com.seed.customapi.file;

import com.seed.customapi.file.request.LoadResourceJsonFileRequest;
import com.seed.customapi.file.request.SaveResourceJsonFileRequest;
import com.seed.customapi.file.response.LoadResourceJsonFileResponse;
import com.seed.customapi.file.response.SaveResourceJsonFileResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

@Component
public class FileClient {
    RestTemplate restTemplate;

    public FileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final String IP_ADDRESS = "10.199.44.41";
    private final String PORT = "3000";

    public SaveResourceJsonFileResponse saveResourceJsonFile(String filePath, List<LinkedHashMap<String, Object>> data) {
        HttpEntity<SaveResourceJsonFileRequest> request = new HttpEntity<>(
                SaveResourceJsonFileRequest.builder()
                .filePath(filePath)
                .data(data)
                .build()
        );

//        String url = "http://" + IP_ADDRESS + ":" + PORT + "/save";
        String url = "http://localhost:3000/save";
        return restTemplate.postForObject(url, request, SaveResourceJsonFileResponse.class);
    }

    public LoadResourceJsonFileResponse loadResourceJsonFile(String filePath) {
        String url = "http://localhost:3000/load";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        ResponseEntity<LoadResourceJsonFileResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, LoadResourceJsonFileResponse.class);
        return new LoadResourceJsonFileResponse(Objects.requireNonNull(response.getBody()).getData());
    }
}

