package com.marvel.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class GenericService<S,T> {

    @Autowired
    JpaRepository<S,T> repository;

    public List<S> findAll(){
        return repository.findAll();
    };

    public List<S> findAllFilter(Example<S> example){
        return repository.findAll(example);
    };

    public Optional<S> findById(T id){
        return repository.findById(id);
    }

    public S save(S s){
        return repository.saveAndFlush(s);
    }

    public List<S> savaAll(List<S> s){
        return repository.saveAll(s);
    }

    public void deleteById(T t){
        repository.deleteById(t);
    }

}
