package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ITEM")
public class Item extends GenericKey{

    @Column(name = "RESOURCE_URI")
    private String resourceURI;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name = "ID_COMICS")
    @JsonBackReference
    private Comics comics;

    @ManyToOne
    @JoinColumn(name = "ID_STORIES")
    @JsonBackReference
    private Stories stories;

    @ManyToOne
    @JoinColumn(name = "ID_EVENTS")
    @JsonBackReference
    private Events events;

    @ManyToOne
    @JoinColumn(name = "ID_SERIES")
    @JsonBackReference
    private Series series;

    @ManyToOne
    @JoinColumn(name = "ID_CREATORS")
    @JsonBackReference
    private Creators creators;

}