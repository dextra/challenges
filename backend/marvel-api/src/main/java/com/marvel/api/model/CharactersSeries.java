package com.marvel.api.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@Table(name = "CHARACTERS_SERIES")
public class CharactersSeries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "MODIFIED")
    private Calendar modified;

    @Column(name = "RESOURCE_URI")
    private String resourceURI;

    @Column(name = "TYPE")
    public String type;

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS")
    private Characters characters;

    @ManyToOne
    @JoinColumn(name = "COMICS")
    private Comics comics;

    @ManyToOne
    @JoinColumn(name = "EVENTS")
    private Events events;

    @ManyToOne
    @JoinColumn(name = "ORIGINAL_ISSUE")
    private OriginalIssue originalIssue;

    @ManyToOne
    @JoinColumn(name = "SERIES")
    private Series series;

    @ManyToOne
    @JoinColumn(name = "CREATORS")
    public Creators creators;

    @ManyToOne
    @JoinColumn(name = "NEXT")
    public Url next;

    @ManyToOne
    @JoinColumn(name = "PREVIUS")
    public Url previus;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersEvents")
    @Fetch(FetchMode.SUBSELECT)
    private List<Url> urls;

    @Column(name = "START_YEAR")
    public int startYear;

    @Column(name = "END_YEAR")
    public int endYear;

    @Column(name = "RATING")
    public String rating;
}
