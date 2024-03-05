package com.baluchi.ecommerce.ecommerce.services.customer.review;

import java.io.IOException;

import com.baluchi.ecommerce.ecommerce.dto.OrderedProductsResponseDto;
import com.baluchi.ecommerce.ecommerce.dto.ReviewDto;

public interface ReviewService {
    
    OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId);

    ReviewDto giveReview(ReviewDto reviewDto) throws IOException;
}
