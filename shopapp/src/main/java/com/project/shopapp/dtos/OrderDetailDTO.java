package com.project.shopapp.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    @NotNull(message = "Order ID is required")
    private Integer orderId;

    @NotNull(message = "Product ID is required")
    private Integer productId;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Number of products is required")
    @Min(value = 1, message = "Number of products must be at least 1")
    private Integer numberOfProducts;

    private BigDecimal totalMoney;

    @Size(max = 20, message = "Color must be less than 20 characters")
    private String color;

    private Integer couponId;
}