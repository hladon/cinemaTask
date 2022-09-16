package com.example.demo.repository;

import com.example.demo.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface OrderRepository extends PagingAndSortingRepository<Order,Integer> {
    List<Order> findAllByVisitors(int visitors, Pageable pageable);
}
