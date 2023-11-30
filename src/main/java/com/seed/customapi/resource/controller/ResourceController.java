package com.seed.customapi.resource.controller;

import com.seed.customapi.resource.request.CreateResourceRequest;
import com.seed.customapi.resource.response.GetResourceDataResponse;
import com.seed.customapi.resource.request.UpdateResourceDataStructureRequest;
import com.seed.customapi.resource.request.UpdateResourceSizeRequest;
import com.seed.customapi.resource.response.*;
import com.seed.customapi.resource.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<CreateResourceResponse> createResource(@RequestBody CreateResourceRequest resource) {
        return ResponseEntity.ok(service.create(resource));
    }

    @GetMapping("get/{resId}")
    public ResponseEntity<GetResourceResponse> getResource(@PathVariable Long resId) {
        return ResponseEntity.ok(service.get(resId));
    }

    @GetMapping("get/{resId}/data")
    public ResponseEntity<GetResourceDataResponse> getResourceData(@PathVariable Long resId) {
        return ResponseEntity.ok(service.getData(resId));
    }

    // only update data structure and size;
    @PostMapping("updateDataStructure")
    public ResponseEntity<UpdateResourceDataStructureResponse> updateDataStructure(@RequestBody UpdateResourceDataStructureRequest request) {
        return ResponseEntity.ok(service.updateDataStructure(request));
    }

    @PostMapping("updateSize")
    public ResponseEntity<UpdateResourceSizeResponse> updateSize(@RequestBody UpdateResourceSizeRequest request) {
         return ResponseEntity.ok(service.updateSize(request));
    }
}
