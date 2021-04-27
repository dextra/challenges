package com.marvel.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@Table(name = "CHARACTERS")
public class Characters {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "MODIFIED")
    private Calendar modified;

    @Column(name = "RESOURCE_URI")
    private String resourceURI;

    @ManyToOne
    @JoinColumn(name = "ID_THUMBNAIL")
    private Thumbnail thumbnail;

    @ManyToOne
    @JoinColumn(name = "COMICS")
    private Comics comics;

    @ManyToOne
    @JoinColumn(name = "STORIES")
    private Stories stories;

    @ManyToOne
    @JoinColumn(name = "EVENTS")
    private Events events;

    @ManyToOne
    @JoinColumn(name = "SERIES")
    private Series series;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "characters")
    @Fetch(FetchMode.SUBSELECT)
    private List<Url> urls;
}

