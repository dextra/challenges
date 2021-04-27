package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "TEXT_OBJECT")
public class TextObject extends GenericKey{

    @Column(name = "TYPE")
    public String type;

    @Column(name = "LANGUAGE")
    public String language;

    @Column(name = "TEXT", length = 2000)
    public String text;

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS_COMICS")
    @JsonBackReference
    private CharactersComics charactersComics;

}