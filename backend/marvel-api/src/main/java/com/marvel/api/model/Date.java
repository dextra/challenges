package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "DATE")
@Data
public class Date extends GenericKey{

    @Column(name = "TYPE")
    public String type;

    @Column(name = "DATE")
    public Calendar date;

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS_COMICS")
    @JsonBackReference
    private CharactersComics charactersComics;
}
