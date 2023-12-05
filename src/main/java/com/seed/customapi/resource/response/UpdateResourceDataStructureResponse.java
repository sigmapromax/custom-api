package com.seed.customapi.resource.response;

import com.seed.customapi.resource.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResourceDataStructureResponse {
    ResourceEntity resource;
}
