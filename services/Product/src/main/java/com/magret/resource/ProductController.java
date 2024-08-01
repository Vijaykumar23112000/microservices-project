package com.magret.resource;

import com.magret.dto.ProductPurchaseRequest;
import com.magret.dto.ProductPurchaseResponse;
import com.magret.dto.ProductRequest;
import com.magret.dto.ProductResponse;
import com.magret.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    ResponseEntity<Integer> createProduct(
            @RequestBody @Valid ProductRequest request
    )
    {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    )
    {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer productId
    )
    {
        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping
    ResponseEntity<List<ProductResponse>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

}
