package com.magret.resource;

import com.magret.dto.OrderRequest;
import com.magret.dto.OrderResponse;
import com.magret.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequest request
    )
    {
        return ResponseEntity.ok(orderService.createOrder(request));
    }

    @GetMapping
    ResponseEntity<List<OrderResponse>> findAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{order-id}")
    ResponseEntity<OrderResponse> findOrderById(
            @PathVariable("order-id") Integer orderId
    )
    {
        return ResponseEntity.ok(orderService.findById(orderId));
    }

}
