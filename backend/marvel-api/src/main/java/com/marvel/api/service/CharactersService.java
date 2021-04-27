package com.marvel.api.service;

import com.marvel.api.model.*;
import com.marvel.api.model.dto.Data;
import com.marvel.api.model.dto.ResultEndpoint;
import com.marvel.api.repository.CharactersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.caseSensitive;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@Service
public class CharactersService extends GenericService<Characters,Long>{

    @Autowired
    CharactersRepository charactersRepository;

    @Autowired
    ComicsService comicsService;

    @Autowired
    EventsService eventsService;

    @Autowired
    StoriesService storiesService;

    @Autowired
    SeriesService seriesService;

    @Autowired
    CharactersStoriesService charactersStoriesService;

    @Autowired
    CharactersEventsService charactersEventsService;

    @Autowired
    CharactersComicsService charactersComicsService;

    @Autowired
    CharactersSeriesService charactersSeriesService;


    public ResultEndpoint findAllMapFilter(Map<String,String> map) {
        Characters characters = new Characters();
        ExampleMatcher matcher = matcher = ExampleMatcher.matchingAll();

        if(map.get("nameStartsWith") != null) {
            matcher = ExampleMatcher
                    .matchingAll()
                    .withMatcher("name",contains());
        }

        characters.setName(map.get("name") == null ? map.get("nameStartsWith") : map.get("name"));

        if(map.get("modifiedSince") != null) {
            try {

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(map.get("modifiedSince")));
                characters.setModified(calendar);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }


        //Filter comics id
        if(map.get("comics") != null){
            Optional<Comics> comicsOptional = comicsService.findById(Long.parseLong(map.get("comics").toString()));
            characters.setComics(comicsOptional.isPresent() ? comicsOptional.get() : comicsOptional.orElse(new Comics()));
        }

        //Filter series id
        if(map.get("series") != null) {
            Optional<Series> seriesOptional = seriesService.findById(Long.parseLong(map.get("series").toString()));
            characters.setSeries(seriesOptional.isPresent() ? seriesOptional.get() : seriesOptional.orElse(new Series()));
        }

        //Filter events id
        if(map.get("events") != null) {
            Optional<Events> eventsOptional = eventsService.findById(Long.parseLong(map.get("events").toString()));
            characters.setEvents(eventsOptional.isPresent() ? eventsOptional.get() : eventsOptional.orElse(new Events()));
        }

        //Filter stories id
        if(map.get("stories") != null){
            Optional<Stories> storiesOptional = storiesService.findById(Long.parseLong(map.get("stories").toString()));
            characters.setStories(storiesOptional.isPresent() ? storiesOptional.get() : storiesOptional.orElse(new Stories()));
        }

        Page<Characters> charactersPage = null;
        Pageable limit = PageRequest.of(0,20,sortBy(map.get("orderBy")));

        if(map.get("limit") != null){
            limit = PageRequest.of(0,Integer.parseInt(map.get("limit")),sortBy(map.get("orderBy")));
        }

        int offset = 0;
        if(map.get("offset") != null){
            offset = 1;
            limit = PageRequest.of(0, charactersPage.getSize(),sortBy(map.get("orderBy")));
        }

        charactersPage = charactersRepository.findAll(Example.of(characters,matcher),limit);

        Data<Characters> charactersData =
                new Data<Characters>(offset,
                                     limit.getPageSize(),
                                     charactersPage.getTotalElements(),
                                     charactersPage.getSize(),
                                     charactersPage.getContent());


        ResultEndpoint resultEndpoint = new ResultEndpoint("200","Ok", charactersData);

        return resultEndpoint;
    }

    public Sort sortBy(String valueSort){
        if(valueSort == null){
            valueSort = "name";
        }
        return valueSort.contains("-") ? Sort.by(Sort.Direction.DESC, valueSort) : Sort.by(Sort.Direction.ASC, valueSort);
    }

    public boolean validaParameter(String value, String type){

        if(value == null){
            return true;
        }

        try{
            switch (type){
                case "int":
                    Integer.parseInt(value);
                    break;
                case "calendar":
                    new SimpleDateFormat("yyyy-MM-dd").parse(value);
                    break;
                case "order":
                    if(!value.equals("name") || !value.equals("-name") || !value.equals("modified") || !value.equals("-modified") || !value.equals("-id")|| !value.equals("id")){
                        return false;
                    }
                    break;
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public ResultEndpoint findByChacterId(Long characterId) {
        List<Characters> dataList = new ArrayList<>();

        Optional<Characters> optionalCharacters = charactersRepository.findById(characterId);

        if(optionalCharacters.isPresent()){
            dataList.add(charactersRepository.findById(characterId).get());
        }

        Data<Characters> charactersData =
                new Data<Characters>(0,
                        1,
                        1,
                        1,
                        dataList);

        ResultEndpoint resultEndpoint = null;

        if(optionalCharacters.isPresent()){
            resultEndpoint = new ResultEndpoint("200","Ok",charactersData);
        }else{
            resultEndpoint = new ResultEndpoint("404","Character not found.",charactersData);
        }


        return resultEndpoint;
    }

    public ResultEndpoint findByCharacterIdStories(Long characterId, Map<String,String> map) {

        CharactersStories characters = new CharactersStories();
        ExampleMatcher matcher = matcher = ExampleMatcher.matchingAll();

        Page<CharactersStories> charactersPage = null;
        Pageable limit = PageRequest.of(0,20,sortBy(map.get("orderBy")));

        if(map.get("limit") != null){
            limit = PageRequest.of(0,Integer.parseInt(map.get("limit")),sortBy(map.get("orderBy")));
        }

        int offset = 0;
        if(map.get("offset") != null){
            offset = 1;
            limit = PageRequest.of(0, charactersPage.getSize(),sortBy(map.get("orderBy")));
        }

        charactersPage =  charactersStoriesService.findByCharactersId(characterId,limit);

        Data<CharactersStories> charactersData =
                new Data<>(offset,
                        limit.getPageSize(),
                        charactersPage.getTotalElements(),
                        charactersPage.getSize(),
                        charactersPage.getContent());


        ResultEndpoint resultEndpoint = new ResultEndpoint("200","Ok", charactersData);

        return resultEndpoint;
    }

    public ResultEndpoint findByCharacterIdEvents(Long characterId, Map<String,String> map) {

        CharactersEvents characters = new CharactersEvents();
        ExampleMatcher matcher = matcher = ExampleMatcher.matchingAll();

        Page<CharactersEvents> charactersPage = null;
        Pageable limit = PageRequest.of(0,20,sortBy(map.get("orderBy")));

        if(map.get("limit") != null){
            limit = PageRequest.of(0,Integer.parseInt(map.get("limit")),sortBy(map.get("orderBy")));
        }

        int offset = 0;
        if(map.get("offset") != null){
            offset = 1;
            limit = PageRequest.of(0, charactersPage.getSize(),sortBy(map.get("orderBy")));
        }

        charactersPage =  charactersEventsService.findByCharactersId(characterId,limit);

        Data<CharactersEvents> charactersData =
                new Data<>(offset,
                        limit.getPageSize(),
                        charactersPage.getTotalElements(),
                        charactersPage.getSize(),
                        charactersPage.getContent());


        ResultEndpoint resultEndpoint = new ResultEndpoint("200","Ok", charactersData);

        return resultEndpoint;
    }

    public ResultEndpoint findByCharacterIdComics(Long characterId, Map<String,String> map) {

        CharactersComics characters = new CharactersComics();
        ExampleMatcher matcher = matcher = ExampleMatcher.matchingAll();

        Page<CharactersComics> charactersPage = null;
        Pageable limit = PageRequest.of(0,20,sortBy(map.get("orderBy")));

        if(map.get("limit") != null){
            limit = PageRequest.of(0,Integer.parseInt(map.get("limit")),sortBy(map.get("orderBy")));
        }

        int offset = 0;
        if(map.get("offset") != null){
            offset = 1;
            limit = PageRequest.of(0, charactersPage.getSize(),sortBy(map.get("orderBy")));
        }

        charactersPage =  charactersComicsService.findByCharactersId(characterId,limit);

        Data<CharactersComics> charactersData =
                new Data<>(offset,
                        limit.getPageSize(),
                        charactersPage.getTotalElements(),
                        charactersPage.getSize(),
                        charactersPage.getContent());


        ResultEndpoint resultEndpoint = new ResultEndpoint("200","Ok", charactersData);

        return resultEndpoint;
    }

    public ResultEndpoint findByCharacterIdSeries(Long characterId, Map<String,String> map) {

        CharactersSeries characters = new CharactersSeries();
        ExampleMatcher matcher = matcher = ExampleMatcher.matchingAll();

        Page<CharactersSeries> charactersPage = null;
        Pageable limit = PageRequest.of(0,20,sortBy(map.get("orderBy")));

        if(map.get("limit") != null){
            limit = PageRequest.of(0,Integer.parseInt(map.get("limit")),sortBy(map.get("orderBy")));
        }

        int offset = 0;
        if(map.get("offset") != null){
            offset = 1;
            limit = PageRequest.of(0, charactersPage.getSize(),sortBy(map.get("orderBy")));
        }

        charactersPage =  charactersSeriesService.findByCharactersId(characterId,limit);

        Data<CharactersSeries> charactersData =
                new Data<>(offset,
                        limit.getPageSize(),
                        charactersPage.getTotalElements(),
                        charactersPage.getSize(),
                        charactersPage.getContent());


        ResultEndpoint resultEndpoint = new ResultEndpoint("200","Ok", charactersData);

        return resultEndpoint;
    }
}
