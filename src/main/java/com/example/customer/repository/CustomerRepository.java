package com.example.customer.repository;

import com.example.customer.dto.OrderResponse;
import com.example.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT new com.example.customer.dto.OrderResponse(c.name, p.productName) FROM Customer c JOIN  c.products p")
    public List<OrderResponse> getOrderInfo();
}
