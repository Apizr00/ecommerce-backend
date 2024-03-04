package com.baluchi.ecommerce.ecommerce.services.customer.cart;

import org.springframework.http.ResponseEntity;

import com.baluchi.ecommerce.ecommerce.dto.AddProductInCartDto;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

}
