package com.example.demo.service;

import com.example.demo.model.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
    private static final int PAGE_SIZE = 5;
    private MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public Optional<Movie> getById(Integer id) {
        return repository.findById(id);
    }

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public List<Movie> findByName(String name,Integer page,Integer size){
        if(size==null)
            size=PAGE_SIZE;

        Pageable moviePage= PageRequest.of(page,size);

        if (name==null||name.isEmpty()){
            return repository.findAll(moviePage).getContent();
        }

        return repository.findByName(name,moviePage);
    }
}
