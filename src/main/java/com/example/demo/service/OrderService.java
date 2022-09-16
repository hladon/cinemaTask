package com.example.demo.service;

import com.example.demo.repository.OrderRepository;
import com.example.demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Optional<Order> getById(Integer id) {
        return repository.findById(id);
    }

    public Order save(Order order) {
        return repository.save(order);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
