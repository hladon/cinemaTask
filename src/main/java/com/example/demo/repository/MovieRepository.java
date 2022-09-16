package com.example.demo.repository;

import com.example.demo.model.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie,Integer> {
    List<Movie> findByName(String name, Pageable pageable);
}
