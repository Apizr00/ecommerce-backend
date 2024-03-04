package com.baluchi.ecommerce.ecommerce.services.customer.wishlist;

import java.util.List;

import com.baluchi.ecommerce.ecommerce.dto.WishlistDto;

public interface WishlistService {
    
    WishlistDto addProductToWishlist(WishlistDto wishlistDto);

    List<WishlistDto> getWishlistByUserId(Long userId);
}
