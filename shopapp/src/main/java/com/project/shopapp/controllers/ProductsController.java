package com.project.shopapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.dtos.ProductResponse;
import com.project.shopapp.utils.FileUtils;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductsController {

    @Autowired
    private FileUtils fileUtils;

    @GetMapping("")
    public ResponseEntity<List<ProductResponse>> getProducts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit) {
        // Placeholder for service call
        List<ProductResponse> products = new ArrayList<>();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable Long id) {
        // Placeholder for service call
        ProductResponse product = new ProductResponse();
        return ResponseEntity.ok(product);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        // Placeholder for service call
        ProductResponse newProduct = new ProductResponse();
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable Long id,
            @Valid @RequestBody ProductDTO productDTO) {
        // Placeholder for service call
        ProductResponse updatedProduct = new ProductResponse();
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        // Placeholder for service call
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/upload/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadProductImages(
            @PathVariable Long productId,
            @RequestParam("files") MultipartFile[] files) throws IOException {

        // Validate max number of images
        if (files.length > 5) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Maximum of 5 images allowed per product");
        }

        // Validate file types and sizes
        for (MultipartFile file : files) {
            if (!FileUtils.isImageFile(file)) {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("Only image files are allowed");
            }

            if (!FileUtils.isFileSizeValid(file, 5)) { // 5MB max size
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body("File size exceeds the maximum limit of 5MB");
            }
        }

        // Placeholder for file storage service
        List<ProductImageDTO> uploadedImages = new ArrayList<>();

        Arrays.stream(files).forEach(file -> {
            try {
                // Save the file and get the path
                String filePath = FileUtils.saveFile(file);

                // Create a ProductImageDTO with the file path
                ProductImageDTO imageDTO = ProductImageDTO.builder()
                        .productId(productId)
                        .imageUrl(filePath) // In production, this would be a URL
                        .build();

                uploadedImages.add(imageDTO);
            } catch (IOException e) {
                // Log the error (in real implementation)
                System.err.println("Error saving file: " + e.getMessage());
            }
        });

        return ResponseEntity.ok(uploadedImages);
    }

    @DeleteMapping("/images/{imageId}")
    public ResponseEntity<Void> deleteProductImage(@PathVariable Long imageId) {
        // In a real implementation:
        // 1. Get the ProductImage entity
        // 2. Delete the file using FileUtils.deleteFile(filePath)
        // 3. Delete the entity from the database

        return ResponseEntity.noContent().build();
    }
}