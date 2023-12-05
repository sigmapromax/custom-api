package com.seed.customapi.file;

import com.seed.customapi.file.request.SaveResourceJsonFileRequest;
import com.seed.customapi.file.response.LoadResourceJsonFileResponse;
import com.seed.customapi.file.response.SaveResourceJsonFileResponse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@Data
public class FileClient {
    RestTemplate restTemplate;
    public FileClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${file-server.url-prefix}")
    private String URL_PREFIX;

    @Value("${file-server.basic-path}")
    private String BASIC_PATH;

    @Value("${file-server.file-suffix}")
    private String FILE_SUFFIX;


    public SaveResourceJsonFileResponse saveResourceJsonFile(String filePath, List<LinkedHashMap<String, Object>> data) {
        HttpEntity<SaveResourceJsonFileRequest> request = new HttpEntity<>(
                SaveResourceJsonFileRequest.builder()
                .filePath(filePath)
                .data(data)
                .build()
        );

        String url = URL_PREFIX + "/save";
        return restTemplate.postForObject(url, request, SaveResourceJsonFileResponse.class);
    }

    public LoadResourceJsonFileResponse loadResourceJsonFile(String filePath) {
        String url = URL_PREFIX + "/load";

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("filePath", filePath);

        ResponseEntity<LoadResourceJsonFileResponse> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, LoadResourceJsonFileResponse.class);
        return new LoadResourceJsonFileResponse(Objects.requireNonNull(response.getBody()).getData());
    }

    // write a method to generate a random file name which is a string and 16 characters long
    private String getRandomFileName() {
        return UUID.randomUUID().toString();
    }

    public String generateFilePath(Long userId, Long projId) {
        return  BASIC_PATH +
                "/" +
                userId +
                "/" +
                projId +
                "/" +
                getRandomFileName() +
                FILE_SUFFIX;
    }
}

