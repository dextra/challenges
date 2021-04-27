package com.marvel.api.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
@Data
@Table(name = "CHARACTERS_COMICS")
public class CharactersComics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;


    @Column(name = "DIGITALID")
    public String digitalId;

    @Column(name = "TITLE")
    public String title;

    @Column(name = "ISSUENUMBER")
    public String issueNumber;

    @Column(name = "VARIANT_DESCRIPTION")
    public String variantDescription;

    @Column(name = "DESCRIPTION")
    public String description;

    @Column(name = "MODIFIED")
    public Calendar modified;

    @Column(name = "ISBN")
    public String isbn;

    @Column(name = "UPC")
    public String upc;

    @Column(name = "DIAMOND_CODE")
    public String diamondCode;

    @Column(name = "EAN")
    public String ean;

    @Column(name = "ISSN")
    public String issn;

    @Column(name = "FORMAT")
    public String format;

    public int pageCount;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<TextObject> textObjects;

    @Column(name = "RESOURCE_URI")
    public String resourceURI;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> urls;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> variants;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> collections;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> collectedIssues;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Date> dates;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> prices;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "charactersComics")
    @Fetch(FetchMode.SUBSELECT)
    public List<Url> images;

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

    @ManyToOne
    @JoinColumn(name = "ID_CHARACTERS")
    private Characters characters;
}
