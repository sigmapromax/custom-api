package com.seed.customapi.resource.controller;

import com.seed.customapi.common.utils.ResourceDataUtil;
import com.seed.customapi.file.FileClient;
import com.seed.customapi.resource.request.CreateResourceRequest;
import com.seed.customapi.resource.response.ListResourceResponse;
import com.seed.customapi.resource.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RequestMapping("resources/v1")
@RestController
public class ResourceController {
    private final ResourceService service;
    private final FileClient fileClient;

    public ResourceController(ResourceService service, FileClient fileClient) {
        this.service = service;
        this.fileClient = fileClient;
    }

    @GetMapping("list/{projId}")
    public ResponseEntity<ListResourceResponse> listResource(@PathVariable Long projId) {
        return ResponseEntity.ok(service.list(projId));
    }

    @PostMapping("create")
    public String createResource(@RequestBody CreateResourceRequest resource) {
        LinkedHashMap<String, String> dataStructure = resource.getDataStructure();
        List<LinkedHashMap<String, Object>> data = ResourceDataUtil.generateData(resource.getSize(), dataStructure);
        fileClient.saveResourceJsonFile(resource.getUserId(), resource.getProjId(), data);
        return "create successfully";
    }
}
