package com.seed.customapi.resource.response;

import com.seed.customapi.resource.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListResourceResponse {
    List<ResourceEntity> resources;
}
