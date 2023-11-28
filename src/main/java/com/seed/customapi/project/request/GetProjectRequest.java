package com.seed.customapi.project.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// get project resources
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProjectRequest {
    // project id
    private Long id;
}
