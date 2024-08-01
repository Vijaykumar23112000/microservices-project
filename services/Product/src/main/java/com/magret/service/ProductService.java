package com.magret.service;

import com.magret.dto.ProductPurchaseRequest;
import com.magret.dto.ProductPurchaseResponse;
import com.magret.dto.ProductRequest;
import com.magret.dto.ProductResponse;

import java.util.List;

public interface ProductService {

    Integer createProduct(ProductRequest request);
    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);
    ProductResponse findById(Integer productId);
    List<ProductResponse> findAll();

}
