package com.seed.customapi.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceEntity {
    Long id;
    Long projId;
    String name;
    String data_address;
    Boolean isDeleted;
}
