package com.mrtkrkrt.template_pattern.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderServiceRequest {
    private String foodName;
    private String restaurantName;
    private BigDecimal price;
    private BigDecimal portion;
}
