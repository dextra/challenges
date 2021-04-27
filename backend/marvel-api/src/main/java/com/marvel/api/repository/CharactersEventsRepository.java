package com.marvel.api.repository;

import com.marvel.api.model.CharactersEvents;
import com.marvel.api.model.CharactersStories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharactersEventsRepository extends JpaRepository<CharactersEvents, Long> {
    @Query(value = "SELECT * FROM CHARACTERS_EVENTS WHERE ID_CHARACTERS = :charactersId #{#pageable}", nativeQuery = true,
           countQuery = "SELECT COUNT(*) FROM CHARACTERS_EVENTS WHERE ID_CHARACTERS = :charactersId")
    Page<CharactersEvents> findCharactersEventsById(Long charactersId, Pageable pageable);

}
