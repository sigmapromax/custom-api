package com.seed.customapi.file;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadResourceJsonFileResponse {
    List<LinkedHashMap<String, Object>> data;
}
