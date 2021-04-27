package com.marvel.api.service;

import com.marvel.api.model.CharactersEvents;
import com.marvel.api.model.CharactersEvents;
import com.marvel.api.repository.CharactersEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CharactersEventsService extends GenericService<CharactersEvents,Long>{

    @Autowired
    CharactersEventsRepository charactersEventsRepository;

    public Page<CharactersEvents> findByCharactersId(Long characterId,Pageable pageable) {
        return charactersEventsRepository.findCharactersEventsById(characterId, pageable);
    }
}
