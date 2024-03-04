package com.baluchi.ecommerce.ecommerce.services.admin.coupon;

import java.util.List;

import com.baluchi.ecommerce.ecommerce.entity.Coupon;

public interface AdminCouponService {
    
    Coupon createCoupon(Coupon coupon);

    List<Coupon> getAllCoupons();
}
