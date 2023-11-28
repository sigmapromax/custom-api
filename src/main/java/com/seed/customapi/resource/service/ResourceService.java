package com.seed.customapi.resource.service;

import com.seed.customapi.resource.response.ListResourceResponse;

public interface ResourceService {
    ListResourceResponse list(Long projId);
}
