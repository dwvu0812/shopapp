package com.project.shopapp.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {
    private Integer id;
    private Integer userId;
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String note;
    private LocalDateTime orderDate;

    // Using enum for status
    private String status;

    private Float totalMoney;
    private String shippingMethod;
    private String shippingAddress;
    private LocalDate shippingDate;
    private String trackingNumber;
    private String paymentMethod;
    private Boolean active;
    private Integer couponId;

    // Additional user information
    private UserResponse user;
}