package com.project.shopapp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDTO {
    @NotBlank(message = "Status is required")
    @Pattern(regexp = "pending|processing|shipped|delivered|cancelled", message = "Status must be one of: pending, processing, shipped, delivered, cancelled")
    private String status;
}