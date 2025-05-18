package com.project.shopapp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoriesController {

    @GetMapping("")
    public ResponseEntity<String> getCategories(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit) {
        return ResponseEntity.ok("this is categories page: " + page + " limit: " + limit);
    }

    @PostMapping("")
    public ResponseEntity<String> createCategory() {
        return ResponseEntity.ok("Created category");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable String id) {
        return ResponseEntity.ok("Updated category");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable String id) {
        return ResponseEntity.ok("Deleted category");
    }

}
