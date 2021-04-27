package com.marvel.api.repository;

import com.marvel.api.model.Stories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoriesRepository extends JpaRepository<Stories, Long> {
}
