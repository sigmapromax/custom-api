package com.seed.customapi.resource.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResourceSizeRequest {
    Long userId;
    Long resId;
    Integer size;
}
