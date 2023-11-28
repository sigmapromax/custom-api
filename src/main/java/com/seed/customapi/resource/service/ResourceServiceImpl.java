package com.seed.customapi.resource.service;

import com.seed.customapi.resource.mapper.ResourceMapper;
import com.seed.customapi.resource.response.ListResourceResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Qualifier("resourceMapper")
    private final ResourceMapper mapper;

    public ResourceServiceImpl(ResourceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public ListResourceResponse list(Long projId) {
        return new ListResourceResponse(mapper.listByProjId(projId));
    }
}
