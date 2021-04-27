package com.marvel.api.repository;

import com.marvel.api.model.CharactersStories;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CharactersStoriesRepository extends JpaRepository<CharactersStories, Long> {
    @Query(value = "SELECT * FROM CHARACTERS_STORIES WHERE ID_CHARACTERS = :charactersId #{#pageable}", nativeQuery = true,
           countQuery = "SELECT COUNT(*) FROM CHARACTERS_STORIES WHERE ID_CHARACTERS = :charactersId")
    Page<CharactersStories> findCharactersStoriesById(Long charactersId, Pageable pageable);
}
