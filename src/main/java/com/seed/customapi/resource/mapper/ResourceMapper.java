package com.seed.customapi.resource.mapper;

import com.seed.customapi.resource.entity.ResourceEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResourceMapper {
    List<ResourceEntity> listByProjId(Long projId);
}
