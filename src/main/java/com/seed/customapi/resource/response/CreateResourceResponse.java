package com.seed.customapi.resource.response;

import com.seed.customapi.resource.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateResourceResponse {
    // if size == 0, then data is an empty array, filePath is null
    ResourceEntity resource;
}
