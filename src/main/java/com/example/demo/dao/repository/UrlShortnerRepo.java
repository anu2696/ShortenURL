package com.example.demo.dao.repository;

import com.example.demo.dao.entity.UrlShortener;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlShortnerRepo extends CrudRepository<UrlShortener, Long> {

    public UrlShortener findTopByOrderByIdDesc();
    public UrlShortener save(UrlShortener urlShortener);
}
