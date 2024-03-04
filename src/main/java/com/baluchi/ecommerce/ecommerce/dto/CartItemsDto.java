package com.baluchi.ecommerce.ecommerce.dto;

import com.baluchi.ecommerce.ecommerce.entity.CartItems;

import lombok.Data;

@Data
public class CartItemsDto {

    private Long id;

    private Long price;

    private Long quantity;

    private Long productId;

    private Long orderId;

    private String productName;

    private byte[] returnedImg;

    private Long userId;

    private CartItems cartItems; // Add this field

    // Add getter and setter for CartItems
    public CartItems getCartItems() {
        return cartItems;
    }

    public void setCartItems(CartItems cartItems) {
        this.cartItems = cartItems;
    }
}
