package com.baluchi.ecommerce.ecommerce.services.customer.review;

import com.baluchi.ecommerce.ecommerce.dto.OrderedProductsResponseDto;

public interface ReviewService {
    
    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);
}
