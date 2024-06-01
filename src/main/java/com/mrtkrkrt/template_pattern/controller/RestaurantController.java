package com.mrtkrkrt.template_pattern.controller;

import com.mrtkrkrt.template_pattern.dto.request.CreateOrderServiceRequest;
import com.mrtkrkrt.template_pattern.dto.response.CreateOrderServiceResponse;
import com.mrtkrkrt.template_pattern.model.DomainType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/restaurant")
public class RestaurantController {

    @PostMapping("/order")
    public ResponseEntity<CreateOrderServiceResponse> order(
            @RequestHeader("X-Restaurant-Type") DomainType domainType,
            @RequestBody CreateOrderServiceRequest request
    ) {
        return ResponseEntity.ok(domainType.execute().order(request));
    }
}
