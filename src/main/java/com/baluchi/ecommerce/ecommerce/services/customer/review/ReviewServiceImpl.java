package com.baluchi.ecommerce.ecommerce.services.customer.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.OrderedProductsResponseDto;
import com.baluchi.ecommerce.ecommerce.dto.ProductDto;
import com.baluchi.ecommerce.ecommerce.dto.ReviewDto;
import com.baluchi.ecommerce.ecommerce.entity.CartItems;
import com.baluchi.ecommerce.ecommerce.entity.Order;
import com.baluchi.ecommerce.ecommerce.entity.Product;
import com.baluchi.ecommerce.ecommerce.entity.Review;
import com.baluchi.ecommerce.ecommerce.entity.User;
import com.baluchi.ecommerce.ecommerce.repository.OrderRepository;
import com.baluchi.ecommerce.ecommerce.repository.ProductRepository;
import com.baluchi.ecommerce.ecommerce.repository.ReviewRepository;
import com.baluchi.ecommerce.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    
    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    public OrderedProductsResponseDto getOrderedProductsDetailsByOrderId(Long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        OrderedProductsResponseDto orderedProductsResponseDto = new OrderedProductsResponseDto();

        if (optionalOrder.isPresent()) {
            orderedProductsResponseDto.setOrderAmount(optionalOrder.get().getAmount());

            List<ProductDto> productDtoList = new ArrayList<>();

            for(CartItems cartItems: optionalOrder.get().getCartItems()) {
                ProductDto productDto = new ProductDto();

                productDto.setId(cartItems.getProduct().getId());
                productDto.setName(cartItems.getProduct().getName());
                productDto.setPrice(cartItems.getPrice());
                productDto.setQuantity(cartItems.getQuantity());

                productDto.setByteImg(cartItems.getProduct().getImg());

                productDtoList.add(productDto);
            }
            orderedProductsResponseDto.setProductDtoList(productDtoList);
        }
        return orderedProductsResponseDto;
    }

    public ReviewDto giveReview(ReviewDto reviewDto) throws IOException {
        Optional<Product> optionalProduct = productRepository.findById(reviewDto.getProductId());
        Optional<User> optionalUser = userRepository.findById(reviewDto.getUserId());

        if (optionalProduct.isPresent() && optionalUser.isPresent()) {
            Review review = new Review();

            review.setRating(reviewDto.getRating());
            review.setDescription(reviewDto.getDescription());
            review.setUser(optionalUser.get());
            review.setProduct(optionalProduct.get());
            review.setImg(reviewDto.getImg().getBytes());

            return reviewRepository.save(review).getDto();
        }
        return null;
    }
}
