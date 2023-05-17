package com.example.customer.controller;

import com.example.customer.dto.OrderRequest;
import com.example.customer.dto.OrderResponse;
import com.example.customer.entity.Customer;
import com.example.customer.repository.CustomerRepository;
import com.example.customer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeorder")
    public Customer placeOrder(@RequestBody OrderRequest request){
        return customerRepository.save(request.getCustomer());
    }

    @GetMapping("/findallorders")
    public List<Customer> findAllOrder() {
        return customerRepository.findAll();
    }

    @GetMapping("/getorderinfo")
    public List<OrderResponse> getOrderInfo() {
        return customerRepository.getOrderInfo();
    }
}
