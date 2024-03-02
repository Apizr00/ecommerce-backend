package com.baluchi.ecommerce.ecommerce.services.admin.product;

import java.io.IOException;
import java.util.List;

import com.baluchi.ecommerce.ecommerce.dto.ProductDto;

public interface ProductService {
    
    ProductDto addProduct(ProductDto productDto) throws IOException;

    List<ProductDto> getAllProducts();
}
