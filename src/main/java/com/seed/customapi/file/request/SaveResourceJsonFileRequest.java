package com.seed.customapi.file.request;

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
public class SaveResourceJsonFileRequest {
    String filePath;
    List<LinkedHashMap<String, Object>> data;
}
