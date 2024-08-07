package com.magret.service;

import com.magret.dto.OrderLineRequest;
import com.magret.dto.OrderLineResponse;

import java.util.List;

public interface OrderLineService {

    Integer saveOrderLine(OrderLineRequest request);
    List<OrderLineResponse> findAllByOrderId(Integer orderId);

}
