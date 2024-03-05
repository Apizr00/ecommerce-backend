package com.baluchi.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluchi.ecommerce.ecommerce.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    List<Review> findAllByProductId(Long productId);
}
