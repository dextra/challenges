package com.marvel.api.service;

import com.marvel.api.model.CharactersStories;
import com.marvel.api.repository.CharactersStoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharactersStoriesService extends GenericService<CharactersStories,Long>{

    @Autowired
    CharactersStoriesRepository charactersStoriesRepository;

    public Page<CharactersStories> findByCharactersId(Long characterId,Pageable pageable) {
        return charactersStoriesRepository.findCharactersStoriesById(characterId, pageable);
    }
}
