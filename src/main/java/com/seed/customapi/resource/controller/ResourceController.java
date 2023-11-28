package com.seed.customapi.resource.controller;

import com.seed.customapi.resource.request.CreateResourceRequest;
import com.seed.customapi.resource.response.ListResourceResponse;
import com.seed.customapi.resource.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;

@RequestMapping("resources/v1")
@RestController
public class ResourceController {
    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @GetMapping("list/{projId}")
    public ResponseEntity<ListResourceResponse> listResource(@PathVariable Long projId) {
        return ResponseEntity.ok(service.list(projId));
    }

    @PostMapping("create")
    public String createResource(@RequestBody CreateResourceRequest resource) {
        LinkedHashMap<String, String> data = resource.getData();
        for (var key : data.entrySet()) {
            System.out.println(key);
        }
        System.out.println(resource);
        return "create successfully";
    }
}
