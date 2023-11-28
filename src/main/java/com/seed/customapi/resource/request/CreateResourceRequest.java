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
public class CreateResourceRequest {
    Long projId;
    String name;
    Integer size;
    LinkedHashMap<String, String> data;
}
