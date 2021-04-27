package com.marvel.api.repository;

import com.marvel.api.model.CharactersComics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharactersComicsRepository extends JpaRepository<CharactersComics, Long> {
    @Query(value = "SELECT * FROM CHARACTERS_COMICS WHERE ID_CHARACTERS = :charactersId #{#pageable}", nativeQuery = true,
           countQuery = "SELECT COUNT(*) FROM CHARACTERS_COMICS WHERE ID_CHARACTERS = :charactersId")
    Page<CharactersComics> findCharactersComicsById(Long charactersId, Pageable pageable);

}
