package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public Order getOrderById(@PathVariable int id){
        return service.getById(id).orElseThrow(()->new EntityNotFoundException());
    }
    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Order saveOrder(@RequestBody Order order){
        return service.save(order);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order deleteOrder(@PathVariable int id,@RequestBody Order order){
        return service.save(order);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Order updateOrder(@PathVariable int id,@RequestBody Order order){
        return service.save(order);
    }
}
