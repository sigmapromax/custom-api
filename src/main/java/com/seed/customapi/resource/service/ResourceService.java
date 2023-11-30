package com.seed.customapi.resource.service;

import com.seed.customapi.resource.request.CreateResourceRequest;
import com.seed.customapi.resource.response.GetResourceDataResponse;
import com.seed.customapi.resource.request.UpdateResourceDataStructureRequest;
import com.seed.customapi.resource.request.UpdateResourceSizeRequest;
import com.seed.customapi.resource.response.*;

public interface ResourceService {
    /* size set to be 0 while creating a resource
    * at this moment, there is no need to call file-server to store data
    * just generate an unused filePath and store it into database
    * */
    CreateResourceResponse create(CreateResourceRequest request);
    ListResourceResponse list(Long projId);

    GetResourceResponse get(Long id);
    GetResourceDataResponse getData(Long resId);

    UpdateResourceSizeResponse updateSize(UpdateResourceSizeRequest request);
    UpdateResourceDataStructureResponse updateDataStructure(UpdateResourceDataStructureRequest request);
}
