package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "URL")
public class Url extends GenericKey{

    @Column(name = "TYPE")
    private String type;

    @Column(name = "URL")
    private String url;

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS")
    @JsonBackReference
    private Characters characters;

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS_EVENTS")
    @JsonBackReference
    private CharactersEvents charactersEvents;

    @ManyToOne
    @JoinColumn(name = "ID_CH_COMICS")
    @JsonBackReference
    private CharactersComics charactersComics;
}
