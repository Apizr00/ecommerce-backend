package com.baluchi.ecommerce.ecommerce.services.admin.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.baluchi.ecommerce.ecommerce.dto.OrderDto;
import com.baluchi.ecommerce.ecommerce.entity.Order;
import com.baluchi.ecommerce.ecommerce.enums.OrderStatus;
import com.baluchi.ecommerce.ecommerce.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminOrderServiceImpl implements AdminOrderService {
    
    private final OrderRepository orderRepository;

    public List<OrderDto> getAllPlacedOrders() {
        
        List<Order> orderList = orderRepository.findAllByOrderStatusIn(List.of(OrderStatus.Placed, OrderStatus.Shipped, OrderStatus.Delivered));

        return orderList.stream().map(Order::getOrderDto).collect(Collectors.toList());
    }
}
