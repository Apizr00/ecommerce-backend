package com.baluchi.ecommerce.ecommerce.controller.customer;

import org.springframework.web.bind.annotation.RestController;

import com.baluchi.ecommerce.ecommerce.dto.ProductDetailDto;
import com.baluchi.ecommerce.ecommerce.dto.ProductDto;
import com.baluchi.ecommerce.ecommerce.services.customer.CustomerProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class CustomerProductController {

    private final CustomerProductService customerProductService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtos = customerProductService.getAllProducts();
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<ProductDto>> getAllProductByTitle(@PathVariable String name) {
        List<ProductDto> productDtos = customerProductService.searchProductByTitle(name);
        return ResponseEntity.ok(productDtos);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductDetailDto> getProductDetailById(@PathVariable Long productId) {
        ProductDetailDto productDetailDto = customerProductService.getProductDetailById(productId);
        if (productDetailDto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(productDetailDto);
    }
}
