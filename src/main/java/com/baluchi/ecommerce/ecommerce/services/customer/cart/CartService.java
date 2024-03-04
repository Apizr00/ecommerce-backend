package com.baluchi.ecommerce.ecommerce.services.customer.cart;

import org.springframework.http.ResponseEntity;

import com.baluchi.ecommerce.ecommerce.dto.AddProductInCartDto;
import com.baluchi.ecommerce.ecommerce.dto.OrderDto;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto applyCoupon(Long userId, String code);

    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);
}
