package com.magret.service;

import com.magret.dto.OrderRequest;
import com.magret.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    Integer createOrder(OrderRequest request);
    List<OrderResponse> findAll();
    OrderResponse findById(Integer orderId);

}
