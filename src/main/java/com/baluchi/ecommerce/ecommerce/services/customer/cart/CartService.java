package com.baluchi.ecommerce.ecommerce.services.customer.cart;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.baluchi.ecommerce.ecommerce.dto.AddProductInCartDto;
import com.baluchi.ecommerce.ecommerce.dto.OrderDto;
import com.baluchi.ecommerce.ecommerce.dto.PlaceOrderDto;

public interface CartService {

    ResponseEntity<?> addProductToCart(AddProductInCartDto addProductInCartDto);

    OrderDto getCartByUserId(Long userId);

    OrderDto applyCoupon(Long userId, String code);

    OrderDto increaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto decreaseProductQuantity(AddProductInCartDto addProductInCartDto);

    OrderDto placeOrder(PlaceOrderDto placeOrderDto);

    List<OrderDto> getMyPlacedOrders(Long userId);
}
