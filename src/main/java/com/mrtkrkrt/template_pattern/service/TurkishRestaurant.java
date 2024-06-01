package com.mrtkrkrt.template_pattern.service;

import com.mrtkrkrt.template_pattern.dto.request.CreateOrderServiceRequest;
import com.mrtkrkrt.template_pattern.dto.response.CreateOrderServiceResponse;
import com.mrtkrkrt.template_pattern.service.common.RestaurantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TurkishRestaurant extends RestaurantService {
    @Override
    public CreateOrderServiceResponse order(CreateOrderServiceRequest request) {
        log.info("Ordering Turkish food");
        return CreateOrderServiceResponse.builder()
                .success(true)
                .message("Ordering Turkish food")
                .build();
    }
}
