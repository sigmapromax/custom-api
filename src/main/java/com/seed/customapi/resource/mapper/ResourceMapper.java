package com.seed.customapi.resource.mapper;

import com.seed.customapi.resource.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper {
    ResourceEntity findById(Long id);
    Integer save(ResourceEntity resource);
    List<ResourceEntity> listByProjId(Long projId);
    Integer updateSize(Long id, Integer size);
    Integer updateFilePath(Long id, String filePath);
}
