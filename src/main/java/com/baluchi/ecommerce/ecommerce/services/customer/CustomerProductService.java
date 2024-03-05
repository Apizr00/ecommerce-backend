package com.baluchi.ecommerce.ecommerce.services.customer;

import java.util.List;

import com.baluchi.ecommerce.ecommerce.dto.ProductDetailDto;
import com.baluchi.ecommerce.ecommerce.dto.ProductDto;

public interface CustomerProductService {
    
    List<ProductDto> getAllProducts();

    List<ProductDto> searchProductByTitle(String name);

    ProductDetailDto getProductDetailById(Long productId);
}
