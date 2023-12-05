package com.seed.customapi.resource.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetResourceResponse {
    LinkedHashMap<String, String> dataStructure;
    List<LinkedHashMap<String, Object>> data;
}
