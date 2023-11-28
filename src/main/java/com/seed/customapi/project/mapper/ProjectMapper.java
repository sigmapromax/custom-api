package com.seed.customapi.project.mapper;

import com.seed.customapi.project.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectMapper {
    Integer save(ProjectEntity project);

    ProjectEntity findById(Long id);
    List<ProjectEntity> listByUserId(Long userId);
}
