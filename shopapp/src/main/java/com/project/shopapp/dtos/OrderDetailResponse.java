package com.project.shopapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailResponse {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private BigDecimal price;
    private Integer numberOfProducts;
    private BigDecimal totalMoney;
    private String color;
    private Integer couponId;

    // Additional related data
    private ProductResponse product;
}