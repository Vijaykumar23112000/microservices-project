package com.magret.resource;

import com.magret.dto.CustomerRequest;
import com.magret.dto.CustomerResponse;
import com.magret.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    )
    {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @PutMapping
    ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    )
    {
        customerService.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping
    ResponseEntity<List<CustomerResponse>> findAll()
    {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exists/{customer-id}")
    ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") String customerId
    )
    {
        return ResponseEntity.ok(customerService.existsById(customerId));
    }

    @GetMapping("/{customer-id}")
    ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerId
    )
    {
        return ResponseEntity.ok(customerService.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    ResponseEntity<Void> deleteById(
            @PathVariable("customer-id") String customerId
    )
    {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }

}
