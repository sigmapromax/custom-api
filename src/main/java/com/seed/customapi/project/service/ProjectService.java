package com.seed.customapi.project.service;

import com.seed.customapi.project.request.CreateProjectRequest;
import com.seed.customapi.project.response.CreateProjectResponse;
import com.seed.customapi.project.response.GetProjectResponse;
import com.seed.customapi.project.response.ListProjectResponse;

public interface ProjectService {
    CreateProjectResponse create(CreateProjectRequest request);

    ListProjectResponse list(Long userId);
}
