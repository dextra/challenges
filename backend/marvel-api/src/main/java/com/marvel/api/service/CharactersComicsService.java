package com.marvel.api.service;

import com.marvel.api.model.CharactersComics;
import com.marvel.api.repository.CharactersComicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CharactersComicsService extends GenericService<CharactersComics,Long>{

    @Autowired
    CharactersComicsRepository charactersComicsRepository;

    public Page<CharactersComics> findByCharactersId(Long characterId,Pageable pageable) {
        return charactersComicsRepository.findCharactersComicsById(characterId, pageable);
    }
}
