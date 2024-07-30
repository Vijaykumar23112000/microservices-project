package com.magret.service.impl;

import com.magret.dto.CustomerRequest;
import com.magret.dto.CustomerResponse;
import com.magret.entity.Customer;
import com.magret.exception.CustomerNotFoundException;
import com.magret.repo.CustomerRepo;
import com.magret.service.CustomerService;
import com.magret.utils.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo repo;
    private final CustomerMapper mapper;

    @Override
    public String createCustomer(CustomerRequest request) {
        return repo.save(mapper.toCustomer(request)).getId();
    }

    @Override
    public void updateCustomer(CustomerRequest request) {
        var customer = repo.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot Update Customer:: No Customer Found With The Provided Id:: %s",request.id())
                ));
        mergeCustomer(customer , request);
    }

    @Override
    public List<CustomerResponse> findAllCustomers() {
        return repo.findAll()
                .stream()
                .map(mapper::toCustomerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Boolean existsById(String customerId) {
        return repo.findById(customerId)
                .isPresent();
    }

    @Override
    public CustomerResponse findById(String customerId) {
        return repo.findById(customerId)
                .map(mapper::toCustomerResponse)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No Customer Found with id :: %s",customerId)
                ));
    }

    @Override
    public void deleteCustomer(String customerId) {
        repo.deleteById(customerId);
    }

    private void mergeCustomer(Customer customer , CustomerRequest request){
        if(StringUtils.isNotBlank(request.firstname())){
            customer.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            customer.setFirstname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            customer.setFirstname(request.email());
        }
        if(request.firstname() != null){
            customer.setAddress(request.address());
        }
    }
}
