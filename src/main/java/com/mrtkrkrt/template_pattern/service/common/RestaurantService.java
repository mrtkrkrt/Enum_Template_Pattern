package com.mrtkrkrt.template_pattern.service.common;

import com.mrtkrkrt.template_pattern.dto.request.CreateOrderServiceRequest;
import com.mrtkrkrt.template_pattern.dto.response.CreateOrderServiceResponse;

public abstract class RestaurantService {
    public abstract CreateOrderServiceResponse order(CreateOrderServiceRequest request);
}
