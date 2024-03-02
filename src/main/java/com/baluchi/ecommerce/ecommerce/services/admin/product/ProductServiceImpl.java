package com.baluchi.ecommerce.ecommerce.services.admin.product;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.ProductDto;
import com.baluchi.ecommerce.ecommerce.entity.Category;
import com.baluchi.ecommerce.ecommerce.entity.Product;
import com.baluchi.ecommerce.ecommerce.repository.CategoryRepository;
import com.baluchi.ecommerce.ecommerce.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    
    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDto addProduct(ProductDto productDto) throws IOException {
        Product product = new Product();
        product.setName(product.getName());
        product.setDescription(product.getDescription());
        product.setPrice(product.getPrice());
        product.setImg(product.getImg());

        Category category = categoryRepository.findById(productDto.getCategoryId()).orElseThrow();

        product.setCategory(category);
        return productRepository.save(product).getDto();
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(Product::getDto).collect(Collectors.toList());
    }
}
