package com.seed.customapi.resource.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResourceDataStructureRequest {
    // used to get the resource data structure.
    Long resId;
    LinkedHashMap<String, String> dataStructure;
}
