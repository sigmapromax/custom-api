package com.seed.customapi.project.response;

import com.seed.customapi.project.entity.ProjectEntity;
import com.seed.customapi.resource.entity.ResourceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetProjectResponse {
    ProjectEntity project;
    List<ResourceEntity> resources;
}
