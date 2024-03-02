package com.baluchi.ecommerce.ecommerce.services.admin.category;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.CategoryDto;
import com.baluchi.ecommerce.ecommerce.entity.Category;
import com.baluchi.ecommerce.ecommerce.repository.CategoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createcategory(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());

        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
