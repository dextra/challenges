package com.marvel.api.repository;

import com.marvel.api.model.Comics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comics, Long> {
}
