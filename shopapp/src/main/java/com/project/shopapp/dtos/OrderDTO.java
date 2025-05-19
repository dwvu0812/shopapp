package com.project.shopapp.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    @NotNull(message = "User ID is required")
    private Integer userId;

    @Size(max = 100, message = "Fullname must be less than 100 characters")
    private String fullname;

    @Email(message = "Email is invalid")
    @Size(max = 100, message = "Email must be less than 100 characters")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Phone number is invalid")
    @Size(max = 20, message = "Phone number must be less than 20 characters")
    private String phoneNumber;

    @NotBlank(message = "Address is required")
    @Size(max = 200, message = "Address must be less than 200 characters")
    private String address;

    @Size(max = 100, message = "Note must be less than 100 characters")
    private String note;

    @NotNull(message = "Total money is required")
    private Float totalMoney;

    @Size(max = 100, message = "Shipping method must be less than 100 characters")
    private String shippingMethod;

    @Size(max = 200, message = "Shipping address must be less than 200 characters")
    private String shippingAddress;

    private LocalDate shippingDate;

    @Size(max = 100, message = "Tracking number must be less than 100 characters")
    private String trackingNumber;

    @Size(max = 100, message = "Payment method must be less than 100 characters")
    private String paymentMethod;

    private Integer couponId;
}
