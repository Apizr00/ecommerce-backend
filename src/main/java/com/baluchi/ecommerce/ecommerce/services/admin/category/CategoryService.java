package com.baluchi.ecommerce.ecommerce.services.admin.category;

import java.util.List;

import com.baluchi.ecommerce.ecommerce.dto.CategoryDto;
import com.baluchi.ecommerce.ecommerce.entity.Category;

public interface CategoryService {
    
    Category createcategory(CategoryDto categoryDto);

    List<Category> getAllCategories();
}
