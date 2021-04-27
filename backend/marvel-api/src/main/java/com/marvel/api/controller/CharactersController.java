package com.marvel.api.controller;

import com.marvel.api.model.*;
import com.marvel.api.model.dto.Data;
import com.marvel.api.model.dto.ResultEndpoint;
import com.marvel.api.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.swing.text.html.parser.Entity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    @Autowired
    CharactersService charactersService;

    @GetMapping()
    public ResponseEntity<?> findAll(@RequestParam Map<String,String> map){
        return new ResponseEntity<>(charactersService.findAllMapFilter(map), HttpStatus.OK);
    }

    @GetMapping("/{characterId}")
    public ResponseEntity<?> findById(@PathVariable("characterId") Long characterId){
        return new ResponseEntity<>(charactersService.findByChacterId(characterId), HttpStatus.OK);
    }

    @GetMapping("/{characterId}/stories")
    public ResponseEntity<?> findByCharacterIdStories(@PathVariable("characterId") Long characterId,@RequestParam Map<String,String> map){
        return new ResponseEntity<>(charactersService.findByCharacterIdStories(characterId,map), HttpStatus.OK);
    }

    @GetMapping("/{characterId}/comics")
    public ResponseEntity<?> findByCharacterIdComics(@PathVariable("characterId") Long characterId,@RequestParam Map<String,String> map){
        return new ResponseEntity<>(charactersService.findByCharacterIdComics(characterId,map), HttpStatus.OK);
    }

    @GetMapping("/{characterId}/events")
    public ResponseEntity<?> findByCharacterIdEvents(@PathVariable("characterId") Long characterId,@RequestParam Map<String,String> map){
        return new ResponseEntity<>(charactersService.findByCharacterIdEvents(characterId,map), HttpStatus.OK);
    }

    @GetMapping("/{characterId}/series")
    public ResponseEntity<?> findByCharacterIdSeries(@PathVariable("characterId") Long characterId,@RequestParam Map<String,String> map){
        return new ResponseEntity<>(charactersService.findByCharacterIdSeries(characterId,map), HttpStatus.OK);
    }


}
