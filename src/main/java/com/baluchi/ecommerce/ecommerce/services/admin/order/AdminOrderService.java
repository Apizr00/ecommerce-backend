package com.baluchi.ecommerce.ecommerce.services.admin.order;

import java.util.List;

import com.baluchi.ecommerce.ecommerce.dto.AnalyticsResponse;
import com.baluchi.ecommerce.ecommerce.dto.OrderDto;

public interface AdminOrderService {
    
    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();
}
