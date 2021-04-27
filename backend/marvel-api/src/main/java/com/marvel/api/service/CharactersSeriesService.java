package com.marvel.api.service;

import com.marvel.api.model.CharactersSeries;
import com.marvel.api.repository.CharactersSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CharactersSeriesService extends GenericService<CharactersSeries,Long>{

    @Autowired
    CharactersSeriesRepository charactersSeriesRepository;

    public Page<CharactersSeries> findByCharactersId(Long characterId,Pageable pageable) {
        return charactersSeriesRepository.findCharactersSeriesById(characterId, pageable);
    }
}
