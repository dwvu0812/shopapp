package com.project.shopapp.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Product name cannot be empty")
    @Size(min = 3, max = 350, message = "Product name must be between 3 and 350 characters")
    private String name;

    @NotNull(message = "Product price cannot be null")
    @Min(value = 0, message = "Price must be greater than or equal to 0")
    private BigDecimal price;

    private String thumbnail;

    private String description;

    @NotNull(message = "Category ID cannot be null")
    private Long categoryId;
}