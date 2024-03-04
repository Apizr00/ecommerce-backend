package com.baluchi.ecommerce.ecommerce.controller.admin;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baluchi.ecommerce.ecommerce.dto.OrderDto;
import com.baluchi.ecommerce.ecommerce.services.admin.order.AdminOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminOrderController {
    
    private final AdminOrderService adminOrderService;

    @GetMapping("/placedOrders")
    public ResponseEntity<List<OrderDto>> getAllPlacedOrders() {
        return ResponseEntity.ok(adminOrderService.getAllPlacedOrders());
    }
}
