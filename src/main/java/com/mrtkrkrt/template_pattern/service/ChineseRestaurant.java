package com.mrtkrkrt.template_pattern.service;

import com.mrtkrkrt.template_pattern.dto.request.CreateOrderServiceRequest;
import com.mrtkrkrt.template_pattern.dto.response.CreateOrderServiceResponse;
import com.mrtkrkrt.template_pattern.service.common.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChineseRestaurant extends RestaurantService {
    @Override
    public CreateOrderServiceResponse order(CreateOrderServiceRequest request) {
        log.info("Ordering Chinese food");
        return CreateOrderServiceResponse.builder()
                .success(true)
                .message("Ordering Chinese food")
                .build();
    }
}
