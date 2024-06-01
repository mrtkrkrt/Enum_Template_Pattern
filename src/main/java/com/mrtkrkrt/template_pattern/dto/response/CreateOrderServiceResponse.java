package com.mrtkrkrt.template_pattern.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateOrderServiceResponse {
    private boolean success;
    private String message;
}
