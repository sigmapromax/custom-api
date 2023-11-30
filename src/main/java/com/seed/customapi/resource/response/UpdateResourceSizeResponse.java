package com.seed.customapi.resource.response;

import com.seed.customapi.resource.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResourceSizeResponse {
    // empty
    ResourceEntity resource;
}
