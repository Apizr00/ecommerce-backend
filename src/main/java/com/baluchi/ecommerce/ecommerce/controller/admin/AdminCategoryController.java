package com.baluchi.ecommerce.ecommerce.controller.admin;

import org.springframework.web.bind.annotation.RestController;

import com.baluchi.ecommerce.ecommerce.dto.CategoryDto;
import com.baluchi.ecommerce.ecommerce.entity.Category;
import com.baluchi.ecommerce.ecommerce.services.admin.category.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminCategoryController {
    
    private final CategoryService categoryService;

    @PostMapping("category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
        Category category = categoryService.createcategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
