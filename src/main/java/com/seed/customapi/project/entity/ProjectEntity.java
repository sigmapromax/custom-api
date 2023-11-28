package com.seed.customapi.project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    Long id;
    String name;
    Long userId;
    String secret;
    String prefix;
    Boolean isDeleted;
}
