package com.seed.customapi.project;

import com.seed.customapi.project.request.CreateProjectRequest;
import com.seed.customapi.project.response.CreateProjectResponse;
import com.seed.customapi.project.response.GetProjectResponse;
import com.seed.customapi.project.response.ListProjectResponse;
import com.seed.customapi.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("projects/v1")
@RestController
public class ProjectController {

    @Qualifier("projectServiceImpl")
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("create")
    public ResponseEntity<CreateProjectResponse> createProject(@RequestBody CreateProjectRequest request) {
        return ResponseEntity.ok(projectService.create(request));
    }

    @GetMapping("list/{userId}")
    public ResponseEntity<ListProjectResponse> listProject(@PathVariable Long userId) {
        return ResponseEntity.ok(projectService.list(userId));
    }
}
