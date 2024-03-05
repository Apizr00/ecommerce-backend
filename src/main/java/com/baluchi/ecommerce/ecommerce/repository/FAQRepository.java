package com.baluchi.ecommerce.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluchi.ecommerce.ecommerce.entity.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
    
    List<FAQ> findAllByProductId(Long productId);
}
