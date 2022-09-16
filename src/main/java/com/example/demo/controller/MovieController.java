package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/movie")
public class MovieController {
    private MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}")
    public Movie getOrderById(@PathVariable int id){
        return service.getById(id).orElseThrow(()->new EntityNotFoundException());
    }

    @GetMapping(value = "/find/{page}")
    public List<Movie> getOrderById(@PathVariable int page, @RequestParam String name, @RequestParam(required = false) Integer size){
        return service.findByName(name,page,size);
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Movie saveMovie(@RequestBody Movie movie){
        return service.save(movie);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie deleteOrder(@PathVariable int id,@RequestBody Movie movie){
        return service.save(movie);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Movie  updateOrder(@PathVariable int id,@RequestBody Movie movie){
        return service.save(movie);
    }
}
