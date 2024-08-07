package com.magret.utils;

import com.magret.dto.OrderLineRequest;
import com.magret.dto.OrderLineResponse;
import com.magret.entity.Order;
import com.magret.entity.OrderLine;
import org.springframework.stereotype.Component;

@Component
public class OrderLineMapper {

    public OrderLine toOrderLine(OrderLineRequest request){
        return OrderLine
                .builder()
                .id(request.id())
                .quantity(request.quantity())
                .order(
                        Order
                                .builder()
                                .id(request.orderId())
                                .build()
                )
                .productId(request.productId())
                .build();
    }

    public OrderLineResponse toOrderLineResponse(OrderLine orderLine){
        return new OrderLineResponse(
                orderLine.getId(),
                orderLine.getQuantity()
        );
    }


}
