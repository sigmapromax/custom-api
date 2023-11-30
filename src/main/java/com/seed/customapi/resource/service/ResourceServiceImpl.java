package com.seed.customapi.resource.service;

import com.seed.customapi.common.RedisService;
import com.seed.customapi.common.ResourceDataUtil;
import com.seed.customapi.file.FileClient;
import com.seed.customapi.file.FileUtil;
import com.seed.customapi.resource.entity.ResourceEntity;
import com.seed.customapi.resource.mapper.ResourceMapper;
import com.seed.customapi.resource.request.CreateResourceRequest;
import com.seed.customapi.resource.response.GetResourceDataResponse;
import com.seed.customapi.resource.request.UpdateResourceDataStructureRequest;
import com.seed.customapi.resource.request.UpdateResourceSizeRequest;
import com.seed.customapi.resource.response.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Qualifier("resourceMapper")
    private final ResourceMapper mapper;
    private final RedisService redisService;
    private final FileClient fileClient;

    public ResourceServiceImpl(ResourceMapper mapper, RedisService redisService, FileClient fileClient) {
        this.mapper = mapper;
        this.redisService = redisService;
        this.fileClient = fileClient;
    }

    @Override
    public CreateResourceResponse create(CreateResourceRequest request) {
        ResourceEntity resource = ResourceEntity.builder()
                .projId(request.getProjId())
                .name(request.getName())
                .build();

        mapper.save(resource);
        saveDataStructureToRedis(resource.getId(), request.getDataStructure());
        return new CreateResourceResponse(resource);
    }

    @Override
    public ListResourceResponse list(Long projId) {
        return new ListResourceResponse(mapper.listByProjId(projId));
    }

    @Override
    public GetResourceResponse get(Long resId) {
        ResourceEntity resource = mapper.findById(resId);
        if (resource.getSize() == 0 || resource.getFilePath() == null) {
            return GetResourceResponse.builder()
                    .dataStructure(redisService.getValueByKey(resId))
                    .build();
        } else {
            String filePath = resource.getFilePath();
            List<LinkedHashMap<String, Object>> data = fileClient.loadResourceJsonFile(filePath).getData();
            LinkedHashMap<String, String> dataStructure = redisService.getValueByKey(resId);
            return GetResourceResponse.builder()
                    .dataStructure(dataStructure)
                    .data(data)
                    .build();
        }
    }

    @Override
    public GetResourceDataResponse getData(Long resId) {
        ResourceEntity resource = mapper.findById(resId);
        if (resource.getSize() == 0 || resource.getFilePath() == null) {
            return new GetResourceDataResponse();
        } else {
            String filePath = resource.getFilePath();
            List<LinkedHashMap<String, Object>> data = fileClient.loadResourceJsonFile(filePath).getData();
            return GetResourceDataResponse.builder()
                    .data(data)
                    .build();
        }
    }

    @Override
    public UpdateResourceSizeResponse updateSize(UpdateResourceSizeRequest request) {
        ResourceEntity resource = mapper.findById(request.getResId());
        // update resource size in database
        Integer prevSize = resource.getSize();
        Integer size = request.getSize();

        if (resource.getFilePath() == null) {
            // generate data and write to file-server
            List<LinkedHashMap<String, Object>> data = ResourceDataUtil.generateData(1, size, redisService.getValueByKey(request.getResId()));
            String filePath = FileUtil.generateFilePath(request.getUserId(), resource.getProjId());
            fileClient.saveResourceJsonFile(filePath, data);
            mapper.updateFilePath(request.getResId(), filePath);
            resource.setFilePath(filePath);
        } else {
            String filePath = resource.getFilePath();

            if (prevSize < size) {
                // get data from file-server
                // get data structure from redis
                // generate data
                // append data
                // save data to file-server
                List<LinkedHashMap<String, Object>> data = fileClient.loadResourceJsonFile(filePath).getData();
                List<LinkedHashMap<String, Object>> appendData = ResourceDataUtil.generateData(prevSize + 1, size - prevSize + 1, redisService.getValueByKey(request.getResId()));
                data.addAll(appendData);
                fileClient.saveResourceJsonFile(filePath, data);
            } else if (prevSize > size) {
                // get data from file-server
                // cut data
                // save data to file-server
                List<LinkedHashMap<String, Object>> data = fileClient.loadResourceJsonFile(filePath).getData();
                List<LinkedHashMap<String, Object>> newData = data.subList(0, size);
                fileClient.saveResourceJsonFile(filePath, newData);
            }
        }

        resource.setSize(size);
        mapper.updateSize(request.getResId(), request.getSize());
        // should not get here, cause if prevSize == size, no need to update data
        return new UpdateResourceSizeResponse(resource);
    }

    // TODO: change data structure: rewrite data
    @Override
    public UpdateResourceDataStructureResponse updateDataStructure(UpdateResourceDataStructureRequest request) {
        // store data structure in redis
        // generate data
        // write data to file-server
        ResourceEntity resource = mapper.findById(request.getResId());
        if (resource.getFilePath() == null) {
            // only update data structure in redis
            saveDataStructureToRedis(request.getResId(), request.getDataStructure());
        } else {
            // generate data and write to file-server
            List<LinkedHashMap<String, Object>> data = ResourceDataUtil.generateData(1, resource.getSize(), request.getDataStructure());
            fileClient.saveResourceJsonFile(resource.getFilePath(), data);
        }
        return new UpdateResourceDataStructureResponse(resource);
    }

    private void saveDataStructureToRedis(Long resId, LinkedHashMap<String, String> dataStructure) {
        redisService.saveKeyValue(resId, dataStructure);
    }
}
