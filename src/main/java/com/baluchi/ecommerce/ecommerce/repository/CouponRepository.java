package com.baluchi.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baluchi.ecommerce.ecommerce.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    
}
