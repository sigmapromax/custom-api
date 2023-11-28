package com.seed.customapi.project.response;

import com.seed.customapi.project.entity.ProjectEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectResponse {
    ProjectEntity project;
}
