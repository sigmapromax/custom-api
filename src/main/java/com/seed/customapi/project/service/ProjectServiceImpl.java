package com.seed.customapi.project.service;

import com.seed.customapi.common.SecretUtil;
import com.seed.customapi.project.mapper.ProjectMapper;
import com.seed.customapi.project.entity.ProjectEntity;
import com.seed.customapi.project.request.CreateProjectRequest;
import com.seed.customapi.project.response.CreateProjectResponse;
import com.seed.customapi.project.response.ListProjectResponse;
import com.seed.customapi.resource.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper mapper;
    private final ResourceService resourceService;

    public ProjectServiceImpl(ProjectMapper mapper, ResourceService resourceService) {
        this.mapper = mapper;
        this.resourceService = resourceService;
    }

    @Override
    public CreateProjectResponse create(CreateProjectRequest request) {
        ProjectEntity project = ProjectEntity.builder()
                .userId(request.getUserId())
                .name(request.getName())
                .prefix(request.getPrefix())
                .secret(SecretUtil.generateSecret(request))
                .isDeleted(false)
                .build();

        Integer res = mapper.save(project);
        if (res <= 0) {
            log.error("Failed to create project: {}", project);
            return null;
        }
        return new CreateProjectResponse(project);
    }

    @Override
    public ListProjectResponse list(Long userId) {
        return new ListProjectResponse(mapper.listByUserId(userId));
    }
}
