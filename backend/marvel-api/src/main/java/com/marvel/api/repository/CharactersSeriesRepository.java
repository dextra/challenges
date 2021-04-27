package com.marvel.api.repository;

import com.marvel.api.model.CharactersSeries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharactersSeriesRepository extends JpaRepository<CharactersSeries, Long> {
    @Query(value = "SELECT * FROM CHARACTERS_SERIES WHERE ID_CHARACTERS = :charactersId #{#pageable}", nativeQuery = true,
           countQuery = "SELECT COUNT(*) FROM CHARACTERS_SERIES WHERE ID_CHARACTERS = :charactersId")
    Page<CharactersSeries> findCharactersSeriesById(Long charactersId, Pageable pageable);

}
